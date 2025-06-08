package tests;

import static tests.TestData.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.SubmitTableComponent;
import static io.qameta.allure.Allure.step;


public class AutomationPracticeFormWithFakerTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    SubmitTableComponent submitTableComponent = new SubmitTableComponent();

    @Test
    @Tag("smoke")
    @Tag("positiveFull")
    @DisplayName("Позитивный все поля")

    public void allFildsOfFormTest(){
        step("Открываем страницу", ()->{
            registrationPage.openPage()
                    .removeBanner();
        });
        step("Устанавливаем имя", ()->{
            registrationPage.setFirstName(firstName)
                    .setLastName(lastName);
        });
        step("Устанавливаем email", ()->{
            registrationPage.setUserEmail(email);
        });
        step("Устанавливаем пол", ()->{
            registrationPage.setGender(gender);
        });
        step("Устанавливаем телефон", ()->{
            registrationPage.setUserNumber(number);
        });
        step("Устанавливаем день рождения", ()->{
            registrationPage.setBithDay(day, month, year);
        });
        step("Устанавливаем предмет", ()->{
            registrationPage.setSubjects(subject);
        });

        step("Устанавливаем хобби", ()->{
            registrationPage.setHobbies(new String[]{hobby});
        });
        step("Устанавливаем адрес", ()->{
            registrationPage.setAdress(address);
        });
        step("Загружаем файл", ()->{
            registrationPage.uploadFile("file.PNG");
        });
        step("Устанавливаем город", ()->{
            registrationPage.selectStateCity(state, city);
        });
        step("Отправляем форму", ()->{
            registrationPage.clickSubmitBtn();;
        });


        //Проверки
        step("Проверки", ()->{
            submitTableComponent.addCheck("Student Name",firstName + " " + lastName)
                    .addCheck("Student Email", email)
                    .addCheck("Gender", gender)
                    .addCheck("Mobile", number)
                    .addCheck("Date of Birth", day + " " + month + "," + year)
                    .addCheck("Subjects", subject)
                    .addCheck("Hobbies", hobby)
                    .addCheck("Address", address)
                    .addCheck("State and City",state + " " + city);
        });

    }

    @Test
    @Tag("smoke")
    @Tag("positive")
    @DisplayName("Позитивный обязательные поля")
    public void minFildsOfFormTest() {
        registrationPage.openPage()
                .removeBanner()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .setUserNumber(number)
                .clickSubmitBtn();

        //Проверки
        submitTableComponent.addCheck("Student Name", firstName + " " + lastName)
                .addCheck("Gender", gender)
                .addCheck("Mobile", number);
    }

    @Test
    @Tag("smoke")
    @Tag("negative")
    @DisplayName("Нет номера телефона")
    public void noNumberFildsOfFormTest() {
        registrationPage.openPage()
                .removeBanner()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .clickSubmitBtn();

        //Проверки
        submitTableComponent.isNotSubmitted();
    }
}

