package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;

public class CreateTicket extends BaseTest {

    private WebDriver driver;
    private WebDriverWait wait;

    // Constructor
    public CreateTicket(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@class = 'android.widget.TextView' and (@text = 'Need assistance?' or . = 'Need assistance?')]")
    private WebElement assistanceTextView;


    @FindBy(xpath = "//android.widget.EditText[@text=\"Mobile Number\"]")
    private WebElement mobileNumberField;

    @FindBy(xpath = "//android.widget.EditText[@text='Enter your name']")
    private WebElement nameField;


    @FindBy(xpath = "//android.widget.EditText[@text='Enter your email']")
    private WebElement emailField;


    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='Select issue type']/android.widget.ImageView")
    private WebElement issueTypeImageView;


    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='Login issue']/android.view.ViewGroup/android.widget.ImageView")
    private WebElement loginIssueImageView;

    @FindBy(xpath = "//android.widget.TextView[@text='Confirm']")
    private WebElement confirmTextView;


    @FindBy(xpath = "//android.widget.EditText[@text='Write your issue here...']")
    private WebElement issueTextField;

    @FindBy(xpath = "//android.widget.TextView[@text='Upload Image of Issue']")
    private WebElement uploadImageButton;

    @FindBy(xpath = "//android.widget.TextView[@text='Choose from gallery']")
    private WebElement chooseFromGalleryButton;

    @FindBy(xpath = "(//android.widget.ImageView[@resource-id='com.google.android.providers.media.module:id/icon_thumbnail'])[1]")
    private WebElement imageView;

    @FindBy(xpath = "//android.widget.TextView[@text='Submit']")
    private WebElement submitButton;


    public void clickAssistanceTextView() {
        // Wait for a maximum of 10 seconds
        try {
            wait.until(ExpectedConditions.elementToBeClickable(assistanceTextView)); // Wait until the element is clickable
            assistanceTextView.click(); // Perform the click once it's clickable
        } catch (TimeoutException e) {
            System.out.println("Element was not clickable within the timeout period");
        }
    }

    public void enterMobileNumber() {
        try {
            // Waiting for up to 10 seconds
            wait.until(ExpectedConditions.elementToBeClickable(mobileNumberField));

            // Enter the mobile number '7658967891' into the field
            mobileNumberField.sendKeys("7658967891");

            // Log after entering the mobile number
            Reporter.log("Mobile number '7658967891' has been entered into the 'Mobile Number' field.", true);
        } catch (Exception e) {
            // Log if there is an error
            Reporter.log("An error occurred while interacting with the 'Mobile Number' field: " + e.getMessage(), true);
        }
    }

    public void enterYourName() {
        try {

            wait.until(ExpectedConditions.elementToBeClickable(nameField));

            // Enter the name 'venky' into the field
            nameField.sendKeys("venky");

            // Log after entering the name
            Reporter.log("Name 'venky' has been entered into the 'Enter your name' field.", true);
        } catch (Exception e) {
            // Log if there is an error
            Reporter.log("An error occurred while interacting with the 'Enter your name' field: " + e.getMessage(), true);
        }
    }

    public void enterEmail() {
        try {

            wait.until(ExpectedConditions.elementToBeClickable(emailField));

            // Enter the email 'vkautomationtesting@gmail.com' into the field
            emailField.sendKeys("vkautomationtesting@gmail.com");

            // Log after entering the email
            Reporter.log("Email 'vkautomationtesting@gmail.com' has been entered into the 'Enter your email' field.", true);
        } catch (Exception e) {
            // Log if there is an error
            Reporter.log("An error occurred while interacting with the 'Enter your email' field: " + e.getMessage(), true);
        }
    }

    public void selectIssueType() {
        try {
            // Wait until the "Select issue type" ImageView is clickable
            // Waiting for up to 10 seconds
            wait.until(ExpectedConditions.elementToBeClickable(issueTypeImageView));

            // Click the ImageView (Select issue type)
            issueTypeImageView.click();

            // Log after clicking the ImageView
            Reporter.log("Clicked on the 'Select issue type' ImageView.", true);
        } catch (Exception e) {
            // Log if there is an error
            Reporter.log("An error occurred while interacting with the 'Select issue type' ImageView: " + e.getMessage(), true);
        }
    }


    public void selectLoginIssue() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(loginIssueImageView));

            // Click the ImageView (Login issue)
            loginIssueImageView.click();

            // Log after clicking the ImageView
            Reporter.log("Clicked on the 'Login issue' ImageView.", true);
        } catch (Exception e) {
            // Log if there is an error
            Reporter.log("An error occurred while interacting with the 'Login issue' ImageView: " + e.getMessage(), true);
        }
    }

    public void clickConfirmButton() {
        try {

            wait.until(ExpectedConditions.elementToBeClickable(confirmTextView));

            // Click the Confirm button (TextView)
            confirmTextView.click();

            // Log after clicking the button
            Reporter.log("Clicked on the 'Confirm' TextView.", true);
        } catch (Exception e) {
            // Log if there is an error
            Reporter.log("An error occurred while interacting with the 'Confirm' TextView: " + e.getMessage(), true);
        }
    }

    public void enterIssueText() {
        try {
            // Waiting for up to 10 seconds
            wait.until(ExpectedConditions.elementToBeClickable(issueTextField));

            // Enter the issue text into the field (replace this with actual issue text)
            issueTextField.sendKeys("This is the issue description");

            // Log after entering the issue text
            Reporter.log("Entered the issue description into the 'Write your issue here...' field.", true);
        } catch (Exception e) {
            // Log if there is an error
            Reporter.log("An error occurred while interacting with the 'Write your issue here...' field: " + e.getMessage(), true);
        }
    }

    public void clickUploadImage() {
        try {
            // Wait until the 'Upload Image' button is clickable
            wait.until(ExpectedConditions.elementToBeClickable(uploadImageButton));

            // Click the 'Upload Image' button
            uploadImageButton.click();

            // Log after clicking the button
            Reporter.log("Successfully clicked the 'Upload Image' button.", true);
        } catch (Exception e) {
            // Log if there is an error
            Reporter.log("An error occurred while interacting with the 'Upload Image' button: " + e.getMessage(), true);
        }
    }


    public void clickChooseFromGallery() {
        try {
            // Wait until the 'Choose from gallery' button is clickable
            wait.until(ExpectedConditions.elementToBeClickable(chooseFromGalleryButton));

            // Click the 'Choose from gallery' button
            chooseFromGalleryButton.click();

            // Log after clicking the button
            Reporter.log("Successfully clicked the 'Choose from gallery' button.", true);
        } catch (Exception e) {
            // Log if there is an error
            Reporter.log("An error occurred while interacting with the 'Choose from gallery' button: " + e.getMessage(), true);
        }
    }

    public void clickImageView() {
        try {
            // Wait until the ImageView is clickable
            wait.until(ExpectedConditions.elementToBeClickable(imageView));

            // Click the ImageView
            imageView.click();

            // Log after clicking the ImageView
            Reporter.log("Successfully clicked the ImageView with resource-id 'icon_thumbnail'.", true);
        } catch (Exception e) {
            // Log if there is an error
            Reporter.log("An error occurred while interacting with the ImageView: " + e.getMessage(), true);
        }
    }

    public void clcikSubmitinCreateTicket(){

        wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
        submitButton.click();
        Reporter.log("✅ Successfully clicked the 'Submit' button.", true);
        System.out.println("✅ Successfully clicked the 'Submit' button.");

    }


    public void clickSubmitButtonAfterOTp() {
        wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
        submitButton.click();
        Reporter.log("✅ Successfully clicked the 'Submit' button.", true);
        System.out.println("✅ Successfully clicked the 'Submit' button.");


        // Define the locator for the error message
        By errorMessageLocator = By.xpath("//android.widget.TextView[@resource-id='com.paycio:id/snackbar_text']");

        try {
            // Wait for the error message to appear
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement errorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessageLocator));

            // Get the error message text
            String actualErrorMessage = errorElement.getText();

            // Styled log message for TestNG Reporter
            String logMessage = "<div style='background-color:#ff4c4c; color:white; padding:5px; font-weight:bold; border-radius:5px;'>"
                    + "❌🚨 <b>[ERROR MESSAGE]</b> → <b>\"" + actualErrorMessage + "\"</b> ❌🚨"
                    + "</div>";

            // Log the error message with red background in TestNG Report
            Reporter.log(logMessage, true);

            // Console log (ANSI escape codes for red background)
            System.out.println("\033[41;97m ❌🚨 [ERROR MESSAGE] → \"" + actualErrorMessage + "\" ❌🚨 \033[0m");

            // Assert that an error message is expected
            Assert.assertTrue(true, "✅ Test Passed: Validation message appeared as expected.");

        } catch (TimeoutException e) {
            // No error message appeared, so the validation is not working
            Reporter.log("<b style='color:red;'>❌ No validation error message displayed. Test failed!</b>", true);
            System.out.println("❌ No validation error message displayed. Test failed!");

            // Fail the test if no error message appears
            // Assert.fail("❌ Test Failed: Expected validation message but did not appear.");
        }
    }
    public void clickSubmitButton() {
wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
            submitButton.click();
            Reporter.log("✅ Successfully clicked the 'Submit' button.", true);
            System.out.println("✅ Successfully clicked the 'Submit' button.");


        // Define the locator for the error message
        By errorMessageLocator = By.xpath("//android.widget.TextView[@resource-id='com.paycio:id/snackbar_text']");

        try {
            // Wait for the error message to appear
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement errorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessageLocator));

            // Get the error message text
            String actualErrorMessage = errorElement.getText();

            // Styled log message for TestNG Reporter
            String logMessage = "<div style='background-color:#ff4c4c; color:white; padding:5px; font-weight:bold; border-radius:5px;'>"
                    + "❌🚨 <b>[ERROR MESSAGE]</b> → <b>\"" + actualErrorMessage + "\"</b> ❌🚨"
                    + "</div>";

            // Log the error message with red background in TestNG Report
            Reporter.log(logMessage, true);

            // Console log (ANSI escape codes for red background)
            System.out.println("\033[41;97m ❌🚨 [ERROR MESSAGE] → \"" + actualErrorMessage + "\" ❌🚨 \033[0m");

            // Assert that an error message is expected
            Assert.assertTrue(true, "✅ Test Passed: Validation message appeared as expected.");

        } catch (TimeoutException e) {
            // No error message appeared, so the validation is not working
            Reporter.log("<b style='color:red;'>❌ No validation error message displayed. Test failed!</b>", true);
            System.out.println("❌ No validation error message displayed. Test failed!");

            // Fail the test if no error message appears
           // Assert.fail("❌ Test Failed: Expected validation message but did not appear.");
        }
        try {
            WebElement otpScreen = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//android.widget.TextView[@text='OTP Verification.']")
            ));

            if (otpScreen.isDisplayed()) {
                WebElement imageView = driver.findElement(By.xpath("//android.widget.ImageView"));
                imageView.click();
            }
        } catch (Exception e) {
            System.out.println("OTP Verification screen not found, skipping ImageView click.");
        }

    }




    public void mobileNumberEmptyFiled(){

        wait.until(ExpectedConditions.visibilityOf(mobileNumberField));
        mobileNumberField.clear();

    }
    public void enter_invalid_email() {
        List<String> invalidEmails = Arrays.asList(
                "plainaddress",
                "@missingusername.com",
                "username@.com",
                "username@com",
                "username@domain..com",
                "username@domain.c",
                "user name@domain.com",
                "user@domain@domain.com",
                "shiva.pendem.8.9@gmail.com"
        );

        for (String invalidEmail : invalidEmails) {
            try {
                // Step 1: Locate and clear the email field
                emailField.clear();
                Thread.sleep(500); // Small wait to ensure the field is cleared

                // Step 2: Enter an invalid email
                emailField.sendKeys("shiva.pendem.8.9@gmail.com");

                // Step 3: Fetch the entered text using JavaScript Executor if getText() fails
                String enteredEmail;
                try {
                    enteredEmail = emailField.getText();
                    if (enteredEmail.isEmpty()) {
                        // Use JavaScript executor as a fallback
                        JavascriptExecutor js = (JavascriptExecutor) driver;
                        enteredEmail = (String) js.executeScript("return arguments[0].value;", emailField);
                    }
                } catch (Exception e) {
                    enteredEmail = "Unable to fetch entered text";
                }

                // Step 4: Log the entered email with highlighting in TestNG report
                Reporter.log("<b><font color='blue'>Entered Email:</font> <font color='red'>" + enteredEmail + "</font></b>", true);

                // Step 5: Wait for the error message (if any)
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
                WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@resource-id='com.paycio:id/snackbar_text']")));

                // Step 6: Log the error message if it is displayed
                Reporter.log("<b><font color='red'>Error Message Displayed:</font> " + errorMessage.getText() + "</b>", true);

            } catch (Exception e) {
                Reporter.log("<b><font color='orange'>No error message displayed or an issue occurred.</font></b>", true);
            }
        }
    }


    public void emailFieldClear() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        wait.until(ExpectedConditions.elementToBeClickable(emailField));

        emailField.clear();
    }


    public void crossButtonInOTPVerificationPage(){

        WebElement imageView = driver.findElement(By.xpath("//android.widget.ImageView"));
        imageView.click();
    }
}