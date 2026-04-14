package tests;

import org.junit.jupiter.api.Test;
import testdata.TestData;


public class TextBoxTests extends TestBase {
    TestData  data = new TestData();
    @Test
    void successfulFormFillTestWithFaker() {


        textBoxPage.openPage()
                .typeUserName(data.userName)
                .typeUserEmail(data.userEmail)
                .typeCurrentAddress(data.currentAddress)
                .typePermanentAddress(data.permanentAddress)
                .submitForm()
                .outputShouldBeVisible()
                .getResult()
                .checkResult(data.userName)
                .checkResult(data.userEmail)
                .checkResult(data.currentAddress)
                .checkResult(data.permanentAddress);

    }

    @Test
    void  invalidEmailFormatTest() {

        textBoxPage.openPage()
                .typeUserName(data.userName)
                .typeUserEmail(data.negativeUserEmail)
                .typeCurrentAddress(data.currentAddress)
                .typePermanentAddress(data.permanentAddress)
                .submitForm();

        textBoxPage.outputShouldNotBeVisible();
    }

}