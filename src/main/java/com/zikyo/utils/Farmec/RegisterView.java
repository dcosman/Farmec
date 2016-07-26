package com.zikyo.utils.Farmec;

import com.sdl.selenium.web.WebLocator;
import com.sdl.selenium.web.form.ComboBox;

/**
 * Created by Sica-sama on 7/20/2016.
 */
public class RegisterView extends WebLocator {
    private WebLocator birthD = new WebLocator().setId("birthdate");
    private ComboBox bMonth = new ComboBox().setClasses("ui-datepicker-month");
    private ComboBox dYear = new ComboBox().setClasses("ui-datepicker-year");
    private WebLocator date = new WebLocator().setText("17");
    private ComboBox sexField = new ComboBox().setId("sex");
    private ComboBox tenField = new ComboBox().setId("skin-type");
    private ComboBox hairField = new ComboBox().setId("hair-type");
    private WebLocator captchaField = new WebLocator().setId("captcha");

    public void setValue(String captchaF) {
        captchaField.sendKeys(captchaF);
    }

    public ComboBox getHairField() {
        return hairField;
    }

    public ComboBox getTenField() {
        return tenField;
    }

    public ComboBox getSexField() {
        return sexField;
    }

    public void setValues( String bN, String dY){
         birthD.click();
         bMonth.select(bN);
         dYear.select(dY);
         date.click();






    }




}
