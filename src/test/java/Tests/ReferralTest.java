package Tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.*;
import UtilityMethods.ScreenshotListener;

@Listeners(ScreenshotListener.class)
public class ReferralTest extends BaseTest {

    private PayCioLoginPage payciopage;
    private PayCioHomePage payciohomepage;
    private CreateMerchantPage createmerchantpage;
    private SuggestionPage suggestionpage;
    private ReferralPage referralPage;

    @BeforeMethod
    public void setUpPages() {
        // Initialize page objects
        payciopage = new PayCioLoginPage(driver);
        payciohomepage = new PayCioHomePage(driver);
        createmerchantpage = new CreateMerchantPage(driver);
        suggestionpage = new SuggestionPage(driver);
        referralPage = new ReferralPage(driver); // ✅ FIXED: Initialized referralPage
        ScreenshotListener.driver = driver;
    }

    @Test
    public void referralScenario() throws InterruptedException {
        payciohomepage.clickWelcomeBackButton();

        // Waits should ideally be handled inside page methods
        referralPage.scrollAndClickReferral();
        referralPage.clickReferralButton();
        Thread.sleep(1500);
        referralPage.clickInviteContacts();
        Thread.sleep(1000);
        referralPage.clickOnBackButton();
        Thread.sleep(1000);
        payciohomepage.clickWelcomeBackButton();
        referralPage.scrollAndClickReferral();
        referralPage.clickReferralButton();
        Thread.sleep(1000);
        referralPage.clickOnShareYourReferralLInkButton();
        referralPage.ClickOnCancelButton();
        Thread.sleep(1500);
        referralPage.ClickonRewardsButton();
        ScrollToEnd();

    }
}
