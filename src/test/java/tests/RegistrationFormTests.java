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
                .checkFirstName(firstName)
                .checkLastName(lastName)
                .checkEmail(email)
                .checkGender(gender)
                .checkPhone(phone)
                .checkDateOfBirth(day, month, year)
                .checkSubject(subject)
                .checkHobbies(hobby)
                .checkPicture(picture)
                .checkCurrentAddress(currentAddress)
                .checkState(state)
                .checkCity(city)
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
                .checkFirstName(firstName)
                .checkLastName(lastName)
                .checkGender(gender)
                .checkPhone(phone)
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





