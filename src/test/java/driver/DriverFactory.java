package driver;

import com.codeborne.selenide.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.PropertyManager;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Objects;

public class DriverFactory {
    public static String browser;
    static PropertyManager propertyManager = new PropertyManager();

    public static void initDriver() {

        // Get settings from command line
        // Check if remote driver

        if (Objects.equals(propertyManager.getProperty("BROWSER"), "REMOTE")) {
            WebDriverRunner.setWebDriver(initRemoteDriver());
            return;
        }
        // Set settings for selenide browser

        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = false;
        Configuration.screenshots = false;
        Configuration.timeout = 10000;
        Configuration.pageLoadTimeout = 30000;
        Configuration.headless = Objects.equals(propertyManager.getProperty("HEADLESS"), "Y");
        browser = Objects.equals(propertyManager.getProperty("BROWSER"), null) ? "chrome" : propertyManager.getProperty("BROWSER");

        switch (browser) {
            case "CHROME":
                Configuration.browser = Browsers.CHROME;
                break;
            case "EDGE":
                Configuration.browser = Browsers.EDGE;
                break;
            case "FIREFOX":
                Configuration.browser = Browsers.FIREFOX;
                break;
            case "SAFARI":
                Configuration.browser = Browsers.SAFARI;
                break;
            default:
                Configuration.browser = Browsers.CHROME;
        }
    }

    private static RemoteWebDriver initRemoteDriver() {
        String host = "http://localhost:4444/wd/hub";
        String browserName = "CHROME";

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("browserName", browserName);
        capabilities.setCapability("screenResolution", "1920x1080");

        try {
            return new RemoteWebDriver(new URL(host), capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public static WebDriver currentDriver() {
        return WebDriverRunner.getWebDriver();

    }

    public static void open(String url) {
        Selenide.open(url);
    }

    public static void refresh() {
        Selenide.refresh();
    }

    public static void maximize() {
        currentDriver().manage().window().maximize();
    }

    public static void changeWindowSize(int width, int height) {
        currentDriver().manage().window().setSize(new Dimension(width, height));
    }

    public static void waitForUrlContains(String urlChunk) {
        WebDriverWait wait = new WebDriverWait(currentDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains(urlChunk));
    }

    public static void clearCookies() {
        open(propertyManager.getProperty("APP_URL"));
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
    }

    public static void close() {
        currentDriver().quit();
    }
}

