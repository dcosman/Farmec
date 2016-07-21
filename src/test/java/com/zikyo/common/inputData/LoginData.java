package com.zikyo.common.inputData;

import com.sdl.selenium.web.utils.PropertiesReader;
import com.zikyo.common.EnvConfig;
import org.apache.log4j.Logger;

public class LoginData extends PropertiesReader {
    private static final Logger LOGGER = Logger.getLogger(LoginData.class);

    private LoginData() {
        super(EnvConfig.testConfigPath);
    }

    static LoginData loginData = new LoginData();

    public static String getLoginUrl() {
        return loginData.getProperty("frontend.url");
    }
}
