package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.time.Duration;

public class SuggestionPage extends BaseTest {

    private WebDriver driver;
    private WebDriverWait wait;

    // Constructor
    public SuggestionPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//android.widget.TextView[@text=\"Choose from gallery\"]")
    private WebElement Choosefromgallery;

    @FindBy(xpath = "//android.widget.ImageView[@resource-id=\"com.google.android.providers.media.module:id/icon_thumbnail\"]")
    private WebElement Selectimage;

    @FindBy(xpath = "//android.widget.EditText[@text=\"Enter your suggestions up to 300 characters.\"]")
    private WebElement suggestionTextBox;




    public void scrollAndClickSuggestions() {
        WebElement element = driver.findElement(new AppiumBy.ByAndroidUIAutomator(
                "new UiScrollable(new UiSelector().className(\"android.widget.ScrollView\").scrollable(true))"
                        + ".scrollIntoView(new UiSelector().textMatches(\"Suggestions\"))"));
        element.click();
        Reporter.log("clicked Suggestions button", true);
    }

    public boolean enterSuggestion(String suggestionText) {
        if (suggestionText.length() < 3 || suggestionText.length() > 300) {
            System.out.println("❌ Suggestion must be between 3 and 300 characters. Provided: " + suggestionText.length());
            return false; // Don't proceed if invalid
        }

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement inputField = wait.until(ExpectedConditions.visibilityOf(suggestionTextBox));

        inputField.clear();
        inputField.sendKeys(suggestionText);
        System.out.println("✅ Suggestion entered: " + suggestionText);
        return true;
    }

    public void clickOnUploadImage() {
        WebElement uploadImageBtn = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Upload image")));
        uploadImageBtn.click();
    }

    public void clickOnChooseGallery() {
        wait.until(ExpectedConditions.elementToBeClickable(Choosefromgallery));
        Choosefromgallery.click();
    }

    public void selectImage() {
        wait.until(ExpectedConditions.elementToBeClickable(Selectimage));
        Selectimage.click();
    }

    public void clickOnSubmit() {
        WebElement submitButton = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Submit")));
        submitButton.click();
    }



}
