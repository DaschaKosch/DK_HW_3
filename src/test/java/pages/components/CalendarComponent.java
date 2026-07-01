package pages.components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    private final SelenideElement monthSelect = $(".react-datepicker__month-select");
    private final SelenideElement yearSelect = $(".react-datepicker__year-select");
    private final SelenideElement calendar = $(".react-datepicker");

    @Step("Set date {day} {month} {year}")
    public CalendarComponent setDate(String day, String month, String year) {
        monthSelect.selectOption(month);
        yearSelect.selectOption(year);
        calendar.$(By.xpath(".//div[contains(@class,'react-datepicker__day') and text()='" + day + "']"))
                .click();
        return this;
    }
}
