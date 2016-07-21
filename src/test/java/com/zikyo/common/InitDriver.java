package com.zikyo.common;

import com.sdl.selenium.utils.config.WebDriverConfig;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class InitDriver {
    private static final Logger LOGGER = Logger.getLogger(InitDriver.class);
    public static WebDriver driver;

    public static void init() throws IOException {
        LOGGER.info("===============================================================");
        LOGGER.info("|          Environment : " + EnvConfig.testEnvironment);
        LOGGER.info("|          Operating System : " + EnvConfig.operatingSystem);
        LOGGER.info("|          Browser: " + EnvConfig.browser);
        LOGGER.info("|          Browser config file: " + EnvConfig.browserConfigPath);
        LOGGER.info("===============================================================\n");
        if (driver == null) {
            driver = WebDriverConfig.getWebDriver(EnvConfig.browserConfigPath);
            try {
                FileUtils.forceMkdir(new File(WebDriverConfig.getDownloadPath()));
            }
            catch (IOException e){
                LOGGER.error(e);
            }
        }
    }
}
