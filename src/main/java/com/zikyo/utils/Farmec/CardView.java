package com.zikyo.utils.Farmec;

import com.sdl.selenium.web.WebLocator;
import com.sdl.selenium.web.form.ComboBox;
import com.sdl.selenium.web.form.TextField;

/**
 * Created by Sica-sama on 7/18/2016.
 */
public class CardView extends WebLocator {
    private TextField numberField = new TextField().setName("CARD");
    private ComboBox monthField = new ComboBox().setName("EXP");
    private ComboBox yearField = new ComboBox().setName("EXP_YEAR");
    private TextField CVV2Field = new TextField().setName("CVC2");
    private ComboBox tpField = new ComboBox().setName("CVC2_RC");
    private WebLocator aprove = new WebLocator().setName("SEND_BUTTON");



 public void setValues(String number,String cvv,String month,String year,String tipCard){
     numberField.setValue(number);
     CVV2Field.setValue(cvv);
     monthField.select(month);
     yearField.select(year);
     tpField.select(tipCard);
     aprove.click();
 }


}
