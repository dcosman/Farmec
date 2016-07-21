package com.zikyo.utils.Farmec;

import com.sdl.selenium.web.WebLocator;
import com.sdl.selenium.web.form.ComboBox;

/**
 * Created by Sica-sama on 7/20/2016.
 */
public class RegisterView extends WebLocator {
    private WebLocator rEmailField = new WebLocator().setName("account-email");
    private WebLocator cEmail = new WebLocator().setName("confirm-email");
    private WebLocator pass = new WebLocator().setId("account-password");
    private WebLocator cPass = new WebLocator().setId("confirm-password");
    private WebLocator lName = new WebLocator().setId("last-name");
    private WebLocator fName = new WebLocator().setId("first-name");
    private WebLocator birthD = new WebLocator().setId("birthdate");
    private ComboBox bMonth = new ComboBox().setClasses("ui-datepicker-month");
    private ComboBox dYear = new ComboBox().setClasses("ui-datepicker-year");
    private WebLocator date = new WebLocator().setText("17");
    private ComboBox sexField = new ComboBox().setId("sex");

    public ComboBox getSexField() {
        return sexField;
    }

    public void setValues(String emailF, String conEmail, String password, String conPass, String lastN, String firstN, String bN, String dY, String dryH){
         rEmailField.sendKeys(emailF);
         cEmail.sendKeys(conEmail);
         pass.sendKeys(password);
         cPass.sendKeys(conPass);
         lName.sendKeys(lastN);
         fName.sendKeys(firstN);
         birthD.click();
         bMonth.select(bN);
         dYear.select(dY);
         date.click();




    }




}
