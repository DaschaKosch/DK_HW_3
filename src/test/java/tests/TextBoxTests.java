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
        textBoxPage.openPage()
                .typeUserName(userName)
                .typeUserEmail(negativeUserEmail)
                .typeCurrentAddress(currentAddress)
                .typePermanentAddress(permanentAddress)
                .submitForm();

        textBoxPage.outputShouldNotBeVisible();
    }

}