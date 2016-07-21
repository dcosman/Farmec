package com.zikyo.steps.runners;




import cucumber.api.CucumberOptions;


@CucumberOptions(
        monochrome = true,
        plugin =  {"rerun", "html:target/cucumber","json:target/jsonReports/LoginTest.json"},
        glue = {
                "com.zikyo"
        },
        features = {
                "src/test/resources/features/login.feature"
        }
)
public class LoginRunner {
}
