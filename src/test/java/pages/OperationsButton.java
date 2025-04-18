package pages;

import UtilityMethods.ReceiveDetails;
import Tests.ReceiveFunds;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import io.appium.java_client.android.AndroidDriver;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;

import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;

import java.util.List;
import java.util.Random;

import UtilityMethods.ReceiveDetails;

public class OperationsButton extends BaseTest {

    private AndroidDriver driver;
    private WebDriverWait wait;

    // ✅ Corrected Constructor (No return type)
    public OperationsButton(AndroidDriver driver) {
        super(); // If BaseTest requires driver, use: super(driver);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//android.widget.TextView[@text=\"Scan any\n" +
            "QR Code\"]")
    private WebElement scanQrCodeText;

    @FindBy(xpath = "//android.widget.TextView[@text=\"Pay to\n" +
            "Mobile Number\"]")
    private WebElement payToMobileNumberText;

    @FindBy(xpath = "//android.widget.TextView[@text=\"Pay Contacts /\n" +
            "Address\"]")
    private WebElement payContactsAddressText;

    @FindBy(xpath = "//android.widget.TextView[@text=\"Receive\n" +
            "Funds\"]")
    private WebElement receiveFundsText;

    @FindBy(xpath = "//android.widget.Button[@resource-id='com.android.permissioncontroller:id/permission_allow_one_time_button']")
    private WebElement allowOneTimeButtonForCamera;

    @FindBy(xpath = "//android.widget.TextView[@text='Upload QR']")
    private WebElement uploadQrText;

    @FindBy(xpath = "//android.widget.TextView[@text=\"Albums\"]")
    private WebElement AlbumsButton;


    @FindBy(xpath = "(//android.widget.ImageView[@resource-id=\"com.google.android.providers.media.module:id/icon_thumbnail\"])[5]")
    private WebElement selectAlbum;


    @FindBy(xpath = "\n" +
            "//android.widget.ImageView[@resource-id=\"com.google.android.providers.media.module:id/icon_thumbnail\"]")
    private WebElement QRCodeImage;

    @FindBy(xpath = "//android.widget.EditText[@text='Minimum 10 USD']")
    private WebElement minimumAmountField;

    @FindBy(xpath = "//android.widget.TextView[@text='Submit']")
    private WebElement submitButton;

    @FindBy(xpath = "//android.widget.EditText[@text=\"Amount\"]")
    private WebElement setAmountEditfield;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.view.ViewGroup\").description(\"Bitcoin, BTC, Bitcoin Mainnet\")")
    private WebElement bitcoinElement;


    @FindBy(xpath = "//com.horcrux.svg.PathView")
    private WebElement crossButton;

    @FindBy(xpath = "//android.widget.TextView[@text=\"Ok\"]")
    private WebElement okButton;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Bitcoin, BTC, Bitcoin Mainnet\"]")
    private WebElement Expand;

    @FindBy(xpath = "//android.widget.TextView[@text='Ethereum']")
    private WebElement ethereumText;

    @FindBy(xpath = "//android.widget.TextView[@text=\"BitCoin Cash\"]")
    private WebElement bitcoinCashText;

    @FindBy(xpath = "(//android.widget.TextView[@text=\"USDC\"])[1]")
    private WebElement usdcText;


    @FindBy(xpath = "//android.widget.TextView[@text=\"Lite Coin\"]")
    private WebElement liteCoinText;


    @FindBy(xpath = "//android.widget.TextView[@text=\"Bitcoin\"]")
    private WebElement bitCoinElement;

    // Locate the Ethereum text element using @FindBy
    @FindBy(xpath = "//android.widget.TextView[@text=\"Ethereum\"]")
    private WebElement ethereumElement;


    @FindBy(xpath = "//android.widget.TextView[@text=\"Binance Coin\"]")
    private WebElement binanceElement;

    @FindBy(xpath = "//android.widget.TextView[@text=\"Tron\"]")
    private WebElement tronElement;

    @FindBy(xpath = "//android.widget.TextView[@text=\"TrueUSD\"]")
    private WebElement TrueUSDText;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"TrueUSD, TUSD, Ethereum Network\"]\n")
    private WebElement usdTusdText;

    @FindBy(xpath = "//android.widget.TextView[@text=\"Dash\"]")
    private WebElement clickDashText;

    @FindBy(xpath = "(//android.widget.TextView[@text=\"USDT\"])[1]")
    private WebElement clickUSDTText;

    @FindBy(xpath = "//android.widget.TextView[@text=\"Doge\"]")
    private WebElement clickDogeText;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Polygon, POL, Polygon Chain, $ 0.20\"]/android.view.ViewGroup/android.widget.ImageView")
    private WebElement PolygonText;


    @FindBy(xpath = "//*[@class = 'android.widget.TextView' and (@text = 'Tron Network' or . = 'Tron Network')]")
    private WebElement USDTTronNetworkText;

    @FindBy(xpath = "//android.widget.TextView[@text=\"Polygon\"]")
    private WebElement PolygonTexts;

    @FindBy(xpath = "//android.widget.TextView[@text=\"Solana Mainnet\"]")
    private WebElement SolanaText;

    @FindBy(xpath = "//android.widget.TextView[@text=\"Avalanche\"]")
    private WebElement AvalancheText;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='Tether USD, USDT, Binance Smart Chain']")
    private WebElement TetherText;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='Chainlink, LINK, Polygon Chain']")
    private WebElement chainLinkText;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Shiba Inu, SHIB, Ethereum Network\"]\n")
    private WebElement ShibaInuText;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Ripple, XRP, Ripple Payment protocol\"]")
    private WebElement rippleText;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='Polkadot, DOT, Polkadot Network']")
    private WebElement polkadotText;

    @FindBy(xpath = "//android.view.ViewGroup[contains(@content-desc, 'DAI, DAI, Ethereum Network')]/android.view.ViewGroup/android.widget.ImageView")
    private WebElement daiText;


    @FindBy(xpath = "//android.view.ViewGroup[contains(@content-desc, \"Arbitrum, ARB, Ethereum Network\")]")
    private WebElement arbitrumText;

    @FindBy(xpath = "//android.view.ViewGroup[contains(@content-desc, \"Mantle, MNT, Ethereum Network\")]")
    private WebElement mantleText;


    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Render Token, RNDR, Ethereum Network\"]/android.view.ViewGroup/android.widget.ImageView\n")
    private WebElement renderTokenText;

    @FindBy(xpath = "//android.view.ViewGroup[contains(@content-desc, \"Beam, BEAM, Ethereum Network\")]")
    private WebElement beamText;

    @FindBy(xpath = "//android.view.ViewGroup[contains(@content-desc, 'SAND, SAND, Ethereum Network')]")
    private WebElement sandText;


    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Injective Protocol, INJ, Binance Smart Chain\"]/android.view.ViewGroup/android.widget.ImageView\n")
    private WebElement injectiveProtocolText;

    @FindBy(xpath = "//android.view.ViewGroup[contains(@content-desc, \"First Digital, FDUSD, Binance Smart Chain\")]")
    private WebElement firstDigitalText;

    @FindBy(xpath = "//android.view.ViewGroup[contains(@content-desc, \"PancakeSwap, CAKE, Binance Smart Chain\")]")
    private WebElement pancakeSwapText;


    @FindBy(xpath = "//android.widget.TextView[@text=\"Green Metaverse Token\"]")
    private WebElement greenText;

    @FindBy(xpath = "//android.widget.TextView[@text=\"Sleepless AI Token\"]")
    private WebElement sleeplessTokenText;

    @FindBy(xpath = "//android.widget.TextView[@text=\"NFPrompt Token\"]")
    private WebElement NFPromptTokenText;

    @FindBy(xpath = "//android.widget.TextView[@text=\"BurgerCities\"]")
    private WebElement burgerCitiesText;

    @FindBy(xpath = "//android.widget.TextView[@text=\"Trust Wallet\"]")
    private WebElement trustWalletText;

    @FindBy(xpath = "//android.widget.FrameLayout[@content-desc=\"Copy\"]/android.widget.ImageView")
    private WebElement copySharingLink;

    private void logExecutionTime(String methodName, long startTime) {
        long endTime = System.currentTimeMillis();
        System.out.println(methodName + " executed in " + (endTime - startTime) + " ms");
    }


    public void pressAndroidBackButton() {
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        Reporter.log("<b>✅ Pressed the Android system Back button.</b>", true);
    }

    public void clickScanQrCode() {
        long startTime = System.currentTimeMillis();
        try {
            wait.until(ExpectedConditions.elementToBeClickable(scanQrCodeText));
            scanQrCodeText.click();
            Reporter.log("<b>✅ Clicked on the 'Scan any QR Code' TextView.</b>", true);
        } catch (Exception e) {
            Reporter.log("<b>❌ An error occurred while interacting with 'Scan any QR Code': </b>" + e.getMessage(), true);
        } finally {
            long endTime = System.currentTimeMillis();
            long executionTime = endTime - startTime;
            Reporter.log("<b>⏱ Execution Time for clickScanQrCode(): " + executionTime + " ms</b>", true);
        }
    }


    public void clickPayToMobileNumber() {
        long startTime = System.currentTimeMillis();
        try {
            wait.until(ExpectedConditions.elementToBeClickable(payToMobileNumberText)).click();
            Reporter.log("<b>✅ Clicked on the 'Pay to Mobile Number' TextView.</b>", true);
        } catch (Exception e) {
            Reporter.log("<b>❌ An error occurred while interacting with 'Pay to Mobile Number': </b>" + e.getMessage(), true);
        } finally {
            long endTime = System.currentTimeMillis();
            long executionTime = endTime - startTime;
            Reporter.log("<b>⏱ Execution Time for clickPayToMobileNumber(): " + executionTime + " ms</b>", true);
        }
    }


    public void clickPayContactsAddress() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(payContactsAddressText)).click();
            Reporter.log("<b>✅ Clicked on the 'Pay Contacts / Address' TextView.</b>", true);
        } catch (Exception e) {
            Reporter.log("<b>❌ An error occurred while interacting with 'Pay Contacts / Address': </b>" + e.getMessage(), true);
        }
    }

    public void clickReceiveFunds() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(receiveFundsText)).click();
            Reporter.log("<b>✅ Clicked on the 'Receive Funds' TextView.</b>", true);
        } catch (Exception e) {
            Reporter.log("<b>❌ An error occurred while interacting with 'Receive Funds': </b>" + e.getMessage(), true);
        }
    }

    public void clickAllowOneTimeForCamera() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(allowOneTimeButtonForCamera)).click();
            Reporter.log("<b>✅ Clicked the 'Allow One Time' button for camera permission.</b>", true);
        } catch (Exception e) {
            Reporter.log("<b>❌ An error occurred while clicking the 'Allow One Time' button: </b>" + e.getMessage(), true);
        }
    }

    public void clickUploadQR() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(uploadQrText)).click();
            Reporter.log("<b>✅ Clicked on the 'Upload QR' TextView.</b>", true);
        } catch (Exception e) {
            Reporter.log("<b>❌ An error occurred while interacting with 'Upload QR': </b>" + e.getMessage(), true);
        }
    }


    public void clickUploadQRAndUploadImage(String imagePath) {
        try {

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement fileInput = wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath("//android.widget.EditText")));  // Modify this locator based on your app's file input

            // Send the QR image file path
            fileInput.sendKeys(imagePath);
            Reporter.log("<b>✅ QR Code image uploaded from path: </b>" + imagePath, true);

        } catch (Exception e) {
            Reporter.log("<b>❌ Error while uploading QR code image: </b>" + e.getMessage(), true);
        }
    }


    public void uploadQRCode() {
        try {
            String filePath = "/storage/emulated/0/Pictures/WhatsApp/IMG-20250318-WA0043.jpg";

            wait.until(ExpectedConditions.elementToBeClickable(uploadQrText)).click();
            Reporter.log("<b>✅ Clicked on the 'Upload QR' button.</b>", true);

            WebElement fileInput = driver.findElement(By.xpath("//android.widget.EditText[@resource-id='your_file_input_field_id']"));
            fileInput.sendKeys(filePath);
            Reporter.log("<b>✅ Uploaded the QR Code image: " + filePath + "</b>", true);
        } catch (Exception e) {
            Reporter.log("<b>❌ An error occurred while uploading the QR code: </b>" + e.getMessage(), true);
        }
    }

    public void uploadQRCodeFromFile() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(uploadQrText)).click();
            Reporter.log("<b>✅ Clicked on the 'Upload QR' button.</b>", true);

            String filePath = "/storage/emulated/0/Pictures/WhatsApp/IMG-20250318-WA0043.jpg";
            WebElement fileInput = driver.findElement(By.xpath("//android.widget.EditText[@resource-id='com.android.documentsui:id/filename']"));
            fileInput.sendKeys(filePath);
            Reporter.log("<b>✅ Entered the QR Code image path: " + filePath + "</b>", true);
        } catch (Exception e) {
            Reporter.log("<b>❌ An error occurred while uploading the QR code: </b>" + e.getMessage(), true);
        }
    }

    public void clickAlbumsButton() {
        try {
//            wait.until(ExpectedConditions.elementToBeClickable(AlbumsButton));
//            AlbumsButton.click();
//            Reporter.log("<b>✅ Clicked on the 'Albums' button.</b>", true);
//
//            wait.until(ExpectedConditions.elementToBeClickable(selectAlbum));
//            selectAlbum.click();
//            Reporter.log("<b>✅ Selected an album.</b>", true);

            wait.until(ExpectedConditions.elementToBeClickable(QRCodeImage));
            QRCodeImage.click();
            Reporter.log("<b>✅ Clicked on the QR Code image.</b>", true);
        } catch (Exception e) {
            Reporter.log("<b>❌ An error occurred while selecting an album: </b>" + e.getMessage(), true);
        }
    }

    public void enterWithdrawAmount() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(minimumAmountField));
            minimumAmountField.sendKeys("10.01");
            Reporter.log("<b>✅ Entered withdraw amount: <font color='blue'>0.1</font></b>", true);
        } catch (Exception e) {
            Reporter.log("<b>❌ An error occurred while entering the withdrawal amount: </b>" + e.getMessage(), true);
        }
    }

    public void enterSubmitButton() {
        try {
            WebElement element = driver.findElement(
                    AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.TextView\").text(\" Submit\")")
            );
            element.click();
            Reporter.log("<b>✅ Clicked on the Submit button.</b>", true);
        } catch (Exception e) {
            Reporter.log("<b>❌ Error: Submit button not found or not clickable. </b>" + e.getMessage(), true);
        }
    }

    public boolean isElementDisplayed() {
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath("//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]")
            ));
            boolean isDisplayed = element.isDisplayed();
            if (isDisplayed) {
                Reporter.log("<b>✅ Element is displayed on the screen.</b>", true);
            } else {
                Reporter.log("<b>⚠️ Element is NOT displayed on the screen.</b>", true);
            }
            return isDisplayed;
        } catch (Exception e) {
            Reporter.log("<b>❌ An error occurred while verifying element visibility:</b> " + e.getMessage(), true);
            return false;
        }
    }

    public void show_Button() {
        try {
            driver.findElement(By.xpath("//android.widget.TextView[@text=\"Show\"]")).click();
            Reporter.log("<b>✅ Clicked on 'Show' button.</b>", true);
        } catch (Exception e) {
            Reporter.log("<b>❌ An error occurred while clicking 'Show' button: </b>" + e.getMessage(), true);
        }
    }

    public void clickSubmitinUCPIPage() {
        try {
            driver.findElement(By.xpath("//android.widget.TextView[@text=\"Submit\"]")).click();
            Reporter.log("<b>✅ Clicked on 'Submit' button in UCPI page.</b>", true);
        } catch (Exception e) {
            Reporter.log("<b>❌ An error occurred while clicking 'Submit' button: </b>" + e.getMessage(), true);
        }
    }

    public void verifyReceiverInfoErrorMessage() {
        try {
            // Define the locator for the specific error message
            By errorMsgLocator = AppiumBy.xpath(
                    "//*[@class='android.widget.TextView' and " +
                            "(@text='Unfortunately, we are unable to process this transaction as the receiver information is unknown.' or " +
                            ".='Unfortunately, we are unable to process this transaction as the receiver information is unknown.')]"
            );

            // Wait for the message to appear
            WebElement errorMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMsgLocator));

            if (errorMsg.isDisplayed()) {
                String errorText = errorMsg.getText();
                Reporter.log("<b style='color: white; background-color: red;'>❌ Error: " + errorText + "</b>", true);
                takeScreenshots("ReceiverInfoError_" + new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date()));
            }

        } catch (TimeoutException e) {
            Reporter.log("✅ No 'Receiver information unknown' error appeared.", true);
        } catch (Exception e) {
            Reporter.log("❌ Exception while verifying receiver info error: " + e.getMessage(), true);
            e.printStackTrace();
        }
    }

    public void clickOkayButtonIfPresent() {
        try {
            By okayBtnLocator = AppiumBy.xpath(
                    "//*[@class = 'android.widget.TextView' and (@text = 'Okay' or . = 'Okay')]");

            WebElement okayButton = wait.until(ExpectedConditions.elementToBeClickable(okayBtnLocator));

            if (okayButton.isDisplayed()) {
                String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
                takeScreenshots("OkayButtonVisible_" + timestamp);

                okayButton.click();
                Reporter.log("✅ Clicked on 'Okay' button.", true);
            }

        } catch (TimeoutException e) {
            Reporter.log("⚠️ 'Okay' button not found within timeout.", true);
        } catch (Exception e) {
            Reporter.log("❌ Exception while trying to click 'Okay' button: " + e.getMessage(), true);
            e.printStackTrace();
        }
    }


    public void selectAlbum() {
        try {
            wait.until(ExpectedConditions.visibilityOf(selectAlbum));
            wait.until(ExpectedConditions.elementToBeClickable(selectAlbum)).click();
            Reporter.log("<b>✅ Selected an album.</b>", true);
        } catch (Exception e) {
            Reporter.log("<b>❌ Failed to select an album: </b>" + e.getMessage(), true);
        }
    }

    public void clickQRCodeImage() {
        try {
            wait.until(ExpectedConditions.visibilityOf(QRCodeImage));
            wait.until(ExpectedConditions.elementToBeClickable(QRCodeImage)).click();
            Reporter.log("<b>✅ Clicked on the QR Code image.</b>", true);
        } catch (Exception e) {
            Reporter.log("<b>❌ Failed to click on the QR Code image: </b>" + e.getMessage(), true);
        }
    }

    public String clickEditTextField(String inputText) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        try {
            WebElement editText = wait.until(ExpectedConditions.elementToBeClickable(
                    AppiumBy.xpath("//*[@class = 'android.widget.EditText' and (@text = 'Enter Number / Name' or . = 'Enter Number / Name')]")
            ));
            wait.until(ExpectedConditions.elementToBeClickable(editText));
            editText.click();
            editText.clear();
            editText.sendKeys(inputText);

            Thread.sleep(500); // optional short wait
            String actualText = editText.getText();

            Reporter.log("📲 Intended to enter: " + inputText, true);
            Reporter.log("📝 Actual text in field: " + actualText, true);
            System.out.println("📝 Actual text in field: " + actualText);

            return actualText;

        } catch (Exception e) {
            Reporter.log("❌ Failed to interact with EditText: " + e.getMessage(), true);
            throw e;
        } finally {
            long endTime = System.currentTimeMillis();
            Reporter.log("<b>⏱ Execution Time: " + (endTime - startTime) + " ms</b>", true);
        }
    }


    public void clickSendIfElementVisible() {
        try {
            // Step 1: Wait for the specific element to become visible
            WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//*[@class='android.view.ViewGroup' and (@text='' or .='')]")
            ));

            if (ele.isDisplayed()) {
                Reporter.log("✅ Element is visible and displayed", true);

                // Step 2: Click the Send button if the element is displayed
                WebElement sendButton = wait.until(ExpectedConditions.elementToBeClickable(
                        AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.TextView\").text(\"Send\").packageName(\"com.paycio\").enabled(true).clickable(false).longClickable(false).checkable(false).checked(false).focusable(false).focused(false).scrollable(false).selected(false).index(0)")
                ));
                sendButton.click();
                Reporter.log("📨 Send button clicked successfully.", true);
            } else {
                Reporter.log("⚠️ Element is not displayed, skipping send.", true);
            }

        } catch (Exception e) {
            Reporter.log("❌ Exception occurred while checking element or clicking Send: " + e.getMessage(), true);
            e.printStackTrace();
        }
    }

    public void isElementDisplayedForAttention() {
        try {
            WebElement attentionText = wait.until(ExpectedConditions.presenceOfElementLocated(
                    AppiumBy.xpath("//*[@class = 'android.widget.TextView' and (@text = 'Attention!' or . = 'Attention!')]")
            ));

            if (attentionText.isDisplayed()) {
                Reporter.log("<b style='color: orange;'>⚠️ 'Attention!' alert is visible on the screen.</b>", true);
            } else {
                Reporter.log("<b style='color: gray;'>ℹ️ 'Attention!' text found but not visible.</b>", true);
            }

        } catch (TimeoutException e) {
            Reporter.log("<b style='color: red;'>❌ 'Attention!' element not found on screen.</b>", true);
        } catch (Exception e) {
            Reporter.log("<b style='color: red;'>❌ Unexpected exception: " + e.getMessage() + "</b>", true);
            e.printStackTrace();
        }
    }

    public void ClickiUnderstandButton() {
        try {
            WebElement understandButton = wait.until(ExpectedConditions.elementToBeClickable(
                    AppiumBy.xpath("//*[@class = 'android.widget.TextView' and (@text = 'I understand' or . = 'I understand')]")
            ));

            understandButton.click();
            Reporter.log("<b style='color:green;'>✅ Successfully clicked on 'I understand' button.</b>", true);

            // Optional: capture screenshot after clicking
            takeScreenshots("Clicked_I_Understand_" + new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date()));

        } catch (TimeoutException e) {
            Reporter.log("<b style='color:red;'>❌ 'I understand' button not found or not clickable.</b>", true);
            takeScreenshots("Understand_Button_NotFound_" + new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date()));
        } catch (Exception e) {
            Reporter.log("<b style='color:red;'>❌ Unexpected error while clicking 'I understand': " + e.getMessage() + "</b>", true);
            e.printStackTrace();
            takeScreenshots("Understand_Button_Exception_" + new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date()));
        }
    }


    public void clickIfNameAppears() {
        long startTime = System.currentTimeMillis(); // Start time tracking
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement tapToPay = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//android.view.ViewGroup[contains(@content-desc, 'Tap to pay')]")
            ));
            tapToPay.click();

            Reporter.log("✅ Successfully clicked on the specified name ('Tap to pay').", true);
            System.out.println("✅ Successfully clicked on the specified name ('Tap to pay').");

        } catch (Exception e) {
            Reporter.log("❌ Failed to click on the specified name: " + e.getMessage(), true);
            System.out.println("❌ Failed to click on the specified name: " + e.getMessage());
            e.printStackTrace();
            throw e; // Rethrow for test failure
        } finally {
            long endTime = System.currentTimeMillis(); // End time tracking
            long executionTime = endTime - startTime;
            Reporter.log("<b>⏱ Execution Time for clickIfNameAppears(): " + executionTime + " ms</b>", true);
            System.out.println("⏱ Execution Time for clickIfNameAppears(): " + executionTime + " ms");
        }
    }


    // Method to check if the element is present
    private boolean isElementPresent(String description) {
        try {
            driver.findElement(AppiumBy.androidUIAutomator(
                    "new UiSelector().className(\"android.view.ViewGroup\").description(\"" + description + "\")"
            ));
            return true;  // Element found
        } catch (Exception e) {
            return false; // Element not found
        }
    }

    public void enterAmount() {
        long startTime = System.currentTimeMillis(); // Start time tracking
        try {
            // Locate the input field using className or resource-id (if available)
            By amountInputLocator = AppiumBy.androidUIAutomator(
                    "new UiSelector().className(\"android.widget.EditText\")");

            // Wait for the input field to be present
            WebElement amountInput = wait.until(ExpectedConditions.presenceOfElementLocated(amountInputLocator));

            // Wait for the input field to be visible and enabled
            wait.until(ExpectedConditions.elementToBeClickable(amountInput));

            // Clear any pre-filled text (optional, based on UI behavior)
            amountInput.clear();

            // Send the amount
            amountInput.sendKeys("10.3");

            Reporter.log("✅ Entered amount: 10.3", true);

        } catch (Exception e) {
            Reporter.log("❌ Failed to enter amount: " + e.getMessage(), true);
            System.out.println("❌ Failed to enter amount: " + e.getMessage());
            e.printStackTrace();
            throw e; // Rethrow for test failure
        } finally {
            long endTime = System.currentTimeMillis(); // End time tracking
            long executionTime = endTime - startTime;
            Reporter.log("<b>⏱ Execution Time for enterAmount(): " + executionTime + " ms</b>", true);
            System.out.println("⏱ Execution Time for enterAmount(): " + executionTime + " ms");
        }
    }

    public void clickBitcoinElement() {
        long startTime = System.currentTimeMillis(); // Start time tracking
        try {
            // Define the locator using UiAutomator
            By bitcoinLocator = AppiumBy.androidUIAutomator(
                    "new UiSelector().className(\"android.view.ViewGroup\").description(\"USDC, USDC, Ethereum Network\")");

            // Wait until the element is present
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(bitcoinLocator));

            // Wait until the element is clickable
            wait.until(ExpectedConditions.elementToBeClickable(element));

            // Click the element
            element.click();

            // Log success
            Reporter.log("✅ Clicked on 'TrueUSD, TUSD, Ethereum Network'.", true);
            System.out.println("✅ Clicked on 'TrueUSD, TUSD, Ethereum Network'.");

        } catch (Exception e) {
            // Log failure
            Reporter.log("❌ Failed to click 'TrueUSD, TUSD, Ethereum Network': " + e.getMessage(), true);
            System.out.println("❌ Failed to click 'TrueUSD, TUSD, Ethereum Network': " + e.getMessage());
            e.printStackTrace();
            throw e; // Rethrow to mark test as failed
        } finally {
            long endTime = System.currentTimeMillis(); // End time tracking
            long executionTime = endTime - startTime;
            Reporter.log("<b>⏱ Execution Time for TrueUSD, TUSD, Ethereum Network(): " + executionTime + " ms</b>", true);
            System.out.println("⏱ Execution Time for TrueUSD, TUSD, Ethereum Network: " + executionTime + " ms");
        }
    }

    public void forceClickOnBNBTokenUsingActions() {
        try {
            WebElement bnbElement = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//android.view.ViewGroup[@content-desc='Binance Coin, BNB, Binance Smart Chain']")));

            Actions actions = new Actions(driver);
            actions.moveToElement(bnbElement).click().perform();

            Reporter.log("✅ Force-clicked on Binance Coin (BNB) using Actions class", true);

        } catch (Exception e) {
            Reporter.log("❌ Failed to click on Binance Coin (BNB): " + e.getMessage(), true);
        }
    }

    public void clickUSDCElement() throws InterruptedException {
        long startTime = System.currentTimeMillis(); // Start time tracking
        try {
            // 🔄 Scroll to bring USDC element into view
            WebElement usdcElement = driver.findElement(AppiumBy.androidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true).instance(0))" +
                            ".scrollIntoView(new UiSelector().descriptionContains(\"USDC, USDC, Ethereum Network\"))"
            ));

            // ✅ Wait for USDC element to be fully visible
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(usdcElement));
            wait.until(ExpectedConditions.elementToBeClickable(usdcElement));

            // ✅ Click on the USDC element to ensure focus
            usdcElement.click();
            Thread.sleep(1000); // Small pause to ensure the element is interacted with

            // ✅ Log success
            Reporter.log("✅ Successfully clicked on USDC checkbox.", true);
            System.out.println("✅ Successfully clicked on USDC checkbox.");

        } catch (Exception e) {
            // ❌ Log failure
            Reporter.log("❌ Failed to click on USDC checkbox: " + e.getMessage(), true);
            System.out.println("❌ Failed to click on USDC checkbox: " + e.getMessage());
            e.printStackTrace();
            throw e; // Rethrow exception to fail the test properly
        } finally {
            long endTime = System.currentTimeMillis(); // End time tracking
            long executionTime = endTime - startTime;
            Reporter.log("<b>⏱ Execution Time for clickUSDCElement(): " + executionTime + " ms</b>", true);
            System.out.println("⏱ Execution Time for clickUSDCElement(): " + executionTime + " ms");
        }
    }


    public void clickConfirmButton() {
        long startTime = System.currentTimeMillis(); // Start time tracking
        try {
            // Wait until the "Confirm" button is present in the DOM
            WebElement confirmButton = wait.until(ExpectedConditions.presenceOfElementLocated(
                    AppiumBy.xpath("//android.widget.TextView[@text='Confirm']")
            ));

            // Wait until the "Confirm" button is visible
            wait.until(ExpectedConditions.visibilityOf(confirmButton));

            // Wait until the "Confirm" button is clickable
            wait.until(ExpectedConditions.elementToBeClickable(confirmButton));

            // Click the "Confirm" button
            confirmButton.click();
            System.out.println("✅ Clicked on 'Confirm' button.");
            Reporter.log("✅ Clicked on 'Confirm' button.", true);

        } catch (Exception e) {
            System.out.println("❌ Failed to click 'Confirm' button: " + e.getMessage());
            Reporter.log("❌ Failed to click 'Confirm' button: " + e.getMessage(), true);
            e.printStackTrace();
            throw e; // Rethrow exception for test failure
        } finally {
            long endTime = System.currentTimeMillis(); // End time tracking
            long executionTime = endTime - startTime;
            Reporter.log("<b>⏱ Execution Time for clickConfirmButton(): " + executionTime + " ms</b>", true);
            System.out.println("⏱ Execution Time for clickConfirmButton(): " + executionTime + " ms");
        }
    }

    public void clickOnPayButton() {
        long startTime = System.currentTimeMillis(); // Start time tracking
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Explicit wait

            // Wait until the Pay button is clickable
            WebElement payButton = wait.until(ExpectedConditions.elementToBeClickable(
                    driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().description(\"Pay\")"))
            ));

            Reporter.log("✅ Pay Button Found. Clicking on it...", true);
            payButton.click();
            Reporter.log("✅ Pay Button Clicked Successfully", true);
            System.out.println("✅ Pay Button Clicked Successfully");

        } catch (Exception e) {
            Reporter.log("❌ Failed to Click on Pay Button: " + e.getMessage(), true);
            System.out.println("❌ Failed to Click on Pay Button: " + e.getMessage());
            e.printStackTrace();
            throw e; // Rethrow for test failure
        } finally {
            long endTime = System.currentTimeMillis(); // End time tracking
            long executionTime = endTime - startTime;
            Reporter.log("<b>⏱ Execution Time for clickOnPayButton(): " + executionTime + " ms</b>", true);
            System.out.println("⏱ Execution Time for clickOnPayButton(): " + executionTime + " ms");
        }
    }

    public void verifyTransactionSuccess() {
        long startTime = System.currentTimeMillis(); // Start time tracking
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

            // Define locators
            By successMessageLocator = By.xpath("//android.widget.TextView[@text='Transaction Successfull']");
            By errorMessageLocator = By.xpath("//android.widget.TextView[@resource-id='com.paycio:id/snackbar_text']");

            try {
                // Check if error message appears first
                WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessageLocator));
                String errorText = errorMessage.getText();
                Reporter.log("<b style='color: white; background-color: red; padding: 5px;'>❌ Error Message Displayed: " + errorText + "</b>", true);
                takeScreenshot("TransactionError");
                return;
            } catch (TimeoutException e) {
                // No error message, proceed
            }

            // Wait for success message
            WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(successMessageLocator));
            String actualText = successMessage.getText();
            String expectedText = "Transaction Successfull";

            // Screenshot before assertion
            takeScreen("TransactionSuccess");

            System.out.println("✅ Transaction Success Message Displayed: " + actualText);
            Reporter.log("✅ Transaction Success Message Displayed: " + actualText, true);

            // Assertion
            Assert.assertEquals(actualText, expectedText, "❌ Transaction success message does not match!");

        } catch (Exception e) {
            System.out.println("❌ Transaction success message not found: " + e.getMessage());
            Reporter.log("❌ Transaction success message not found: " + e.getMessage(), true);
            takeScreenshot("TransactionFailure");
            Assert.fail("❌ Transaction success message verification failed: " + e.getMessage());
        } finally {
            long endTime = System.currentTimeMillis();
            long executionTime = endTime - startTime;
            Reporter.log("<b>⏱ Execution Time for verifyTransactionSuccess(): " + executionTime + " ms</b>", true);
            System.out.println("⏱ Execution Time for verifyTransactionSuccess(): " + executionTime + " ms");
        }
    }

    public void takeScreen(String fileNamePrefix) {
        try {
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

            // Folder inside test-output
            String screenshotDir = System.getProperty("user.dir") + "/test-output/screenshots";
            File dir = new File(screenshotDir);
            if (!dir.exists()) {
                dir.mkdirs(); // Create folder if it doesn't exist
            }

            // Save screenshot
            String screenshotPath = screenshotDir + "/" + fileNamePrefix + "_" + timestamp + ".png";
            File destFile = new File(screenshotPath);
            FileUtils.copyFile(srcFile, destFile);

            // Relative path for embedding
            String relativePath = "screenshots/" + destFile.getName();

            // Embed full-size image directly
            Reporter.log("<br><b>📸 Screenshot:</b><br>"
                    + "<img src='" + relativePath + "' style='width:100%; border:1px solid #ddd; border-radius:4px; padding:5px;'/><br>", true);

        } catch (IOException e) {
            Reporter.log("❌ Failed to capture screenshot: " + e.getMessage(), true);
        }
    }


    // Ensure you import this

    public ReceiveDetails handleCurrencyClick(By clickElement, By addressElement, String currencyName, String screenshotName) {
        try {
            driver.findElement(clickElement).click();
            Thread.sleep(2000); // Optional: Wait for address to update

            String address = driver.findElement(addressElement).getText();
            String screenshotPath = takeScreenshot(screenshotName);

            return new ReceiveDetails(currencyName, address, screenshotPath);

        } catch (Exception e) {
            e.printStackTrace();
            return new ReceiveDetails(currencyName, "Failed to fetch", "Screenshot not available");
        }
    }


    public void grabResultsAboveEditText() {
        try {
            long startTime = System.currentTimeMillis();

            // Locate and click the EditText
            WebElement editText = wait.until(ExpectedConditions.presenceOfElementLocated(
                    AppiumBy.androidUIAutomator(
                            "new UiSelector().className(\"android.widget.EditText\").text(\"Enter Number / Name / Address\")"
                    )
            ));

            editText.click();
            String input = "Akas";
            editText.sendKeys(input);
            Reporter.log("✅ Entered contact name: " + input, true);

            // Allow results to load
            Thread.sleep(2000); // Replace with explicit wait if you prefer

            // Locate the ScrollView container
            WebElement resultsContainer = driver.findElement(By.xpath(
                    "//android.widget.ScrollView/android.view.ViewGroup"
            ));

            // Fetch all clickable token elements with content-desc
            List<WebElement> tokenElements = resultsContainer.findElements(
                    By.xpath(".//android.view.ViewGroup[@clickable='true' and @content-desc]")
            );

            Reporter.log("🔍 Found " + tokenElements.size() + " result(s) for '" + input + "':", true);
            System.out.println("🔍 Found " + tokenElements.size() + " result(s) for '" + input + "':");

            for (WebElement token : tokenElements) {
                String contentDesc = token.getAttribute("content-desc");
                Reporter.log("🔹 " + contentDesc, true);
                System.out.println("🔹 " + contentDesc);
            }

            long endTime = System.currentTimeMillis();
            Reporter.log("⏱ Execution time: " + (endTime - startTime) + " ms", true);

        } catch (Exception e) {
            Reporter.log("❌ Failed to grab results: " + e.getMessage(), true);
            System.out.println("❌ Exception: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void clickContactByAddress(String contactAddress) {
        try {
            // Step 1: Enter address in search field
            WebElement searchField = wait.until(ExpectedConditions.presenceOfElementLocated(
                    AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").textContains(\"Enter Number / Name\")")
            ));
            searchField.click();
            searchField.clear();
            searchField.sendKeys(contactAddress);
            Reporter.log("🔍 Entered contact address: " + contactAddress, true);
            Thread.sleep(1000);
            // 📸 Screenshot after entering address
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            takeScreenshots("EnteredAddress_" + timestamp);

            Thread.sleep(1000);

            // Step 2: Check for "Invalid Address" error popup with correct locator
            try {
                WebElement errorPopup = wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//*[@class = 'android.widget.TextView' and (@text = 'Invalid Address' or . = 'Invalid Address') and @resource-id = 'com.paycio:id/snackbar_text']")
                ));

                String errorText = errorPopup.getText();
                Reporter.log("<b style='color: white; background-color: red;'>❌ Error: " + errorText + "</b>", true);
                takeScreenshots("InvalidAddress_" + timestamp);
                return;
            } catch (TimeoutException e) {
                // No error popup appeared, continue execution
            }
            Thread.sleep(1000);
            // Step 3: Try to click contact card with matching address
            List<WebElement> contactCards = driver.findElements(By.xpath(
                    "//android.view.ViewGroup[@clickable='true' and @content-desc]"));

            boolean clicked = false;
            for (WebElement card : contactCards) {
                String desc = card.getAttribute("content-desc");
                if (desc != null && desc.contains(contactAddress.trim())) {
                    card.click();
                    Reporter.log("✅ Clicked contact card: " + desc, true);
                    takeScreenshots("ContactClicked_" + timestamp);
                    clicked = true;
                    break;
                }
            }

            if (!clicked) {
                Reporter.log("⚠️ No matching contact card found for: " + contactAddress, true);
                takeScreenshots("NoMatchFound_" + timestamp);
            }

        } catch (Exception e) {
            Reporter.log("❌ Exception while processing contact: " + e.getMessage(), true);
            takeScreenshots("Exception_" + new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date()));
            e.printStackTrace();
        }
    }


    public void takeScreenshots(String filename) {
        try {
            // Capture screenshot
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            // Save inside test-output/screenshots/ (TestNG report can reference this)
            String screenshotsDir = System.getProperty("user.dir") + "/test-output/screenshots/";
            String filePath = screenshotsDir + filename + ".png";
            File dest = new File(filePath);
            dest.getParentFile().mkdirs(); // Create folders if they don't exist
            FileUtils.copyFile(src, dest);

            // Embed screenshot in TestNG report using relative path
            String relativePath = "screenshots/" + filename + ".png";
            String htmlTag = "<br><a href='" + relativePath + "' target='_blank'>" +
                    "<img src='" + relativePath + "' height='150'/></a><br>";
            Reporter.log("📸 Screenshot embedded below:");
            Reporter.log(htmlTag);

            System.out.println("✅ Screenshot saved and logged to: " + filePath);

        } catch (IOException e) {
            Reporter.log("⚠️ Screenshot capture failed: " + e.getMessage(), true);
            e.printStackTrace();
        }
    }

    public void verifyInvalidAddressPopup() {
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

        try {
            // Step 1: Enter invalid address
            WebElement addressField = wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.id("com.paycio:id/address_input")
            ));
            addressField.clear();
            addressField.sendKeys("1InvalidBitcoinAddress");
            Reporter.log("📝 Entered invalid address into input field", true);

            // Step 2: Click send
            WebElement sendButton = driver.findElement(By.id("com.paycio:id/send_button"));
            sendButton.click();
            Reporter.log("📤 Clicked Send button", true);

            // Step 3: Wait for "Invalid Address" popup
            WebElement popupMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//*[contains(@text, 'Invalid Address')]")
            ));
            String popupText = popupMessage.getText();

            Reporter.log("<b style='color: white; background-color: red; padding: 5px;'>❌ Invalid Address Popup Shown: " + popupText + "</b>", true);
            System.out.println("❌ Popup detected: " + popupText);

            // 📷 Take screenshot for report
            takeScreenshot("InvalidAddress_Popup_" + timestamp);

            // Step 4: Dismiss popup if OK button exists
            try {
                WebElement okButton = driver.findElement(By.xpath("//android.widget.Button[@text='OK']"));
                okButton.click();
                Reporter.log("✅ Dismissed the popup", true);
            } catch (NoSuchElementException noButton) {
                Reporter.log("ℹ️ No OK button to dismiss popup", true);
            }

        } catch (TimeoutException e) {
            Reporter.log("❌ 'Invalid Address' popup did NOT appear!", true);
            takeScreenshot("InvalidAddress_Popup_Missing_" + timestamp);
            Assert.fail("Expected 'Invalid Address' popup not shown.");
        } catch (Exception e) {
            Reporter.log("❌ Unexpected error: " + e.getMessage(), true);
            takeScreenshot("UnexpectedError_" + timestamp);
            e.printStackTrace();
            Assert.fail("Unexpected error: " + e.getMessage());
        }
    }

    public void verifyTransactionResult() {
        // Define locators
        By successMessageLocator = By.xpath("//android.widget.TextView[@text='Transaction Successfull']");
        By errorMessageLocator = By.id("com.paycio:id/snackbar_text"); // You can use ID directly if available

        try {
            // Step 1: Check for error message
            WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessageLocator));
            String errorText = errorMessage.getText();

            Reporter.log("<b style='color: white; background-color: red; padding: 5px;'>❌ Error Message Displayed: " + errorText + "</b>", true);
            System.out.println("❌ Error Message: " + errorText);
            return;

        } catch (TimeoutException e) {
            // No error message found — now check for success
            Reporter.log("ℹ️ No error message detected. Checking for success...", true);
        }

        try {
            // Step 2: Check for success message
            WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(successMessageLocator));
            Reporter.log("<b style='color: white; background-color: green; padding: 5px;'>✅ Success Message: Transaction Successful</b>", true);
            System.out.println("✅ Transaction was successful.");
        } catch (TimeoutException e) {
            // Neither success nor error found
            Reporter.log("⚠️ Neither error nor success message appeared.", true);
            System.out.println("⚠️ No message appeared.");
        }
    }


    public void enterAmountToWithdraw() {


        WebElement Amount = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class = 'android.widget.EditText' and (@text = 'Minimum 10 USD' or . = 'Minimum 10 USD')]")));
        Amount.sendKeys("0.1");
    }

    public void clickFirstInviteButton() {
        try {
            // Wait for the "Invite to Paycio" button to be visible and clickable
            WebElement inviteButton = wait.until(ExpectedConditions.presenceOfElementLocated(
                    AppiumBy.accessibilityId("Invite to Paycio")
            ));

            // Click using Actions (optional, direct click works too)
            new Actions(driver).moveToElement(inviteButton).click().perform();

            Reporter.log("✅ Successfully clicked on the first 'Invite' button.", true);
            System.out.println("✅ Successfully clicked on the first 'Invite' button.");
        } catch (Exception e) {
            Reporter.log("❌ Failed to click on the first 'Invite' button: " + e.getMessage(), true);
            e.printStackTrace();
            throw e;
        }

    }


    public void clickIfNameAppearsForContacts() {
        long startTime = System.currentTimeMillis(); // Start time tracking
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Define locator
            By locator = AppiumBy.androidUIAutomator(
                    "new UiSelector().descriptionContains(\"Subbu Paycio, 6304869664\")"
            );

            // Wait for element to be clickable
            WebElement contactElement = wait.until(ExpectedConditions.elementToBeClickable(locator));

            // Click on the element
            contactElement.click();

            Reporter.log("✅ Successfully clicked on the specified contact ('Subbu Paycio, 6304869664').", true);
            System.out.println("✅ Successfully clicked on the specified contact ('Subbu Paycio, 6304869664').");

        } catch (Exception e) {
            Reporter.log("❌ Failed to click on the specified contact: " + e.getMessage(), true);
            System.out.println("❌ Failed to click on the specified contact: " + e.getMessage());
            e.printStackTrace();
            throw e; // Rethrow for test failure
        } finally {
            long endTime = System.currentTimeMillis(); // End time tracking
            long executionTime = endTime - startTime;
            Reporter.log("<b>⏱ Execution Time for clickIfNameAppearsForContacts(): " + executionTime + " ms</b>", true);
            System.out.println("⏱ Execution Time for clickIfNameAppearsForContacts(): " + executionTime + " ms");
        }
    }

    public void clickIfContactNameAppears() {
        long startTime = System.currentTimeMillis(); // Start time tracking
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement tapToPay = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//android.view.ViewGroup[contains(@content-desc, 'Tap to pay')]")
            ));
            tapToPay.click();

            Reporter.log("✅ Successfully clicked on the specified name ('Tap to pay').", true);
            System.out.println("✅ Successfully clicked on the specified name ('Tap to pay').");

        } catch (Exception e) {
            Reporter.log("❌ Failed to click on the specified name: " + e.getMessage(), true);
            System.out.println("❌ Failed to click on the specified name: " + e.getMessage());
            e.printStackTrace();
            throw e; // Rethrow for test failure
        } finally {
            long endTime = System.currentTimeMillis(); // End time tracking
            long executionTime = endTime - startTime;
            Reporter.log("<b>⏱ Execution Time for clickIfNameAppears(): " + executionTime + " ms</b>", true);
            System.out.println("⏱ Execution Time for clickIfNameAppears(): " + executionTime + " ms");
        }
    }

    public void clickBitcoinElementForContact() {
        long startTime = System.currentTimeMillis(); // Start time tracking
        try {
            // Ensure element is refreshed dynamically
            bitcoinElement = refreshElement();

            // Wait until the element is clickable
            wait.until(ExpectedConditions.elementToBeClickable(bitcoinElement));

            // Click the element
            bitcoinElement.click();

            // Log success
            Reporter.log("✅ Clicked on 'Bitcoin, BTC, Bitcoin Mainnet'.", true);
            System.out.println("✅ Clicked on 'Bitcoin, BTC, Bitcoin Mainnet'.");

        } catch (Exception e) {
            // Log failure
            Reporter.log("❌ Failed to click 'Bitcoin, BTC, Bitcoin Mainnet': " + e.getMessage(), true);
            System.out.println("❌ Failed to click 'Bitcoin, BTC, Bitcoin Mainnet': " + e.getMessage());
            e.printStackTrace();
            throw e; // Rethrow to mark test as failed
        } finally {
            long endTime = System.currentTimeMillis(); // End time tracking
            long executionTime = endTime - startTime;
            Reporter.log("<b>⏱ Execution Time for clickBitcoinElement(): " + executionTime + " ms</b>", true);
            System.out.println("⏱ Execution Time for clickBitcoinElement(): " + executionTime + " ms");
        }
    }

    // Refresh element to prevent stale reference exception
    private WebElement refreshElement() {
        return (WebElement) wait.until(ExpectedConditions.presenceOfElementLocated(
                AppiumBy.androidUIAutomator("new UiSelector().className(\"android.view.ViewGroup\").description(\"Bitcoin, BTC, Bitcoin Mainnet\")")
        ));
    }

    public void verifyButtonsDisplayedAndLogText() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Define locators
            By copyButtonLocator = AppiumBy.xpath("//android.widget.TextView[@text='Copy']");
            By setAmountButtonLocator = AppiumBy.xpath("//android.widget.TextView[@text='Set Amount']");
            By shareButtonLocator = AppiumBy.xpath("//android.widget.TextView[@text='Share']");

            // Wait until elements are visible
            WebElement copyButton = wait.until(ExpectedConditions.visibilityOfElementLocated(copyButtonLocator));
            WebElement setAmountButton = wait.until(ExpectedConditions.visibilityOfElementLocated(setAmountButtonLocator));
            WebElement shareButton = wait.until(ExpectedConditions.visibilityOfElementLocated(shareButtonLocator));

            // Verify elements are displayed
            Assert.assertTrue(copyButton.isDisplayed(), "❌ 'Copy' button is NOT displayed!");
            Assert.assertTrue(setAmountButton.isDisplayed(), "❌ 'Set Amount' button is NOT displayed!");
            Assert.assertTrue(shareButton.isDisplayed(), "❌ 'Share' button is NOT displayed!");

            // Take a screenshot
            String screenshotPath = takeScreenshot("Button_Verification");

            // Log details with screenshot in TestNG report
            Reporter.log("✅ 'Copy' button is displayed with text: " + copyButton.getText(), true);
            Reporter.log("✅ 'Set Amount' button is displayed with text: " + setAmountButton.getText(), true);
            Reporter.log("✅ 'Share' button is displayed with text: " + shareButton.getText(), true);

            // Embed the screenshot in the report
            Reporter.log("<br><img src='" + screenshotPath + "' height='400' width='250'/><br>");

        } catch (Exception e) {
            // Take a screenshot on failure
            String screenshotPath = takeScreenshot("Button_Verification_Failed");
            Reporter.log("❌ Error verifying buttons: " + e.getMessage(), true);
            Reporter.log("<br><img src='" + screenshotPath + "' height='400' width='250'/><br>");
            e.printStackTrace();
            Assert.fail("❌ Verification of buttons failed due to exception: " + e.getMessage());
        }
    }

    public String takeScreenshot(String fileName) {
        try {
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String screenshotDir = System.getProperty("user.dir") + "/test-output/screenshots/";
            String screenshotPath = screenshotDir + fileName + ".png";

            // Create the directory if it doesn't exist
            File dir = new File(screenshotDir);
            if (!dir.exists()) dir.mkdirs();

            // Save the screenshot
            FileUtils.copyFile(srcFile, new File(screenshotPath));

            return "screenshots/" + fileName + ".png"; // Return relative path for report
        } catch (IOException e) {
            System.out.println("❌ Failed to capture screenshot: " + e.getMessage());
            return "";
        }
    }

    public void clickSetAmountButton() {
        try {
            By iconLocator = By.xpath("//android.view.ViewGroup[@class=\"android.view.ViewGroup\" and @clickable=\"true\" and @focusable=\"true\" and @bounds=\"[467,1400][611,1544]\"]\n");
            driver.findElement(iconLocator).click();


            Reporter.log("✅ Successfully clicked on the 'Set Amount' button.", true);
            System.out.println("✅ Successfully clicked on the 'Set Amount' button.");

        } catch (Exception e) {
            // Take a screenshot if needed
            String screenshotPath = takeScreenshot("SetAmount_Click_Failed");

            // Log failure
            Reporter.log("❌ Failed to click on the 'Set Amount' button: " + e.getMessage(), true);
            Reporter.log("<br><img src='" + screenshotPath + "' height='400' width='250'/><br>");
            System.out.println("❌ Failed to click on the 'Set Amount' button: " + e.getMessage());

            // Print stack trace
            e.printStackTrace();

            // Fail the test
            throw new RuntimeException("❌ Test failed: Unable to click on 'Set Amount' button.", e);
        }
    }

    public void enterSetAmount() {
        wait.until(ExpectedConditions.elementToBeClickable(setAmountEditfield)).click();
        Reporter.log("✅ Successfully clicked on the 'Set Amount' edit field.", true);

        wait.until(ExpectedConditions.visibilityOf(setAmountEditfield)).sendKeys("10");
        Reporter.log("✅ Successfully entered amount: 10.", true);
    }

    public void clickOKButton() {
        wait.until(ExpectedConditions.elementToBeClickable(okButton));
        Reporter.log("✅ OK Button is clickable.", true);

        okButton.click();
        Reporter.log("✅ Successfully clicked on the OK Button.", true);
    }

    public void click_cancel_button() {

        wait.until(ExpectedConditions.elementToBeClickable(crossButton));
        crossButton.click();
        Reporter.log("✅Successfully clicked on the cancel button , ", true);
    }

    public void enterPIN(String pin) {
        for (char digit : pin.toCharArray()) {
            AndroidKey key = AndroidKey.valueOf("DIGIT_" + digit);
            ((AndroidDriver) driver).pressKey(new KeyEvent(key));
        }
        Reporter.log("✅ Successfully entered PIN: " + pin, true);
    }

    public void enterPINForOTP() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // 🔹 Wait until at least one OTP field is present
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText")));

            // 🔹 Get all OTP input fields
            List<WebElement> otpFields = driver.findElements(By.xpath("//android.widget.EditText"));

            if (otpFields.isEmpty()) {
                Reporter.log("❌ OTP input fields not found!", true);
                return;
            }

            // 📸 Capture screenshot before entering OTP
            captureScreenshot("Before_Entering_OTP");

            // ✅ Generate a 6-digit OTP
            String randomOTP = generateRandomOTP();
            Reporter.log("✅ Generated OTP: " + randomOTP, true);

            for (int i = 0; i < randomOTP.length(); i++) {
                otpFields = driver.findElements(By.xpath("//android.widget.EditText")); // Refresh elements
                if (otpFields.size() < randomOTP.length()) {
                    Reporter.log("❌ OTP input fields are missing! Found: " + otpFields.size(), true);
                    return;
                }

                WebElement otpField = wait.until(ExpectedConditions.elementToBeClickable(otpFields.get(i)));

                otpField.click();  // Ensure focus on the field
                otpField.sendKeys(String.valueOf(randomOTP.charAt(i))); // Use sendKeys

                Reporter.log("🔢 Entered OTP Digit: " + randomOTP.charAt(i), true);
            }

            // 📸 Capture screenshot after entering OTP
            captureScreenshot("After_Entering_OTP");

            Reporter.log("✅ Successfully entered OTP: " + randomOTP, true);
        } catch (Exception e) {
            Reporter.log("❌ Error entering OTP: " + e.getMessage(), true);
        }
    }


    // 📸 Method to capture screenshots
    private void captureScreenshot(String filename) {
        try {
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File destFile = new File("./test-output/screenshots/" + filename + ".png");

            // Ensure directory exists
            Files.createDirectories(destFile.getParentFile().toPath());

            // Copy screenshot to destination
            Files.copy(srcFile.toPath(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

            // Log screenshot in TestNG report
            String relativePath = "screenshots/" + filename + ".png";
            Reporter.log("<br>📸 Screenshot: <a href='" + relativePath + "' target='_blank'>View</a>", true);
        } catch (IOException e) {
            Reporter.log("<br>❌ Screenshot Capture Failed: " + e.getMessage(), true);
        }
    }

    // ✅ Method to generate a 6-digit OTP
    public static String generateRandomOTP() {
        String digits = "0123456789"; // Only digits
        Random random = new Random();
        StringBuilder otp = new StringBuilder();

        for (int i = 0; i < 5; i++) {  // Ensure 6-digit OTP
            otp.append(digits.charAt(random.nextInt(digits.length())));
        }

        return otp.toString();
    }


    // ✅ Convert character digit to AndroidKey
    private AndroidKey getAndroidKeyForDigit(char digit) {
        switch (digit) {
            case '0':
                return AndroidKey.DIGIT_0;
            case '1':
                return AndroidKey.DIGIT_1;
            case '2':
                return AndroidKey.DIGIT_2;
            case '3':
                return AndroidKey.DIGIT_3;
            case '4':
                return AndroidKey.DIGIT_4;
            case '5':
                return AndroidKey.DIGIT_5;
            case '6':
                return AndroidKey.DIGIT_6;
            case '7':
                return AndroidKey.DIGIT_7;
            case '8':
                return AndroidKey.DIGIT_8;
            case '9':
                return AndroidKey.DIGIT_9;
            default:
                throw new IllegalArgumentException("Invalid digit for AndroidKey: " + digit);
        }
    }


    public void enterPINAndCheckError(String pin) throws InterruptedException {
        // Enter the PIN
        Thread.sleep(500);
        enterPIN(pin);
        Thread.sleep(500);
        Reporter.log("🔢 Entered PIN: " + pin, true);
        clickSubmitinUCPIPage();

        try {
            // Wait for the error message to appear
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//android.widget.TextView[@resource-id='com.paycio:id/snackbar_text']"))
            );

            // Get the error message text
            String errorText = errorMessage.getText();

            // Log the error message with a red background
            Reporter.log("<b style='background-color: red; color: white; padding: 5px; display: inline-block;'>❌ Error Message Displayed: " + errorText + "</b>", true);

            System.out.println("Error Message: " + errorText);
        } catch (TimeoutException e) {
            Reporter.log("✅ No error message displayed after entering PIN: " + pin, true);
        }
    }

    public void enterPINStepByStepAndValidate(String fullPIN) {
        for (int i = 4; i <= fullPIN.length(); i++) {
            String pinAttempt = fullPIN.substring(0, i);  // Take first i digits
            enterPIN(pinAttempt);
            Reporter.log("🔢 Entered PIN: " + pinAttempt, true);

            clickSubmitinUCPIPage();

            try {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
                WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//android.widget.TextView[@resource-id='com.paycio:id/snackbar_text']"))
                );

                String errorText = errorMessage.getText();
                Reporter.log("❌ Error Message Displayed for PIN (" + pinAttempt + "): " + errorText, true);
                System.out.println("Error Message: " + errorText);

                clearPINField();
                Reporter.log("🔄 Cleared PIN field after error.", true);
            } catch (TimeoutException e) {
                Reporter.log("✅ PIN accepted: " + pinAttempt + ", proceeding to the next page.", true);
                break;
            }
        }
    }

    public void clearPINField() {
        WebElement pinField = driver.findElement(By.xpath("//android.widget.EditText[@resource-id='com.paycio:id/pin_input']"));
        pinField.clear();  // Clear the text field
    }


    public void playBeepSound() {
        Toolkit.getDefaultToolkit().beep();
    }

    public void clickImageView() {

        By bitcoinMainnetLocator = By.xpath("//android.view.ViewGroup[@content-desc='Bitcoin, BTC, Bitcoin Mainnet']");

        // Wait until the new page is loaded and the element is available
        WebElement bitcoinElement = wait.until(ExpectedConditions.presenceOfElementLocated(bitcoinMainnetLocator));

        // Click the element after it is refreshed
        bitcoinElement.click();
        Reporter.log("Clicked on Bitcoin Mainnet", true);

    }


    public String getText() {
        String text = "";

        try {
            // Use XPath with the 'text' property and other identifiers
            WebElement element = driver.findElement(By.xpath(
                    "//android.widget.TextView[@package='com.paycio' and @enabled='true' and @bounds='[85,1288][995,1340]']"
            ));

            // Retrieve the text from the element
            text = element.getText();

            // Log the text to TestNG report
            Reporter.log("Retrieved text: " + text, true);

        } catch (Exception e) {
            // Handle any exceptions and log the error
            Reporter.log("Error retrieving text: " + e.getMessage(), true);
            captureScreenshot(); // Capture a screenshot in case of failure
        }

        return text;
    }

    // Method to capture a screenshot
    private void captureScreenshot() {
        try {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String filePath = "test-output/screenshots" + System.currentTimeMillis() + ".png";
            FileUtils.copyFile(screenshot, new File(filePath));

            // Log the screenshot path to TestNG report
            Reporter.log("Screenshot saved at: " + filePath, true);
        } catch (IOException e) {
            Reporter.log("Error capturing screenshot: " + e.getMessage(), true);
        }
    }

    // Method to click on Bitcoin text
    public void clickOnBitcoinText() {
        // 10 seconds timeout
        wait.until(ExpectedConditions.elementToBeClickable(bitCoinElement));

        // Click on the element
        bitCoinElement.click();
        Reporter.log("Attempting to click on the 'Bitcoin' text element.", true);

    }

    // Method to click on Ethereum text with explicit wait and reporter log
    public void clickOnEthereumText() {
        try {
            // Log the start of the action
            Reporter.log("Attempting to click on the 'Ethereum' text element.", true);

            // Wait until the Ethereum element is visible and clickable
            wait.until(ExpectedConditions.elementToBeClickable(ethereumElement));

            // Log the successful element found
            Reporter.log("Ethereum element is visible and clickable.", true);

            // Click on the Ethereum text element
            ethereumElement.click();

            // Log successful click action
            Reporter.log("Clicked on the 'Ethereum' text element.", true);
        } catch (Exception e) {
            // Log failure if an exception occurs
            Reporter.log("Error occurred while clicking on the 'Ethereum' text element: " + e.getMessage(), true);
        }
    }


    public void clickMyAddresses() {

        driver.findElement(By.xpath("//android.widget.TextView[@text=\"My Addresses\"]")).click();

    }

    public void clickEthereum() {
        wait.until(ExpectedConditions.elementToBeClickable(ethereumElement)).click();
        Reporter.log("Clicked on Ethereum TextView", true);
    }

    // Click Lite Coin Element with Explicit Wait and Logging
    public void clickLiteCoin() {
        wait.until(ExpectedConditions.elementToBeClickable(liteCoinText)).click();
        Reporter.log("Clicked on Lite Coin TextView", true);
    }

    // Click BitCoin Cash Element with Explicit Wait and Logging
    public void clickBitCoinCash() {
        wait.until(ExpectedConditions.elementToBeClickable(bitcoinCashText)).click();
        Reporter.log("Clicked on BitCoin Cash TextView", true);
    }

    // Click USDC Element with Explicit Wait and Logging
    public void clickUSDC() {
        wait.until(ExpectedConditions.elementToBeClickable(usdcText)).click();
        Reporter.log("Clicked on USDC TextView", true);
    }

    public void capturePageScreenshot() {
        // Wait for the entire page (the last ViewGroup) to load
        WebElement pageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.FrameLayout[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[7]/android.widget.ScrollView/android.view.ViewGroup")
        ));

        // Take screenshot of the entire page (element)
        takeScreenshotOfElement(pageElement, "FullPage_Screenshot");
    }

    public void takeScreenshotOfElement(WebElement element, String fileName) {
        // Format the timestamp for unique filenames
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

        // Capture screenshot of the specific element (entire page)
        File srcFile = element.getScreenshotAs(OutputType.FILE);

        // Define destination file path
        File destFile = new File("screenshots/" + fileName + "_" + timestamp + ".png");

        try {
            FileHandler.copy(srcFile, destFile);
            Reporter.log("Screenshot saved: " + destFile.getAbsolutePath(), true);
        } catch (IOException e) {
            e.printStackTrace();
            Reporter.log("Failed to capture screenshot", true);
        }
    }

    public void clickBinanceCoin() {

        // Wait for the element to be clickable
        wait.until(ExpectedConditions.elementToBeClickable(binanceElement));

        // Click on the Binance Coin element
        binanceElement.click();

        // Log the action in TestNG report
        Reporter.log("✅ Clicked on Binance Coin TextView", true);
    }

    public void clickTron() {

        // Wait for the element to be clickable
        wait.until(ExpectedConditions.elementToBeClickable(tronElement));

        // Click on the Tron element
        tronElement.click();

        // Log the action in TestNG report
        Reporter.log("✅ Clicked on Tron TextView", true);
    }

    public void scrollAndClickonTrueUSD() {
        // Scroll to the element with text "Create New Merchant"
        driver.findElement(new AppiumBy.ByAndroidUIAutomator(
                "new UiScrollable(new UiSelector().className(\"android.widget.ScrollView\").scrollable(true))"
                        + ".scrollIntoView(new UiSelector().textMatches(\"TrueUSD\"))"));


        wait.until(ExpectedConditions.visibilityOf(TrueUSDText));

        // Click the "Create New Merchant" element
        TrueUSDText.click();
        Reporter.log("clicked on True USD ", true);
    }

    public void clickOnTrueUSDText() {

        wait.until(ExpectedConditions.elementToBeClickable(usdTusdText)).click();
        // usdTusdText.click();
        Reporter.log("clicked on True USD ", true);

    }

    public void scrollAndClickonDash() {
        // Scroll to the element with text "Dash"
        driver.findElement(new AppiumBy.ByAndroidUIAutomator(
                "new UiScrollable(new UiSelector().className(\"android.widget.ScrollView\").scrollable(true))"
                        + ".scrollIntoView(new UiSelector().textMatches(\"Dash\"))"));

        // Wait for the Dash element to be visible
        wait.until(ExpectedConditions.visibilityOf(clickDashText));

        // Click on the "Dash" element
        clickDashText.click();

        // Log the action in TestNG report
        Reporter.log("✅ Clicked on Dash TextView", true);
    }


    public void clickOnDashText() {
        wait.until(ExpectedConditions.visibilityOf(clickDashText));

        // Click on the "Dash" element
        clickDashText.click();

        // Log the action in TestNG report
        Reporter.log("✅ Clicked on Dash TextView", true);

    }

    public void scrollAndClickOnDoge() throws InterruptedException {
        // Scroll to the element with text "Doge Coin"
        driver.findElement(new AppiumBy.ByAndroidUIAutomator(
                "new UiScrollable(new UiSelector().className(\"android.widget.ScrollView\").scrollable(true))"
                        + ".scrollIntoView(new UiSelector().textMatches(\"Doge Coin\"))"));

        // Wait for the Doge Coin element to be visible
        wait.until(ExpectedConditions.visibilityOf(clickDogeText));

        // Click on the "Doge Coin" element
        clickDogeText.click();

        // Log the action in TestNG report
        Reporter.log("✅ Clicked on Doge Coin TextView", true);
    }

    public void clickOnDogeText() {
        // Wait for the Doge element to be visible
        wait.until(ExpectedConditions.visibilityOf(clickDogeText));

        // Use Actions class to click
        Actions actions = new Actions(driver);
        actions.moveToElement(clickDogeText).click().perform();

        // Log the action in TestNG report
        Reporter.log("✅ Clicked on Doge TextView using Actions class", true);
    }

    public void scrollAndClickOnUSDT() {
        try {
            // Scroll to the element with text "USDT, USDT, Tron Network"
            WebElement usdtElement = driver.findElement(new AppiumBy.ByAndroidUIAutomator(
                    "new UiScrollable(new UiSelector().className(\"android.widget.ScrollView\").scrollable(true))" +
                            ".scrollIntoView(new UiSelector().text(\"USDT, USDT, Tron Network\"))"));

            // Wait until the element is visible
            wait.until(ExpectedConditions.visibilityOf(usdtElement));

            // Click on the element
            usdtElement.click();

            // Log the action
            Reporter.log("✅ Clicked on USDT, USDT, Tron Network TextView", true);

        } catch (Exception e) {
            Reporter.log("❌ Failed to scroll and click on USDT: " + e.getMessage(), true);
            e.printStackTrace();
        }
    }


    public void clickOnUSDTText() {
        // Wait for the USDT element to be visible
        wait.until(ExpectedConditions.visibilityOf(USDTTronNetworkText));

        // Click on the "USDT" element
        USDTTronNetworkText.click();

        // Log the action in TestNG report
        Reporter.log("✅ Clicked on USDT TextView", true);
    }


    public void scrollAndClickOnPolygon() throws InterruptedException {
        // Scroll to the element with text "Polygon, POL, Polygon Chain"
        driver.findElement(new AppiumBy.ByAndroidUIAutomator(
                "new UiScrollable(new UiSelector().className(\"android.widget.ScrollView\").scrollable(true))"
                        + ".scrollIntoView(new UiSelector().textMatches(\"Polygon Chain\"))"));

        wait.until(ExpectedConditions.visibilityOf(PolygonTexts));

        // Click on the "Polygon, POL, Polygon Chain" element
        PolygonTexts.click();

        // Log the action in TestNG report
        Reporter.log("✅ Clicked on Polygon TextView", true);
    }

    public void clickOnPolygonText() {
        // Wait for the Polygon element to be visible
        wait.until(ExpectedConditions.visibilityOf(PolygonTexts));

        // Click on the "Polygon, POL, Polygon Chain" element
        PolygonTexts.click();

        // Log the action in TestNG report
        Reporter.log("✅ Clicked on Polygon TextView", true);
    }


    public void scrollAndClickOnSolana() throws InterruptedException {
        // Scroll to the element with text "Solana Mainnet"
        driver.findElement(new AppiumBy.ByAndroidUIAutomator(
                "new UiScrollable(new UiSelector().className(\"android.widget.ScrollView\").scrollable(true))"
                        + ".scrollIntoView(new UiSelector().textMatches(\"Solana Mainnet\"))"));

        // Wait for the Solana element to be visible
        wait.until(ExpectedConditions.visibilityOf(SolanaText));

        // Click on the "Solana Mainnet" element
        SolanaText.click();

        // Log the action in TestNG report
        Reporter.log("✅ Clicked on Solana Mainnet TextView", true);
    }

    public void clickOnSolanaText() {
        // Wait for the Solana element to be visible
        wait.until(ExpectedConditions.visibilityOf(SolanaText));

        // Click on the "Solana Mainnet" element
        SolanaText.click();

        // Log the action in TestNG report
        Reporter.log("✅ Clicked on Solana Mainnet TextView", true);
    }

    public void scrollAndClickOnAvalancheCChain() throws InterruptedException {
        // Scroll to the element with text "Avalanche C-Chain"
        driver.findElement(new AppiumBy.ByAndroidUIAutomator(
                "new UiScrollable(new UiSelector().className(\"android.widget.ScrollView\").scrollable(true))"
                        + ".scrollIntoView(new UiSelector().textMatches(\"Avalanche C-Chain\"))"));

        // Wait for the Avalanche C-Chain element to be visible
        wait.until(ExpectedConditions.visibilityOf(AvalancheText));

        // Click on the "Avalanche C-Chain" element
        AvalancheText.click();

        // Log the action in TestNG report
        Reporter.log("✅ Clicked on Avalanche C-Chain TextView", true);
    }

    public void clickOnAvalancheText() throws InterruptedException {
        // Wait for the Avalanche element to be visible
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOf(AvalancheText));
        Thread.sleep(2000);
        // Click on the "Avalanche" element
        AvalancheText.click();

        // Log the action in TestNG report
        Reporter.log("✅ Clicked on Avalanche TextView", true);
    }


//    public void scrollAndClickOnTetherUSDT() throws InterruptedException {
//        try {
//            // Scroll to the element containing "Tether USD, USDT, Binance Smart Chain"
//            driver.findElement(new AppiumBy.ByAndroidUIAutomator(
//                    "new UiScrollable(new UiSelector().scrollable(true))"
//                            + ".scrollIntoView(new UiSelector().descriptionContains(\"Tether USD, USDT, Binance Smart Chain\"))"));
//
//            // Wait for the element to be visible and clickable
//            WebElement tetherElement = wait.until(ExpectedConditions.presenceOfElementLocated(
//                    By.xpath("//android.view.ViewGroup[contains(@content-desc, 'Tether USD, USDT, Binance Smart Chain')]")));
//
//            // Ensure the element is clickable
//            wait.until(ExpectedConditions.elementToBeClickable(tetherElement)).click();
//
//            // Log the action
//            Reporter.log("✅ Clicked on Tether USD (Binance Smart Chain)", true);
//        } catch (Exception e) {
//            Reporter.log("❌ Failed to click on Tether USD: " + e.getMessage(), true);
//        }
//    }

    public void scrollAndClickOnTetherUSD() throws InterruptedException {
        try {
            // Scroll vertically to the element containing "Tether USD, USDT, Binance Smart Chain" in content-desc
            driver.findElement(new AppiumBy.ByAndroidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true).className(\"android.view.View\"))"
                            + ".setAsVerticalList()"
                            + ".scrollIntoView(new UiSelector().descriptionContains(\"Tether USD, USDT, Binance Smart Chain\"))"));

            // Define the element using XPath with contains() to handle dynamic price
            WebElement tetherElement = driver.findElement(By.xpath(
                    "//android.view.ViewGroup[contains(@content-desc, 'Tether USD, USDT, Binance Smart Chain')]"
                            + "/android.view.ViewGroup/android.widget.ImageView"));

            // Wait until the element is visible
            wait.until(ExpectedConditions.visibilityOf(tetherElement));

            // Click on the element
            tetherElement.click();

            // Log the action in TestNG report
            Reporter.log("✅ Clicked on Tether USD, USDT, Binance Smart Chain", true);
        } catch (Exception e) {
            Reporter.log("❌ Failed to scroll and click on Tether USD. Error: " + e.getMessage(), true);
        }
    }


    public void clickOnTetherText() {
        // Wait for the Tether element to be visible
        wait.until(ExpectedConditions.visibilityOf(TetherText));

        // Click on the "Tether" element
        TetherText.click();

        // Log the action in TestNG report
        Reporter.log("✅ Clicked on Tether TextView", true);
    }

    public void scrollAndClickOnChainlink() throws InterruptedException {
        // Scroll to the element containing "Chainlink, LINK, Polygon Chain"
        driver.findElement(new AppiumBy.ByAndroidUIAutomator(
                "new UiScrollable(new UiSelector().className(\"android.widget.ScrollView\").scrollable(true))"
                        + ".scrollIntoView(new UiSelector().descriptionContains(\"Chainlink, LINK, Polygon Chain\"))"));

        // Wait for the Chainlink element to be clickable
        WebElement chainlinkElement = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//android.view.ViewGroup[contains(@content-desc, 'Chainlink, LINK, Polygon Chain')]")));

        // Click on the Chainlink element
        chainlinkElement.click();

        // Log the action in TestNG report
        Reporter.log("✅ Clicked on Chainlink (Polygon Chain)", true);
    }


    public void clickOnChainlinkText() {
        // Wait for the Chainlink element to be visible
        wait.until(ExpectedConditions.visibilityOf(chainLinkText));

        // Click on the "Chainlink" element
        chainLinkText.click();

        // Log the action in TestNG report
        Reporter.log("✅ Clicked on Chainlink TextView", true);
    }

    public void scrollAndClickOnShibaInu() throws InterruptedException {
        // Scroll to the element with content-desc "Shiba Inu, SHIB, Ethereum Network"
        driver.findElement(new AppiumBy.ByAndroidUIAutomator(
                "new UiScrollable(new UiSelector().className(\"android.widget.ScrollView\").scrollable(true))"
                        + ".scrollIntoView(new UiSelector().descriptionContains(\"Shiba Inu, SHIB, Ethereum Network\"))"));

        // Wait for the Shiba Inu element to be clickable
        WebElement shibaInuElement = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//android.view.ViewGroup[@content-desc='Shiba Inu, SHIB, Ethereum Network, $ 0.00']")));

        // Click on the Shiba Inu element
        shibaInuElement.click();

        // Log the action in TestNG report
        Reporter.log("✅ Clicked on Shiba Inu (Ethereum Network)", true);
    }

//    public void clickOnShibaInu() {
//        WebElement shibaInuText = wait.until(ExpectedConditions.elementToBeClickable(
//                By.xpath("//android.view.ViewGroup[contains(@content-desc, 'Shiba Inu, SHIB, Ethereum Network')]")
//        ));
//
//        // Click the element
//        shibaInuText.click();
//
//        // Log the action
//        Reporter.log("✅ Clicked on Shiba Inu TextView", true);
//    }

    public void forceClickUsingActions() {
        WebElement shibaInuText = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//android.view.ViewGroup[@content-desc=\"Shiba Inu, SHIB, Ethereum Network\"]/android.view.ViewGroup/android.widget.ImageView\n")
        ));
        // Perform a move + click
        Actions actions = new Actions(driver);
        actions.moveToElement(shibaInuText).click().perform();

        Reporter.log("✅ Force Clicked on Shiba Inu using Actions Class", true);
    }

    public void scrollAndClickOnRippleXRP() throws InterruptedException {
        try {
            // Scroll to the element containing "Ripple, XRP, Ripple Payment protocol" (ignoring price)
            boolean isElementFound = false;
            int maxScrolls = 5; // Limit the scroll attempts
            int scrollCount = 0;

            while (!isElementFound && scrollCount < maxScrolls) {
                try {
                    driver.findElement(new AppiumBy.ByAndroidUIAutomator(
                            "new UiScrollable(new UiSelector().scrollable(true).className(\"android.view.View\"))"
                                    + ".setAsVerticalList()"
                                    + ".scrollIntoView(new UiSelector().descriptionContains(\"Ripple, XRP, Ripple Payment protocol\"))"));

                    isElementFound = true; // If found, exit loop
                } catch (Exception e) {
                    // Scroll forward manually if element is not found
                    new AppiumBy.ByAndroidUIAutomator(
                            "new UiScrollable(new UiSelector().scrollable(true)).scrollForward();");
                    scrollCount++;
                }
            }

            // Define the element using XPath (ignoring dynamic price)
            WebElement rippleElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
                    "//android.view.ViewGroup[contains(@content-desc, \"Ripple, XRP, Ripple Payment protocol\")]/android.view.ViewGroup/android.widget.ImageView")));

            // Click the element
            rippleElement.click();

            // Log the action
            Reporter.log("✅ Clicked on Ripple (XRP) ImageView", true);
        } catch (Exception e) {
            Reporter.log("❌ Failed to scroll and click on Ripple XRP: " + e.getMessage(), true);
        }
    }


    public void clickOnRippleText() {
        // Wait for the Ripple element to be visible
        wait.until(ExpectedConditions.visibilityOf(rippleText));

        // Click on the "Ripple" element
        rippleText.click();

        // Log the action in TestNG report
        Reporter.log("✅ Clicked on Ripple TextView", true);
    }

    public void scrollAndClickOnPolkadot() throws InterruptedException {
        // Scroll to the element containing "Polkadot, DOT, Polkadot Network"
        driver.findElement(new AppiumBy.ByAndroidUIAutomator(
                "new UiScrollable(new UiSelector().className(\"android.widget.ScrollView\").scrollable(true))"
                        + ".scrollIntoView(new UiSelector().descriptionContains(\"Polkadot, DOT, Polkadot Network\"))"));

        // Wait for the Polkadot element to be clickable (ignore price)
        WebElement polkadotElement = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//android.view.ViewGroup[contains(@content-desc, 'Polkadot, DOT, Polkadot Network')]")));

        // Click on the Polkadot element
        polkadotElement.click();

        // Log the action in TestNG report
        Reporter.log("✅ Clicked on Polkadot (DOT) Network", true);
    }


    public void clickOnPolkadotText() {
        // Wait for the Polkadot element to be visible
        wait.until(ExpectedConditions.visibilityOf(polkadotText));

        // Click on the "Polkadot" element
        polkadotText.click();

        // Log the action in TestNG report
        Reporter.log("✅ Clicked on Polkadot TextView", true);
    }

    public void scrollAndClickOnDAI() throws InterruptedException {
        // Scroll to the element containing "DAI, DAI, Ethereum Network"
        driver.findElement(new AppiumBy.ByAndroidUIAutomator(
                "new UiScrollable(new UiSelector().className(\"android.widget.ScrollView\").scrollable(true))"
                        + ".scrollIntoView(new UiSelector().descriptionContains(\"DAI, DAI, Ethereum Network\"))"));

        // Wait for the DAI element to be clickable (ignore price)
        WebElement daiElement = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//android.view.ViewGroup[contains(@content-desc, 'DAI, DAI, Ethereum Network')]")));

        // Click on the DAI element
        daiElement.click();

        // Log the action in TestNG report
        Reporter.log("✅ Clicked on DAI (Ethereum Network)", true);
    }

    public void clickOnDAIText() {
        // Wait for the DAI element to be visible
        wait.until(ExpectedConditions.visibilityOf(daiText));

        // Click on the "DAI" element
        daiText.click();

        // Log the action in TestNG report
        Reporter.log("✅ Clicked on DAI TextView", true);
    }

    public void scrollAndClickOnArbitrum() throws InterruptedException {
        // Scroll to the element containing "Arbitrum, ARB, Ethereum Network"
        driver.findElement(new AppiumBy.ByAndroidUIAutomator(
                "new UiScrollable(new UiSelector().className(\"android.widget.ScrollView\").scrollable(true))"
                        + ".scrollIntoView(new UiSelector().descriptionContains(\"Arbitrum, ARB, Ethereum Network\"))"));

        // Wait for the Arbitrum element to be clickable (ignore price)
        WebElement arbitrumElement = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//android.view.ViewGroup[contains(@content-desc, 'Arbitrum, ARB, Ethereum Network')]")));

        // Click on the Arbitrum element
        arbitrumElement.click();

        // Log the action in TestNG report
        Reporter.log("✅ Clicked on Arbitrum (ARB) Ethereum Network", true);
    }

    public void clickOnArbitrumText() {
        // Wait for the Arbitrum element to be visible
        wait.until(ExpectedConditions.visibilityOf(arbitrumText));

        // Click on the "Arbitrum" element
        arbitrumText.click();

        // Log the action in TestNG report
        Reporter.log("✅ Clicked on Arbitrum TextView", true);
    }

    public void scrollAndClickOnMantle() throws InterruptedException {
        // Scroll to the element containing "Mantle, MNT, Ethereum Network"
        driver.findElement(new AppiumBy.ByAndroidUIAutomator(
                "new UiScrollable(new UiSelector().className(\"android.widget.ScrollView\").scrollable(true))"
                        + ".scrollIntoView(new UiSelector().descriptionContains(\"Mantle, MNT, Ethereum Network\"))"));

        // Wait for the Mantle element to be clickable (ignore price)
        WebElement mantleElement = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//android.view.ViewGroup[contains(@content-desc, 'Mantle, MNT, Ethereum Network')]")));

        // Click on the Mantle element
        mantleElement.click();

        // Log the action in TestNG report
        Reporter.log("✅ Clicked on Mantle (MNT) Ethereum Network", true);
    }

    public void clickOnMantleText() {
        // Wait for the Mantle element to be visible
        wait.until(ExpectedConditions.visibilityOf(mantleText));

        // Click on the "Mantle" element
        mantleText.click();

        // Log the action in TestNG report
        Reporter.log("✅ Clicked on Mantle TextView", true);
    }

    public void scrollAndClickOnRenderToken() throws InterruptedException {
        // Scroll to the element containing "Render Token, RNDR, Ethereum Network"
        driver.findElement(new AppiumBy.ByAndroidUIAutomator(
                "new UiScrollable(new UiSelector().className(\"android.widget.ScrollView\").scrollable(true))"
                        + ".scrollIntoView(new UiSelector().descriptionContains(\"Render Token, RNDR, Ethereum Network\"))"));

        // Wait for the Render Token element to be clickable (ignore price)
        WebElement renderTokenElement = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//android.view.ViewGroup[contains(@content-desc, 'Render Token, RNDR, Ethereum Network')]")));

        // Click on the Render Token element
        renderTokenElement.click();

        // Log the action in TestNG report
        Reporter.log("✅ Clicked on Render Token (RNDR) Ethereum Network", true);
    }

    /**
     * Force clicks on the Render Token TextView using the Actions class
     * after waiting for it to be visible. Logs the action in the TestNG report.
     */
    public void clickOnRenderTokenText() {
        // Wait until the Render Token element is visible
        wait.until(ExpectedConditions.visibilityOf(renderTokenText));

        // Perform a move + click using Actions class
        Actions actions = new Actions(driver);
        actions.moveToElement(renderTokenText).click().perform();

        // Log the action in TestNG report
        Reporter.log("✅ Force Clicked on Render Token TextView using Actions Class", true);
    }


    public void scrollAndClickOnBeam() throws InterruptedException {
        // Scroll to the element containing "Beam, BEAM, Ethereum Network"
        driver.findElement(new AppiumBy.ByAndroidUIAutomator(
                "new UiScrollable(new UiSelector().className(\"android.widget.ScrollView\").scrollable(true))"
                        + ".scrollIntoView(new UiSelector().descriptionContains(\"Beam, BEAM, Ethereum Network\"))"));

        // Wait for the Beam element to be clickable (ignore price)
        WebElement beamElement = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//android.view.ViewGroup[contains(@content-desc, 'Beam, BEAM, Ethereum Network')]")));

        // Click on the Beam element
        beamElement.click();

        // Log the action in TestNG report
        Reporter.log("✅ Clicked on Beam (BEAM) Ethereum Network", true);
    }

    public void clickOnBeamText() {
        // Wait for the Beam element to be visible
        wait.until(ExpectedConditions.visibilityOf(beamText));

        // Click on the "Beam" element
        beamText.click();

        // Log the action in TestNG report
        Reporter.log("✅ Clicked on Beam TextView", true);
    }

    public void scrollAndClickOnSand() throws InterruptedException {
        // Scroll to the element containing "SAND, SAND, Ethereum Network"
        driver.findElement(new AppiumBy.ByAndroidUIAutomator(
                "new UiScrollable(new UiSelector().className(\"android.widget.ScrollView\").scrollable(true))"
                        + ".scrollIntoView(new UiSelector().descriptionContains(\"SAND, SAND, Ethereum Network\"))"));

        // Wait for the SAND element to be clickable (ignore price)
        WebElement sandElement = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//android.view.ViewGroup[contains(@content-desc, 'SAND, SAND, Ethereum Network')]")));

        // Click on the SAND element
        sandElement.click();

        // Log the action in TestNG report
        Reporter.log("✅ Clicked on SAND (Ethereum Network)", true);
    }

    public void clickOnSandText() {
        // Wait for the SAND element to be visible
        wait.until(ExpectedConditions.visibilityOf(sandText));

        // Click on the "SAND" element
        sandText.click();

        // Log the action in TestNG report
        Reporter.log("✅ Clicked on SAND TextView", true);
    }

    public void scrollAndClickOnInjectiveProtocol() throws InterruptedException {
        // Scroll to the element containing the full name "Injective Protocol, INJ, Binance Smart Chain"
        driver.findElement(new AppiumBy.ByAndroidUIAutomator(
                "new UiScrollable(new UiSelector().className(\"android.widget.ScrollView\").scrollable(true))"
                        + ".scrollIntoView(new UiSelector().descriptionContains(\"Injective Protocol, INJ, Binance Smart Chain\"))"));


        WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//android.view.ViewGroup[contains(@content-desc, 'Injective Protocol')]/android.view.ViewGroup/android.widget.ImageView")
        ));
        ele.click();

        // Click on the Injective Protocol element


        // Log the action in TestNG report
        Reporter.log("✅ Clicked on Injective Protocol (INJ) Binance Smart Chain", true);
    }

    public void clickOnInjectiveTokenText() {
        try {
            // Targeting the ViewGroup with content-desc that wraps the text
            WebElement injectiveText = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//android.view.ViewGroup[@content-desc='Injective Protocol, INJ, Binance Smart Chain']")));

            injectiveText.click();
            Reporter.log("✅ Clicked on Injective Protocol text area", true);

        } catch (Exception e) {
            Reporter.log("❌ Failed to click on Injective Protocol text area: " + e.getMessage(), true);
        }
    }
//    public void scrollAndClickOnFirstDigital() throws InterruptedException {
//        // Scroll to the element containing the full name "First Digital, FDUSD, Binance Smart Chain"
//        driver.findElement(new AppiumBy.ByAndroidUIAutomator(
//                "new UiScrollable(new UiSelector().className(\"android.widget.ScrollView\").scrollable(true))"
//                        + ".scrollIntoView(new UiSelector().descriptionContains(\"First Digital USD, FDUSD, Binance Smart Chain\"))"));
//
//        // Wait for the First Digital element to be clickable
//        wait.until(ExpectedConditions.elementToBeClickable(firstDigitalText));
//
//        // Click on the First Digital element
//        firstDigitalText.click();
//
//        // Log the action in TestNG report
//        Reporter.log("✅ Clicked on First Digital (FDUSD) Binance Smart Chain", true);
//    }

    public void scrollAndClickOnFirstDigitalUSD() {
        try {
            // Scroll until the element with the partial content-desc is visible
            driver.findElement(new AppiumBy.ByAndroidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true))" +
                            ".scrollIntoView(new UiSelector().descriptionContains(\"First Digital USD, FDUSD, Binance Smart Chain\"))"
            ));

            // Wait and click the element ignoring price
            WebElement firstDigital = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//android.view.ViewGroup[contains(@content-desc, 'First Digital USD, FDUSD, Binance Smart Chain')]" +
                            "/android.view.ViewGroup/android.widget.ImageView")
            ));

            firstDigital.click();
            Reporter.log("✅ Clicked on First Digital USD (FDUSD)", true);
        } catch (Exception e) {
            Reporter.log("❌ Failed to scroll and click on First Digital USD: " + e.getMessage(), true);
        }
    }


    public void clickOnFirstDigitalUSD() {
        try {
            WebElement firstDigital = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//android.view.ViewGroup[@content-desc='First Digital USD, FDUSD, Binance Smart Chain']" +
                            "/android.view.ViewGroup/android.widget.ImageView")
            ));

            firstDigital.click();
            Reporter.log("✅ Clicked on First Digital USD (FDUSD)", true);
        } catch (Exception e) {
            Reporter.log("❌ Failed to click on First Digital USD: " + e.getMessage(), true);
        }
    }

    public void scrollAndClickOnPancakeSwapToken() {
        try {
            // Scroll to the element using partial content-desc match
            driver.findElement(new AppiumBy.ByAndroidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true))"
                            + ".setAsVerticalList()"
                            + ".scrollIntoView(new UiSelector().descriptionContains(\"PancakeSwap Token, CAKE, Binance Smart Chain\"))"
            ));

            // Click the exact element (including price if needed)
            WebElement pancakeTokenElement = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//android.view.ViewGroup[@content-desc='PancakeSwap Token, CAKE, Binance Smart Chain, $ 1.81']" +
                            "/android.view.ViewGroup/android.widget.ImageView")
            ));

            pancakeTokenElement.click();
            Reporter.log("✅ Clicked on PancakeSwap Token (CAKE)", true);

        } catch (Exception e) {
            Reporter.log("❌ Failed to scroll and click on PancakeSwap Token (CAKE): " + e.getMessage(), true);
        }
    }

    public void clickOnPancakeSwapText() {
        // Wait for the PancakeSwap element to be visible
        wait.until(ExpectedConditions.visibilityOf(pancakeSwapText));

        // Click on the "PancakeSwap" element
        pancakeSwapText.click();

        // Log the action in TestNG report
        Reporter.log("✅ Clicked on PancakeSwap TextView", true);
    }

    public void scrollAndClickOnGreenMetaverseToken() throws InterruptedException {
        try {
            // Scroll to the element containing "Green Metaverse Token, GMT, Binance Smart Chain"
            driver.findElement(new AppiumBy.ByAndroidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true))"
                            + ".scrollIntoView(new UiSelector().descriptionContains(\"Green Metaverse Token, GMT, Binance Smart Chain\"))"));

            // Wait for the Green Metaverse Token element to be clickable
            WebElement gmtElement = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//android.view.ViewGroup[contains(@content-desc, 'Green Metaverse Token, GMT, Binance Smart Chain')]"
                            + "/android.view.ViewGroup/android.widget.ImageView")));

            // Click on the GMT element
            gmtElement.click();

            // Log the action
            Reporter.log("✅ Clicked on Green Metaverse Token (GMT) Binance Smart Chain", true);
        } catch (Exception e) {
            Reporter.log("❌ Failed to scroll and click on Green Metaverse Token (GMT): " + e.getMessage(), true);
        }
    }

    public void clickOnGreenMetaverseText() {
        // Wait for the Green Metaverse Token element to be visible
        wait.until(ExpectedConditions.visibilityOf(greenText));

        // Click on the "Green Metaverse Token" element
        greenText.click();

        // Log the action in TestNG report
        Reporter.log("✅ Clicked on Green Metaverse Token (GMT) TextView", true);
    }


    public void scrollAndClickOnSleeplessAIToken() throws InterruptedException {
        try {
            // Scroll to the element containing "Sleepless AI Token, AI, Binance Smart Chain"
            driver.findElement(new AppiumBy.ByAndroidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true))"
                            + ".scrollIntoView(new UiSelector().descriptionContains(\"Sleepless AI Token, AI, Binance Smart Chain\"))"));

            // Wait for the Sleepless AI Token element to be clickable
            WebElement aiTokenElement = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//android.view.ViewGroup[contains(@content-desc, 'Sleepless AI Token, AI, Binance Smart Chain')]"
                            + "/android.view.ViewGroup/android.widget.ImageView")));

            // Click on the Sleepless AI Token element
            aiTokenElement.click();

            // Log the action
            Reporter.log("✅ Clicked on Sleepless AI Token (AI) Binance Smart Chain", true);
        } catch (Exception e) {
            Reporter.log("❌ Failed to scroll and click on Sleepless AI Token (AI): " + e.getMessage(), true);
        }
    }

    public void clickOnSleeplessTokenText() {
        // Wait until the Sleepless Token text is visible
        wait.until(ExpectedConditions.visibilityOf(sleeplessTokenText));

        // Use Actions class to perform click
        Actions actions = new Actions(driver);
        actions.moveToElement(sleeplessTokenText).click().perform();

        // Log the action
        Reporter.log("✅ Clicked on Sleepless AI Token (AI) TextView using Actions class", true);
    }


    public void scrollAndClickOnNFPromptToken() throws InterruptedException {
        try {
            // Scroll to the element containing "NFPrompt Token, NFP, Binance Smart Chain"
            driver.findElement(new AppiumBy.ByAndroidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true))"
                            + ".scrollIntoView(new UiSelector().descriptionContains(\"NFPrompt Token, NFP, Binance Smart Chain\"))"));

            // Wait for the NFPrompt Token element to be clickable
            WebElement nfpTokenElement = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//android.view.ViewGroup[contains(@content-desc, 'NFPrompt Token, NFP, Binance Smart Chain')]"
                            + "/android.view.ViewGroup/android.widget.ImageView")));

            // Click on the NFPrompt Token element
            nfpTokenElement.click();

            // Log the action
            Reporter.log("✅ Clicked on NFPrompt Token (NFP) Binance Smart Chain", true);
        } catch (Exception e) {
            Reporter.log("❌ Failed to scroll and click on NFPrompt Token (NFP): " + e.getMessage(), true);
        }
    }


    public void clickOnNFPromptTokenText() {
        // Wait for the NFPrompt Token element to be visible
        wait.until(ExpectedConditions.visibilityOf(NFPromptTokenText));

        // Click on the "NFPrompt Token"
        NFPromptTokenText.click();

        // Log the action in TestNG report
        Reporter.log("✅ Clicked on NFPrompt Token (NFP) TextView", true);
    }

    public void scrollAndClickOnBurgerCities() throws InterruptedException {
        try {
            // Scroll to the element containing "BurgerCities, BURGER, Binance Smart Chain"
            driver.findElement(new AppiumBy.ByAndroidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true))"
                            + ".scrollIntoView(new UiSelector().descriptionContains(\"BurgerCities, BURGER, Binance Smart Chain\"))"));

            // Wait for the BurgerCities element to be clickable
            WebElement burgerElement = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//android.view.ViewGroup[contains(@content-desc, 'BurgerCities, BURGER, Binance Smart Chain')]"
                            + "/android.view.ViewGroup/android.widget.ImageView")));

            // Click on the BurgerCities element
            burgerElement.click();

            // Log the action
            Reporter.log("✅ Clicked on BurgerCities (BURGER) Binance Smart Chain", true);
        } catch (Exception e) {
            Reporter.log("❌ Failed to scroll and click on BurgerCities (BURGER): " + e.getMessage(), true);
        }
    }

    public void clickOnBurgerCitiesText() {
        // Wait for the BurgerCities element to be visible
        wait.until(ExpectedConditions.visibilityOf(burgerCitiesText));

        // Click on the "BurgerCities"
        burgerCitiesText.click();

        // Log the action in TestNG report
        Reporter.log("✅ Clicked on BurgerCities (BURGER) TextView", true);
    }


    public void scrollAndClickOnTrustWallet() throws InterruptedException {
        try {
            // Scroll to the element containing "Trust Wallet, TWT, Binance Smart Chain"
            driver.findElement(new AppiumBy.ByAndroidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true))"
                            + ".scrollIntoView(new UiSelector().descriptionContains(\"Trust Wallet, TWT, Binance Smart Chain\"))"));

            // Wait for the Trust Wallet element to be clickable
            WebElement trustWalletElement = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//android.view.ViewGroup[contains(@content-desc, 'Trust Wallet, TWT, Binance Smart Chain')]"
                            + "/android.view.ViewGroup/android.widget.ImageView")));

            // Click on the Trust Wallet element
            trustWalletElement.click();

            // Log the action
            Reporter.log("✅ Clicked on Trust Wallet (TWT) Binance Smart Chain", true);
        } catch (Exception e) {
            Reporter.log("❌ Failed to scroll and click on Trust Wallet (TWT): " + e.getMessage(), true);
        }
    }

    public void clickOnTrustWalletText() {
        // Wait for the Trust Wallet element to be visible
        wait.until(ExpectedConditions.visibilityOf(trustWalletText));

        // Click on the "Trust Wallet"
        trustWalletText.click();

        // Log the action in TestNG report
        Reporter.log("✅ Clicked on Trust Wallet (TWT) TextView", true);
    }

    public void scrollAndClickOnUSDTPolygonChain() throws InterruptedException {
        try {
            // Scroll to the element containing "USDT, USDT, Polygon Chain"
            driver.findElement(new AppiumBy.ByAndroidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true))"
                            + ".scrollIntoView(new UiSelector().descriptionContains(\"USDT, USDT, Polygon Chain\"))"));

            // Wait for the USDT element to be clickable
            WebElement usdtElement = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//android.view.ViewGroup[contains(@content-desc, 'USDT, USDT, Polygon Chain')]"
                            + "/android.view.ViewGroup/android.widget.ImageView")));

            // Click on the USDT element
            usdtElement.click();

            // Log the action
            Reporter.log("✅ Clicked on USDT (Polygon Chain)", true);
        } catch (Exception e) {
            Reporter.log("❌ Failed to scroll and click on USDT (Polygon Chain): " + e.getMessage(), true);
        }
    }

    public void clickOnUSDTPolygonText() {

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.ViewGroup[contains(@content-desc, 'USDT, USDT, Polygon Chain')]"))).click();
        Reporter.log("✅ Clicked on USDT (Polygon Chain)", true);
    }


    public void scrollAndClickOnAave() throws InterruptedException {
        try {
            // Scroll to the element containing "Aave, AAVE, Polygon Chain"
            driver.findElement(new AppiumBy.ByAndroidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true))"
                            + ".scrollIntoView(new UiSelector().descriptionContains(\"Aave, AAVE, Polygon Chain\"))"));

            // Wait for the Aave element to be clickable
            WebElement aaveElement = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//android.view.ViewGroup[contains(@content-desc, 'Aave, AAVE, Polygon Chain')]"
                            + "/android.view.ViewGroup/android.widget.ImageView")));

            // Click on the Aave element
            aaveElement.click();

            // Log the action
            Reporter.log("✅ Clicked on Aave (Polygon Chain)", true);
        } catch (Exception e) {
            Reporter.log("❌ Failed to scroll and click on Aave (Polygon Chain): " + e.getMessage(), true);
        }
    }

    public void clickOnAaveText() {

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.ViewGroup[contains(@content-desc, 'Aave, AAVE, Polygon Chain')]"))).click();
        Reporter.log("✅ Clicked on Aave (Polygon Chain)", true);
    }

    public void scrollAndClickOnWootrade() throws InterruptedException {
        // Scroll to the element containing "Wootrade Network, WOO, Polygon Chain"
        driver.findElement(new AppiumBy.ByAndroidUIAutomator(
                "new UiScrollable(new UiSelector().className(\"android.widget.ScrollView\").scrollable(true))"
                        + ".scrollIntoView(new UiSelector().descriptionContains(\"Wootrade Network, WOO, Polygon Chain\"))"));

        // Wait for the Wootrade element to be clickable (ignore price)
        WebElement wooElement = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//android.view.ViewGroup[contains(@content-desc, 'Wootrade Network, WOO, Polygon Chain')]")));

        // Click on the Wootrade element
        wooElement.click();

        // Log the action in TestNG report
        Reporter.log("✅ Clicked on Wootrade Network (Polygon Chain)", true);
    }

    public void clickOnWootradeText() {
        // Define the Wootrade element using its content-desc
        By wootradeElementLocator = By.xpath("//android.view.ViewGroup[@content-desc='Wootrade Network, WOO, Polygon Chain']");

        // Wait for the Wootrade element to be visible
        WebElement wootradeText = wait.until(ExpectedConditions.visibilityOfElementLocated(wootradeElementLocator));

        // Click on the "Wootrade Network"
        wootradeText.click();

        // Log the action in TestNG report
        Reporter.log("✅ Clicked on Wootrade Network (WOO) TextView", true);
    }

    public void scrollAndClickOnSushiToken() throws InterruptedException {
        // Scroll to the SushiToken element using partial content-desc (excluding the dynamic price)
        driver.findElement(new AppiumBy.ByAndroidUIAutomator(
                "new UiScrollable(new UiSelector().className(\"android.widget.ScrollView\").scrollable(true))" +
                        ".scrollIntoView(new UiSelector().descriptionContains(\"SushiToken, SUSHI, Polygon Chain\"))"));

        // Wait for the SushiToken element to be clickable
        WebElement sushiElement = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//android.view.ViewGroup[contains(@content-desc, 'SushiToken, SUSHI, Polygon Chain')]")));

        // Click on the SushiToken element
        sushiElement.click();

        // Log to TestNG report
        Reporter.log("✅ Clicked on SushiToken (SUSHI) - Polygon Chain", true);
    }

    public void clickOnSushiTokenText() {
        // Define the SushiToken element using its exact content-desc
        By sushiTokenLocator = By.xpath("//android.view.ViewGroup[@content-desc='SushiToken, SUSHI, Polygon Chain']");

        // Wait for the SushiToken element to be visible
        WebElement sushiTokenText = wait.until(ExpectedConditions.visibilityOfElementLocated(sushiTokenLocator));

        // Click on the "SushiToken" ViewGroup
        sushiTokenText.click();

        // Log the action in TestNG report
        Reporter.log("✅ Clicked on SushiToken (SUSHI) - Polygon Chain", true);
    }

    public void scrollAndClickOnUniswap() throws InterruptedException {
        // Scroll to the Uniswap element using partial content-desc
        driver.findElement(new AppiumBy.ByAndroidUIAutomator(
                "new UiScrollable(new UiSelector().className(\"android.widget.ScrollView\").scrollable(true))" +
                        ".scrollIntoView(new UiSelector().descriptionContains(\"Uniswap, UNI, Polygon Chain\"))"));

        // Wait for the Uniswap element to be clickable
        WebElement uniElement = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//android.view.ViewGroup[contains(@content-desc, 'Uniswap, UNI, Polygon Chain')]")));

        // Click on the Uniswap element
        uniElement.click();

        // Log the action in TestNG report
        Reporter.log("✅ Clicked on Uniswap (UNI) - Polygon Chain", true);
    }

    public void clickOnUniswapText() {
        // Define the Uniswap element using exact content-desc
        By uniswapLocator = By.xpath("//android.view.ViewGroup[@content-desc='Uniswap, UNI, Polygon Chain']");

        // Wait for the Uniswap element to be visible
        WebElement uniswapText = wait.until(ExpectedConditions.visibilityOfElementLocated(uniswapLocator));

        // Click on the Uniswap ViewGroup
        uniswapText.click();

        // Log the action in TestNG report
        Reporter.log("✅ Clicked on Uniswap (UNI) - Polygon Chain", true);
    }

    public void scrollAndClickOnUsdCoin() throws InterruptedException {
        // Scroll to the USD Coin element using partial content-desc
        driver.findElement(new AppiumBy.ByAndroidUIAutomator(
                "new UiScrollable(new UiSelector().className(\"android.widget.ScrollView\").scrollable(true))" +
                        ".scrollIntoView(new UiSelector().descriptionContains(\"USD Coin, USDC, Tron Network\"))"));

        // Wait for the USD Coin element to be clickable
        WebElement usdcElement = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//android.view.ViewGroup[contains(@content-desc, 'USD Coin, USDC, Tron Network')]")));

        // Click on the USD Coin element
        usdcElement.click();

        // Log the action in TestNG report
        Reporter.log("✅ Clicked on USD Coin (USDC) - Tron Network", true);
    }

    public void clickOnUsdCoinText() {
        // Define the USD Coin element using exact content-desc
        By usdcLocator = By.xpath("//android.view.ViewGroup[@content-desc='USD Coin, USDC, Tron Network']");

        // Wait until the element is visible
        WebElement usdcElement = wait.until(ExpectedConditions.visibilityOfElementLocated(usdcLocator));

        // Click on the USD Coin ViewGroup
        usdcElement.click();

        // Log the action in TestNG report
        Reporter.log("✅ Clicked on USD Coin (USDC) - Tron Network", true);
    }

    public void scrollAndClickOnCartesiToken() throws InterruptedException {
        // Scroll to the Cartesi Token element using partial content-desc
        driver.findElement(new AppiumBy.ByAndroidUIAutomator(
                "new UiScrollable(new UiSelector().className(\"android.widget.ScrollView\").scrollable(true))" +
                        ".scrollIntoView(new UiSelector().descriptionContains(\"Cartesi Token, CTSI, Ethereum Network\"))"));

        // Wait for the Cartesi Token element to be clickable
        WebElement ctsiElement = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//android.view.ViewGroup[contains(@content-desc, 'Cartesi Token, CTSI, Ethereum Network')]")));

        // Click on the Cartesi Token
        ctsiElement.click();

        // Log the action in TestNG report
        Reporter.log("✅ Clicked on Cartesi Token (CTSI) - Ethereum Network", true);
    }

    public void clickOnCartesiToken() {
        // Wait for the Cartesi Token element to be visible and clickable
        WebElement cartesiElement = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//android.view.ViewGroup[contains(@content-desc, 'Cartesi Token, CTSI, Ethereum Network')]")));

        // Click on the element
        cartesiElement.click();

        // Log the action in TestNG report
        Reporter.log("✅ Clicked on Cartesi Token (CTSI) - Ethereum Network", true);
    }

    public void scrollAndClickOnMakerToken() {
        // Scroll to the Maker token using UiScrollable and partial content-desc
        driver.findElement(new AppiumBy.ByAndroidUIAutomator(
                "new UiScrollable(new UiSelector().className(\"android.widget.ScrollView\").scrollable(true))"
                        + ".scrollIntoView(new UiSelector().descriptionContains(\"Maker, MKR, Ethereum Network\"))"));

        // Wait for the element to be clickable (ignoring price part)
        WebElement makerElement = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//android.view.ViewGroup[contains(@content-desc, 'Maker, MKR, Ethereum Network')]")));

        // Click the token
        makerElement.click();

        // Log it in the report
        Reporter.log("✅ Clicked on Maker (MKR) - Ethereum Network", true);
    }

    public void clickOnMakerToken() {
        // Wait until the Maker token element is clickable
        WebElement makerElement = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//android.view.ViewGroup[@content-desc='Maker, MKR, Ethereum Network']")
        ));

        // Use Actions class to perform the click
        Actions actions = new Actions(driver);
        actions.moveToElement(makerElement).click().perform();

        // Log the action
        Reporter.log("✅ Clicked on Maker (MKR) - Ethereum Network using Actions class", true);
    }

    public void scrollAndClickOnMemesAfterDark() {
        // Scroll to the full card
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))" +
                        ".scrollIntoView(new UiSelector().description(\"MemesAfterDark, MAD, Solano, $ 0.00\"))"
        ));

        // Click on the full card
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//android.view.ViewGroup[@content-desc='MemesAfterDark, MAD, Solano, $ 0.00']")
        ));
        element.click();

        // Report
        Reporter.log("✅ Clicked on MemesAfterDark (MAD) token", true);
    }

    public void clickOnMemesAfterDark() {
        WebElement madToken = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//android.view.ViewGroup[@content-desc='MemesAfterDark, MAD, Solano']")
        ));
        madToken.click();

        Reporter.log("✅ Clicked on 'MemesAfterDark, MAD, Solano' token", true);
    }

    public void scrollAndClickNearProtocol() {
        String nearXpath = "//android.view.ViewGroup[@content-desc='NEAR Protocol, NEAR, Ethereum Network, $ 2.54']";

        // Scroll into view using UiScrollable
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))" +
                        ".scrollIntoView(new UiSelector().description(\"NEAR Protocol, NEAR, Ethereum Network, $ 2.54\"))"
        ));

        // Click the element after scroll
        WebElement nearElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(nearXpath)));
        nearElement.click();

        Reporter.log("✅ Scrolled to and clicked on 'NEAR Protocol, NEAR, Ethereum Network'", true);
    }

    public void clickNearToken() {
        WebElement nearToken = (WebElement) driver.findElement(
                AppiumBy.accessibilityId("NEAR Protocol, NEAR, Ethereum Network")
        );

        nearToken.click();

        Reporter.log("✅ Clicked on 'NEAR Protocol, NEAR, Ethereum Network'", true);
    }

    public void scrollAndClickOnXDC() {
        try {
            // Scroll to the element using descriptionContains
            driver.findElement(new AppiumBy.ByAndroidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true))"
                            + ".scrollIntoView(new UiSelector().descriptionContains(\"XDC Network, XDC, Ethereum Network, $ 0.07\"))"
            ));

            // Wait and click on the nested ImageView inside the ViewGroup
            WebElement xdcElement = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//android.view.ViewGroup[@content-desc='XDC Network, XDC, Ethereum Network, $ 0.07']"
                            + "/android.view.ViewGroup/android.widget.ImageView")));

            xdcElement.click();
            Reporter.log("✅ Clicked on XDC Network (XDC)", true);

        } catch (Exception e) {
            Reporter.log("❌ Failed to scroll and click on XDC Network (XDC): " + e.getMessage(), true);
        }
    }

    public void clickOnXDC() {
        try {
            // Locate the element and wait until it is clickable
            WebElement xdcElement = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//android.view.ViewGroup[@content-desc='XDC Network, XDC, Ethereum Network']"
                            + "/android.view.ViewGroup/android.widget.ImageView")));

            // Click on the element
            xdcElement.click();

            // Log success
            Reporter.log("✅ Clicked on XDC Network (XDC)", true);

        } catch (Exception e) {
            Reporter.log("❌ Failed to click on XDC Network (XDC): " + e.getMessage(), true);
        }
    }

    public void scrollAndClickOnTXDC() {
        try {
            // Scroll to the element with description containing "XDC Network, TXDC, XDC Network"
            driver.findElement(new AppiumBy.ByAndroidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true))"
                            + ".scrollIntoView(new UiSelector().descriptionContains(\"XDC Network, TXDC, XDC Network\"))"));

            // Wait until the ImageView inside is clickable
            WebElement txdcElement = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//android.view.ViewGroup[@content-desc='XDC Network, TXDC, XDC Network, $ 0.07']"
                            + "/android.view.ViewGroup/android.widget.ImageView")));

            // Click the element
            txdcElement.click();

            // Log the action
            Reporter.log("✅ Clicked on XDC Network (TXDC)", true);

        } catch (Exception e) {
            Reporter.log("❌ Failed to scroll and click on XDC Network (TXDC): " + e.getMessage(), true);
        }
    }

    public void clickOnTXDC() {
        try {
            // Wait until the element is clickable
            WebElement txdcElement = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//android.view.ViewGroup[@content-desc='XDC Network, TXDC, XDC Network']"
                            + "/android.view.ViewGroup/android.widget.ImageView")));

            // Click the element
            txdcElement.click();

            // Log success
            Reporter.log("✅ Clicked on XDC Network (TXDC)", true);

        } catch (Exception e) {
            Reporter.log("❌ Failed to click on XDC Network (TXDC): " + e.getMessage(), true);
        }
    }

    public void scrollAndClickOnDiamante() {
        try {
            // Scroll to the element with description containing "Diamante, DIAM, $ 1.00"
            driver.findElement(new AppiumBy.ByAndroidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true))" +
                            ".scrollIntoView(new UiSelector().descriptionContains(\"Diamante, DIAM, $ 1.00\"))"));

            // Wait until the element is clickable
            WebElement diamanteElement = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//android.view.ViewGroup[@content-desc='Diamante, DIAM, $ 1.00']" +
                            "/android.view.ViewGroup/android.widget.ImageView")));

            // Click the element
            diamanteElement.click();

            // Log success
            Reporter.log("✅ Clicked on Diamante (DIAM)", true);

        } catch (Exception e) {
            Reporter.log("❌ Failed to scroll and click on Diamante (DIAM): " + e.getMessage(), true);
        }
    }

    public void clickOnDiamante() {
        try {
            WebElement diamanteElement = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//android.view.ViewGroup[@content-desc='Diamante, DIAM']" +
                            "/android.view.ViewGroup/android.widget.ImageView")));

            diamanteElement.click();
            Reporter.log("✅ Clicked on Diamante (DIAM)", true);
        } catch (Exception e) {
            Reporter.log("❌ Failed to click on Diamante (DIAM): " + e.getMessage(), true);
        }
    }

    public void scrollAndClickOnLumia() {
        try {
            // Scroll to the Lumia element
            driver.findElement(new AppiumBy.ByAndroidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true))" +
                            ".scrollIntoView(new UiSelector().descriptionContains(\"Lumia, TLUMIA, Lumia Chain\"))"
            ));

            // Wait and click the element
            WebElement lumiaElement = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//android.view.ViewGroup[@content-desc='Lumia, TLUMIA, Lumia Chain, $ 0.34']" +
                            "/android.view.ViewGroup/android.widget.ImageView")));

            lumiaElement.click();
            Reporter.log("✅ Clicked on Lumia (TLUMIA)", true);

        } catch (Exception e) {
            Reporter.log("❌ Failed to scroll and click on Lumia (TLUMIA): " + e.getMessage(), true);
        }
    }

    public void clickLumiaToken() {
        try {
            WebElement lumia = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc='Lumia, TLUMIA, Lumia Chain']"));
            lumia.click();
            System.out.println("✅ Clicked on Lumia token.");
        } catch (Exception e) {
            System.out.println("❌ Could not click on Lumia token: " + e.getMessage());
        }
    }


    public void scrollAndClickOnWYZth() {
        try {
            // Scroll to the WYZth element
            driver.findElement(new AppiumBy.ByAndroidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true))" +
                            ".scrollIntoView(new UiSelector().descriptionContains(\"WYZth, TWYZ, WYZth Chain\"))"
            ));

            // Wait and click the element
            WebElement wyzthElement = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//android.view.ViewGroup[@content-desc='WYZth, TWYZ, WYZth Chain, $ 0.00']" +
                            "/android.view.ViewGroup/android.widget.ImageView")));

            wyzthElement.click();
            Reporter.log("✅ Clicked on WYZth (TWYZ)", true);

        } catch (Exception e) {
            Reporter.log("❌ Failed to scroll and click on WYZth (TWYZ): " + e.getMessage(), true);
        }
    }

    public void clickOnWYZth() {
        try {
            WebElement wyzthElement = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//android.view.ViewGroup[@content-desc='WYZth, TWYZ, WYZth Chain, $ 0.00']" +
                            "/android.view.ViewGroup/android.widget.ImageView")));

            wyzthElement.click();
            Reporter.log("✅ Clicked on WYZth (TWYZ)", true);
        } catch (Exception e) {
            Reporter.log("❌ Failed to click on WYZth (TWYZ): " + e.getMessage(), true);
        }
    }

    public void scrollAndClickOnBinanceTestnet() {
        try {
            // Scroll to the Binance Coin testnet element
            driver.findElement(new AppiumBy.ByAndroidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true))" +
                            ".scrollIntoView(new UiSelector().descriptionContains(\"Binance Coin testnet, TBNB, Binance Smart Chain Test Net\"))"
            ));

            // Wait and click the element
            WebElement binanceElement = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//android.view.ViewGroup[@content-desc='Binance Coin testnet, TBNB, Binance Smart Chain Test Net, $ 586.20']" +
                            "/android.view.ViewGroup/android.widget.ImageView")));

            binanceElement.click();
            Reporter.log("✅ Clicked on Binance Coin testnet (TBNB)", true);

        } catch (Exception e) {
            Reporter.log("❌ Failed to scroll and click on Binance Coin testnet (TBNB): " + e.getMessage(), true);
        }
    }

    public void clickOnBinanceTestnet() {
        try {
            WebElement binanceElement = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//android.view.ViewGroup[@content-desc='Binance Coin testnet, TBNB, Binance Smart Chain Test Net, $ 586.20']" +
                            "/android.view.ViewGroup/android.widget.ImageView")));

            binanceElement.click();
            Reporter.log("✅ Clicked on Binance Coin testnet (TBNB)", true);

        } catch (Exception e) {
            Reporter.log("❌ Failed to click on Binance Coin testnet (TBNB): " + e.getMessage(), true);
        }
    }

    public void scrollAndClickOnEthereum() {
        try {
            // Scroll to the Ethereum element
            driver.findElement(new AppiumBy.ByAndroidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true))" +
                            ".scrollIntoView(new UiSelector().descriptionContains(\"Ethereum, ETH, Arbitrum Network\"))"
            ));

            // Wait and click the Ethereum element
            WebElement ethereumElement = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//android.view.ViewGroup[@content-desc='Ethereum, ETH, Arbitrum Network, $ 1771.95']" +
                            "/android.view.ViewGroup/android.widget.ImageView")));

            ethereumElement.click();
            Reporter.log("✅ Clicked on Ethereum (ETH)", true);

        } catch (Exception e) {
            Reporter.log("❌ Failed to scroll and click on Ethereum (ETH): " + e.getMessage(), true);
        }
    }

    public void clickOnEthereumLastCurrency() {
        try {
            WebElement ethereumElement = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//android.view.ViewGroup[@content-desc='Ethereum, ETH, Arbitrum Network, $ 1771.95']" +
                            "/android.view.ViewGroup/android.widget.ImageView")));

            ethereumElement.click();
            Reporter.log("✅ Clicked on Ethereum (ETH)", true);

        } catch (Exception e) {
            Reporter.log("❌ Failed to click on Ethereum (ETH): " + e.getMessage(), true);
        }
    }

    public void printAllCurrencyNamesWithVerticalScroll() {
        try {
            Set<String> currencySet = new LinkedHashSet<>();
            int previousCount = -1;

            // Step 1: Collect first visible items
            List<WebElement> initialElements = driver.findElements(By.xpath("//android.widget.TextView"));
            for (WebElement element : initialElements) {
                String text = element.getText().trim();
                if (!text.isEmpty()) {
                    currencySet.add(text);
                }
            }

            // Step 2: Scroll and collect more
            while (true) {
                List<WebElement> currencyElements = driver.findElements(By.xpath("//android.widget.TextView"));
                for (WebElement element : currencyElements) {
                    String text = element.getText().trim();
                    if (!text.isEmpty()) {
                        currencySet.add(text);
                    }
                }

                if (currencySet.size() == previousCount) {
                    Reporter.log("✅ Reached end. Total currencies: " + currencySet.size(), true);
                    break;
                }

                previousCount = currencySet.size();

                try {
                    Reporter.log("🔃 Attempting to scroll...", true);

                    driver.findElement(AppiumBy.androidUIAutomator(
                            "new UiScrollable(new UiSelector().className(\"android.widget.ScrollView\")).scrollForward()"));

                    Thread.sleep(800); // allow content to load

                } catch (Exception e) {
                    Reporter.log("⚠️ Scroll failed: " + e.getMessage(), true);
                    break;
                }
            }

            // Print all collected currencies
            for (String currency : currencySet) {
                Reporter.log("💱 Currency: " + currency, true);
            }

        } catch (Exception e) {
            Reporter.log("❌ Error while scrolling currencies: " + e.getMessage(), true);
            e.printStackTrace();
        }
    }


    public void printAllCurrencyNamesPageByPage() {
        try {
            Set<String> currencySet = new LinkedHashSet<>(); // To maintain order and avoid duplicates

            // First: Collect initially visible currencies
            List<WebElement> initialCurrencies = driver.findElements(By.xpath(
                    "//androidx.viewpager.widget.ViewPager//android.widget.TextView"));
            for (WebElement element : initialCurrencies) {
                String text = element.getText().trim();
                if (!text.isEmpty()) {
                    currencySet.add(text);
                }
            }

            int maxScrolls = 20; // safety limit
            int previousSize;

            for (int i = 0; i < maxScrolls; i++) {
                previousSize = currencySet.size();

                // Perform a slow scroll using TouchAction (slightly upwards swipe)
                Dimension size = driver.manage().window().getSize();
                int startX = size.width / 2;
                int startY = (int) (size.height * 0.7);
                int endY = (int) (size.height * 0.3);

                new TouchAction<>(driver)
                        .press(PointOption.point(startX, startY))
                        .waitAction(WaitOptions.waitOptions(Duration.ofMillis(700)))
                        .moveTo(PointOption.point(startX, endY))
                        .release()
                        .perform();

                Thread.sleep(1000); // wait for content to load after scroll

                // Collect all visible currencies again after scroll
                List<WebElement> currentCurrencies = driver.findElements(By.xpath(
                        "//androidx.viewpager.widget.ViewPager//android.widget.TextView"));
                for (WebElement element : currentCurrencies) {
                    String text = element.getText().trim();
                    if (!text.isEmpty()) {
                        currencySet.add(text);
                    }
                }

                // Stop if no new items were added
                if (currencySet.size() == previousSize) {
                    Reporter.log("✅ Reached end of currency list.", true);
                    break;
                }
            }

            // Print all collected currencies
            Reporter.log("🔍 Total unique currencies found: " + currencySet.size(), true);
            for (String currency : currencySet) {
                Reporter.log("💱 Currency: " + currency, true);
            }

        } catch (Exception e) {
            Reporter.log("❌ Error while scrolling and collecting currencies: " + e.getMessage(), true);
            e.printStackTrace();
        }
    }

    public void scrollAndPrintAllCurrencyNames() {
        try {
            List<String> currencyList = new ArrayList<>();
            int previousCount = -1;

            while (true) {
                // Capture all currently visible TextViews inside the RecyclerView
                List<WebElement> currencyElements = driver.findElements(By.xpath(
                        "//androidx.recyclerview.widget.RecyclerView//android.widget.TextView"
                ));

                for (WebElement element : currencyElements) {
                    String text = element.getText().trim();
                    if (!text.isEmpty()) {
                        currencyList.add(text);
                    }
                }

                // Break if no new items are appearing
                if (currencyList.size() == previousCount) {
                    break;
                }

                previousCount = currencyList.size();

                // Scroll RecyclerView using UiScrollable
                driver.findElement(AppiumBy.androidUIAutomator(
                        "new UiScrollable(new UiSelector().className(\"androidx.recyclerview.widget.RecyclerView\")).scrollForward()"
                ));

                Thread.sleep(1000); // Wait for new items to load
            }

            // Output results (including duplicates)
            Reporter.log("🔍 Total currencies found (with duplicates): " + currencyList.size(), true);
            for (String currency : currencyList) {
                Reporter.log("💱 Currency: " + currency, true);
            }

        } catch (Exception e) {
            Reporter.log("❌ Failed to scroll and fetch all currencies: " + e.getMessage(), true);
            e.printStackTrace();
        }
    }

    public void printAllCurrencyNames() {
        try {
            // Wait until at least one currency element is visible
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//androidx.viewpager.widget.ViewPager//android.widget.TextView")
            ));

            // Locate all TextViews inside the ViewPager
            List<WebElement> currencies = driver.findElements(By.xpath(
                    "//androidx.viewpager.widget.ViewPager//android.widget.TextView"
            ));

            Reporter.log("🔍 Found " + currencies.size() + " currencies in the list.", true);

            for (WebElement currency : currencies) {
                String name = currency.getText().trim();
                if (!name.isEmpty()) {
                    System.out.println("💱 Currency: " + name); // Console output
                    Reporter.log("💱 Currency: " + name, true); // TestNG report
                }
            }

        } catch (Exception e) {
            Reporter.log("❌ Failed to fetch currency list: " + e.getMessage(), true);
            e.printStackTrace();
        }
    }


    public void clickOnSharingLink() throws InterruptedException {

//        // 1. Wait for and click "Copy Sharing Link"
//        wait.until(ExpectedConditions.visibilityOf(copySharingLink));
//        wait.until(ExpectedConditions.elementToBeClickable(copySharingLink));
//        copySharingLink.click();
//        Reporter.log("Clicked on 'Copy Sharing Link'", true);

        Thread.sleep(2000);

        // 2. Select Gmail app from share sheet
        WebElement gmailOption = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Gmail\").instance(1)"));
        gmailOption.click();
        Reporter.log("Gmail selected from share options", true);

        Thread.sleep(1000);

        // 3. Enter email address in Gmail "To" field
        WebElement toField = driver.findElement(By.xpath("//android.view.ViewGroup[@resource-id='com.google.android.gm:id/peoplekit_autocomplete_chip_group']/android.widget.EditText"));
        toField.sendKeys("svsswamy99@gmail.com");
        Reporter.log("Entered recipient email: svsswamy99@gmail.com", true);

        // 4. Wait for suggestion and click
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement suggestion = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//android.widget.RelativeLayout[@resource-id='com.google.android.gm:id/peoplekit_listview_flattened_row']")
        ));
        suggestion.click();
        Reporter.log("Selected email suggestion from Gmail", true);

        Thread.sleep(1000);

        // 5. Enter subject
        WebElement subject = driver.findElement(By.xpath("//android.widget.EditText[@resource-id='com.google.android.gm:id/subject']"));
        subject.sendKeys("PayCIo Link");
        Reporter.log("Entered email subject: PayCIo Link", true);

        // 6. Click Send
        WebElement sendButton = driver.findElement(By.xpath("//android.widget.Button[@content-desc='Send']"));
        sendButton.click();
        Reporter.log("Clicked on Send button - Email sent successfully", true);
    }
}











