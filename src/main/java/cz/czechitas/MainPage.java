package cz.czechitas;

import org.openqa.selenium.*;

public class MainPage {

    WebDriver browser;

    public MainPage(WebDriver browser) {
        this.browser = browser;
    }

    public void navigateToHomepage() {
        browser.navigate().to("http://www.czechitas-hackhaton.cz/");
        System.out.println("Navigate to homepage");
    }

    public boolean isCartIconPresent() throws InterruptedException {

        WebElement cartIcon = browser.findElement(By.className("shopping_cart"));
        System.out.println("Search for Cart icon element");
        return cartIcon.isDisplayed();
    }


    public boolean isSignInIconPresent() {

        WebElement signInIcon = browser.findElement(By.className("user_login"));
        System.out.println("Search for Sign In element");
        return signInIcon.isDisplayed();
    }

    public void clickOnSignIn() throws InterruptedException {
        WebElement signInIcon = browser.findElement(By.className("user_login"));
        signInIcon.click();
        System.out.println("Click on Sign In link");
        Thread.sleep(5000);
    }

    public boolean isLogoIconPresent() {

        WebElement logoIcon = browser.findElement(By.id("header_logo"));
        System.out.println("Search for Logo icon element");
        return logoIcon.isDisplayed();
    }

    public boolean isMenuIconPresent() {

        WebElement menuIcon = browser.findElement(By.className("nav_toggle"));
        System.out.println("Search for Menu icon element");
        return menuIcon.isDisplayed();
    }

    public void inputSubscriptionField(String mail) throws InterruptedException {
        WebElement  subscriptionField = browser.findElement(By.id("newsletter-input"));
        subscriptionField.clear();
        Thread.sleep(2000);
        subscriptionField.sendKeys(mail);
        System.out.println("Write into subscription mail field: " + mail);
    }

    public void clickOnSubscribeButton() {
        WebElement subscriptionButton = browser.findElement(By.name("submitNewsletter"));
        subscriptionButton.click();
    }

    public boolean OKInSubscriptionField() {
        WebElement okIcon = browser.findElement(By.className("form-ok"));
        boolean okIconPresent = okIcon.isDisplayed();
        System.out.println("Check if the OK icon is displayed");
        return okIconPresent;
    }

}
