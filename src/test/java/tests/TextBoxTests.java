package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests extends TestBase {


    @Test
    void successfulFillTest() {
        open("/text-box");
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
        open("/text-box");

        $("[id=userName]").setValue("Alex Black");
        $("[id=userEmail]").setValue("not-an-email"); // невалидный email
        $("[id=currentAddress]").setValue("test address");
        $("[id=permanentAddress]").setValue("test address 2");
        $("[id=submit]").click();
        $("[id=output]").shouldNotBe(visible, Duration.ofSeconds(5));
    }

    @Test
    void fillAllFieldsDetailedTest() {
        open("/automation-practice-form");
        $("[id=firstName]").setValue("Alex");
        $("[id=lastName]").setValue("Black");
        $("[id=userEmail]").setValue("alex@black.com");
        $("#genterWrapper").$(byText("Male")).click();
        $("[id=userNumber]").setValue("1020304050");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("January");
        $(".react-datepicker__year-select").selectOption("2000");
        $(".react-datepicker__day--001").click();
        $("#subjectsInput").setValue("Chemistry").pressEnter();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("[id=uploadPicture]").uploadFromClasspath("img.png");
        $("[id=currentAddress]").setValue("123  Street");
        $("#state").click();
        //$("#state").$(By.xpath(".//div[text()='NCR']")).click();
        $("#state").$(byText("NCR")).click();
        $("#city").click();
        $("#city").$(byText("Delhi")).click();
        $("[id=submit]").click();
        $(".modal-content").shouldBe(visible);

        $(".modal-body").shouldHave(text("Alex"));
        $(".modal-body").shouldHave(text("Black"));
        $(".modal-body").shouldHave(text("alex@black.com"));
        $(".modal-body").shouldHave(text("Male"));
        $(".modal-body").shouldHave(text("1020304050"));
        $(".modal-body").shouldHave(text("01 January,2000"));
        $(".modal-body").shouldHave(text("Chemistry"));
        $(".modal-body").shouldHave(text("Music"));
        $(".modal-body").shouldHave(text("img.png"));
        $(".modal-body").shouldHave(text("123  Street"));
        $(".modal-body").shouldHave(text("NCR"));
        $(".modal-body").shouldHave(text("Delhi"));

        $("#closeLargeModal").click();



    }

    @Test
    void fillRequiredFieldsDetailedTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Darja");
        $("#lastName").setValue("Koshman");
        $("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue("9999999999");
        $("#submit").scrollTo().click();
        $(".modal-content").shouldBe(visible);

        $(".modal-body").shouldHave(text("Darja"));
        $(".modal-body").shouldHave(text("Koshman"));
        $(".modal-body").shouldHave(text("Female"));
        $(".modal-body").shouldHave(text("9999999999"));

        $("#closeLargeModal").click();


    }
    @Test
    void negativeTest_emptyForm() {
        open("/automation-practice-form");
        $("#submit").scrollTo().click();
        $(".modal-content").shouldNotBe(visible);
    }
    @Test
    void negativeTest_shortPhone() {
        open("/automation-practice-form");
        $("#firstName").setValue("Andy");
        $("#lastName").setValue("Bin");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("123");
        $("#submit").scrollTo().click();
        $(".modal-content").shouldNotBe(visible);
    }
    @Test
    void negativeTest_onlyFirstName() {
        open("/automation-practice-form");

        $("#firstName").setValue("Andy");
        $("#submit").scrollTo().click();
        $(".modal-content").shouldNotBe(visible, Duration.ofSeconds(5));
        $("#firstName").shouldBe(visible);
    }
}
