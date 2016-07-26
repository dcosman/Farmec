package com.zikyo.steps.registerSteps;

import com.sdl.selenium.extjs3.form.ComboBox;
import com.sdl.selenium.web.WebLocator;
import com.zikyo.utils.Farmec.RegisterView;
import cucumber.api.java.en.And;

/**
 * Created by Sica-sama on 7/20/2016.
 */
public class RegisterSteps {
    private RegisterView registerView = new RegisterView();





    @And("^I select gender from the drop-down$")
    public void iSelectGenderFromTheDropDown()  {
        ComboBox genderList = new ComboBox().setId("sex");
        registerView.getSexField().select("Masculin");

    }


    @And("^I select skin-type$")
    public void iSelectSkinType() throws Throwable {
     ComboBox skinList = new ComboBox().setId("skin-type");
        registerView.getTenField().select("Normal");
    }

    @And("^I select hair-type$")
    public void iSelectHairType()  {
       ComboBox hairList= new ComboBox().setId("hair-type");
        registerView.getHairField().select("Cu mătreaţă");

    }


    @And("^I type into captcha field$")
    public void iTypeIntoCaptchaField()  {
        WebLocator CaptchaList = new WebLocator().setId("captcha");
        registerView.setValue("ei9s56hzrr");
    }

    @And("^I complete birthdate$")
    public void iCompleteBirthdate() throws Throwable {
        registerView.setValues("May","1984");
}}





