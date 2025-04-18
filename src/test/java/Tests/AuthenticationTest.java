package Tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.*;
import UtilityMethods.ScreenshotListener;


@Listeners(ScreenshotListener.class)
public class AuthenticationTest extends BaseTest {

    private PayCioLoginPage payciopage;
    private PayCioHomePage payciohomepage;
    private CreateMerchantPage createmerchantpage;
    private SuggestionPage suggestionpage;
    private ReferralPage referralPage;
    private AuthenticationPinPage authenticationpinpage;

    @BeforeMethod
    public void setUpPages() {
        // Initialize page objects
        payciopage = new PayCioLoginPage(driver);
        payciohomepage = new PayCioHomePage(driver);
        createmerchantpage = new CreateMerchantPage(driver);
        suggestionpage = new SuggestionPage(driver);
        referralPage = new ReferralPage(driver);
        authenticationpinpage = new AuthenticationPinPage(driver);

        ScreenshotListener.driver = driver;
    }

    @Test
    public void authenticationScenario() throws InterruptedException {
        payciohomepage.clickWelcomeBackButton();
        Thread.sleep(2000);

        authenticationpinpage.scrollAndClickAuthentication();
        Thread.sleep(2000);

        authenticationpinpage.clickOnAuthenticationButton();

        Thread.sleep(1000);

        //authenticationpinpage.EnableSecurityPin();
//shubh
        Thread.sleep(1000);

        authenticationpinpage.DisableSecurityPin();
        Thread.sleep(3000);

       // authenticationpinpage.EnterSecurityPin();
        //authenticationpinpage.EnterSecurityPin("1234");
        EnterSecurityPin("1234");
//Test

        Thread.sleep(2000);

        authenticationpinpage.ClickOnSubmitButton();
    }


}