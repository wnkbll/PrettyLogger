package com.wnkbll.logger;

public class Main {
    public static void main(String[] args) {
        Logger logger = new Logger();

        logger.trace("Some text");
        logger.debug("Some text");
        logger.info("Some text");
        logger.success("Some text");
        logger.warning("Some text");
        logger.error("Some text");
        logger.critical("Some text");
    }
}
