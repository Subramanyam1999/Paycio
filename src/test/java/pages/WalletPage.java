package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.time.Duration;

public class WalletPage {


    private WebDriver driver;
    private WebDriverWait wait;

    // Constructor
    public WalletPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//android.widget.TextView[@text='Wallet']")
    private WebElement walletTextView;


    @FindBy(xpath = "//android.widget.HorizontalScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/com.horcrux.svg.SvgView/com.horcrux.svg.GroupView/com.horcrux.svg.GroupView/com.horcrux.svg.PathView[1]")
    private WebElement withdrawButton;


    @FindBy(xpath = "//android.widget.ImageView")
    private WebElement cancelButton;


    @FindBy(xpath = "//android.widget.HorizontalScrollView/android.view.ViewGroup/android.view.ViewGroup[3]/com.horcrux.svg.SvgView/com.horcrux.svg.GroupView/com.horcrux.svg.GroupView/com.horcrux.svg.PathView")
    private WebElement swap;


    // XPath Locator using text
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Swap']")
    private WebElement SwapbackButton;


    @FindBy(xpath = "//android.widget.HorizontalScrollView/android.view.ViewGroup/android.view.ViewGroup[4]/com.horcrux.svg.SvgView/com.horcrux.svg.GroupView/com.horcrux.svg.PathView")
    private WebElement buy;


    @FindBy(xpath = "//android.widget.TextView[@text='Buy']\n")
    private WebElement buyBackButton;

    @FindBy(xpath = "//android.widget.HorizontalScrollView/android.view.ViewGroup/android.view.ViewGroup[5]/com.horcrux.svg.SvgView/com.horcrux.svg.GroupView/com.horcrux.svg.GroupView/com.horcrux.svg.GroupView/com.horcrux.svg.PathView")
    private WebElement sell;

    @FindBy(xpath = "//android.widget.TextView[@text='Sell']")
    private WebElement sellButton;


    @FindBy(xpath = "//android.view.ViewGroup[@bounds='[33,117][91,176]']")
    private WebElement swapButton;

    @FindBy(xpath = "//*[@class = 'android.widget.TextView' and (@text = 'Send via Phone Number' or . = 'Send via Phone Number')]")
    private WebElement sendViaPhoneNumText;


    @FindBy(xpath = "//*[@class = 'android.widget.EditText' and (@text = 'Enter Phone number' or . = 'Enter Phone number')]")
    private WebElement enterPhoneNumber;

    @FindBy(xpath = "//*[@class = 'android.widget.TextView' and (@text = 'User name : Bandaru Yoganandham' or . = 'User name : Bandaru Yoganandham')]")
    private WebElement userNameText;

    @FindBy(xpath = "//*[@class = 'android.widget.TextView' and (@text = 'Send via Crypto Network' or . = 'Send via Crypto Network')]") private WebElement cryptoNetwork;


    @FindBy(xpath = "//*[@class = 'android.widget.EditText' and (@text = 'Enter address' or . = 'Enter address')]")  private WebElement enterCryptoAddress;

    @FindBy(xpath = "//*[@class = 'android.widget.TextView' and (@text = 'Send via Paycio ID' or . = 'Send via Paycio ID')]")  private WebElement payCIoID;

@FindBy(xpath = "//*[@class = 'android.widget.EditText' and (@text = 'Enter Paycio User ID' or . = 'Enter Paycio User ID')]")  private WebElement enterPayCioUserID;




    public void clickWalletTextView() {
        try {
            // Wait until the 'Wallet' TextView is clickable
            wait.until(ExpectedConditions.elementToBeClickable(walletTextView));

            // Click the 'Wallet' TextView
            walletTextView.click();

            // Log after clicking the element
            Reporter.log("Successfully clicked the 'Wallet' TextView.", true);
        } catch (Exception e) {
            // Log if there is an error
            Reporter.log("An error occurred while interacting with the 'Wallet' TextView: " + e.getMessage(), true);
        }
    }

    public void clickWithdrawButton() {
        try {
            // Wait until the 'Withdraw' button is clickable
            wait.until(ExpectedConditions.visibilityOf(withdrawButton));

            // Click the 'Withdraw' button
            withdrawButton.click();

            // Log after clicking the element
            Reporter.log("Successfully clicked the 'Withdraw' button.", true);
        } catch (Exception e) {
            // Log if there is an error
            Reporter.log("An error occurred while interacting with the 'Withdraw' button: " + e.getMessage(), true);
        }
    }


    public void clickCancelButton() {
        try {
            // Wait until the cancel button is clickable
            wait.until(ExpectedConditions.elementToBeClickable(cancelButton));

            // Click the cancel button
            cancelButton.click();

            // Log after clicking the cancel button
            Reporter.log("Successfully clicked the 'Cancel' button.", true);
        } catch (Exception e) {
            // Log if there is an error
            Reporter.log("An error occurred while interacting with the 'Cancel' button: " + e.getMessage(), true);
        }
    }

    public void clickSwap() {
        try {
            // Wait until the 'swap' element is clickable
            wait.until(ExpectedConditions.elementToBeClickable(swap));

            // Click the 'swap' element
            swap.click();

            // Log after clicking the element
            Reporter.log("Successfully clicked the 'swap' Button.", true);
        } catch (Exception e) {
            // Log if there is an error
            Reporter.log("An error occurred while interacting with the 'swap' SVG Path View: " + e.getMessage(), true);
        }

    }


    public void backFromSwapPage() {
        try {
            // Wait until the 'back' button or equivalent element is clickable
            wait.until(ExpectedConditions.elementToBeClickable(SwapbackButton));

            // Click the 'back' button
            SwapbackButton.click();

            // Log after clicking the 'back' button
            Reporter.log("Successfully navigated back from the 'Swap' page.", true);
        } catch (Exception e) {
            // Log if there is an error
            Reporter.log("An error occurred while navigating back from the 'Swap' page: " + e.getMessage(), true);
        }
    }

    public void clickBuy() {
        try {
            // Wait until the 'buy' element is clickable
            wait.until(ExpectedConditions.elementToBeClickable(buy));

            // Click the 'buy' element
            buy.click();

            // Log after clicking the element
            Reporter.log("Successfully clicked the 'Buy' Button ", true);
        } catch (Exception e) {
            // Log if there is an error
            Reporter.log("An error occurred while interacting with the 'buy' SVG Path View: " + e.getMessage(), true);
        }
    }

    public void clickSell() {
        try {
            // Wait until the 'sell' element is clickable
            wait.until(ExpectedConditions.elementToBeClickable(sell));

            // Click the 'sell' element
            sell.click();

            // Log after clicking the element
            Reporter.log("Successfully clicked the 'sell' Button.", true);
        } catch (Exception e) {
            // Log if there is an error
            Reporter.log("An error occurred while interacting with the 'sell' SVG Path View: " + e.getMessage(), true);
        }


    }

    public void clickBuyBackButton() {
        try {
            // Wait until the 'Buy' button is clickable
            wait.until(ExpectedConditions.elementToBeClickable(buyBackButton));

            // Click the 'Buy' button
            buyBackButton.click();

            // Log after clicking the element
            Reporter.log("Successfully clicked the 'Buy' button.", true);
        } catch (Exception e) {
            // Log if there is an error
            Reporter.log("An error occurred while interacting with the 'Buy' button: " + e.getMessage(), true);
        }
    }

    public void clickSellButton() {
        try {
            // Wait until the 'Sell' button is clickable
            wait.until(ExpectedConditions.elementToBeClickable(sellButton));

            // Click the 'Sell' button
            sellButton.click();

            // Log after clicking the element
            Reporter.log("Successfully clicked the 'Sell' button.", true);
        } catch (Exception e) {
            // Log if there is an error
            Reporter.log("An error occurred while interacting with the 'Sell' button: " + e.getMessage(), true);
        }
    }

    public void clickOnSendViaPhoneNumber() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(sendViaPhoneNumText));
            if (sendViaPhoneNumText.isDisplayed() && sendViaPhoneNumText.isEnabled()) {
                sendViaPhoneNumText.click();
                Reporter.log("✅ Clicked on 'Send via Phone Number' option", true);
            } else {
                Reporter.log("❌ Element 'Send via Phone Number' is not enabled or not visible", true);
            }
        } catch (Exception e) {
            Reporter.log("❌ Failed to click on 'Send via Phone Number'. Error: " + e.getMessage(), true);
        }
    }


    public void enterAndLogPhoneNumber() {
        try {
            wait.until(ExpectedConditions.visibilityOf(enterPhoneNumber));
            enterPhoneNumber.sendKeys("9652096580");
        } catch (NoSuchElementException e) {
            System.out.println("Element not found. Page Source:");
            System.out.println(driver.getPageSource());
            throw e;
        }

    }

    public void verifyUserNameTextVisible() {
        try {
            wait.until(ExpectedConditions.visibilityOf(userNameText));
            Reporter.log("✅ User name text 'Bandaru Yoganandham' is visible.", true);
        } catch (Exception e) {
            Reporter.log("❌ User name text 'Bandaru Yoganandham' is NOT visible.", true);
        }
    }
    public void clickOnCryptoNetwork() {
        try {
            // Wait for cryptoNetwork element to be clickable
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(cryptoNetwork));
            Reporter.log("cryptoNetwork element is clickable", true);

            // Click the element
            cryptoNetwork.click();
            Reporter.log("Clicked on cryptoNetwork element", true);

        } catch (Exception e) {
            Reporter.log("Failed to click on cryptoNetwork: " + e.getMessage(), true);
            e.printStackTrace();
        }
    }
    public void enterCryptoAddress() {
        try {
            // Adjust the locator to match your app's crypto input field

            // Explicit wait
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement cryptoInputField = wait.until(ExpectedConditions.visibilityOf(enterCryptoAddress));

            // Crypto address to send
            String cryptoAddress = "0xA5385D4052De470350DAcf00eC68fb0BFaeD4f29";

            // Enter the address
            cryptoInputField.clear();
            cryptoInputField.sendKeys(cryptoAddress);

            // Logging
            Reporter.log("Crypto address entered successfully: " + cryptoAddress, true);
        } catch (Exception e) {
            Reporter.log("Failed to enter crypto address: " + e.getMessage(), true);
        }
    }

    public void clickPaycioID() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(payCIoID));

            payCIoID.click();
            Reporter.log("✅ Clicked on 'Send via Paycio ID' successfully.", true);
            System.out.println("✅ Clicked on 'Send via Paycio ID'");
        } catch (Exception e) {
            Reporter.log("❌ Failed to click on 'Send via Paycio ID': " + e.getMessage(), true);
            System.out.println("❌ Click failed: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void enterPayCioUserID() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(enterPayCioUserID));

            String userId = "919652096580";
            enterPayCioUserID.clear(); // optional: clear field before typing
            enterPayCioUserID.sendKeys(userId);

            Reporter.log("✅ Entered PayCio User ID: " + userId, true);
            System.out.println("✅ Entered PayCio User ID: " + userId);
        } catch (Exception e) {
            Reporter.log("❌ Failed to enter PayCio User ID: " + e.getMessage(), true);
            System.out.println("❌ Failed to enter PayCio User ID: " + e.getMessage());
            e.printStackTrace();
        }
    }









    public void clickBackNavigationButton() {
        try {
            // Wait until the 'Swap' button is clickable
            wait.until(ExpectedConditions.elementToBeClickable(swapButton));

            // Click the 'Swap' button
            swapButton.click();

            // Log after clicking the element
            Reporter.log("Successfully clicked the 'Back Navigation' button.", true);
        } catch (Exception e) {
            // Log if there is an error
            Reporter.log("An error occurred while interacting with the 'Swap' button: " + e.getMessage(), true);
        }
    }


}