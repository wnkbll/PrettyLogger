package com.wnkbll.logger.components;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileStream {
    private final String directory;
    private final String file;
    private String currentFile;
    private final int rotationThreshold;

    public FileStream(String directory, String file, int rotationThreshold) {
        this.directory = directory;
        this.file = file;
        this.rotationThreshold = rotationThreshold;

        if (rotationThreshold != 0)
            this.currentFile = file + "_" + Formatter.getFormatedTime("YYYY-MM-dd_HH-mm-ss") + ".log";
        else
            this.currentFile = file;
    }

    private void createDirectory() throws IOException {
        Path directoryPath = Paths.get(directory);
        if (Files.notExists(directoryPath)) Files.createDirectory(directoryPath);
    }

    private Path createFile() throws IOException {
        Path filePath = Paths.get(directory + "/" + currentFile);

        if (Files.notExists(filePath)) return Files.createFile(filePath);

        if (rotationThreshold != 0 && Files.size(filePath) > rotationThreshold) {
            currentFile = file + "_" + Formatter.getFormatedTime("YYYY-MM-dd_HH-mm-ss")  + ".log";
            filePath = Paths.get(directory + "/" + currentFile);
            return Files.createFile(filePath);
        }

        return filePath;
    }

    public void write(String message) throws IOException {
        createDirectory();
        Path filePath = createFile();

        List<String> lines = Files.readAllLines(filePath);
        lines.add(message);

        Files.write(filePath, lines);
    }
}
