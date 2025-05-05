package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.components.SubmitTableComponent;
import pages.registrationPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;



public class AutomationPracticeFormPageObjexctsTests extends testBase{

    registrationPage RP = new registrationPage();
    SubmitTableComponent STC = new SubmitTableComponent();

    @Test
    public void allFildsOfFormTest(){
        RP.openPage()
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
        STC.addCheck("Student Name","Murka Barsikovna")
                .addCheck("Student Email", "murka.barsikovna@gmail.com")
                .addCheck("Gender", "Male")
                .addCheck("Mobile", "9866509834")
                .addCheck("Date of Birth", "12 September,2000")
                .addCheck("Subjects", "Maths")
                .addCheck("Hobbies", "Reading")
                .addCheck("Address", "Russia, Kirov")
                .addCheck("State and City","NCR Gurgaon");


    }
}

