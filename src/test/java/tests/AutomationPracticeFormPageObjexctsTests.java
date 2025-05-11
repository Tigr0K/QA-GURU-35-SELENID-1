package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.components.SubmitTableComponent;
import pages.RegistrationPage;


public class AutomationPracticeFormPageObjexctsTests extends testBase{

    RegistrationPage registrationPage = new RegistrationPage();
    SubmitTableComponent submitTableComponent = new SubmitTableComponent();

    @Test
    @DisplayName("Позитивный все поля")
    public void allFildsOfFormTest(){
        registrationPage.openPage()
                .removeBanner()
                .setFirstName("Murka")
                .setLastName("Barsikovna")
                .setUserEmail("murka.barsikovna@gmail.com")
                .setGender("Male")
                .setUserNumber("9866509834")
                .setBithDay("12", "September", "2000")
                .setSubjects("Maths")
                .setHobbies(new String[]{"Reading", "Sports"})
                .setAdress("Russia, Kirov")
                .uploadFile("file.PNG")
                .selectStateCity("NCR", "Gurgaon")
                .clickSubmitBtn();

        //Проверки
        submitTableComponent.addCheck("Student Name","Murka Barsikovna")
                .addCheck("Student Email", "murka.barsikovna@gmail.com")
                .addCheck("Gender", "Male")
                .addCheck("Mobile", "9866509834")
                .addCheck("Date of Birth", "12 September,2000")
                .addCheck("Subjects", "Maths")
                .addCheck("Hobbies", "Reading")
                .addCheck("Address", "Russia, Kirov")
                .addCheck("State and City","NCR Gurgaon");
    }

    @Test
    @DisplayName("Позитивный обязательные поля")
    public void minFildsOfFormTest() {
        registrationPage.openPage()
                .removeBanner()
                .setFirstName("Murka")
                .setLastName("Barsikovna")
                .setGender("Male")
                .setUserNumber("9866509834")
                .clickSubmitBtn();

        //Проверки
        submitTableComponent.addCheck("Student Name", "Murka Barsikovna")
                .addCheck("Gender", "Male")
                .addCheck("Mobile", "9866509834");
    }

    @Test
    @DisplayName("Нет номера телефона")
    public void noNumberFildsOfFormTest() {
        registrationPage.openPage()
                .removeBanner()
                .setFirstName("Murka")
                .setLastName("Barsikovna")
                .setGender("Male")
                .clickSubmitBtn();

        //Проверки
        submitTableComponent.isNotSubmitted();
    }
}

