package com.zikyo.steps;

import com.sdl.selenium.utils.config.WebDriverConfig;
import com.zikyo.common.InitDriver;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.IOException;

public class Hooks {
    private static final Logger LOGGER = Logger.getLogger(Hooks.class);

    @Before
    public void beforeScenario(Scenario scenario)throws IOException {
        LOGGER.debug("***** START of Scenario: " + scenario.getName() + " *****");
        InitDriver.init();
    }

    @After
    public void tearDown(Scenario scenario) {
        String scenarioName = scenario.getName();
        if (scenario.isFailed()) {
            LOGGER.warn("\"" + scenarioName + "\" scenario has failed! Screenshot embedded in the report.");
            byte[] screenshot = ((TakesScreenshot) WebDriverConfig.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        }
        LOGGER.debug("***** END of Scenario: " + scenario.getName() + " *****");
    }
}
