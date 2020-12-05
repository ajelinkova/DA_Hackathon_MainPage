package cz.czechitas;

import org.openqa.selenium.*;

public class AuthenticationPage {

    WebDriver browser;

    public AuthenticationPage(WebDriver browser) {
        this.browser = browser;
    }

    public String checkCurrentUrl() {
        String currentUrl = browser.getCurrentUrl();
        System.out.println("Get current URL");
        return currentUrl;
    }

}
