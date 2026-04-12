package tests;

import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.*;
import static testdata.TestData.*;

public class TextBoxTests extends TestBase {

    @Test
    void successfulFormFillTest_dsl() {

        textBoxPage.openPage()
                .typeUserName(userName)
                .typeUserEmail(userEmail)
                .typeCurrentAddress(currentAddress)
                .typePermanentAddress(permanentAddress)
                .submitForm();

        textBoxPage.checkField("name", userName);
        textBoxPage.checkField("email", userEmail);
        textBoxPage.checkField("currentAddress", currentAddress);
        textBoxPage.checkField("permanentAddress", permanentAddress);

    }

    @Test
    void  invalidEmailFormatTest() {
        textBoxPage.openPage()
                .typeUserName(userName)
                .typeUserEmail(negativeUserEmail)
                .typeCurrentAddress(currentAddress)
                .typePermanentAddress(permanentAddress)
                .submitForm();

        textBoxPage.outputShouldNotBeVisible(visible);
    }

}