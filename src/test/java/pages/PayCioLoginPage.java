package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

import java.time.Duration;

public class PayCioLoginPage extends BaseTest {

    private WebDriver driver;
    private WebDriverWait wait;

    // Constructor
    public PayCioLoginPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
    }

    // Locators
    @FindBy(xpath = "//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_allow_button\"]")
    private WebElement allowButton;

    @FindBy(xpath = "//android.widget.TextView[@text='Skip']")
    private WebElement skipButton;

    @FindBy(xpath = "//android.widget.EditText[@text='Mobile Number']")
    private WebElement mobileNumberField;

    @FindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup")
    private WebElement checkBox;

    @FindBy(xpath = "//android.widget.TextView[@text='Get Call']")
    private WebElement getCallButton;

    @FindBy(xpath = "//android.widget.Button[@resource-id='com.android.permissioncontroller:id/permission_allow_button']")
    private WebElement allowButtonPhoneCallLogs;

    @FindBy(xpath = "//android.widget.Button[@resource-id='com.android.permissioncontroller:id/permission_allow_one_time_button']")
    private WebElement allowLocationAccessButton;

    @FindBy(xpath = "//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_allow_one_time_button\"]")
    private WebElement deviceLocation;

    @FindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]")
    private WebElement verifyUpdate;

    @FindBy(xpath = "//android.widget.TextView[@text=\"Okay\"]")
    private WebElement okayButton;

    // Locate "Logout" button
    @AndroidFindBy(xpath = "//android.widget.Button[@text='Logout']")
    private WebElement logoutButton;

    // Locate "Yes, Log Me Out" button (confirmation)
    @AndroidFindBy(xpath = "//android.widget.Button[@text='Yes, Log Me Out']")
    private WebElement confirmLogoutButton;

    @Test
    public void clickAllowButton() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(allowButton));
            allowButton.click();
            System.out.println("Clicked the 'Allow' button.");  // Log to console
            Reporter.log("Clicked the 'Allow' button.", true);  // Log to report
        } catch (Exception e) {
            // Capture screenshot and log failure if exception occurs
            System.out.println("Failed to click 'Allow' button: " + e.getMessage());
            e.printStackTrace(); // Capture detailed error info
            throw e; // Rethrow the exception for test failure
        }
    }

    @Test
    public void clickSkipButton() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(skipButton));
            skipButton.click();
            System.out.println("Clicked the 'Skip' button.");  // Log to console
            Reporter.log("Clicked the 'Skip' button.", true);  // Log to report
        } catch (Exception e) {
            // Capture screenshot and log failure if exception occurs
            System.out.println("Failed to click 'Skip' button: " + e.getMessage());
            e.printStackTrace(); // Capture detailed error info
            throw e; // Rethrow the exception for test failure
        }
    }

    @Test
    public void enterMobileNumber() throws InterruptedException {
        try {
            String mobileNumber = "7658967891";  // Example mobile number
            wait.until(ExpectedConditions.visibilityOf(mobileNumberField));
            Thread.sleep(2000);
            mobileNumberField.clear();
            Thread.sleep(2000);
            mobileNumberField.sendKeys(mobileNumber);
            Reporter.log("Entered mobile number: " + mobileNumber, true); // Log the mobile number entry
        } catch (Exception e) {
            // Capture screenshot and log failure if exception occurs
            System.out.println("Failed to enter mobile number: " + e.getMessage());
            e.printStackTrace(); // Capture detailed error info
            throw e; // Rethrow the exception for test failure
        }
    }

    @Test
    public void clickCheckBox() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(checkBox));  // Wait until checkbox is clickable
            checkBox.click();  // Click the checkbox
            Reporter.log("Clicked the checkbox.", true);  // Log the action
        } catch (Exception e) {
            // Capture screenshot and log failure if exception occurs
            System.out.println("Failed to click checkbox: " + e.getMessage());
            e.printStackTrace(); // Capture detailed error info
            throw e; // Rethrow the exception for test failure
        }
    }

    @Test
    public void clickGetCallButton() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(getCallButton));  // Wait until the Get Call button is clickable
            getCallButton.click();  // Click the Get Call button
            Reporter.log("Clicked the 'Get Call' button.", true);  // Log the action
        } catch (Exception e) {
            // Capture screenshot and log failure if exception occurs
            System.out.println("Failed to click 'Get Call' button: " + e.getMessage());
            e.printStackTrace(); // Capture detailed error info
            throw e; // Rethrow the exception for test failure
        }
    }

    @Test
    public void clickAllowButtonPhoneCalls() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(allowButtonPhoneCallLogs));  // Wait until the Allow button is clickable
            allowButtonPhoneCallLogs.click();  // Click the Allow button for phone call logs
            Reporter.log("Clicked the 'Allow' button for phone call logs.", true);  // Log the action
        } catch (Exception e) {
            // Capture screenshot and log failure if exception occurs
            System.out.println("Failed to click 'Allow' button for phone call logs: " + e.getMessage());
            e.printStackTrace(); // Capture detailed error info
            throw e; // Rethrow the exception for test failure
        }
    }

    public void clickAllowLocationAccess() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(allowLocationAccessButton));
            allowLocationAccessButton.click();
            System.out.println("Location access granted.");
            Reporter.log("Location access granted.", true); // Log the action
        } catch (Exception e) {
            System.out.println("Location access button is not visible or clickable.");
            e.printStackTrace(); // Capture detailed error info
            throw e; // Rethrow the exception for test failure
        }
    }

    @Test
    public void verifyUpdateText() {
        try {
            // Wait until the 'Verify Update' element is visible
            wait.until(ExpectedConditions.visibilityOf(verifyUpdate));

            String updateText = verifyUpdate.getText();

            System.out.println("Text in 'Verify Update' element: " + updateText);
            Reporter.log("Text in 'Verify Update' element: " + updateText, true);

            String expectedText = "Update Available";  // Adjust this based on what the actual text should be
            assert updateText.equals(expectedText) : "Text mismatch! Expected: " + expectedText + " but got: " + updateText;

        } catch (Exception e) {
            // Log failure if exception occurs
            System.out.println("Failed to retrieve or verify text from 'Verify Update' element: " + e.getMessage());
            e.printStackTrace();  // Capture detailed error info
            throw e;  // Rethrow the exception for test failure
        }
    }

    @Test
    public void clickOkayButton() {
        try {

            wait.until(ExpectedConditions.elementToBeClickable(okayButton));

            okayButton.click();

            Reporter.log("Clicked the 'Okay' button.", true);

        } catch (Exception e) {
            // Log failure if exception occurs
            System.out.println("Failed to click 'Okay' button: " + e.getMessage());
            e.printStackTrace();  // Capture detailed error info
            throw e;  // Rethrow the exception for test failure
        }
    }
    // Click Logout button
    public void clickLogout() {
        wait.until(ExpectedConditions.elementToBeClickable(logoutButton)).click();
        Reporter.log("Clicked on Logout Button", true);
    }

    // Click "Yes, Log Me Out" button
    public void confirmLogout() {
        wait.until(ExpectedConditions.elementToBeClickable(confirmLogoutButton)).click();
        Reporter.log("Confirmed Logout by clicking 'Yes, Log Me Out'", true);
    }
}


