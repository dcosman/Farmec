package com.zikyo.steps.creditCardSteps;

import com.sdl.selenium.web.WebLocator;
import com.zikyo.utils.Farmec.CardView;
import com.zikyo.utils.TestUtils;
import cucumber.api.java.en.And;


/**
 * Created by Sica-sama on 7/18/2016.
 */
public class MyCreditCardSteps {
   private CardView cardView = new CardView();
    @And("^I fill in credit card information$")
    public void iFillInCreditCardInformation()  {
        TestUtils.switchToIframe();
        cardView.setValues("4111111111111111","555","05 Mai","2020","Maestro");

    }

    @And("^I fill in card number \"([^\"]*)\", cvc \"([^\"]*)\", month \"([^\"]*)\", year \"([^\"]*)\" and card type \"([^\"]*)\"$")
    public void iFillInCardNumberCvcDateCardType(String cardNumber, String cvc, String month, String year, String type) {
        TestUtils.switchToIframe();
        cardView.setValues(cardNumber, cvc, month, year, type);
    }


    @And("^I click on  label \"([^\"]*)\" with class$")
    public void iClickOnLabelWithClass(String arg0) {
        WebLocator editSpan = new WebLocator("pull-right edit").setText("Editează");
        editSpan.click();

    }
}
