package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.time.Duration;

public class ReferralPage extends BaseTest {

    private AndroidDriver driver;
    private WebDriverWait wait;

    // Constructor
    public ReferralPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='Referral' and @clickable='true']")
    private WebElement referralButton;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='Invite contacts' and @clickable='true']")
    private WebElement inviteContactsButton;

    @FindBy(xpath = "//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.widget.FrameLayout[1]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.widget.FrameLayout[1]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.widget.ImageView[1]")
    private WebElement backButton;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='Share your referral link']")
    private WebElement shareReferralButton;

    @FindBy(xpath = "//android.widget.Button[@resource-id=\"android:id/button2\"]")
    private WebElement clickOnCancelButton;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='Rewards']")
    private WebElement rewardsButton;





    // Scroll to the "Referral" section using UIAutomator and click it
    public void scrollAndClickReferral() {
        WebElement element = driver.findElement(new AppiumBy.ByAndroidUIAutomator(
                "new UiScrollable(new UiSelector().className(\"android.widget.ScrollView\").scrollable(true))"
                        + ".scrollIntoView(new UiSelector().textMatches(\"Referral\"))"));

        element.click();
        Reporter.log("Clicked on Referral button after scrolling", true);
    }

    // Wait for the referral button and click
    public void clickReferralButton() {
        wait.until(ExpectedConditions.elementToBeClickable(referralButton));
        referralButton.click();
        Reporter.log("Clicked on Referral button", true);
    }
    public void clickInviteContacts() {
        wait.until(ExpectedConditions.elementToBeClickable(inviteContactsButton));
        inviteContactsButton.click();
        Reporter.log("Clicked on Invite contacts", true);
    }
   public void  clickOnBackButton(){
        wait.until(ExpectedConditions.elementToBeClickable(backButton));
        backButton.click();
        Reporter.log("Clicked On Back Button ",  true);


   }
   public void  clickOnShareYourReferralLInkButton(){
        wait.until(ExpectedConditions.elementToBeClickable(shareReferralButton));
        shareReferralButton.click();
        Reporter.log("Clicked on Share your Referral link", true);
   }

   public void  ClickOnCancelButton(){
        wait.until(ExpectedConditions.elementToBeClickable(clickOnCancelButton));
        clickOnCancelButton.click();
        Reporter.log("Clicked on Cancel BUtton", true);

   }

    public void  ClickonRewardsButton(){
        wait.until(ExpectedConditions.elementToBeClickable(rewardsButton));
        rewardsButton.click();
        Reporter.log("Clicked on Rewards Button",true);



    }

}
