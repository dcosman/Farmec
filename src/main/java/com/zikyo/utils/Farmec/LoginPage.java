package com.zikyo.utils.Farmec;
import com.sdl.selenium.web.WebLocator;

public class LoginPage {


    private WebLocator emailField = new WebLocator().setId("txLoginEmail");
    private WebLocator passField  = new WebLocator().setId("txLoginPassword");
    private WebLocator loginBtn = new WebLocator("btn btn-custom").setText("Intră în contul tău");




    public void doLogin(String txLoginEmail, String txLoginPassword){
        emailField.sendKeys(txLoginEmail);
        passField.sendKeys(txLoginPassword);
        loginBtn.click();


    }

    }