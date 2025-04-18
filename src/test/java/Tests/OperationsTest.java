package Tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.*;
import UtilityMethods.ScreenshotListener; // Ensure this import matches your package structure


@Listeners(ScreenshotListener.class) // Attach the listener to capture screenshots on failure
public class OperationsTest extends BaseTest {

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
    public void Operations_Buttons_Scenario() throws InterruptedException {
        operationsbutton.clickScanQrCode();
        operationsbutton.clickUploadQR();
//operationsbutton.clickUploadQRAndUploadImage("/storage/emulated/0/Pictures/QrCode/IMG-20250318-WA0043.jpg");


        operationsbutton.clickAlbumsButton();


        //operationsbutton.clickAllowOneTimeForCamera();

        operationsbutton.enterWithdrawAmount();

        operationsbutton.enterSubmitButton();

        operationsbutton.enterPINStepByStepAndValidate("2580");

        operationsbutton.clickSubmitinUCPIPage();
        Thread.sleep(3000);
        operationsbutton.isElementDisplayed();
        Thread.sleep(3000);
        operationsbutton.click_cancel_button();
        Thread.sleep(3000);
        operationsbutton.pressAndroidBackButton();
        Thread.sleep(3000);
        operationsbutton.clickPayToMobileNumber();
       // operationsbutton.clickEditTextField();
        operationsbutton.clickIfNameAppears();
        Thread.sleep(3000);
        operationsbutton.enterAmount();
        Thread.sleep(2000);
      //  operationsbutton.clickBitcoinElement();
        operationsbutton.clickUSDCElement();
        operationsbutton.clickConfirmButton();
        Thread.sleep(3000);
        operationsbutton.clickOnPayButton();
        operationsbutton.enterPINStepByStepAndValidate("2580");
        Thread.sleep(6000);
        operationsbutton.clickSubmitinUCPIPage();
        operationsbutton.verifyTransactionSuccess();
        Thread.sleep(2000);
        operationsbutton.click_cancel_button();
        Thread.sleep(2000);

        operationsbutton.pressAndroidBackButton();
        Thread.sleep(2000);

        operationsbutton.pressAndroidBackButton();
        Thread.sleep(2000);
        operationsbutton.clickPayContactsAddress();
        //operationsbutton.clickEditTextFieldForCotact();
        operationsbutton.clickIfNameAppearsForContacts();

        operationsbutton.enterAmount();
        operationsbutton.clickBitcoinElement();
        operationsbutton.clickUSDCElement();

        operationsbutton.clickConfirmButton();
        Thread.sleep(2000);
        operationsbutton.clickOnPayButton();
        Thread.sleep(6000);
        operationsbutton.enterPINStepByStepAndValidate("2580");
        operationsbutton.clickSubmitinUCPIPage();
        operationsbutton.verifyTransactionSuccess();
        Thread.sleep(2000);
        operationsbutton.click_cancel_button();
        Thread.sleep(2000);
        operationsbutton.pressAndroidBackButton();
        Thread.sleep(2000);
        operationsbutton.pressAndroidBackButton();
        Thread.sleep(2000);

        operationsbutton.clickReceiveFunds();
        //  Thread.sleep(2000);
        operationsbutton.verifyButtonsDisplayedAndLogText();
        operationsbutton.clickSetAmountButton();
        operationsbutton.enterSetAmount();
        operationsbutton.clickOKButton();


    }
}