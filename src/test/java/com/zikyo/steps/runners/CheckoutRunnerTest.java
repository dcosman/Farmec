package com.zikyo.steps.runners;




import cucumber.api.CucumberOptions;


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
