package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class AutomationPracticeForm {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    public void AllFildsOfFormTest(){
        open("/automation-practice-form");
        $("#firstName").setValue("Murka");
        $("#lastName").setValue("Barsikovna");
        $("#userEmail").setValue("murka.barsikovna@gmail.com");
        $("#userNumber").setValue("9866509834");
        $("#subjectsInput").setValue("Hello World");
        $("#currentAddress").setValue("Russia, Kirov");
        $x("//*[@id=\"genterWrapper\"]/div[2]/div[1]/label").click();
        $("#subjectsInput").setValue("Maths");
        SelenideElement inputField = Selenide.$("#subjectsInput");
        inputField.pressEnter();
        $x("//*[@id=\"hobbiesWrapper\"]/div[2]/div[2]/label").click();
        $x("//*[@id=\"hobbiesWrapper\"]/div[2]/div[1]/label").click();

        //Календарь
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("September");
        $(".react-datepicker__year-select").selectOption("2000");
        $$(".react-datepicker__day").findBy(text("12")).click();

        //Загрузка файлов
        $("input#uploadPicture").uploadFile(new File("src/test/data/file.PNG"));

        //Выбор страны/города
        $x("//*[@id=\"state\"]/div").click();
        $("#react-select-3-option-0").click();
        $x("//*[@id=\"city\"]").click();
        $("#react-select-4-option-1").click();

        $("#submit").click();

        //Проверки
        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("Murka Barsikovna"));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text("murka.barsikovna@gmail.com"));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Male"));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text("9866509834"));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text("12 September,2000"));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text("Maths"));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text("Reading, Sports"));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text("file.PNG"));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text("Russia, Kirov"));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text("NCR Gurgaon"));
    }
}

