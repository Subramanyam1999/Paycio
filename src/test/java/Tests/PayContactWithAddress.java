package Tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.*;
import UtilityMethods.ScreenshotListener; // Ensure this import matches your package structure


@Listeners(ScreenshotListener.class) // Attach the listener to capture screenshots on failure
public class PayContactWithAddress extends BaseTest {

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
    public void PayContactWithAddress() throws InterruptedException {
        // payciohomepage.clickWelcomeBackButton();
        operationsbutton.clickPayContactsAddress();
        //  Thread.sleep(2500);
        //  operationsbutton.clickContactByAddress("0x6EEc5c5786BE10145646D1550C51aa24Cf3CB80F");
// Invalid address trying
// not my contact but paycio user
        operationsbutton.clickContactByAddress("6302675294");
        Thread.sleep(1000);

        //operationsbutton.verifyTransactionResult();

//
//operationsbutton.enterAmountToWithdraw();
//
//operationsbutton.enterSubmitButton();
//        operationsbutton.enterPIN("2580");
//        operationsbutton.clickSubmitinUCPIPage();
//        operationsbutton.verifyTransactionSuccess();


//        Thread.sleep(2000);
//        operationsbutton.enterAmount();
//        Thread.sleep(3000);
//        operationsbutton.forceClickOnBNBTokenUsingActions();
//        Thread.sleep(1000);
//        operationsbutton.clickUSDCElement();
//        Thread.sleep(1000);
//        operationsbutton.clickConfirmButton();
//        Thread.sleep(2000);
//        operationsbutton.clickOnPayButton();
//        operationsbutton.enterPIN("2580");
////        operationsbutton.enterPINAndCheckError("258");
//        operationsbutton.clickSubmitinUCPIPage();
//        operationsbutton.verifyTransactionSuccess();
//        Thread.sleep(2000);
//        operationsbutton.click_cancel_button();
//        Thread.sleep(2000);
//        operationsbutton.pressAndroidBackButton();
//        Thread.sleep(2000);
//        operationsbutton.pressAndroidBackButton();

    }
}