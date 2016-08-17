package com.zikyo.steps.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        monochrome = true,
        plugin =  {"rerun", "html:target/cucumber","json:target/jsonReports/CheckoutTest.json"},
        glue = {
                "com.zikyo"
        },
        features = {
                "src/test/resources/features/checkout.feature"
        }
)
public class CheckoutRunnerTest {
}
