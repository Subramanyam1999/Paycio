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
public class CreateMerchantTest extends BaseTest {

    private PayCioLoginPage payciopage;
    private PayCioHomePage payciohomepage;
    private CreateMerchantPage createmerchantpage;

    @BeforeMethod
    public void setUpLoginClass() {
        // Initialize PayCioPage
        payciopage = new PayCioLoginPage(driver);
        payciohomepage = new PayCioHomePage(driver);
        createmerchantpage = new CreateMerchantPage(driver);
        ScreenshotListener.driver = driver;
    }

    @Test
    public void CreateMerchantScenario() throws InterruptedException {
        payciohomepage.clickWelcomeBackButton();
        createmerchantpage.scrollAndClickCreateNewMerchant();
        //   createmerchantpage.scrolltoendAndClickAcceptButton();
        createmerchantpage.enterMerchantStoreName();
        createmerchantpage.enterEmail();
        Thread.sleep(1500);
        createmerchantpage.clickOnCategory();
        Thread.sleep(1500);
        createmerchantpage.clickAutomotive();
        createmerchantpage.clickOnSelectButton();
        createmerchantpage.clickOnSelectAll();
        createmerchantpage.clickOnConfirmButton();
        // Thread.sleep(500);
        //  createmerchantpage.clickOnUploadText();
        Thread.sleep(1000);

        createmerchantpage.scrollAndClickCreateMerchant();
       // createmerchantpage.clickOnCreateMerchantButton();
    }
}