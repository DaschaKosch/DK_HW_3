/* package tests.examples;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebElementCondition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pages.TextBoxPage;
import tests.TestBase;

import java.time.Duration;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static testdata.TestData.*;

public class TextBoxTests extends TestBase {

    TextBoxPage textBoxPage = new TextBoxPage();


    @Test
    void successfulFormFillTest() {

        textBoxPage.openPage();
        textBoxPage.typeUserName(userName);
        textBoxPage.typeUserEmail(userEmail);
        textBoxPage.typeCurrentAddress(currentAddress);
        textBoxPage.typePermanentAddress(permanentAddress);
        textBoxPage.submitForm();

        textBoxPage.checkField("name", userName);
        textBoxPage.checkField("email", userEmail);
        textBoxPage.checkField("currentAddress", currentAddress);
        textBoxPage.checkField("permanentAddress", permanentAddress);

    }

    @Test
    void  invalidEmailFormatTest() {
        textBoxPage.openPage();
        textBoxPage.typeUserName(userName);
        textBoxPage.typeUserEmail(negativeUserEmail);
        textBoxPage.typeCurrentAddress(currentAddress);
        textBoxPage.typePermanentAddress(permanentAddress);
        textBoxPage.submitForm();

        textBoxPage.outputShouldNotBeVisible(visible);
    }
    }
 package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebElementCondition;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxPage {
    // Elements
    private SelenideElement userNameInput = $("#userName");
    private SelenideElement userEmailInput = $("#userEmail");
    private SelenideElement currentAddressInput = $("#currentAddress");
    private SelenideElement permanentAddressInput = $("#permanentAddress");
    private SelenideElement submitButton = $("#submit");
    private SelenideElement outputResults = $("#output");


    // Actions
    public void outputShouldNotBeVisible(WebElementCondition visible) {
        outputResults.shouldNotBe(Condition.visible);
    }


    public void outputShouldBeVisible() {
        outputResults.shouldBe(visible);
    }

    public void typeUserName(String value) {
        userNameInput.setValue(value);
    }

    public void typeCurrentAddress(String value) {
        currentAddressInput.setValue(value);
    }

    public void typePermanentAddress(String value) {
        permanentAddressInput.setValue(value);
    }

    public void typeUserEmail(String value) {
        userEmailInput.setValue(value);
    }

    public void openPage() {
        open("/text-box");
    }

    public void submitForm() {
        submitButton.scrollTo().click();
    }

    public void checkField(String key, String value) {
        outputResults.$(byId(key)).shouldHave(text(value));
    }
} */
