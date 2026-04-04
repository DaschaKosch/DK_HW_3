package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests extends TestBase {
    String firstName = "Alex";
    String lastName = "Black";
    String email = "alex@black.com";
    String gender = "Male";
    String phone = "1020304050";
    String birthMonth = "January";
    String birthYear = "2000";
    String birthDay = "1";
    String subject = "Chemistry";
    String hobby = "Music";
    String picture = "img.png";
    String currentAddress = "123  Street";
    String state = "NCR";
    String city = "Delhi";

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
        $("[id=firstName]").setValue(firstName);
        $("[id=lastName]").setValue(lastName);
        $("[id=userEmail]").setValue(email);
        $("[value=" + gender + "]").click();
        $("[id=userNumber]").setValue(phone);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(birthMonth);
        $(".react-datepicker__year-select").selectOption(birthYear);
        $(By.xpath("//div[contains(@class, 'react-datepicker__day') and text()='" + birthDay + "']")).click();
        $("#subjectsInput").setValue(subject).pressEnter();
        $("#hobbiesWrapper").$(By.xpath(".//label[text()='Music']")).click();
        $("[id=uploadPicture]").uploadFromClasspath(picture);
        $("[id=currentAddress]").setValue(currentAddress);
        $("#state").click();
        $("#state").$(By.xpath(".//div[text()='" + state + "']")).click();
        $("#city").click();
        $("#city").$(By.xpath(".//div[text()='" + city + "']")).click();
        $("[id=submit]").click();
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
    void fillRequiredFieldsDetailedTest() {
        open("/automation-practice-form");
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("[value=" + gender + "]").click();
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
    void negativeTest_emptyForm() {
        open("/automation-practice-form");
        $("#submit").scrollTo().click();
        $(".modal-content").shouldNotBe(visible);
    }
    @Test
    void negativeTest_shortPhone() {
        open("/automation-practice-form");
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("[value=" + gender + "]").click();
        $("#userNumber").setValue("123");
        $("#submit").scrollTo().click();
        $(".modal-content").shouldNotBe(visible);
    }
    @Test
    void negativeTest_onlyFirstName() {
        open("/automation-practice-form");

        $("#firstName").setValue(firstName);
        $("#submit").scrollTo().click();
        $(".modal-content").shouldNotBe(visible, Duration.ofSeconds(5));
        $("#firstName").shouldBe(visible);
    }
}
