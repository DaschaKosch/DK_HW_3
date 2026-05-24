package tests;

import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import testdata.TestData;
import static io.qameta.allure.Allure.step;

@Story("Registration form")
public class RegistrationFormTests extends TestBase {
    TestData data = new TestData();

    @Test
    @DisplayName("All fields")
    void fillAllFieldsDetailedTestWithFaker() {
        step("Open registration page", () ->
            registrationPage.openPage());

        step("Fill registration form", () -> {
            registrationPage.typeFirstName(data.firstName)
                .typeLastName(data.lastName)
                .typeUserEmail(data.email)
                .setGender(data.gender)
                .typeUserNumber(data.phone)
                .setDateOfBirth(data.day, data.month, data.year)
                .typeSubjects(data.subject)
                .setHobbies(data.hobby)
                .uploadPicture(data.picture)
                .typeCurrentAddress(data.currentAddress)
                .setStateAndCity(data.state, data.city)
                .submitForm();
        });

        step("Check registration form results", () -> {
            registrationPage.modalContentShouldBeVisible()
                    .getResult()
                    .checkResult(data.firstName)
                    .checkResult(data.lastName)
                    .checkResult(data.email)
                    .checkResult(data.gender)
                    .checkResult(data.phone)
                    .checkDateOfBirth(data.day, data.month, data.year)
                    .checkResult(data.subject)
                    .checkResult(data.hobby)
                    .checkResult(data.picture)
                    .checkResult(data.currentAddress)
                    .checkResult(data.state)
                    .checkResult(data.city)
                    .close();
        });
    }

    @Test
    @DisplayName("Required fields")
    void fillRequiredFieldsTestWithFaker() {
        step("Open registration page", () ->
                registrationPage.openPage());
        step("Fill registration form", () -> {
        registrationPage.typeFirstName(data.firstName)
                .typeLastName(data.lastName)
                .setGender(data.gender)
                .typeUserNumber(data.phone)
                .submitForm();
        });
        step("Check registration form results", () -> {
        registrationPage.modalContentShouldBeVisible()
                .getResult()
                .checkResult(data.firstName)
                .checkResult(data.lastName)
                .checkResult(data.gender)
                .checkResult(data.phone)
                .close();
        });

    }

    @Test
    @DisplayName("Negative empty form")
    void negativeEmptyFormTestWithFaker() {
        step("Open registration page", () ->
                registrationPage.openPage());
        step("Fill registration form", () -> {
        registrationPage.submitForm();
        });
        step("Check registration form results", () -> {
                registrationPage.modalContentShouldNotBeVisible();
        });
    }

    @Test
    @DisplayName("Invalid phone number")
    void invalidPhoneNumberTestWithFaker() {
        step("Open registration page", () ->
                registrationPage.openPage());
        step("Fill registration form", () -> {
        registrationPage.typeFirstName(data.firstName)
                .typeLastName(data.lastName)
                .setGender(data.gender)
                .typeUserNumber(data.negativePhone)
                .submitForm();
        });
        step("Check registration form results", () -> {
            registrationPage.modalContentShouldNotBeVisible();
        });

    }

    @Test
    @DisplayName("Negative only first name")
    void negativeFillOnlyFirstNameTestWithFaker() {
        step("Open registration page", () ->
                registrationPage.openPage());
        step("Fill registration form", () -> {
            registrationPage.typeFirstName(data.firstName)
                .submitForm();
        });
        step("Check registration form results", () -> {
            registrationPage.modalContentShouldNotBeVisible();
        });


    }
}





