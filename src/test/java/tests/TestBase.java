package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.RegistrationPage;
import pages.TextBoxPage;

import java.util.Map;

import static com.codeborne.selenide.Selenide.closeWebDriver;


public class TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    TextBoxPage textBoxPage = new TextBoxPage();

    @BeforeAll
    static void setUpConfig() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.timeout = 10000;
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub"; //удаленная ферма Selenoid

        //для записи видео. Это объект свойств chrome
        ChromeOptions options = new ChromeOptions();
        options.setCapability("selenoid:options", Map.of(
                "enableVNC", true,      //потоковое видео
                "enableVideo", true
        ));                                     //можно добавить сертификат и пр.настройки
        Configuration.browserCapabilities = options;

    }

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

    }


    @AfterEach
    void addAttachments() {
        try {
            Attach.screenshotAs("Last screenshot");
            Attach.pageSource();
            Attach.browserConsoleLogs();
            Attach.addVideo();
        } finally {
            closeWebDriver();
        }
    }
}

