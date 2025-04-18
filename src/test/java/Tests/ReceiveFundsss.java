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
public class ReceiveFundsss extends BaseTest {

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
        Thread.sleep(1200);
        operationsbutton.clickOnBitcoinText();
        // operationsbutton.printAllCurrencyNamesPageByPage();
        // operationsbutton.printAllCurrencyNamesPageByPage();
        //  Thread.sleep(3000);
        operationsbutton.scrollAndPrintAllCurrencyNames();

    }
}