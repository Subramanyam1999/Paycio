package Tests;

import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.*;
import UtilityMethods.ScreenshotListener; // Ensure this import matches your package structure


@Listeners(ScreenshotListener.class) // Attach the listener to capture screenshots on failure
public class WalletWithdraw extends BaseTest {

    private PayCioLoginPage payciopage;
    private PayCioHomePage payciohomepage;
    private OperationsButton operationsbutton;
    private WalletPage walletPage;

    @BeforeMethod
    public void setUpLoginClass() {
        // Initialize PayCioPage
        payciopage = new PayCioLoginPage(driver);
        operationsbutton = new OperationsButton(driver);
        payciohomepage = new PayCioHomePage(driver);
        createmerchantpage = new CreateMerchantPage(driver);
        walletpage = new WalletPage(driver);
        ScreenshotListener.driver = driver;
    }

    @Test()
    public void Wallet_WithDraw_Scenario() throws InterruptedException {

        // 🚀 Phone Number Withdrawal Flow
        Reporter.log("<hr><b style='color:blue;'>📱 Starting: Withdraw via Phone Number</b><hr>", true);
        payciohomepage.clickWalletButton();
        Thread.sleep(3000);
        walletpage.clickWithdrawButton();
        operationsbutton.clickUSDC();
        walletpage.clickOnSendViaPhoneNumber();
        Thread.sleep(2500);
        walletpage.enterAndLogPhoneNumber();
        Thread.sleep(2500);
        walletpage.verifyUserNameTextVisible();
        operationsbutton.enterWithdrawAmount();
        operationsbutton.enterSubmitButton();
        operationsbutton.enterPINAndCheckError("2580");
        operationsbutton.enterWithdrawAmount();
        operationsbutton.verifyTransactionSuccess(); // embed screenshot here
        operationsbutton.click_cancel_button();
        Reporter.log("<b style='color:green;'>✅ Completed: Withdraw via Phone Number</b><hr>", true);

        // 🌐 Crypto Network Withdrawal Flow
        Reporter.log("<hr><b style='color:blue;'>🌐 Starting: Withdraw via Crypto Network</b><hr>", true);
        operationsbutton.clickUSDC();
        walletpage.clickOnCryptoNetwork();
        walletpage.enterCryptoAddress();
        operationsbutton.enterWithdrawAmount();
        operationsbutton.enterSubmitButton();
        operationsbutton.enterPINAndCheckError("2580");
        operationsbutton.enterSubmitButton();
        operationsbutton.verifyTransactionSuccess(); // embed screenshot here
        operationsbutton.click_cancel_button();
        Reporter.log("<b style='color:green;'>✅ Completed: Withdraw via Crypto Network</b><hr>", true);

        // 🆔 PayCio ID Withdrawal Flow
        Reporter.log("<hr><b style='color:blue;'>🆔 Starting: Withdraw via PayCio ID</b><hr>", true);
        operationsbutton.clickUSDC();
        walletpage.clickPaycioID();
        walletpage.enterPayCioUserID();
        operationsbutton.enterWithdrawAmount();
        operationsbutton.enterSubmitButton();
        operationsbutton.enterPINAndCheckError("2580");
        operationsbutton.enterSubmitButton();
        operationsbutton.verifyTransactionSuccess(); // embed screenshot here
        operationsbutton.click_cancel_button();
        Reporter.log("<b style='color:green;'>✅ Completed: Withdraw via PayCio ID</b><hr>", true);

    }

}