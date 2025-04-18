package pages;

import Tests.PayCioLoginTest;
import Tests.PayContactWithAddress;
import UtilityMethods.ExcelUtils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.android.options.UiAutomator2Options;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;  // Correct import
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.LocalFileDetector;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Set;
import java.util.regex.Matcher;

import org.openqa.selenium.*;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;

import java.util.regex.Pattern;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.google.common.collect.ImmutableMap;
import org.testng.annotations.BeforeMethod;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.AndroidDriver;


import java.util.Arrays;
import java.util.List;

public class BaseTest {
    public static AndroidDriver driver;
    private AppiumDriverLocalService service;
    public static ExtentReports extent;
    public PayCioLoginPage payciopage;
    public PayCioHomePage payciohomepage;
    public CreateMerchantPage createmerchantpage;
    public CreateTicket createticket;
    public WalletPage walletpage;
    public OperationsButton operationsbutton;
    public PayCioLoginPage payciologinpage;
    public LiquidityPage liquiditypage;
    public SuggestionPage suggestionpage;
    public ReferralPage referralPage;
    public AuthenticationPinPage authenticationpinpage;

    private PayCioLoginTest payCioLoginTest;
    public PayContactWithAddress paycontactwithaddress;

    public static ExtentTest createTest(String testName, String description) {
        return extent.createTest(testName, description);
    }

    // Finalize the report
    protected static void finalizeReport() {
        if (extent != null) {
            extent.flush();
        }
    }

    @BeforeClass
    public void ConfigureAppium() throws MalformedURLException {
        // Start Appium Server
        service = new AppiumServiceBuilder()
                .withAppiumJS(new File("C://Users//svs92//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"))
                .withIPAddress("127.0.0.1").usingPort(4723).build();
        service.start();

        // Set up Appium capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        //   options.setDeviceName("Vivo I2208 API 34"); // Device name for testing
        options.setDeviceName("POCO M7 Pro 5G");
        options.setApp("C:/Users/svs92/Downloads/Paycio-release.apk"); // Path to your APK
        options.setCapability("noReset", true); // Keeps the session active
        options.setCapability("fullReset", false); // Prevents a full app reinstall
        options.setCapability("ignoreHiddenApiPolicyError", true);

//        // Initialize the Android Driver with the options
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);

        // Set File Detector to handle file uploads
        driver.setFileDetector(new LocalFileDetector());

        // Initialize Extent Reports
        extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("extent-report.html");
        extent.attachReporter(spark);
    }

    // Abstract method to be implemented by subclasses
    protected DesiredCapabilities getCapabilities() {
        return null;
    }

    private void clickElement(By locator, String description) {
        try {
            WebElement element = waitForElementVisibility(locator, Duration.ofSeconds(20));
            element.click();
        } catch (Exception e) {
        }
    }

    public void gmailAutomation(AndroidDriver driver) {
        UiAutomator2Options options = new UiAutomator2Options();
        // real device
        options.setPlatformName("Android");
        options.setPlatformVersion("14");
        options.setDeviceName("Vivo I2208 API 34");
        options.setAppPackage("com.google.android.gm");
        options.setAppActivity("com.google.android.gm.ConversationListActivityGmail");
        options.noReset().withBrowserName("Chrome");
        options.setAutomationName("UiAutomator2");
        options.withBrowserName("Chrome");

    }

    public void switchToWebViewContext(AndroidDriver Driver) {
        // Method to switch to WebView context
        Set<String> contextHandles = driver.getContextHandles();
        for (String context : contextHandles) {
            if (context.startsWith("WEBVIEW")) {
                driver.context(context);
                break;
            }
        }
    }

    public void SecurityPin() {
        driver.findElement(By.xpath("(//android.view.ViewGroup[@resource-id='otp-input'])[1]")).click();
        ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.DIGIT_1));

        driver.findElement(By.xpath("(//android.view.ViewGroup[@resource-id='otp-input'])[2]")).click();
        ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.DIGIT_2));

        driver.findElement(By.xpath("(//android.view.ViewGroup[@resource-id='otp-input'])[3]")).click();
        ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.DIGIT_3));

        driver.findElement(By.xpath("(//android.view.ViewGroup[@resource-id='otp-input'])[4]")).click();
        ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.DIGIT_4));

    }
    public void EnterSecurityPin(String pin) {
        for (int i = 0; i < 4; i++) {
            char digit = pin.charAt(i);
            driver.findElement(By.xpath("(//android.view.ViewGroup[@resource-id='otp-input'])[" + (i + 1) + "]")).click();
            ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.valueOf("DIGIT_" + digit)));
        }
    }

    // Utility methods

    public void longPressAction(WebElement ele) {
        ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
                ImmutableMap.of("elementId", ((RemoteWebElement) ele).getId(),
                        "duration", 2000));
    }


    public void ActionMethod(WebElement element) {

        Actions a = new Actions(driver);
        a.moveToElement(element);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void SaveAndNextButton() {

        driver.findElement(By.xpath("//android.widget.TextView[@text=\"Save and Next\"]")).click();
    }

    public void ScrollToEnd() {

        // Scroll to End
        driver.findElement(new AppiumBy.ByAndroidUIAutomator(
                "new UiScrollable(new UiSelector().className(\"android.widget.ScrollView\").scrollable(true))"
                        + ".scrollToEnd(1)"
        ));
    }


    public void scrollToEndAction() {
        boolean canScrollMore;
        do {
            canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                    "left", 100, "top", 100, "width", 200, "height", 200,
                    "direction", "down",
                    "percent", 3.0

            ));
        } while (canScrollMore);
    }

    public void swipeAction(WebElement ele, String direction) {
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) ele).getId(),

                "direction", direction,
                "percent", 0.75
        ));


    }


    public Double getFormattedAmount(String amount) {
        Double price = (Double) Double.parseDouble(amount.substring(1));
        return price;

    }

    public void closeNativeKeyboard() {
        try {
            driver.hideKeyboard();
        } catch (Exception e) {
            // Handle exception if hideKeyboard() fails (not all drivers may support this method)
            System.out.println("Keyboard close operation failed: " + e.getMessage());
        }
    }


    public void enter_invalid_name() {
        List<String> invalidNames = Arrays.asList(
                "12345",         // Numbers instead of letters
                "@#$%^&*",       // Special characters
                "A",            // Too short
                "VeryVeryLongNameExceedingLimit", // Too long
                " "             // Blank space
        );

        for (String invalidName : invalidNames) {
            try {
                // Step 1: Locate and clear the name field
                WebElement nameInput = driver.findElement(By.xpath("//android.widget.EditText[@text='Enter your name']"));
                nameInput.clear();

                // Step 2: Enter an invalid name
                String nameToEnter = " ";  // Example invalid name
                nameInput.sendKeys(nameToEnter);

                // Step 3: Fetch the entered text
                String enteredName = nameInput.getText();

                // Step 4: Log the entered name with highlighting in TestNG report
                Reporter.log("<b><font color='blue'>Entered Name:</font> <font color='red'>" + enteredName + "</font></b>", true);

                // Step 5: Wait for the error message (if any)
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
                WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@resource-id='com.paycio:id/snackbar_text']")));

                // Step 6: Log the error message if it is displayed
                Reporter.log("<b><font color='red'>Error Message Displayed:</font> " + errorMessage.getText() + "</b>", true);

            } catch (Exception e) {
                // Handle any exceptions that may occur
            }
        }
    }


    public String enter_email_address() {
        try {
            // Step 1: Generate a random email
            String randomEmail = generateRandomEmail();

            // Step 2: Locate and enter the email
            WebElement emailInput = driver.findElement(By.xpath("//android.widget.EditText[@text='Enter your email']"));
            emailInput.sendKeys(randomEmail);

            // Step 3: Retrieve and log the entered email with highlights
            String enteredEmail = emailInput.getAttribute("text");  // Use "text" or "value" depending on the app
            System.out.println("✅ Entered Email: " + enteredEmail);
            Reporter.log("✅ <b><font color='blue'>Entered Email:</font> <font color='green'>" + enteredEmail + "</font></b>", true);

        } catch (Exception e) {
            try {
                // If entering random email fails, use a predefined email
                WebElement emailId = driver.findElement(By.xpath("//android.widget.EditText[@text='Enter your email']"));
                emailId.sendKeys("venky.123@gmail.com");

                // Retrieve and log the entered email with highlights
                String enteredEmail = emailId.getAttribute("text");
                Reporter.log("<b><font color='blue'>Entered Predefined Email:</font> <font color='orange'>" + enteredEmail + "</font></b>", true);
            } catch (Exception ex) {
                Reporter.log("<b><font color='red'>❌ Error:</font> Failed to enter email.</b>", true);
            }
        }
        return "";
    }

    // Method to generate a random email address
    public static String generateRandomEmail() {
        String domain = generateRandomString(getrandomNumber(2, 10)) + "." + generateRandomString(getrandomNumber(2, 8)); // Replace with your desired domain
        String username = generateRandomString(getrandomNumber(2, 40), "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890,.-@"); // Generate a random username
        return username + "@" + domain;
    }

    public static int getrandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }

    public static String generateRandomString(int length) {
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        return generateRandomString(length, characters);
    }

    // Method to generate a random string of specified length
    public static String generateRandomString(int length, String characters) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            sb.append(characters.charAt(index));
        }
        return sb.toString();
    }


    public void enter_mobile_number_nine_digits() throws InterruptedException {

        // Generate a random mobile number
        String mobileNumber = generateRandomMobileNumber();

        // Print and log the generated number
        System.out.println("✅ Generated Mobile Number: " + mobileNumber);
        Reporter.log("✅ Generated Mobile Number: " + mobileNumber, true);

        // Locate the mobile number input field and enter the generated mobile number
        By mobileNumberField = By.xpath("//android.widget.EditText[@text='Mobile Number']"); // Update with actual locator
        WebElement mobileField = driver.findElement(mobileNumberField);
        mobileField.sendKeys(mobileNumber);

        System.out.println("✅ Entered Mobile Number: " + mobileNumber);
        Reporter.log("✅ Entered Mobile Number: " + mobileNumber, true);
    }

    // **Method to generate a random 10-digit mobile number starting with 8 or 9**
    public static String generateRandomMobileNumber() {
        Random random = new Random();

        // Generate the first digit (8 or 9)
        int firstDigit = 8 + random.nextInt(2); // Generates 8 or 9

        // Generate the remaining 9 digits
        StringBuilder sb = new StringBuilder();
        sb.append(firstDigit);

        for (int i = 1; i < 10; i++) { // 9 more digits to complete 10
            sb.append(random.nextInt(10)); // Generate random digits
        }

        return sb.toString();
    }

    public void enter_mobile_number_eleven_digits() throws InterruptedException {

        // Generate a random mobile number
        String mobileNumber = generateRandomMobileNum();

        // Print and log the generated number
        System.out.println("✅ Generated Mobile Number: " + mobileNumber);
        Reporter.log("✅ Generated Mobile Number: " + mobileNumber, true);

        // Locate the mobile number input field and enter the generated mobile number
        By mobileNumberField = By.xpath("//android.widget.EditText[@text='Mobile Number']"); // Update with actual locator
        WebElement mobileField = driver.findElement(mobileNumberField);
        mobileField.sendKeys(mobileNumber);

        System.out.println("✅ Entered Mobile Number: " + mobileNumber);
        Reporter.log("✅ Entered Mobile Number: " + mobileNumber, true);
    }

    // **Method to generate a random 10-digit mobile number starting with 8 or 9**
    public static String generateRandomMobileNum() {
        Random random = new Random();

        // Generate the first digit (8 or 9)
        int firstDigit = 8 + random.nextInt(2); // Generates 8 or 9

        // Generate the remaining 9 digits
        StringBuilder sb = new StringBuilder();
        sb.append(firstDigit);

        for (int i = 1; i < 11; i++) { // 9 more digits to complete 10
            sb.append(random.nextInt(10)); // Generate random digits
        }

        return sb.toString();
    }

    public void enter_mobile_number() throws InterruptedException {
        // Generate a random mobile number
        String mobileNumber = generateRandomMobNum();

        // Print and log the generated number
        System.out.println("✅ Generated Mobile Number: " + mobileNumber);
        Reporter.log("✅ Generated Mobile Number: " + mobileNumber, true);

        // Define the mobile number field locator
        By mobileNumberField = By.xpath("//android.widget.EditText[@text='Mobile Number']"); // Update with actual locator

        // Create an explicit wait condition
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement mobileField = wait.until(ExpectedConditions.visibilityOfElementLocated(mobileNumberField));

        // Enter the generated mobile number
        mobileField.sendKeys(mobileNumber);

        System.out.println("✅ Entered Mobile Number: " + mobileNumber);
        Reporter.log("✅ Entered Mobile Number: " + mobileNumber, true);
    }

    // **Method to generate a random 10-digit mobile number starting with 8 or 9**
    public static String generateRandomMobNum() {
        Random random = new Random();

        // Generate the first digit (8 or 9)
        int firstDigit = 8 + random.nextInt(2); // Generates 8 or 9

        // Generate the remaining 9 digits
        StringBuilder sb = new StringBuilder();
        sb.append(firstDigit);

        for (int i = 1; i < 10; i++) { // 9 more digits to complete 10
            sb.append(random.nextInt(10)); // Generate random digits
        }

        return sb.toString();
    }


    public void selectDate() {
        // Create a WebDriverWait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(70));
        // 70 seconds timeout

        // Click to view the calendar
        WebElement examDate = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ImageView")
        ));
        examDate.click();

        // Get the current date
        LocalDate currentDate = LocalDate.now();

        // Calculate the date four days from today
        LocalDate targetDate = currentDate.plusDays(4);

        // Format the date to the expected format (e.g., "d" for day without leading zero)
        DateTimeFormatter dayFormatter = DateTimeFormatter.ofPattern("d");
        String formattedDay = targetDate.format(dayFormatter);

        // Locate the date element in the calendar and click it
        try {
            // Wait for the specific day to be visible in the calendar
            WebElement pickExamDate = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//android.widget.TextView[@text=\"" + formattedDay + "\"]")
            ));
            // Wait until it's clickable and then click
            wait.until(ExpectedConditions.elementToBeClickable(pickExamDate)).click();
        } catch (Exception e) {
            System.out.println("Date " + formattedDay + " is not available.");
        }
    }

    // Method to generate a random PAN number
    public String generateRandomPANNumber() {
        Random random = new Random();

        // PAN number format: 5 alphabets + 4 digits + 1 alphabet
        StringBuilder panNumber = new StringBuilder();

        // Generating first 5 alphabets (Uppercase)
        for (int i = 0; i < 5; i++) {
            panNumber.append((char) ('A' + random.nextInt(26)));  // Append random uppercase letter
        }

        // Generating next 4 digits
        for (int i = 0; i < 4; i++) {
            panNumber.append(random.nextInt(10));  // Append random digit
        }

        // Generating last alphabet
        panNumber.append((char) ('A' + random.nextInt(26)));  // Append random uppercase letter

        return panNumber.toString();
    }


    // Method to generate a random PAN number
    public static String generateRandomPan() {
        Random random = new Random();
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sb = new StringBuilder();

        // First 5 characters
        for (int i = 0; i < 5; i++) {
            sb.append(chars.charAt(random.nextInt(chars.length())));
        }

        // Next 4 digits
        sb.append(random.nextInt(10)).append(random.nextInt(10)).append(random.nextInt(10)).append(random.nextInt(10));

        // Last character
        sb.append(chars.charAt(random.nextInt(chars.length())));

        return sb.toString();
    }


    @AfterClass
    public void tearDown() throws InterruptedException, IOException {

        ExcelUtils.saveExcel();
        //	driver.quit();

//        payciohomepage.clickWelcomeBackButton();
//        Thread.sleep(1500);
//// Scroll to End
//        driver.findElement(new AppiumBy.ByAndroidUIAutomator(
//                "new UiScrollable(new UiSelector().className(\"android.widget.ScrollView\").scrollable(true))"
//                        + ".scrollToEnd(1)"
//        ));
//        payciologinpage.clickLogout();
//        payciologinpage.confirmLogout();


        //	service.stop();

        // Flush Extent Reports
        extent.flush();


    }

    public WebElement waitForElementVisibility(By locator, Duration timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }


    public boolean getWait(int duration) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        return false;
    }


    // Method to extract OTP from message
    protected static String extractOTPFromMessage() {
        try {
            // Wait for the message body element to be visible
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement messageBody = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                    "//android.widget.TextView[contains(@text, \"Here's your OTP for your mobile verification\")]"
            )));

            String messageText = messageBody.getText();
            System.out.println("Extracted Message Text: " + messageText);

            // Regex pattern to extract the OTP (adjust pattern as needed)
            Pattern otpPattern = Pattern.compile("\\b\\d{6}\\b"); // Matches a 6-digit number
            Matcher matcher = otpPattern.matcher(messageText);
            if (matcher.find()) {
                String otp = matcher.group();
                System.out.println("Extracted OTP: " + otp); // Debugging statement
                return otp;
            } else {
                System.out.println("OTP pattern not matched.");
            }
        } catch (WebDriverException e) {
            e.printStackTrace(); // Print stack trace for debugging
            System.out.println("Error extracting OTP: " + e.getMessage());
        }
        return null;
    }

    // Method to enter OTP into fields
    protected static void enterOTPIntoFields(String otp) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Ensure OTP is not null and is a valid length
        if (otp == null || otp.length() != 6) {
            System.out.println("Invalid OTP: " + otp);
            return;
        }

        // Split OTP into individual characters and input each one into corresponding field
        for (int i = 0; i < otp.length(); i++) {
            WebElement targetField = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(" + i + ")")
            ));
            System.out.println("Entering " + otp.charAt(i) + " into field index " + i); // Debugging statement
            targetField.sendKeys(String.valueOf(otp.charAt(i)));
        }
        Thread.sleep(2000); // Allow time for each digit to be entered
    }

    static void scrollToEnd(AndroidDriver driver) {
        boolean moreElements = true;
        while (moreElements) {
            // Perform a scroll action using UIAutomator
            scrollDownUsingUIAutomator(driver);


        }
    }

    private static void scrollDownUsingUIAutomator(AndroidDriver driver) {
        // Use UIAutomator to scroll down
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollForward()"
        ));
    }


    // Method to generate a random name
    public String generateRandomName() {
        String[] names = {"Alice", "Bob", "Charlie", "Diana", "Eve", "Frank", "Grace"};
        Random random = new Random();
        return names[random.nextInt(names.length)];
    }


}












