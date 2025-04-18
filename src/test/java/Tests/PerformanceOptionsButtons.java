package Tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.*;
import UtilityMethods.ScreenshotListener; // Ensure this import matches your package structure


@Listeners(ScreenshotListener.class) // Attach the listener to capture screenshots on failure
public class PerformanceOptionsButtons extends BaseTest {

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
    public void PerformanceOptionsButtons() throws InterruptedException {


        operationsbutton.clickScanQrCode();
        operationsbutton.pressAndroidBackButton();
        operationsbutton.clickPayToMobileNumber();
        operationsbutton.pressAndroidBackButton();
        operationsbutton.clickPayContactsAddress();
        operationsbutton.pressAndroidBackButton();
        operationsbutton.clickReceiveFunds();
        operationsbutton.pressAndroidBackButton();

    }}