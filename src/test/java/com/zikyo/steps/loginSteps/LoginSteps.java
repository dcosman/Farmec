package com.zikyo.steps.loginSteps;

import com.zikyo.utils.Farmec.LoginPage;
import cucumber.api.java.en.When;

/**
 * Created by Sica-sama on 7/20/2016.
 */
public class LoginSteps {
    LoginPage loginPage = new LoginPage();

    @When("^I login with \"([^\"]*)\"/\"([^\"]*)\"$")
    public void iLoginWith(String email, String pass) throws Throwable {
        loginPage.doLogin(email, pass);

    }
}
