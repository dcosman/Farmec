package com.zikyo.steps.genericSteps;

import com.sdl.selenium.WebLocatorUtils;
import com.sdl.selenium.bootstrap.form.Form;
import com.sdl.selenium.utils.config.WebDriverConfig;
import com.sdl.selenium.web.SearchType;
import com.sdl.selenium.web.WebLocator;
import com.sdl.selenium.web.button.Button;
import com.sdl.selenium.web.button.InputButton;
import com.sdl.selenium.web.form.ComboBox;
import com.sdl.selenium.web.form.TextField;
import com.sdl.selenium.web.link.WebLink;
import com.thoughtworks.selenium.webdriven.ElementFinder;
import com.zikyo.steps.TestBase;
import com.zikyo.utils.Farmec.LoginPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.Dimension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static com.zikyo.utils.TestUtils.sleep;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;



public class GenericSteps extends TestBase {
    private LoginPage loginPage = new LoginPage();
    private static final Logger LOGGER = LoggerFactory.getLogger(GenericSteps.class);
    private ElementFinder driver;


    @Given("^I open \"([^\"]*)\"$")
    public void openUrl(String url) {
        WebDriverConfig.getDriver().get(url);
    }

    @And("^I wait (\\d+) second(?:s*)$")
    public void waitSeconds(int seconds) {
        sleep(seconds);
    }

    @When("^I click on link with text \"([^\"]*)\"$")
    public void I_click_on_link_with_text(String text) {
        WebLink link = new WebLink().setText(text);
        link.assertClick();
    }

    //public static void main(String[] args) {
    //WebLink link = new WebLink().setText("Adviser", SearchType.TRIM, SearchType.EQUALS, SearchType.CHILD_NODE);
    //System.out.println(link.getXPath());
    // }


    @When("^I click on link with text2 \"([^\"]*)\"$")
    public void I_click_on_link_with_text2(String text) {
        WebLink link = new WebLink().setText(text, SearchType.TRIM, SearchType.EQUALS, SearchType.CHILD_NODE);
        link.assertClick();
    }

    @When("^I click on link with text3 \"([^\"]*)\"$")
    public void I_click_on_link_with_Text3(String text) {
        WebLink link = new WebLink().setText(text, SearchType.TRIM, SearchType.EQUALS, SearchType.DEEP_CHILD_NODE);
        link.assertClick();
    }

    @When("^I click on element with text \"([^\"]*)\"$")
    public void I_click_on_element_with_text(String text) throws Throwable {
        WebLocator element = new WebLocator().setText(text);
        element.assertClick();
    }

    @When("^I click on \"([^\"]*)\" button from the section \"([^\"]*)\"$")
    public void I_click_on_element_from_container_with_text(String text, String section) {
        Form form = new Form().setTitle(section);
        WebLink link = new WebLink(form).setText(text, SearchType.DEEP_CHILD_NODE_OR_SELF);
        link.assertClick();
    }

    @When("^I click on \"([^\"]*)\" on visible \"([^\"]*)\" form$")
    public void clickOnButton(String text, String legend) {
        WebLocator visibleWrapper = new WebLocator().setClasses("wrapper").setExcludeClasses("hide");
        Form form = new Form(visibleWrapper).setTitle(legend);
        WebLink link = new WebLink(form).setText(text, SearchType.DEEP_CHILD_NODE_OR_SELF);
        link.assertClick();
    }


    @When("^I click on input button with text \"([^\"]*)\"$")
    public void I_click_on_input_button_with_text(String text) {
        InputButton button = new InputButton().setText(text);
        button.click();
    }


    @When("^I click on  button2 with text \"([^\"]*)\"$")
    public void I_click_on_button2_with_text(String text) {
        Button button = new Button().setText(text).setClasses("top-margin-small");;
        button.click();
    }

    @Then("^I should see an element with text \"([^\"]*)\"$")
    public void assertHaveElementWithText(String text) {
        WebLocator element = new WebLocator().setText(text);
        element.assertReady();
    }



    @Then("^I should see following elements with texts \"(.*)\"$")
    public void assertHaveElementsWithText(List<String> texts) {
        for (String text : texts) {
            assertHaveElementWithText(text);
        }
    }

    @When("^I type \"([^\"]*)\" into \"([^\"]*)\" field$")
    public void typeIntoField(String value, String label) {
        TextField field = new TextField().setPlaceholder(label);
        assertThat("Failed to set value in field.", field.setValue(value));
    }

    @When("^I type \"([^\"]*)\" into2 \"([^\"]*)\" field$")
    public void typeIntoField_2(String value, String label) {
        TextField field = new TextField().setLabel(label).setLabelPosition("//following-sibling::").setVisibility(true);
        assertThat("Failed to set value in field.", field.setValue(value));
    }


    @Then("^field \"([^\"]*)\" should have value \"([^\"]*)\"$")
    public void text_field_with_label_should_have_value(String label, String value) {
        TextField field = new TextField().setLabel(label, SearchType.DEEP_CHILD_NODE_OR_SELF);
        assertThat(field.getValue(), is(value));
    }

    @When("^I mouse over on element with text \"([^\"]*)\"$")
    public void I_mouse_over_on_element_with_text(String text) {
        WebLocator element = new WebLocator().setText(text);
        element.mouseOver();
    }

    @Given("^I set browser size to (\\d+), (\\d+)$")
    public void setBrowserSize(int width, int height) {
        LOGGER.info("I set browser size to ({}, {})", width, height);
        WebDriverConfig.getDriver().manage().window().setSize(new Dimension(width, height));
    }

    @Given("^I maximize browser$")
    public void maximizeBrowser() {
        WebDriverConfig.getDriver().manage().window().maximize();
    }

    @Then("^I should be on url \"([^\"]*)\"$")
    public void I_should_be_on_url(String url) {
        assertThat(WebDriverConfig.getDriver().getCurrentUrl(), is(url));
    }

    @And("^I select \"([^\"]*)\" in the drop-down list named \"([^\"]*)\"$")
    public void selectValueInDropdown(String value, String label) {
        ComboBox comboBox = new ComboBox().setLabel(label);
        assertThat("Failed to select " + value, comboBox.select(value));
    }

    @And("^I select \"([^\"]*)\" in the drop-down list with label in separate div \"([^\"]*)\"$")
    public void selectValueInDropdownCustom(String value, String label) {
        ComboBox comboBox = new ComboBox().setLabel(label).setLabelPosition("//following::");
        assertThat("Failed to select " + value, comboBox.select(value));
    }

    @And("^I select \"(.+?)\" in the section \"(.+?)\" from the \"(.+?)\" form$")
    public void selectRadioFromSection(String value, String section, String formTitle) {
        Form parentForm = new Form().setTitle(formTitle);
        WebLocator parentDiv = new WebLocator(parentForm).setLabel(section).setLabelPosition("//following::").setTag("div");
        WebLocator radio = new WebLocator().setLabel(value).setLabelPosition("//preceding-sibling::").setTag("input").setType("radio");
        WebLocator clickableSpan = new WebLocator(parentDiv).setChildNodes(radio);
        clickableSpan.assertClick();
    }

    //private WebLocator addVisibilityCheck(WebLocator locator) {
    //return locator.setElPathSuffix("visibility", "count(ancestor::*[contains(concat(' ', @class, ' '), ' hide ')])=0");


    //public static void main (String[] args) {
    //Button button = new Button().setText("Login",SearchType.DEEP_CHILD_NODE_OR_SELF);
    //System.out.println(button.getXPath());
    // }
    //public static void main(String[] args) {
        // TextField field = new TextField().setLabel("What is the payroll commonly known as?").setLabelPosition("//preceding-sibling::").setTag("div");
        //TextField field = new TextField().setLabel("What is the payroll commonly known as?").setLabelPosition("//following::").setTag("div");
        //System.out.println(field.getXPath());
    //}


    // public static void I_click_on_element_by_class(String[] args) {
    //   WebLink link = new WebLink().setText("Continue", SearchType.CHILD_NODE);
    // System.out.println(link.getXPath());


    // public static I_click_on_GenericSteps(String[] args) {
    //InputButton button = new InputButton().setText("Login", SearchType.DEEP_CHILD_NODE_OR_SELF);
    // System.out.println(button.getXPath());


//        Form parentForm = new Form().setTitle("Drivers");

//        WebLocator subTitle = new WebLocator().setText("Add Driver Primary Applicant");
//        Form parentForm = new Form().setTitle("Drivers").setChildNodes(subTitle);

//        WebLocator visibleContainer = new WebLocator().setCls("wrapper demo");
//        Form parentForm = new Form(visibleContainer).setTitle("Drivers");

//        WebLocator visibleContainer = new WebLocator().setClasses("wrapper").setExcludeClasses("hide");
//        Form parentForm = new Form(visibleContainer).setTitle("Drivers");

    // WebLocator visibleContainer = new WebLocator().setClasses("wrapper").setExcludeClasses("hide");
    // Form parentForm = new Form(visibleContainer).setTitle("Drivers");

    //WebLink link = new WebLink(parentForm).setText("Continue", SearchType.DEEP_CHILD_NODE_OR_SELF);
    //System.out.println(link.getXPath());


    @And("^I select \"([^\"]*)\" in the active drop-down list \"([^\"]*)\"$")
    public void selectValueInActiveDropdown(String value, String label) {
        WebLocator parentDiv = new WebLocator().setClasses("filter-option pull-left");
        ComboBox comboBox = new ComboBox(parentDiv).setLabel(label).setLabelPosition("//following::");
        assertThat("Failed to select " + value, comboBox.select(value));

    }

    @And("^I click on label \"([^\"]*)\"$")
    public void I_click_on_label(String text) {
        WebLocator creditCardPaymentSpan = new WebLocator().setText(text);
        creditCardPaymentSpan.click();
    }
    @And("^I click on button with text \"([^\"]*)\"$")
    public void I_click_on_button_with_text(String text) throws Throwable {
        Button button = new Button().setText(text, SearchType.DEEP_CHILD_NODE_OR_SELF).setVisibility(true);
        button.assertClick();
    }

    @And("^I type \"([^\"]*)\" into \"([^\"]*)\" field with input type$")
    public void I_type_into_field_with_input_type(String value, String label) throws Throwable {
        TextField field = new TextField().setLabel(label).setLabelPosition("//following::");
        assertThat("Failed to set value in field.", field.setValue(value));
    }


    @And("^I select \"([^\"]*)\" in the drop-down list \"([^\"]*)\"$")
    public void I_select_in_the_drop_down_list(String value, String label)  {
        ComboBox comboBox = new ComboBox().setLabel(label).setLabel(label, SearchType.DEEP_CHILD_NODE_OR_SELF).setVisibility(true);
        assertThat("Failed to select " + value, comboBox.select(value));
    }


    @And("^I type \"([^\"]*)\" into \"([^\"]*)\" field with input$")
    public void I_type_into_field_with_input(String value, String label) throws Throwable {
        WebLocator container = new WebLocator().setTag("fieldset").setExcludeClasses("repeatPrototype");
        TextField field = new TextField(container).setLabel(label).setLabelPosition("//following::").setVisibility(true);
        boolean valueSet = field.setValue(value);
        assertThat("Failed to set value in field.", valueSet);
    }

    @And("^I select \"([^\"]*)\" in the drop-down list with container \"([^\"]*)\"$")
    public void I_select_in_the_drop_down_list_with_container(String value, String label) throws Throwable {
        WebLocator container = new WebLocator().setTag("fieldset").setExcludeClasses("repeatPrototype");
        ComboBox comboBox = new ComboBox(container).setLabel(label).setLabel(label, SearchType.DEEP_CHILD_NODE_OR_SELF).setVisibility(true);
        assertThat("Failed to select " + value, comboBox.select(value));
    }


    @And("^I type \"([^\"]*)\" into \"([^\"]*)\" with id$")
    public void I_type_into_label(String value, String Id) throws Throwable {
        WebDriverConfig.switchToLastTab();
        TextField field = new TextField().setId(Id);
        WebLocatorUtils.getXPathScript(field);
        assertThat("Failed to set value in field.", field.setValue(value));
    }

    @And("^I click on  button with text \"([^\"]*)\" with switch page$")
    public void I_click_on_button_with_text_with_switch_page(String text) throws Throwable {
        WebDriverConfig.switchToLastTab();
        TextField field = new TextField().setPlaceholder(text).setVisibility(true);
        WebLocatorUtils.getXPathScript(field);
        field.assertClick();

    }

    @And("^I click on  button with switch page \"([^\"]*)\"$")
    public void pressButtonAndSwitchTab(String value) {
        WebDriverConfig.switchToLastTab();
        InputButton button = new InputButton().setAttribute("value", value);
        button.assertClick();


    }



    @And("^I click on radio button with text \"([^\"]*)\"$")
    public void I_click_on_radio_button_with_text(String label) {
        WebLocator radio = new WebLocator().setLabel(label,SearchType.CONTAINS_ALL);
        radio.click();

    }

    @And("^I click on element with line-bar \"([^\"]*)\"$")
    public void I_click_on_element_with_line_bar(String Text) throws Throwable {
        WebLocator parentDiv = new WebLocator(). setBaseCls("button-nav");
        parentDiv.assertClick();
    }

    @Given("^I open url\"([^\"]*)\"$")
    public void iOpenUrl(String url)  {
        WebDriverConfig.getDriver().navigate().to(url);

    }

    @And("^I mouse over on link with text \"([^\"]*)\"$")
    public void iMouseOverOnLinkWithText(String text)  {
        WebLink link = new WebLink().setText(text);
        link.mouseOver();
        sleep(5);
    }


    public static void main(String[] args) {
        Button finalc = new Button().setText("Finalizează comanda").setClasses("top-margin-small");
        System.out.println(finalc.getXPath());


    }



}




