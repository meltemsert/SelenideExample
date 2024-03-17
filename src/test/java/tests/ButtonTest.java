package tests;

import static org.assertj.core.api.Assertions.assertThat;
import org.testng.annotations.Test;

public class ButtonTest extends BaseTest {

    @Test
    public void readMessageText() {
        pageManager.buttonPage.open();
        pageManager.buttonPage.clickButton();
        String actualText = pageManager.buttonPage.readMessageElement.getText();
        String expectedText = "You have done a dynamic click";
        assertThat(actualText).isEqualTo(expectedText);

    }
}
