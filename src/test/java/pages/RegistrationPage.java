package pages;


import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import pages.components.CalendarComponent;
import pages.components.RegistrationResultComponent;
import java.time.Duration;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;



public class RegistrationPage {

    //===== Components =====
    private final CalendarComponent calendar = new CalendarComponent();
    private final RegistrationResultComponent resultComponent = new RegistrationResultComponent();

    // ===== Elements =====
    private final SelenideElement firstNameInput = $("#firstName");
    private final SelenideElement lastNameInput = $("#lastName");
    private final SelenideElement userEmailInput = $("#userEmail");
    private final SelenideElement userNumberInput = $("#userNumber");
    private final SelenideElement currentAddressInput = $("#currentAddress");
    private final SelenideElement genderContainer = $("#genterWrapper");
    private final SelenideElement hobbiesContainer = $("#hobbiesWrapper");
    private final SelenideElement uploadPictureInput = $("#uploadPicture");
    private final SelenideElement subjectsInput = $("#subjectsInput");
    private final SelenideElement submitButton = $("#submit");
    private final SelenideElement modalContent = $(".modal-content");


    // ===== Actions ======
    @Step("Open registration page /automation-practice-form")
    public RegistrationPage openPage() {
        open("/automation-practice-form");
        return this;
    }

    @Step("Type first name \"{value}\"")
    public RegistrationPage typeFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }
    @Step("Type last name \"{value}\"")
    public RegistrationPage typeLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }
    @Step("Type user name \"{value}\"")
    public RegistrationPage typeUserEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }
    @Step("Set gender \"{gender}\"")
    public RegistrationPage setGender(String value) {
        genderContainer.$(byText(value)).click();
        return this;
    }
    @Step("Type user number \"{value}\"")
    public RegistrationPage typeUserNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }
    @Step("Set date of Birth {day} {month} {year}")
    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendar.setDate(day, month, year);
        return this;
    }
    @Step("Type Subjects \"{value}\"")
    public RegistrationPage typeSubjects(String value) {
        subjectsInput.setValue(value).pressEnter();
        return this;
    }
    @Step("Set hobbies \"{value}\"")
    public RegistrationPage setHobbies(String value) {
        hobbiesContainer.$(byText(value)).click();
        return this;
    }
    @Step("Upload picture \"{value}\"")
    public RegistrationPage uploadPicture(String fileName) {
        uploadPictureInput.uploadFromClasspath(fileName);
        return this;
    }
    @Step("Type current address \"{value}\"")
    public RegistrationPage typeCurrentAddress(String value) {
        currentAddressInput.setValue(value);
        return this;
    }
    @Step("Set state and city {state} {city}")
    public RegistrationPage setStateAndCity(String state, String city) {
        $("#state").click();
        $(By.xpath("//*[contains(@id, 'react-select') and contains(@id, 'listbox')]//*[text()='" + state + "']"))
                .shouldBe(visible, Duration.ofSeconds(15))
                .click();
        $("#city").click();
        $(By.xpath("//*[contains(@id, 'react-select') and contains(@id, 'listbox')]//*[text()='" + city + "']"))
                .shouldBe(visible, Duration.ofSeconds(15))
                .click();

        return this;
    }
    @Step("Submit form")
    public  RegistrationPage submitForm() {
        submitButton.scrollTo().click();
        return this;
    }
    @Step("Get result {resultComponent}")
    public RegistrationResultComponent getResult() {
        return resultComponent;
    }

    @Step("Modal content should be visible")
    public RegistrationPage modalContentShouldBeVisible() {
        modalContent.shouldBe(visible);
        return this;
    }

    @Step("Modal content should not be visible")
    public RegistrationPage modalContentShouldNotBeVisible() {
        modalContent.shouldNotBe(visible);
        return this;
    }

}
