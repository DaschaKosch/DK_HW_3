package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class TextBoxTests extends TestBase {


@Test
    void successfulFillTest() {
        Selenide.open("https://demoqa.com/text-box");
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

}
