package pages;


import com.codeborne.selenide.SelenideElement;
import pages.components.TextBoxResultComponent;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxPage {

    //===== Components =====
    private final TextBoxResultComponent resultComponent = new TextBoxResultComponent();

    // ===== Elements =====
    private final SelenideElement userNameInput = $("#userName");
    private final SelenideElement userEmailInput = $("#userEmail");
    private final SelenideElement currentAddressInput = $("#currentAddress");
    private final SelenideElement permanentAddressInput = $("#permanentAddress");
    private final SelenideElement submitButton = $("#submit");
    private final SelenideElement outputResults = $("#output");


    // ===== Actions ======
    public TextBoxPage outputShouldNotBeVisible() {
        outputResults.shouldNotBe(visible);
        return this;
    }

    public TextBoxPage outputShouldBeVisible() {
        outputResults.shouldBe(visible);
        return this;
    }

    public TextBoxPage typeUserName(String value) {
        userNameInput.setValue(value);
        return this;
    }

    public TextBoxPage typeCurrentAddress(String value) {
        currentAddressInput.setValue(value);
        return this;
    }

    public TextBoxPage typePermanentAddress(String value) {
        permanentAddressInput.setValue(value);
        return this;
    }

    public TextBoxPage typeUserEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public TextBoxPage openPage() {
        open("/text-box");
        return this;

    }

    public TextBoxPage submitForm() {
        submitButton.scrollTo().click();
        return this;
    }

    public TextBoxResultComponent getResult() {
        return resultComponent;
    }



}



