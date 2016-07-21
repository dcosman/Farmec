package com.zikyo.utils;

import com.sdl.selenium.utils.config.WebDriverConfig;
import com.sdl.selenium.web.WebLocator;

public class TestUtils {

    public static void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
      public static void switchToIframe(){
          WebLocator iframe = new WebLocator().setTag("iframe");
          WebDriverConfig.getDriver().switchTo().frame(iframe.findElement());

      }


}
