package tests;

import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.*;
import static testdata.TestData.*;
import net.datafaker.Faker;

import java.util.Locale;

public class TextBoxTests extends TestBase {

    @Test
    void successfulFormFillTestWithFaker() {
        //Faker faker = new Faker();
        Faker faker = new Faker(new Locale("ru"));

        String userName = faker.name().fullName();
        String userEmail = faker.internet().emailAddress();
        String permanentAddress = faker.address().fullAddress();
        String currentAddress = faker.address().fullAddress();

        textBoxPage.openPage()
                .typeUserName(userName)
                .typeUserEmail(userEmail)
                .typeCurrentAddress(currentAddress)
                .typePermanentAddress(permanentAddress)
                .submitForm()
                .outputShouldBeVisible()
                .getResult()
                .checkResult(userName)
                .checkResult(userEmail)
                .checkResult(currentAddress)
                .checkResult(permanentAddress);

    }

    @Test
    void  invalidEmailFormatTest() {
        String userName = "Alex Black";
        String negativeUserEmail = "alex.com";
        String permanentAddress = "123 Street";
        String currentAddress = "123  Street";

        textBoxPage.openPage()
                .typeUserName(userName)
                .typeUserEmail(negativeUserEmail)
                .typeCurrentAddress(currentAddress)
                .typePermanentAddress(permanentAddress)
                .submitForm();

        textBoxPage.outputShouldNotBeVisible();
    }

}