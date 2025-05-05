package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class registrationPage {

    private SelenideElement firstNameInput = $("#firstName");
    private SelenideElement lastNameInput = $("#lastName");
    private SelenideElement userEmailInput = $("#userEmail");
    private SelenideElement GenderWrapper = $("#genterWrapper");
    private SelenideElement numberInput = $("#userNumber");
    private SelenideElement calendarLocator = $("#dateOfBirthInput");
    private SelenideElement subjectsInput = $("#subjectsInput");
    private SelenideElement hobbiesWrapper = $("#hobbiesWrapper");
    private SelenideElement addressInput = $("#currentAddress");
    private SelenideElement uploadPicture = $("#uploadPicture");
    private SelenideElement setState = $("#state");
    private SelenideElement setCity = $("#city");
    private final ElementsCollection dropdownOptions = $$("div[id^='react-select']");
    private SelenideElement submitButton = $("#submit");

    CalendarComponent calCom = new CalendarComponent();

    public registrationPage openPage(){
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('#footer').remove()");
        return this;
    }
    public registrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public registrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public registrationPage setUserEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public registrationPage setGender(String value) {
        GenderWrapper.$(byText(value)).click();
        return this;
    }

    public registrationPage setUserNumber(String value) {
        numberInput.setValue(value);
        return this;
    }

    public registrationPage setBithDay(String day, String month, String year) {
        $(calendarLocator).click();
        calCom.setDate(day, month, year);
        return this;
    }
    public registrationPage setSubjects(String value) {
        subjectsInput.setValue(value).pressEnter();
        return this;
    }
    public registrationPage setHobbies(String [] valueArr) {
        for (int i = 0; i < valueArr.length; i++) {
            hobbiesWrapper.$(byText(valueArr[i])).click();
        }
        return this;
    }
    public registrationPage setAdress(String value) {
        addressInput.setValue(value);
        return this;
    }
    public registrationPage uploadFile (String path) {
        uploadPicture.uploadFromClasspath(path);
        return this;
    }
    public registrationPage selectStateCity (String state, String city) {
        setState.click();
        dropdownOptions.findBy(text(state)).click();
        setCity.click();
        dropdownOptions.findBy(text(city)).click();
        return this;
    }
    public void clickSubmitBtn() {
        submitButton.click();
    }


}
