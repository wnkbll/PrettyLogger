package com.wnkbll.logger.modules;

import com.wnkbll.logger.types.Text;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.IOException;
import java.io.BufferedWriter;
import java.nio.file.StandardOpenOption;

public class FileLogger {
    private String directory = "logs/";
    private String file = "file";
    private String extension = ".log";

    public void setDirectory(String directory) {
        this.directory = directory;
    }

    public void setFile(String file) {
        this.file = directory;
    }

    public void setExtension(String extension) {
        this.extension = directory;
    }

    private void createDirectory(String pathToDirectory) throws IOException {
        Path directoryPath = Paths.get(pathToDirectory);
        if (Files.notExists(directoryPath)) Files.createDirectory(directoryPath);
    }

    private void write(String message) throws IOException {
        try {
            createDirectory(directory);
        } catch (IOException e) {
            System.out.println("Impossible to create directory");
        }

        Path path = Paths.get(directory + file + extension);

        try (BufferedWriter writer = Files.newBufferedWriter(path,
                StandardOpenOption.WRITE, StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {
            writer.write(message + "\n");
        }
    }

    public void log(Text time, Text level, Text trace, Text message) {
        String output = Formatter.getFormatedOutput(time, level, trace, message);

        try {
            write(output);
        } catch (IOException e) {
            System.out.println("Impossible to write log file.");
        }
    }
}
