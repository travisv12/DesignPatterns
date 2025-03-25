package Singleton;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Logger {
    private static Logger instance;
    private PrintWriter writer;
    private String fileName;

    private Logger() {
        setFileName("default_log.txt");
    }

    public static synchronized Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public synchronized void setFileName(String fileName) {
        if (writer != null) {
            writer.close();
        }
        this.fileName = fileName;
        try {
            writer = new PrintWriter(new FileWriter(fileName, true));
        } catch (IOException e) {
            System.err.println("Failed to open log file: " + e.getMessage());
        }
    }

    public synchronized void write(String message) {
        if (writer != null) {
            writer.println(message);
            writer.flush();
        } else {
            System.err.println("Logger is not initialized properly.");
        }
    }

    public synchronized void close() {
        if (writer != null) {
            writer.close();
        }
    }
}