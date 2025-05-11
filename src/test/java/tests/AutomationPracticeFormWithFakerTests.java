package tests;

import static tests.TestData.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.SubmitTableComponent;


public class AutomationPracticeFormWithFakerTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    SubmitTableComponent submitTableComponent = new SubmitTableComponent();

    @Test
    @DisplayName("Позитивный все поля")

    public void allFildsOfFormTest(){
        registrationPage.openPage()
                .removeBanner()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(email)
                .setGender(gender)
                .setUserNumber(number)
                .setBithDay(day, month, year)
                .setSubjects(subject)
                .setHobbies(new String[]{hobby})
                .setAdress(address)
                .uploadFile("file.PNG")
                .selectStateCity(state, city)
                .clickSubmitBtn();

        //Проверки
        submitTableComponent.addCheck("Student Name",firstName + " " + lastName)
                .addCheck("Student Email", email)
                .addCheck("Gender", gender)
                .addCheck("Mobile", number)
                .addCheck("Date of Birth", day + " " + month + "," + year)
                .addCheck("Subjects", subject)
                .addCheck("Hobbies", hobby)
                .addCheck("Address", address)
                .addCheck("State and City",state + " " + city);
    }

    @Test
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

