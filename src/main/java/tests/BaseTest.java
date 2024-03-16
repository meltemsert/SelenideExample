package tests;

import com.codeborne.selenide.Selenide;
import org.testng.asserts.SoftAssert;
import common.PageManager;
import driver.DriverFactory;
import org.testng.annotations.*;

public class BaseTest {
    protected PageManager pageManager;
    protected SoftAssert softAssert;

    @BeforeClass
    public void setUp() {
        pageManager = new PageManager();
        softAssert = new SoftAssert();
    }

    @BeforeMethod(alwaysRun = true)
    public void openDriver() {
        Selenide.open();
    }

    @AfterMethod(alwaysRun = true)
    public void clearCookies() {
        DriverFactory.clearCookies();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        DriverFactory.close();
    }

}


