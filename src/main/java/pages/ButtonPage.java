package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
public class ButtonPage extends BasePage {
    public SelenideElement buttonElement = $("#item-4");
    public SelenideElement clickMeButtonElement = $(new By.ByXPath("//button[text() = 'Click Me']"));
    public SelenideElement readMessageElement = $("#dynamicClickMessage");

    public ButtonPage(String pageUrl) {
        super(pageUrl);
    }

    public void clickButton() {
        buttonElement.click();
        clickMeButtonElement.should(Condition.visible).click();
    }
}
