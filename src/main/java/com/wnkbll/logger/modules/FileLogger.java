package com.wnkbll.logger.modules;

import com.wnkbll.logger.dataclasses.Text;
import com.wnkbll.logger.interfaces.Logger;

import java.util.List;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.IOException;

public class FileLogger implements Logger {
    private String directoryName = "logs/";
    private String fileName = "file";
    private String currentFileName = fileName;
    private String extension = ".log";
    private Integer rotationThreshold = 0;

    public void setDirectoryName(String value) {
        directoryName = value;
    }

    public void setFileName(String value) {
        fileName = value;
    }

    public void setExtension(String value) {
        extension = value;
    }

    public void setRotationThreshold(Integer value) {
        if (value > 0) {
            rotationThreshold = value;
            currentFileName = fileName + "." + Formatter.getTime("YYYY-MM-dd_HH-mm-ss");
            return;
        }

        currentFileName = fileName;
    }

    private synchronized void createDirectory() throws IOException {
        Path directoryPath = Paths.get(directoryName);
        if (Files.notExists(directoryPath)) Files.createDirectory(directoryPath);
    }

    private synchronized Path createFile() throws IOException {
        Path filePath = Paths.get(directoryName + currentFileName + extension);

        if (Files.notExists(filePath)) return Files.createFile(filePath);

        if (rotationThreshold != 0 && Files.size(filePath) > rotationThreshold) {
            currentFileName = fileName + "." + Formatter.getTime("YYYY-MM-dd_HH-mm-ss");
            filePath = Paths.get(directoryName + currentFileName + extension);
            return Files.createFile(filePath);
        }

        return filePath;
    }

    private synchronized void write(String message) {
        try {
            createDirectory();
        } catch (IOException ignored) {
            System.out.println("Impossible to create log directory. Check directory name.");
        }

        try {
            Path filePath = createFile();

            List<String> lines = Files.readAllLines(filePath);
            lines.add(message);

            Files.write(filePath, lines);
        } catch (IOException ignored) {
            System.out.println("Impossible to create log file. Check file name.");
        }
    }

    public void log(Text time, Text level, Text trace, Text message) {
        String output = Formatter.getFormatedOutput(time, level, trace, message);

        write(output);
    }
}
