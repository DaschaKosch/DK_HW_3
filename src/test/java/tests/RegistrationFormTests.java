package tests;

import org.junit.jupiter.api.Test;
import static testdata.TestData.*;

public class RegistrationFormTests extends TestBase {

    @Test
    void fillAllFieldsDetailedTest() {
        registrationPage.openPage()
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .typeUserEmail(email)
                .setGender(gender)
                .typeUserNumber(phone)
                .setDateOfBirth(day, month, year)
                .typeSubjects(subject)
                .setHobbies(hobby)
                .uploadPicture(picture)
                .typeCurrentAddress(currentAddress)
                .setStateAndCity(state, city)
                .submitForm()
                .modalContentShouldBeVisible()
                .getResult()
                .checkResult(firstName)
                .checkResult(lastName)
                .checkResult(email)
                .checkResult(gender)
                .checkResult(phone)
                .checkDateOfBirth(day, month, year)
                .checkResult(subject)
                .checkResult(hobby)
                .checkResult(picture)
                .checkResult(currentAddress)
                .checkResult(state)
                .checkResult(city)
                .close();
    }

    @Test
    void fillRequiredFieldsTest() {
        registrationPage.openPage()
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .setGender(gender)
                .typeUserNumber(phone)
                .submitForm()
                .modalContentShouldBeVisible()
                .getResult()
                .checkResult(firstName)
                .checkResult(lastName)
                .checkResult(gender)
                .checkResult(phone)
                .close();

    }

    @Test
    void negativeEmptyFormTest() {
        registrationPage.openPage()
                .submitForm()
                .modalContentShouldNotBeVisible();
    }

    @Test
    void invalidPhoneNumberTest() {
        registrationPage.openPage()
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .setGender(gender)
                .typeUserNumber(negativePhone)
                .submitForm()
                .modalContentShouldNotBeVisible();
    }

    @Test
    void negativeFillOnlyFirstNameTest() {
        registrationPage.openPage()
                .typeFirstName(firstName)
                .submitForm()
                .modalContentShouldNotBeVisible();

    }
}





