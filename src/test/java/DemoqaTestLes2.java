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
        $$(".react-datepicker__day").findBy(text("14")).click();

        //Должность
        $("#subjectsInput").setValue("Biology").pressEnter();

        //Увлечение
        $("#hobbiesWrapper").$(byText("Sports")).click();

        //Загрузка картинки
        $("#uploadPicture").uploadFromClasspath("2025-04-12_18-09-49.png");

        //Текущий адресс
        $("#currentAddress").setValue("Baker Street 1");

        //Штат и город
        $("#react-select-3-input").setValue("Haryana").pressEnter();
        $("#react-select-4-input").setValue("Karnal").pressEnter();

        $("#submit").click();

        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("Max Jons"));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Male"));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text("1234567890"));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text("14 August,1980"));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text("Biology"));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text("Sports"));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text("2025-04-12_18-09-49.png"));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text("Baker Street 1"));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text("Haryana Karnal"));
    }
}


