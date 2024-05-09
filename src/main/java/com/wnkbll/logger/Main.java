package com.wnkbll.logger;

import com.wnkbll.logger.modules.FileLogger;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        FileLogger logger = new FileLogger();
        logger.setRotationThreshold(5000);

        Logger.setMinLevel(Logger.SUCCESS);
        Logger.setFileLogger(logger);

        while (true) {
            Logger.debug("Some text");
            Logger.info("Some text");
            Logger.success("Some text");
            Logger.warning("Some text");
            Logger.error("Some text");
            Logger.critical("Some text");

            Thread.sleep(1000);
        }
    }
}
