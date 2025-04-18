package Tests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.*;
import UtilityMethods.ScreenshotListener; // Ensure this import matches your package structure


@Listeners(ScreenshotListener.class) // Attach the listener to capture screenshots on failure
public class ScanAnyQR extends BaseTest {

    private PayCioLoginPage payciopage;
    private PayCioHomePage payciohomepage;
    private OperationsButton operationsbutton;

    @BeforeMethod
    public void setUpLoginClass() {
        // Initialize PayCioPage
        payciopage = new PayCioLoginPage(driver);
        operationsbutton = new OperationsButton(driver);
        payciohomepage = new PayCioHomePage(driver);
        createmerchantpage = new CreateMerchantPage(driver);
        ScreenshotListener.driver = driver;

    }

    @Test()
    public void Scan_Any_QR_Scenario() throws InterruptedException {
        operationsbutton.clickScanQrCode();
        operationsbutton.clickUploadQR();
        operationsbutton.clickAlbumsButton();
        //operationsbutton.clickAllowOneTimeForCamera();
        operationsbutton.enterWithdrawAmount();
        operationsbutton.enterSubmitButton();
        operationsbutton.enterSubmitButton();

       operationsbutton.enterPINAndCheckError("2");
        operationsbutton.clickSubmitinUCPIPage();
        operationsbutton.isElementDisplayed();
        operationsbutton.click_cancel_button();
        Thread.sleep(3000);
        operationsbutton.pressAndroidBackButton();
        Thread.sleep(3000);


    }
}

