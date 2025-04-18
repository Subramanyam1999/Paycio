package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.time.Duration;

public class PayCioHomePage extends BaseTest {
    private WebDriver driver;
    private WebDriverWait wait;

    // Constructor
    public PayCioHomePage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }



    @FindBy(xpath = "//android.widget.TextView[contains(@text, 'Welcome')]")
    private WebElement welcomeBackText;

    @FindBy(xpath = "//android.widget.TextView[@text='Wallet']")
    private WebElement walletButton;


    @Test
    public void clickWelcomeBackButton() {
        try {

            wait.until(ExpectedConditions.elementToBeClickable(welcomeBackText));

            welcomeBackText.click();

            Reporter.log("Clicked the 'Welcome Back' button.", true);

        } catch (Exception e) {

            System.out.println("Failed to click 'Welcome Back' button: " + e.getMessage());
            e.printStackTrace();  // Capture detailed error info
            throw e;  // Rethrow the exception for test failure
        }



    }

    public void clickWalletButton() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(walletButton)); // Wait until it's clickable
            walletButton.click(); // Click the button
            Reporter.log("Clicked the 'Wallet' button.", true);
        } catch (Exception e) {
            System.out.println("Failed to click 'Wallet' button: " + e.getMessage());
            e.printStackTrace(); // Capture detailed error info
            throw e; // Rethrow the exception for test failure
        }
    }




}
