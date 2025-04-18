package pages;


import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.AndroidDriver;

import java.time.Duration;
import java.util.List;

public class AuthenticationPinPage extends BaseTest {
    private AndroidDriver driver;
    private WebDriverWait wait;
//    AndroidDriver driver1;

    // Constructor
    public AuthenticationPinPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    // ✅ Locators
    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='Authentication']")
    private WebElement authenticationButton;

    @FindBy(xpath = "//android.widget.TextView[@text='Security PIN ']/following-sibling::android.view.ViewGroup[@clickable='true']")
    private WebElement securityPinToggleButton;




    // ✅ Scroll to "Authentication" and click it
    public void scrollAndClickAuthentication() {
        WebElement element = driver.findElement(new AppiumBy.ByAndroidUIAutomator(
                "new UiScrollable(new UiSelector().className(\"android.widget.ScrollView\").scrollable(true))"
                        + ".scrollIntoView(new UiSelector().description(\"Authentication\"))"
        ));

        element.click();
        Reporter.log("Clicked on Authentication button after scrolling", true);
    }

    // ✅ Click the "Authentication" button
    public void clickOnAuthenticationButton() {
        wait.until(ExpectedConditions.elementToBeClickable(authenticationButton));
        authenticationButton.click();
        Reporter.log("Clicked on Authentication Button", true);
    }
    public void  EnableSecurityPin(){

        wait.until(ExpectedConditions.elementToBeClickable(securityPinToggleButton));
        securityPinToggleButton.click();
        Reporter.log("Pin Enabled Successfull",true);

    }
    public void DisableSecurityPin(){
        wait.until(ExpectedConditions.elementToBeClickable(securityPinToggleButton));
    securityPinToggleButton.click();
    Reporter.log("Security Pin Disabled Success",true);


}



//    public void EnterSecurityPin() {
//        driver.findElement(By.xpath("(//android.view.ViewGroup[@resource-id='otp-input'])[1]")).click();
//        ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.DIGIT_1));
//
//        driver.findElement(By.xpath("(//android.view.ViewGroup[@resource-id='otp-input'])[2]")).click();
//        ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.DIGIT_2));
//
//        driver.findElement(By.xpath("(//android.view.ViewGroup[@resource-id='otp-input'])[3]")).click();
//        ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.DIGIT_3));
//
//        driver.findElement(By.xpath("(//android.view.ViewGroup[@resource-id='otp-input'])[4]")).click();
//        ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.DIGIT_4));
//
//    }


    public void EnterSecurityPin(String pin) {
        for (int i = 0; i < 4; i++) {
            char digit = pin.charAt(i);
            driver.findElement(By.xpath("(//android.view.ViewGroup[@resource-id='otp-input'])[" + (i + 1) + "]")).click();
            ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.valueOf("DIGIT_" + digit)));
        }
    }

    public void ClickOnSubmitButton () {

//        WebElement ClickSubmit = driver.findElement(By.xpath("//android.widget.TextView[@text=\"Submit\"]"));
//        ClickSubmit.click();


            WebElement ClickSubmit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text=\"Submit\"]")));
            ClickSubmit.click();

        }

    }