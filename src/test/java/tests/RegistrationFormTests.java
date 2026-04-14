package tests;

import org.junit.jupiter.api.Test;
import testdata.TestData;


public class RegistrationFormTests extends TestBase {
    TestData data = new TestData();

    @Test
    void fillAllFieldsDetailedTest() {
        registrationPage.openPage()
                .typeFirstName(data.firstName)
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
                .submitForm()
                .modalContentShouldBeVisible()
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
    }

    @Test
    void fillRequiredFieldsTest() {
        registrationPage.openPage()
                .typeFirstName(data.firstName)
                .typeLastName(data.lastName)
                .setGender(data.gender)
                .typeUserNumber(data.phone)
                .submitForm()
                .modalContentShouldBeVisible()
                .getResult()
                .checkResult(data.firstName)
                .checkResult(data.lastName)
                .checkResult(data.gender)
                .checkResult(data.phone)
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
                .typeFirstName(data.firstName)
                .typeLastName(data.lastName)
                .setGender(data.gender)
                .typeUserNumber(data.negativePhone)
                .submitForm()
                .modalContentShouldNotBeVisible();
    }

    @Test
    void negativeFillOnlyFirstNameTest() {
        registrationPage.openPage()
                .typeFirstName(data.firstName)
                .submitForm()
                .modalContentShouldNotBeVisible();

    }
}





