package common;

import driver.DriverFactory;
import pages.ButtonPage;
import pages.AddAndEditPage;

public class PageManager {
    public ButtonPage buttonPage;
    public AddAndEditPage addAndEditPage;

    public PageManager() {

        DriverFactory.initDriver();
        buttonPage = PageFactory.buildButtonPage();
        addAndEditPage = PageFactory.buildEditPage();
    }
}



