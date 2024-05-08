package com.wnkbll.logger.modules;

import com.wnkbll.logger.dataclasses.Level;

import java.util.List;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.IOException;

public class FileLogger {
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
            currentFileName = fileName + "." + Formatter.getFormatedTime("YYYY-MM-dd_HH-mm-ss") + extension;
            return;
        }

        currentFileName = fileName;
    }

    private synchronized void createDirectory() throws IOException {
        Path directoryPath = Paths.get(directoryName);
        if (Files.notExists(directoryPath)) Files.createDirectory(directoryPath);
    }

    private synchronized Path createFile() throws IOException {
        Path filePath = Paths.get(directoryName + fileName + extension);

        if (Files.notExists(filePath)) return Files.createFile(filePath);

        if (rotationThreshold != 0 && Files.size(filePath) > rotationThreshold) {
            currentFileName = fileName + "." + Formatter.getFormatedTime("YYYY-MM-dd_HH-mm-ss")  + extension;
            filePath = Paths.get(directoryName + currentFileName);
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

    public void log(String message, Level level) {
        String output = String.format(
                "%s | %s | %s - %s",
                Formatter.getTimeFromPattern("YYYY-MM-dd HH:mm:ss.SSS"), level.name,
                Formatter.getTrace(), message
        );

        write(output);
    }
}
