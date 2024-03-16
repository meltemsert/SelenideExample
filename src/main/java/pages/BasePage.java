package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import utils.PropertyManager;

public abstract class BasePage {
    protected String pageUrl;
    PropertyManager propertyManager = new PropertyManager();

    public BasePage(String pageUrl) {
        this.pageUrl = pageUrl;
    }

    public void open() {
        pageUrl = propertyManager.getProperty("APP_URL");
        Selenide.open(pageUrl);
    }

    public void openWebTables() {
        pageUrl = propertyManager.getProperty("APP_URL_2");
        Selenide.open(pageUrl);

    }

    public String getUrl() {
        return WebDriverRunner.getWebDriver().getCurrentUrl();
    }
}
