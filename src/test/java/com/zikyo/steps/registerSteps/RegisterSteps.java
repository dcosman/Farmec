package com.zikyo.steps.registerSteps;

import com.sdl.selenium.extjs3.form.ComboBox;
import com.zikyo.utils.Farmec.RegisterView;
import cucumber.api.java.en.And;

/**
 * Created by Sica-sama on 7/20/2016.
 */
public class RegisterSteps {
    private RegisterView registerView = new RegisterView();


    @And("^I register with valid dates$")
    public void iRegisterWithValidDates()  {

        registerView.setValues("testare1984+1@gmail.com","testare1984+1@gmail.com","remussic","remussic","Marin","Pop","May","1984","Uscat");


    }


    @And("^I select gender from the drop-down$")
    public void iSelectGenderFromTheDropDown()  {
        ComboBox gendreList = new ComboBox().setId("sex");
        gendreList.select("Masculin");

    }
}



