package pages.components;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationResultComponent {

    // ===== Elements =====
    private SelenideElement modalBody = $(".modal-body");
    private SelenideElement closeButton = $("#closeLargeModal");


    // ===== Actions ======
        public RegistrationResultComponent checkFirstName(String firstName) {
            modalBody.shouldHave(text(firstName));
            return this;
        }

        public RegistrationResultComponent checkLastName(String lastName) {
            modalBody.shouldHave(text(lastName));
            return this;
        }

        public RegistrationResultComponent checkEmail(String email) {
            modalBody.shouldHave(text(email));
            return this;
        }

        public RegistrationResultComponent checkGender(String gender) {
            modalBody.shouldHave(text(gender));
            return this;
        }

        public RegistrationResultComponent checkPhone(String phone) {
            modalBody.shouldHave(text(phone));
            return this;
        }

        public RegistrationResultComponent checkDateOfBirth(String day, String month, String year) {
            modalBody.shouldHave(text(day + " " + month + "," + year));
            return this;
        }

        public RegistrationResultComponent checkSubject(String subject) {
            modalBody.shouldHave(text(subject));
            return this;
        }

        public RegistrationResultComponent checkHobbies(String hobby) {
            modalBody.shouldHave(text(hobby));
            return this;
        }

        public RegistrationResultComponent checkPicture(String picture) {
            modalBody.shouldHave(text(picture));
            return this;
        }

        public RegistrationResultComponent checkCurrentAddress(String address) {
            modalBody.shouldHave(text(address));
            return this;
        }

        public RegistrationResultComponent checkState(String state) {
            modalBody.shouldHave(text(state));
            return this;
        }

        public RegistrationResultComponent checkCity(String city) {
            modalBody.shouldHave(text(city));
            return this;
        }
        public RegistrationResultComponent close() {
            closeButton.click();
            return this;
        }

    }

