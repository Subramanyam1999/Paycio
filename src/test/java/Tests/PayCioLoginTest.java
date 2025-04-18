package Tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.BaseTest;
import UtilityMethods.ScreenshotListener; // Ensure this import matches your package structure
import pages.CreateMerchantPage;
import pages.PayCioHomePage;
import pages.PayCioLoginPage;

@Listeners(ScreenshotListener.class) // Attach the listener to capture screenshots on failure
public class PayCioLoginTest extends BaseTest {

    private PayCioLoginPage payciopage;
    private PayCioHomePage payciohomepage;

    @BeforeMethod
    public void setUpLoginClass() {
        // Initialize PayCioPage
        payciopage = new PayCioLoginPage(driver);
        payciohomepage = new PayCioHomePage(driver);
        createmerchantpage = new CreateMerchantPage(driver);

        ScreenshotListener.driver = driver;

    }

    @Test(priority = 1)
    public void loginScenario() throws InterruptedException {
        payciopage.clickAllowButton();
        payciopage.clickSkipButton();
//       // payciopage.enterMobileNumber();
        enter_mobile_number();
        Thread.sleep(1000);
        payciopage.clickCheckBox();
        Thread.sleep(1000);
        payciopage.clickGetCallButton();
        Thread.sleep(1000);
       payciopage.clickAllowButtonPhoneCalls();
//      //  Thread.sleep(7000);  // Simulate some wait time for the app to react
payciopage.clickAllowButtonPhoneCalls();
//        payciopage.clickAllowButtonPhoneCalls();
//        payciopage.clickAllowLocationAccess();
//        payciopage.clickOkayButton();
//        payciohomepage.clickWelcomeBackButton();
//        payciohomepage.clickWelcomeBackButton();
//        createmerchantpage.scrollAndClickCreateNewMerchant();
//        createmerchantpage.scrolltoendAndClickAcceptButton();
//        createmerchantpage.enterMerchantStoreName();
//        createmerchantpage.enterEmail();
//        createmerchantpage.clickOnCategory();
//        createmerchantpage.clickAutomotive();
//        createmerchantpage.clickUpcoming();

        System.out.println("Current working directory: " + System.getProperty("user.dir"));
    }


}

