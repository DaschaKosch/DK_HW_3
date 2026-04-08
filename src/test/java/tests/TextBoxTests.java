package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import java.time.Duration;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static testdata.TestData.*;

public class TextBoxTests extends TestBase {

    @Test
    void successfulFormFillTest() {
        open("/text-box");
        $("#userName").setValue(userName);
        $("#userEmail").setValue(userEmail);
        $("#currentAddress").setValue(currentAddress);
        $("#permanentAddress").setValue(permanentAddress);
        $("#submit").scrollTo().click();

        $("#output #name").shouldHave(text(userName));
        $("#output #email").shouldHave(text(userEmail));
        $("#output #currentAddress").shouldHave(text(currentAddress));
        $("#output #permanentAddress").shouldHave(text(permanentAddress));

    }

    @Test
    void  invalidEmailFormatTest() {
        open("/text-box");

        $("#userName").setValue(userName);
        $("#userEmail").setValue("not-an-email"); // невалидный email
        $("#currentAddress").setValue(currentAddress);
        $("#permanentAddress").setValue(permanentAddress);
        $("#submit").click();
        $("#output").shouldNotBe(visible, Duration.ofSeconds(5));
    }

    @Test
    void fillAllFieldsDetailedTest() {
        open("/automation-practice-form");
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $("#genterWrapper").$(byText(gender)).click();
        $("#userNumber").setValue(phone);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(birthMonth);
        $(".react-datepicker__year-select").selectOption(birthYear);
        $(By.xpath("//div[contains(@class, 'react-datepicker__day') and text()='" + birthDay + "']")).click();
        $("#subjectsInput").setValue(subject).pressEnter();
        $("#hobbiesWrapper").$(By.xpath(".//label[text()='Music']")).click();
        $("#uploadPicture").uploadFromClasspath(picture);
        $("#currentAddress").setValue(currentAddress);
        $("#state").click();
        $("#state").$(byText(state)).click();
        $("#city").click();
        $("#city").$(byText(city)).click();
        $("#submit").click();
        $(".modal-content").shouldBe(visible);

        $(".modal-body").shouldHave(text(firstName));
        $(".modal-body").shouldHave(text(lastName));
        $(".modal-body").shouldHave(text(email));
        $(".modal-body").shouldHave(text(gender));
        $(".modal-body").shouldHave(text(phone));
        $(".modal-body").shouldHave(text(birthDay + " " + birthMonth + "," + birthYear));
        $(".modal-body").shouldHave(text(subject));
        $(".modal-body").shouldHave(text(hobby));
        $(".modal-body").shouldHave(text(picture));
        $(".modal-body").shouldHave(text(currentAddress));
        $(".modal-body").shouldHave(text(state));
        $(".modal-body").shouldHave(text(city));

        $("#closeLargeModal").click();

    }

    @Test
    void fillRequiredFieldsTest() {
        open("/automation-practice-form");
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#genterWrapper").$(byText(gender)).click();
        $("#userNumber").setValue(phone);
        $("#submit").scrollTo().click();
        $(".modal-content").shouldBe(visible);

        $(".modal-body").shouldHave(text(firstName));
        $(".modal-body").shouldHave(text(lastName));
        $(".modal-body").shouldHave(text(gender));
        $(".modal-body").shouldHave(text(phone));

        $("#closeLargeModal").click();


    }
    @Test
    void negativeEmptyFormTest() {
        open("/automation-practice-form");
        $("#submit").scrollTo().click();
        $(".modal-content").shouldNotBe(visible);
    }
    @Test
    void invalidPhoneNumberTest() {
        open("/automation-practice-form");
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#genterWrapper").$(byText(gender)).click();
        $("#userNumber").setValue("123");
        $("#submit").scrollTo().click();
        $(".modal-content").shouldNotBe(visible);
    }
    @Test
    void negativeFillOnlyFirstNameTest() {
        open("/automation-practice-form");

        $("#firstName").setValue(firstName);
        $("#submit").scrollTo().click();
        $(".modal-content").shouldNotBe(visible, Duration.ofSeconds(5));
        $("#firstName").shouldBe(visible);
    }
}