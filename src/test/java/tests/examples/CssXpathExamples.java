package tests.examples;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static jdk.internal.org.jline.utils.Colors.s;
import static org.openqa.selenium.bidi.script.LocalValue.setValue;

public class CssXpathExamples {
    void cssXpath() {
        $("[data-testid=email]").setValue("1");
        $(by("data-testid","email")).setValue("1");
        $x("//*[@data-testid='email']").setValue("1");

        $("[id=email]").setValue("1");
        $(by("id","email")).setValue("1");
        $(byId("email")).setValue("1");
        $("[#email]").setValue("1");
        $x("//*[@id='email']").setValue("1");

        $("[name=email]").setValue("1");
        $(by("name","email")).setValue("1");
        $(byName("email")).setValue("1");
        $x("//*[@name='email']").setValue("1");
        $("input[name=email]").setValue("1");

        $("[class=inputtext] [class=login_form_input_box]").setValue("1");
        $(".inputtext.login_form_input_box").setValue("1");
        $(".login_form_input_box").setValue("1");
        $("input.inputtext.login_form_input_box").setValue("1");
        $(byClassName("login_form_input_box")).setValue("1");
        $x("//input[@Class='inputtext'][@class= 'login_form_input_box']").setValue("1");

        // <div class="inputtext">
        // <input type="email" class="login_form_input_box">
        // </div>
        $(".inputtext .login_form_input_box").setValue("1");
        //$(".inputtext").$(s:".login_form_input_box").setValue("1");
        $(".login_form_input_box").setValue("1");
        $("div.inputtext input.login_form_input_box").setValue("1");

        //<div>Hello, qa.guru!</div>
        $x("//*[text()='Hello, qa.guru!']"); //bad practice
        $x("//*[contains(text(),'Hello, qa.guru!')]"); //bad practice
        $(byText("Hello, qa.guru!"));
        $(withText("Hello, qa.guru!"));







    }
}
