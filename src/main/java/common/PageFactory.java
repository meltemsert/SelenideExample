package common;

import pages.ButtonPage;
import pages.AddAndEditPage;

public class PageFactory {
    public static ButtonPage buildButtonPage() {
        return new ButtonPage("/");
    }

    public static AddAndEditPage buildEditPage() {
        return new AddAndEditPage("/");

    }

}
