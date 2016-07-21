package com.zikyo.steps;

import com.sdl.selenium.utils.config.WebDriverConfig;
import com.zikyo.common.InitDriver;

import java.io.IOException;

/**
 * Created by fratiu on 10/19/2015.
 */
public class TestBase {
    static {
        if (WebDriverConfig.getDriver() == null) {
            try {
                InitDriver.init();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
