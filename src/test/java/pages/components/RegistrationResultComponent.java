package pages.components;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationResultComponent {

    // ===== Elements =====
    private final SelenideElement modalBody = $(".modal-body");
    private final SelenideElement closeButton = $("#closeLargeModal");


    // ===== Actions ======

    public RegistrationResultComponent checkResult(String value) {
        modalBody.shouldHave(text(value));
        return this;

    }
    public RegistrationResultComponent checkDateOfBirth(String day, String month, String year) {
        modalBody.shouldHave(text(day + " " + month + "," + year));
        return this;
    }
        public RegistrationResultComponent close() {
            closeButton.click();
            return this;
        }

    }

