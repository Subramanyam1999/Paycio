package Tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.*;
import UtilityMethods.ScreenshotListener; // Ensure this import matches your package structure


@Listeners(ScreenshotListener.class) // Attach the listener to capture screenshots on failure
public class WalletTest extends BaseTest {

    private PayCioLoginPage payciopage;
    private PayCioHomePage payciohomepage;
    private PayCioLoginPage payciologinpage;
    private WalletPage walletpage;

    private PayCioLoginTest payCioLoginTest;

    @BeforeMethod
    public void setUpLoginClass() {
        // Initialize PayCioPage
        payciopage = new PayCioLoginPage(driver);
        payciohomepage = new PayCioHomePage(driver);
        createmerchantpage = new CreateMerchantPage(driver);
        payciologinpage = new PayCioLoginPage(driver);
        walletpage = new WalletPage(driver);
        payCioLoginTest = new PayCioLoginTest();


        ScreenshotListener.driver = driver;

    }

    @Test
    public void WalletTestScenario() throws InterruptedException {
//        payciopage.clickAllowButton();
//        payciopage.clickSkipButton();
//        payciopage.enterMobileNumber();
//        payciopage.clickCheckBox();
//        payciopage.clickGetCallButton();
//        payciopage.clickAllowButtonPhoneCalls();
//        //  Thread.sleep(7000);  // Simulate some wait time for the app to react
//        payciopage.clickAllowButtonPhoneCalls();
//        payciopage.clickAllowButtonPhoneCalls();
//        payciopage.clickAllowLocationAccess();
//        payciopage.clickOkayButton();

//walletpage.clickWalletTextView();
        payciohomepage.clickWalletButton();
        walletpage.clickWithdrawButton();
        walletpage.clickSwap();
        //walletpage.backFromSwapPage();
        walletpage.clickBackNavigationButton();
        Thread.sleep(500);
        walletpage.clickBuy();
        Thread.sleep(500);
        walletpage.clickBackNavigationButton();
        walletpage.clickSell();
        walletpage.clickBackNavigationButton();


    }
}