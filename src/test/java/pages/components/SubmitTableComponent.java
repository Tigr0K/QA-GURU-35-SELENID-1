package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SubmitTableComponent {
    private final SelenideElement table = $(".table-responsive");
    public SubmitTableComponent addCheck(String fieldText, String value) {
        table.$(byText(fieldText)).parent().shouldHave(text(value));
        return this;
    }
    public SubmitTableComponent isNotSubmitted() {
        table.shouldNotBe(visible);
        return this;
    }
}
