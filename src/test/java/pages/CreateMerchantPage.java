package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en_old.Ac;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.time.Duration;

public class CreateMerchantPage extends BaseTest {

    private WebDriver driver;
    private WebDriverWait wait;

    // Constructor
    public CreateMerchantPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//android.widget.TextView[@text='Create New Merchant']")
    private WebElement createNewMerchantText;

    @FindBy(xpath = "//android.widget.TextView[@text=\"Accept\"]")
    private WebElement acceptButton;

    @FindBy(xpath = "//android.widget.EditText[@text='Enter merchant user name']")
    private WebElement merchantUserNameField;


    @FindBy(xpath = "//android.widget.EditText[@text='Enter email']")
    private WebElement enterEmailField;

    @FindBy(xpath = "//android.widget.TextView[@class='android.widget.TextView' and @text='Select Category']")
    private WebElement categoryText;


    @FindBy(xpath = "//android.widget.TextView[@text='Automotive']")
    private WebElement automotiveText;

    @FindBy(xpath = "//android.widget.TextView[@text='Upcoming']")
    private WebElement upcomingText;

    public void scrollAndClickCreateNewMerchant() {
        // Scroll to the element with text "Create Merchant"
        WebElement element = driver.findElement(new AppiumBy.ByAndroidUIAutomator(
                "new UiScrollable(new UiSelector().className(\"android.widget.ScrollView\").scrollable(true))"
                        + ".scrollIntoView(new UiSelector().textMatches(\"Create Merchant\"))"));

        // Now that the element is visible, perform a click on it
        element.click();
        Reporter.log("clicked  merchantButton", true);
    }


    public void scrolltoendAndClickAcceptButton() {
        driver.findElement(new AppiumBy.ByAndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollToEnd(1, 5)"));
        wait.until(ExpectedConditions.elementToBeClickable(acceptButton));
        acceptButton.click();
        Reporter.log("CLicked accept Button", true);
    }


    public void enterMerchantStoreName() {
        try {
            // Log the action

            wait.until(ExpectedConditions.elementToBeClickable(merchantUserNameField));

            merchantUserNameField.sendKeys("Test1");

            Reporter.log("'Test1' has been typed into the field.", true);
        } catch (Exception e) {

            Reporter.log("An error occurred while interacting with the 'Enter mobile number / Address' field: " + e.getMessage(), true);
        }
    }

    public void enterEmail() {
        try {


            wait.until(ExpectedConditions.visibilityOf(enterEmailField));

            enterEmailField.sendKeys("vkautomationtesting@gmail.com");

            // Log after successfully typing into the field
            Reporter.log("'vkautomationtesting@gmail.com' has been typed into the field.", true);
        } catch (Exception e) {
            // Log if there is an error
            Reporter.log("An error occurred while interacting with the 'Enter email' field: " + e.getMessage(), true);
        }
    }


    public void clickOnCategory() {

        WebElement imageView = driver.findElement(By.xpath("//android.widget.TextView[@text='Select categogy']/following-sibling::android.widget.ImageView"));
        Actions a = new Actions(driver);
        a.moveToElement(imageView).click().perform();
        Reporter.log("Clicekd on Select category", true);
    }


    public void clickAutomotive() {
        try {
            // Log the action

            wait.until(ExpectedConditions.elementToBeClickable(automotiveText));

            automotiveText.click();

            // Log after clicking the element
            Reporter.log("'Automotive' TextView has been clicked.", true);
        } catch (Exception e) {
            // Log if there is an error
            Reporter.log("An error occurred while interacting with the 'Automotive' TextView: " + e.getMessage(), true);
        }
    }

    public void clickUpcoming() {
        try {
            // Log the action

            wait.until(ExpectedConditions.elementToBeClickable(upcomingText));

            upcomingText.click();

            // Log after clicking the element
            Reporter.log("'Upcoming' TextView has been clicked.", true);
        } catch (Exception e) {
            // Log if there is an error
            Reporter.log("An error occurred while interacting with the 'Upcoming' TextView: " + e.getMessage(), true);
        }
    }


    public boolean clickSubmitinUCPIPageWithRetries(String[] pinAttempts) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        for (String pin : pinAttempts) {
            enterPIN(pin);  // Enter PIN without finding input field
            operationsbutton.clickSubmitinUCPIPage();  // Click Submit

            try {
                // Check if error message appears
                WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//android.widget.TextView[@resource-id='com.paycio:id/snackbar_text']"))
                );

                String errorText = errorMessage.getText();
                Reporter.log("<b style='color: red;'>❌ Error: " + errorText + "</b>", true);
                System.out.println("❌ PIN Rejected: " + pin);

                // Wait before next attempt
                Thread.sleep(1000);

            } catch (TimeoutException e) {
                // No error message → PIN accepted
                Reporter.log("✅ PIN accepted: " + pin, true);
                System.out.println("✅ PIN Accepted: " + pin);
                return true;  // Exit loop if PIN is accepted
            } catch (Exception e) {
                Reporter.log("<b>❌ Unexpected Error: </b>" + e.getMessage(), true);
            }
        }

        Reporter.log("<b>⚠️ All PIN attempts failed.</b>", true);
        return false;  // No valid PIN found
    }

    public void enterPIN(String pin) {
        try {
            Thread.sleep(500); // Small delay to ensure the field is active
            driver.switchTo().activeElement().sendKeys(pin);
            Reporter.log("🔢 Entered PIN: " + pin, true);
            System.out.println("🔢 Entered PIN: " + pin);
        } catch (Exception e) {
            Reporter.log("<b style='color: red;'>❌ Error entering PIN: </b>" + e.getMessage(), true);
            System.out.println("❌ Error entering PIN: " + e.getMessage());
        }


    }


    public void clickOnSelectButton() {

        WebElement selectButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.ViewGroup[@content-desc='Select']\n")));
        Actions a = new Actions(driver);
        a.moveToElement(selectButton).click().perform();

    }

    public void clickOnSelectAll() {

        WebElement selectAllButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.ViewGroup[@content-desc=\"Select All\"]/android.view.ViewGroup/android.widget.ImageView")));
        Actions a = new Actions(driver);
        a.moveToElement(selectAllButton).click().perform();
        Reporter.log("Clicked on Selected All Check box", true);
    }

    public void clickOnConfirmButton() {

        WebElement confirmButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text=\"Confirm\"]")));
        Actions a = new Actions(driver);
        a.moveToElement(confirmButton).click().perform();
        Reporter.log("CLicked on Confirm Button ", true);

    }

    public void clickOnUploadText() {


        WebElement uploadLogo = driver.findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().text(\"Upload Logo\")"
        ));
        uploadLogo.click();

    }

    public void scrollAndClickCreateMerchant() {

        driver.findElement(new AppiumBy.ByAndroidUIAutomator(
                "new UiScrollable(new UiSelector().className(\"android.widget.ScrollView\").scrollable(true))"
                        + ".scrollToEnd(1)"
        ));

        // Wait briefly to allow UI to settle after scroll
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement ele = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc='Create Merchant']"));
        ele.click();


        Reporter.log("clicked on create Merchant button", true);
    }


    public void clickOnCreateMerchantButton() {

        WebElement ele = driver.findElement(By.xpath("//android.widget.TextView[@text='Create Merchant' and @package='com.paycio']"));
        Actions a = new Actions(driver);
        a.moveToElement(ele).click().perform();

    }

}




