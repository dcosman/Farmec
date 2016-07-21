package com.zikyo.common;

import org.apache.commons.lang3.SystemUtils;
import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class EnvConfig extends Properties {
    private static final Logger LOGGER = Logger.getLogger(EnvConfig.class);

    public static final String RESOURCES_PATH = "src/test/resources/";
    private static final String INIT_CONFIG_PATH = RESOURCES_PATH + "defaultTestConfig.properties";
    private static Properties initProperties;
    static Properties browserProperties;

    public static String operatingSystem = System.getProperty("os.name");
    public static String testEnvironment;
    public static String testConfigPath;
    public static String browser;
    public static String browserConfigPath;

    public EnvConfig() {
        try {
            testEnvironment = System.getProperty(ENV_PROPERTY, DEFAULT_ENV);
            browser = System.getProperty(BROWSER_PROPERTY, DEFAULT_BROWSER);
            browserConfigPath = browser + ".properties";
            testConfigPath = RESOURCES_PATH + "environments/" + testEnvironment + "/test-config.properties";

            FileInputStream fileInputStream = new FileInputStream(testConfigPath);
            load(fileInputStream);

            FileInputStream browserPropertiesStream = new FileInputStream(RESOURCES_PATH + browserConfigPath);
            browserProperties = new Properties();
            browserProperties.load(browserPropertiesStream);

            if (browser.equals("chrome")) {
                if (SystemUtils.IS_OS_MAC) {
                    System.setProperty("browser.driver.path", browserProperties.getProperty("browser.driver.path.mac"));
                } else if (SystemUtils.IS_OS_LINUX) {
                    System.setProperty("browser.driver.path", browserProperties.getProperty("browser.driver.path.linux"));
                }
            }
        } catch (IOException e) {
            LOGGER.error(e);
        }
    }

    static {
        try {
            FileInputStream initPropertiesStream = new FileInputStream(INIT_CONFIG_PATH);
            initProperties = new Properties();
            initProperties.load(initPropertiesStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static final String ENV_PROPERTY = "env";
    public static final String BROWSER_PROPERTY = "browser";
    public static final String DEFAULT_ENV = initProperties.getProperty(ENV_PROPERTY);
    public static final String DEFAULT_BROWSER = initProperties.getProperty(BROWSER_PROPERTY);

    static EnvConfig envConfig = new EnvConfig();

    public String getProperty(String key, boolean log) {
        String property = System.getProperty(key, super.getProperty(key));
        if (log)
            LOGGER.debug("getProperty: " + key + " = " + property);
        return property;
    }

    public String getProperty(String key) {
        return getProperty(key, false);
    }

}
