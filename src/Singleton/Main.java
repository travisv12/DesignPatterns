package Singleton;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.write("Application started");
        logger.write("Performing some operations...");
        logger.write("Application finished");
        logger.close();

        logger.setFileName("test_log.txt");
        logger.write("Writing to a new log file");
        logger.write("Finished writing to a new log file");
        logger.close();
    }
}
