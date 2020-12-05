package cz.czechitas;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;

public class ElementsAndSubscriptionTests {

    private WebDriver browser;

    @Before
    public void SetUp() {

        System.setProperty("webdriver.gecko.driver", "C:/Java-Training/Selenium/geckodriver.exe");

        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("-private");
        browser = new FirefoxDriver(options);

    }

    @Test

    public void findHeaderElements_elementsPresent() throws InterruptedException {
        // This test corresponds to Shared Features - test #1, REQ-0020: Logo, login feature, Cart and Menu items are displayed on the main page

        MainPage mainPage = new MainPage(browser);
        
        mainPage.navigateToHomepage();

        boolean cartPresent = mainPage.isCartIconPresent();
        boolean signInPresent = mainPage.isSignInIconPresent();
        boolean logoPresent = mainPage.isLogoIconPresent();
        boolean menuPresent = mainPage.isMenuIconPresent();
        
        Assert.assertTrue("No Cart icon on the mainpage", cartPresent);
        Assert.assertTrue("No Sign in link on the mainpage", signInPresent);
        Assert.assertTrue("No Logo on the mainpage", logoPresent);
        Assert.assertTrue("No Menu button on the mainpage", menuPresent);
        
    }

    @Test

    public void ClickOnSignIn_landOnAuthenticationPage() throws InterruptedException {
        // This test corresponds to Shared Features - test #2, REQ-0021: By clicking on login button, user is transferred to „Authentification“ page
        // Tests if the user lands on the authentication page; grammar error from the specifications reported in Mantis

        MainPage mainPage = new MainPage(browser);

        AuthenticationPage authenticationPage = new AuthenticationPage(browser);

        mainPage.navigateToHomepage();
        mainPage.clickOnSignIn();
        String currentUrl = authenticationPage.checkCurrentUrl();
        Assert.assertEquals("The current URL is not the authentication page", "http://www.czechitas-hackhaton.cz/en/login?back=my-account", currentUrl);

    }

    @Test

    public void enterValidEmailtoSubscription_confirmationMessageAppears() throws InterruptedException {
        // This test corresponds to Shared Features - test #7, REQ-0025: When user enters email address and clicks „Subscribe“ button, he/she receives an on page confirmation, that user has been subscribed.

        MainPage mainPage = new MainPage(browser);

        mainPage.navigateToHomepage();

        mainPage.inputSubscriptionField("idd51271@eoopy.com");
        // The test only works when the email is submitted for the first time; in the second time, it fails because the mail is already subscribed.
        // The email idd51271@eoopy.com has not yet been used, so the test should go green if you'll run it now:)

        Thread.sleep(5000);

        mainPage.clickOnSubscribeButton();

        Thread.sleep(5000);

        Assert.assertTrue("OK icon not displayed", mainPage.OKInSubscriptionField());


    }


    @After
    public void CleanUp() throws InterruptedException {

        Thread.sleep(5000);

        browser.quit();

    }

}
