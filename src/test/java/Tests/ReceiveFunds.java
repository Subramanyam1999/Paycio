package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.*;
import UtilityMethods.ScreenshotListener; // Ensure this import matches your package structure

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static pages.BaseTest.driver;


@Listeners(ScreenshotListener.class) // Attach the listener to capture screenshots on failure
public class ReceiveFunds extends BaseTest {

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
    public void Receive_Funds_Scenario() throws InterruptedException {
        // payciohomepage.clickWelcomeBackButton();
        //  Thread.sleep(5000);


        operationsbutton.clickReceiveFunds();
        //  Thread.sleep(2000);
//        operationsbutton.verifyButtonsDisplayedAndLogText();
//        operationsbutton.clickSetAmountButton();
//        operationsbutton.enterSetAmount();
//        operationsbutton.clickOKButton();
        // Example of clicking elements and capturing screenshot after each action
        operationsbutton.clickOnBitcoinText();

      //operationsbutton.printAllCurrencyNames();
      operationsbutton.scrollAndPrintAllCurrencyNames();



        // operationsbutton.clickImageView();
        Thread.sleep(2000);
        operationsbutton.clickEthereum();
        Thread.sleep(2000);

        // Take screenshot after clicking Ethereum and log it
        String screenshotPath = takeScreenshot("Ethereum_Screenshot");
        Reporter.log("📸 Screenshot after clicking Ethereum: " + screenshotPath, true);
        operationsbutton.clickEthereum();
        operationsbutton.clickLiteCoin();
        Thread.sleep(2000);

        // Take screenshot after clicking Litecoin and log it
        screenshotPath = takeScreenshot("LiteCoin_Screenshot");
        Reporter.log("📸 Screenshot after clicking Litecoin: " + screenshotPath, true);

        operationsbutton.clickLiteCoin();
        operationsbutton.clickBitCoinCash();
        Thread.sleep(2000);

        // Take screenshot after clicking BitCoin Cash and log it
        screenshotPath = takeScreenshot("BitCoinCash_Screenshot");
        Reporter.log("📸 Screenshot after clicking BitCoin Cash: " + screenshotPath, true);

        operationsbutton.clickBitCoinCash();
        operationsbutton.clickUSDC();
        Thread.sleep(2000);

        // Take screenshot after clicking USDC and log it

        operationsbutton.clickUSDC();


        operationsbutton.clickBinanceCoin();
        Thread.sleep(2000);
        // Take screenshot after clicking USDC and log it

        operationsbutton.clickBinanceCoin();

        operationsbutton.clickTron();
        Thread.sleep(2000);

        operationsbutton.clickTron();
        operationsbutton.scrollAndClickonTrueUSD();
        Thread.sleep(2000);

        Thread.sleep(2000);
        operationsbutton.clickOnTrueUSDText();
        Thread.sleep(5000);
        operationsbutton.scrollAndClickonDash();
        Thread.sleep(2000);

        operationsbutton.clickOnDashText();
        Thread.sleep(2000);
        operationsbutton.scrollAndClickOnDoge();
        Thread.sleep(2000);
        operationsbutton.clickOnDogeText();
        Thread.sleep(5000);
        operationsbutton.scrollAndClickOnUSDT();
        operationsbutton.clickOnUSDTText();
        operationsbutton.scrollAndClickOnPolygon();
        Thread.sleep(2000);
        operationsbutton.clickOnPolygonText();


        Thread.sleep(2000);
        operationsbutton.scrollAndClickOnSolana();
        Thread.sleep(2000);
        operationsbutton.clickOnSolanaText();
        Thread.sleep(2000);
        operationsbutton.scrollAndClickOnAvalancheCChain();
        Thread.sleep(2000);
        operationsbutton.clickOnAvalancheText();
//
//        Thread.sleep(6000);
        operationsbutton.scrollAndClickOnTetherUSD();
        Thread.sleep(6000);
        operationsbutton.clickOnTetherText();
        Thread.sleep(2000);
        operationsbutton.scrollAndClickOnChainlink();
        Thread.sleep(2000);
        operationsbutton.clickOnChainlinkText();
        Thread.sleep(2000);
        operationsbutton.scrollAndClickOnShibaInu();
        Thread.sleep(3000);
        operationsbutton.forceClickUsingActions();
        Thread.sleep(2000);
        operationsbutton.scrollAndClickOnRippleXRP();
        Thread.sleep(3000);
        operationsbutton.clickOnRippleText();
        Thread.sleep(3000);
        operationsbutton.scrollAndClickOnPolkadot();
        Thread.sleep(3000);
        operationsbutton.clickOnPolkadotText();
//        Thread.sleep(2000);
        operationsbutton.scrollAndClickOnDAI();
        Thread.sleep(3000);
        operationsbutton.clickOnDAIText();
        Thread.sleep(2000);
        operationsbutton.scrollAndClickOnArbitrum();
        Thread.sleep(3000);
        operationsbutton.clickOnArbitrumText();
        Thread.sleep(2000);
        operationsbutton.scrollAndClickOnMantle();
        Thread.sleep(4000);

//        operationsbutton.clickOnMantleText();
//        Thread.sleep(2000);
//        operationsbutton.scrollAndClickOnRenderToken();
//        Thread.sleep(3000);
//        operationsbutton.clickOnRenderTokenText();
//        Thread.sleep(3000);
//        operationsbutton.scrollAndClickOnBeam();
//        Thread.sleep(2000);
//        operationsbutton.clickOnBeamText();
//        Thread.sleep(2000);
//        operationsbutton.scrollAndClickOnSand();
//        Thread.sleep(2000);
//        operationsbutton.clickOnSandText();
//        Thread.sleep(2000);
////        operationsbutton.scrollAndClickOnInjectiveProtocol();
////        Thread.sleep(4000);
////        operationsbutton.clickOnInjectiveTokenText();
//        Thread.sleep(5000);
//        operationsbutton.scrollAndClickOnFirstDigitalUSD();
//        Thread.sleep(3000);
//        operationsbutton.clickOnFirstDigitalUSD();
//        Thread.sleep(2000);
////        operationsbutton.scrollAndClickOnPancakeSwapToken();
////        Thread.sleep(2000);
////        operationsbutton.clickOnPancakeSwapText();
////        Thread.sleep(3000);
//        operationsbutton.scrollAndClickOnGreenMetaverseToken();
//        Thread.sleep(2000);
//        operationsbutton.clickOnGreenMetaverseText();
//        Thread.sleep(3000);
//        operationsbutton.scrollAndClickOnSleeplessAIToken();
//        Thread.sleep(2000);
//        operationsbutton.clickOnSleeplessTokenText();
//        Thread.sleep(3000);
//        operationsbutton.scrollAndClickOnNFPromptToken();
//        Thread.sleep(3000);
//        operationsbutton.clickOnNFPromptTokenText();
//        Thread.sleep(3000);
//        operationsbutton.scrollAndClickOnBurgerCities();
//        Thread.sleep(3000);
//        operationsbutton.clickOnBurgerCitiesText();
//        Thread.sleep(3000);
//        operationsbutton.scrollAndClickOnTrustWallet();
//        Thread.sleep(3000);
//        operationsbutton.clickOnTrustWalletText();
//        Thread.sleep(3000);
//        operationsbutton.scrollAndClickOnUSDTPolygonChain();
//        Thread.sleep(3000);
//        operationsbutton.clickOnUSDTPolygonText();
//        Thread.sleep(3000);
//        operationsbutton.scrollAndClickOnAave();
//        Thread.sleep(3000);
//        operationsbutton.clickOnAaveText();
//        operationsbutton.scrollAndClickOnWootrade();
//        operationsbutton.clickOnWootradeText();
//        operationsbutton.scrollAndClickOnSushiToken();
//        operationsbutton.clickOnSushiTokenText();
//        operationsbutton.scrollAndClickOnUniswap();
//        operationsbutton.clickOnUniswapText();
//        operationsbutton.scrollAndClickOnUsdCoin();
//        operationsbutton.clickOnUsdCoinText();
//        operationsbutton.scrollAndClickOnCartesiToken();
//        operationsbutton.clickOnCartesiToken();
//        operationsbutton.scrollAndClickOnMakerToken();
//        operationsbutton.clickOnMakerToken();
//        operationsbutton.scrollAndClickOnMemesAfterDark();
//        operationsbutton.clickOnMemesAfterDark();
//        operationsbutton.scrollAndClickNearProtocol();
//        operationsbutton.clickNearToken();
//        operationsbutton.scrollAndClickOnXDC();
//        operationsbutton.clickOnXDC();
//        operationsbutton.scrollAndClickOnTXDC();
//        operationsbutton.clickOnTXDC();
//        operationsbutton.scrollAndClickOnDiamante();
//        operationsbutton.clickOnDiamante();
//        operationsbutton.scrollAndClickOnLumia();
//        operationsbutton.clickLumiaToken();
//        operationsbutton.scrollAndClickOnWYZth();
//        operationsbutton.clickOnWYZth();
//        operationsbutton.scrollAndClickOnBinanceTestnet();
//        operationsbutton.clickOnBinanceTestnet();
//        operationsbutton.scrollAndClickOnEthereum();
//        operationsbutton.clickOnEthereumLastCurrency();

    }

    public void runFromMantle() throws InterruptedException {
        // operationsbutton.clickOnDogeText();
        Thread.sleep(2000);
//        operationsbutton.scrollAndClickOnUSDT();
        operationsbutton.clickOnUSDTText();
        operationsbutton.scrollAndClickOnPolygon();
        Thread.sleep(2000);
        operationsbutton.clickOnPolygonText();

        Thread.sleep(2000);
        operationsbutton.scrollAndClickOnSolana();
        Thread.sleep(2000);
        operationsbutton.clickOnSolanaText();
        Thread.sleep(2000);
        operationsbutton.scrollAndClickOnAvalancheCChain();
        Thread.sleep(2000);
        operationsbutton.clickOnAvalancheText();
//
//        Thread.sleep(6000);
        operationsbutton.scrollAndClickOnTetherUSD();
        Thread.sleep(6000);
        operationsbutton.clickOnTetherText();
        Thread.sleep(2000);
        operationsbutton.scrollAndClickOnChainlink();
        Thread.sleep(2000);
        operationsbutton.clickOnChainlinkText();
        Thread.sleep(2000);
        operationsbutton.scrollAndClickOnShibaInu();
        Thread.sleep(3000);
        operationsbutton.forceClickUsingActions();
        Thread.sleep(2000);
        operationsbutton.scrollAndClickOnRippleXRP();
        Thread.sleep(3000);
        operationsbutton.clickOnRippleText();
        Thread.sleep(3000);
        operationsbutton.scrollAndClickOnPolkadot();
        Thread.sleep(3000);
        operationsbutton.clickOnPolkadotText();
//        Thread.sleep(2000);
        operationsbutton.scrollAndClickOnDAI();
        Thread.sleep(3000);
        operationsbutton.clickOnDAIText();
        Thread.sleep(2000);
        operationsbutton.scrollAndClickOnArbitrum();
        Thread.sleep(3000);
        operationsbutton.clickOnArbitrumText();
        Thread.sleep(2000);
        operationsbutton.scrollAndClickOnMantle();
        Thread.sleep(4000);

        operationsbutton.clickOnMantleText();
        Thread.sleep(2000);

        operationsbutton.scrollAndClickOnRenderToken();
        Thread.sleep(3000);
        operationsbutton.clickOnRenderTokenText();
        Thread.sleep(3000);

        operationsbutton.scrollAndClickOnBeam();
        Thread.sleep(2000);
        operationsbutton.clickOnBeamText();
        Thread.sleep(2000);

        operationsbutton.scrollAndClickOnSand();
        Thread.sleep(2000);
        operationsbutton.clickOnSandText();

        Thread.sleep(2000);

        operationsbutton.scrollAndClickOnInjectiveProtocol();
        Thread.sleep(4000);
        operationsbutton.clickOnInjectiveTokenText();
        operationsbutton.scrollAndClickOnFirstDigitalUSD();
        Thread.sleep(3000);
        operationsbutton.clickOnFirstDigitalUSD();
        // Thread.sleep(2000);
        operationsbutton.scrollAndClickOnPancakeSwapToken();
        Thread.sleep(2000);
        operationsbutton.clickOnPancakeSwapText();
        Thread.sleep(3000);


        operationsbutton.scrollAndClickOnGreenMetaverseToken();
        Thread.sleep(2000);
        operationsbutton.clickOnGreenMetaverseText();
        Thread.sleep(3000);

        operationsbutton.scrollAndClickOnSleeplessAIToken();
//        Thread.sleep(2000);
        operationsbutton.clickOnSleeplessTokenText();
        Thread.sleep(1000);

        operationsbutton.scrollAndClickOnNFPromptToken();
        Thread.sleep(2000);
        operationsbutton.clickOnNFPromptTokenText();
        Thread.sleep(2000);

        operationsbutton.scrollAndClickOnBurgerCities();
        Thread.sleep(2000);
        operationsbutton.clickOnBurgerCitiesText();
        Thread.sleep(2000);

        operationsbutton.scrollAndClickOnTrustWallet();
        Thread.sleep(2000);
        operationsbutton.clickOnTrustWalletText();
        Thread.sleep(2000);

        operationsbutton.scrollAndClickOnUSDTPolygonChain();
        Thread.sleep(2000);
        operationsbutton.clickOnUSDTPolygonText();
        Thread.sleep(2000);

        operationsbutton.scrollAndClickOnAave();
        Thread.sleep(2000);
        operationsbutton.clickOnAaveText();

        operationsbutton.scrollAndClickOnWootrade();
        operationsbutton.clickOnWootradeText();

        operationsbutton.scrollAndClickOnSushiToken();
        operationsbutton.clickOnSushiTokenText();

        operationsbutton.scrollAndClickOnUniswap();
        operationsbutton.clickOnUniswapText();

        operationsbutton.scrollAndClickOnUsdCoin();
        operationsbutton.clickOnUsdCoinText();

        operationsbutton.scrollAndClickOnCartesiToken();
        operationsbutton.clickOnCartesiToken();

        operationsbutton.scrollAndClickOnMakerToken();
        operationsbutton.clickOnMakerToken();
//
//        operationsbutton.scrollAndClickOnMemesAfterDark();
//        operationsbutton.clickOnMemesAfterDark();
//
//        operationsbutton.scrollAndClickNearProtocol();
//        operationsbutton.clickNearToken();
//
//        operationsbutton.scrollAndClickOnXDC();
//        operationsbutton.clickOnXDC();
//
//        operationsbutton.scrollAndClickOnTXDC();
//        operationsbutton.clickOnTXDC();
//
//        operationsbutton.scrollAndClickOnDiamante();
//        operationsbutton.clickOnDiamante();
//
//        operationsbutton.scrollAndClickOnLumia();
//        operationsbutton.clickLumiaToken();
//
//        operationsbutton.scrollAndClickOnWYZth();
//        operationsbutton.clickOnWYZth();
//
//        operationsbutton.scrollAndClickOnBinanceTestnet();
//        operationsbutton.clickOnBinanceTestnet();

        operationsbutton.scrollAndClickOnEthereum();
        operationsbutton.clickOnEthereumLastCurrency();
    }


    // Method to take screenshot and save it with a timestamp
    public String takeScreenshot(String fileName) {
        // Format the timestamp for unique filenames
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

        // Capture screenshot of the entire page or element
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        // Define destination file path
        File destFile = new File("screenshots/" + fileName + "_" + timestamp + ".png");

        try {
            FileHandler.copy(srcFile, destFile);
            return destFile.getAbsolutePath();  // Return the path of the saved screenshot
        } catch (IOException e) {
            e.printStackTrace();
            return "Failed to capture screenshot";
        }
    }
}
