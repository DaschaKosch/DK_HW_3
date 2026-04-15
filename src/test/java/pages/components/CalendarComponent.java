package pages.components;

import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    public void setDate(String day, String month, String year) {
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker")
                .$(By.xpath(".//div[text()='" + day + "']" +
                        "[not(contains(@class, 'react-datepicker__day--outside-month'))]")).click();
    }
}
