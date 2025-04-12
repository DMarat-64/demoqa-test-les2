import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class DemoqaTestLes2 {

    @BeforeAll
    static void beforeall() {
        Configuration.browserSize = "1920*1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
    }
    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        //ФИ=почта+пол+тел
        $("#firstName").setValue("Max");
        $("#lastName").setValue("Jons");
        $("#userEmail").setValue("max@jons.com");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("1234567890");

        //Д/р
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("1980");
        $(".react-datepicker__month-select").selectOption("August");
        $(".react-datepicker__day react-datepicker__day--001").click();

        //Должность
        $("#subjectsInput").setValue("Biology").pressEnter();

        //Увлечение
        $("#hobbiesWrapper").$(byText("Sports")).click();

        //Загрузка картинки
        $("#uploadPicture").uploadFromClasspath("2025-04-12_18-09-49.png");

        //Текущий адресс
        $("#currentAddress").setValue("Baker Street 1");

        //Штат и город
        $("#react-select-3-input").$(byText("Haryana")).click();
        $("#react-select-4-input").$(byText("Karnal")).click();

        $("#submit").click();

        $("[id=search]").shouldHave(text("https://selenide.org"));
    }
}


