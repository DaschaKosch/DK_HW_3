package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests extends TestBase {

    @BeforeEach
    void setUp() {
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void successfulFillTest() {
        open("https://demoqa.com/text-box");
        $("[id=userName]").setValue("Alex Black");
        $("[id=userEmail]").setValue("alex@black.com");
        $("[id=currentAddress]").setValue("first address 1");
        $("[id=permanentAddress]").setValue("second address 2");
        $("[id=submit]").click();

        $("[id=output] [id=name]").shouldHave(text("Alex Black"));
        $("[id=output] [id=email]").shouldHave(text("alex@black.com"));
        $("[id=output] [id=currentAddress]").shouldHave(text("first address 1"));
        $("[id=output] [id=permanentAddress]").shouldHave(text("second address 2"));

    }

    @Test
    void negativeTest_invalidEmailFormat() {
        open("https://demoqa.com/text-box");

        $("[id=userName]").setValue("Alex Black");
        $("[id=userEmail]").setValue("not-an-email"); // невалидный email
        $("[id=currentAddress]").setValue("test address");
        $("[id=permanentAddress]").setValue("test address 2");
        $("[id=submit]").click();
        $("[id=output]").shouldNotBe(visible, Duration.ofSeconds(5));
    }

    @Test
    void fillAllFieldsDetailedTest() {
        open("https://demoqa.com/automation-practice-form");
        $("[id=firstName]").setValue("Alex");
        $("[id=lastName]").setValue("Black");
        $("[id=userEmail]").setValue("alex@black.com");
        $("[id=gender-radio-1]").click();
        $("[id=userNumber]").setValue("1020304050");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("January");
        $(".react-datepicker__year-select").selectOption("2000");
        $(".react-datepicker__day--001").click();
        $("#subjectsInput").setValue("Chemistry").pressEnter();
        $("#hobbies-checkbox-3").click();
        $("[id=uploadPicture]").uploadFromClasspath("img.png");
        $("[id=currentAddress]").setValue("123  Street");
        $("[id=state]").click();
        $("[id=react-select-3-option-0]").click();
        $("[id=city]").click();
        $("[id=react-select-4-option-0]").click();
        $("[id=submit]").click();
        $(".modal-content").shouldBe(visible);

        $(".modal-body").shouldHave(
                text("Alex"),
                text("Black"),
                text("alex@black.com"),
                text("Male"),
                text("1020304050"),
                text("01 January,2000"),
                text("Chemistry"),
                text("Music"),
                text("img.png"),
                text("123  Street"),
                text("NCR"),
                text("Delhi")
        );


    }

    @Test
    void fillRequiredFieldsDetailedTest() {
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("Darja");
        $("#lastName").setValue("Koshman");
        $("#gender-radio-2").click();
        $("#userNumber").setValue("9999999999");
        $("#submit").scrollTo().click();
        $(".modal-content").shouldBe(visible);

        $(".modal-body").shouldHave(
                text("Darja"),
                text("Koshman"),
                text("Female"),
                text("9999999999")
        );
        $("#closeLargeModal").click();


    }
    @Test
    void negativeTest_emptyForm() {
        open("https://demoqa.com/automation-practice-form");
        $("#submit").scrollTo().click();
        $(".modal-content").shouldNotBe(visible);
    }
    @Test
    void negativeTest_shortPhone() {
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("Andy");
        $("#lastName").setValue("Bin");
        $("#gender-radio-1").click();
        $("#userNumber").setValue("123");
        $("#submit").scrollTo().click();
        $(".modal-content").shouldNotBe(visible);
    }
    @Test
    void negativeTest_onlyFirstName() {
        open("https://demoqa.com/automation-practice-form");

        $("#firstName").setValue("Andy");
        $("#submit").scrollTo().click();
        $(".modal-content").shouldNotBe(visible, Duration.ofSeconds(5));
        $("#firstName").shouldBe(visible);
    }
}
