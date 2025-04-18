package Tests;

import UtilityMethods.ExcelUtils;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.*;
import UtilityMethods.ScreenshotListener;

@Listeners(ScreenshotListener.class)
public class PayToMobileNumber extends BaseTest {

    private PayCioLoginPage payciopage;
    private PayCioHomePage payciohomepage;
    private OperationsButton operationsbutton;
    private CreateMerchantPage createmerchantpage;

    @DataProvider(name = "mobileNumberTestData")
    public Object[][] provideMobileNumberData() {
        return new Object[][]{
                // Equivalence Partitioning
                {"9830567890", "Valid - Registered"},
                {"7734567890", "Valid - Not Registered"},

                // Boundary Value Analysis
                {"9999999999", "Max boundary"},
                {"8000000000", "Min boundary"},
                {"7999999999", "Below Min - Invalid"},
                {"10000000000", "Above Max - Invalid"},

                // Error Guessing
                {"98@#123456", "Invalid - Special characters"},
                {"abcdefghij", "Invalid - Alphabets only"},
                {"", "Empty input"},

                // Decision Table
                {"9123456789", "Expected to proceed"},
                {"8899999999", "Expected to show error"},
        };
    }

    @BeforeMethod
    public void setUpLoginClass() {
        payciopage = new PayCioLoginPage(driver);
        operationsbutton = new OperationsButton(driver);
        payciohomepage = new PayCioHomePage(driver);
        createmerchantpage = new CreateMerchantPage(driver);

        ScreenshotListener.driver = driver;
    }

    @Test(dataProvider = "mobileNumberTestData")
    public void testPayToMobileWithVariousInputs(String mobileNumber, String testTypeDescription) throws InterruptedException {
        Reporter.log("<hr><b>🚀 Starting Test Scenario</b>", true);
        Reporter.log("🔍 <b>Test Type:</b> " + testTypeDescription + " | <b>Input:</b> " + mobileNumber, true);

        // Navigate to Pay to Mobile screen
        operationsbutton.clickPayToMobileNumber();
        Thread.sleep(1000);

        // Enter mobile number and capture the entered value from UI
        String actualEnteredText = operationsbutton.clickEditTextField(mobileNumber);
        Reporter.log("✅ Confirmed input shown on UI: <b>" + actualEnteredText + "</b>", true);

        Thread.sleep(1000);
        operationsbutton.clickSendIfElementVisible();

        // Continue with flow
        operationsbutton.isElementDisplayedForAttention();
        operationsbutton.ClickiUnderstandButton();
        operationsbutton.enterAmount();
        operationsbutton.clickBitcoinElement();
        operationsbutton.clickUSDCElement();
        operationsbutton.clickConfirmButton();
        Thread.sleep(2000);
        operationsbutton.clickOnPayButton();
        operationsbutton.enterPINAndCheckError("2580");
        operationsbutton.clickSubmitinUCPIPage();
        operationsbutton.verifyReceiverInfoErrorMessage();
        operationsbutton.clickOkayButtonIfPresent();
        operationsbutton.pressAndroidBackButton();
        operationsbutton.pressAndroidBackButton();

        Reporter.log("✅ Test completed for input: <b>" + mobileNumber + "</b> (" + testTypeDescription + ")", true);
        Reporter.log("<hr>", true); // separator for report
        System.out.println("=====================================================");

        try {
            ExcelUtils.writeResult(mobileNumber, testTypeDescription, "PASS");
        } catch (Exception e) {
            ExcelUtils.writeResult(mobileNumber, testTypeDescription, "FAIL");
        }

    }

}
