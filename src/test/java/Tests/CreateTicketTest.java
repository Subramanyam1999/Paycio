package Tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.Reporter;
import pages.*;
import UtilityMethods.ScreenshotListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;
@Listeners(ScreenshotListener.class)
public class CreateTicketTest extends BaseTest {

    private CreateTicket createticket;
    private OperationsButton operationsbutton;
    private WalletPage walletpage;

    private List<String> allEmails = new ArrayList<>();
    private int validEmailCount = 0;
    private int invalidEmailCount = 0;

    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

    @BeforeMethod
    public void setUpLoginClass() {
        createticket = new CreateTicket(driver);
        walletpage = new WalletPage(driver);
        operationsbutton = new OperationsButton(driver);
        ScreenshotListener.driver = driver;
    }

    @Test(priority = 2)
    public void sendEmailsMultipleTimeswithOTP() throws InterruptedException {
        int totalEmails = 100;

        for (int i = 1; i <= totalEmails; i++) {
            Reporter.log("<br><b>🔄 Execution Iteration: " + i + "</b>", true);

            createticket.clickAssistanceTextView();
            Thread.sleep(100);

            enter_mobile_number();
            createticket.enterYourName();

            // ✅ Generate and enter a valid email
            String email = generateRandomValidEmail();
            allEmails.add(email);

            WebElement emailInput = driver.findElement(By.xpath("//android.widget.EditText[@text='Enter your email']"));
            emailInput.sendKeys(email);

            if (isValidEmails(email) && !isErrorMessageDisplayed()) {
                validEmailCount++;
                Reporter.log("<br>✅ <b><font color='green'>Valid Email:</font></b> " + email, true);
                captureScreenshot("Valid_Email_" + i);
            } else {
                invalidEmailCount++;
                Reporter.log("<br>❌ <b><font color='red'>Invalid Email:</font></b> " + email, true);
            }
            createticket.selectIssueType();
            createticket.selectLoginIssue();
            createticket.clickConfirmButton();
            createticket.enterIssueText();
            createticket.clickUploadImage();
            createticket.clickChooseFromGallery();
            createticket.clickImageView();
            createticket.clcikSubmitinCreateTicket();
            Thread.sleep(2000);
//            operationsbutton.enterPINForOTP();
            operationsbutton.enterPINAndCheckError("33333454");
            // createticket.clickSubmitButtonAfterOTp();
            createticket.crossButtonInOTPVerificationPage();
            walletpage.clickBackNavigationButton();
            Thread.sleep(500);
            walletpage.clickBackNavigationButton();


        }

        generateEmailReport();
    }

    // ✅ Email validation method using regex
    private static boolean isValidEmails(String email) {
        return EMAIL_PATTERN.matcher(email).matches();
    }

    // ✅ Method to check if an error message for invalid email appears
    private boolean isErrorMessageDisplayed() {
        try {
            WebElement errorMessage = driver.findElement(By.xpath("//android.widget.TextView[@text='Enter the valid email']"));
            return errorMessage.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // ✅ Generate valid random email within 40-50 character limit
    public static String generateRandomValidEmail() {
        String[] domains = {"gmail.com", "yahoo.com", "outlook.com", "company.org", "business.net"}; // Valid domain list

        String username, domain, email;
        do {
            username = generateRandomString(getRandomNumber(20, 30));  // Username between 20-30 characters
            domain = domains[getRandomNumber(0, domains.length - 1)];  // Pick a random domain

            email = username + "@" + domain;

        } while (!isValidEmails(email) || email.length() < 40 || email.length() > 50);

        Reporter.log("<br>📧 Generated Valid Email: <b><font color='blue'>" + email + "</font></b> (Length: " + email.length() + ")", true);
        return email;
    }

    private void generateEmailReport() {
        StringBuilder report = new StringBuilder();
        report.append("<br><b>======= 📊 Email Report =======</b>");
        report.append("<br><b>Total Emails Sent:</b> ").append(allEmails.size());
        report.append("<br><b>✅ Valid Emails:</b> ").append(validEmailCount);
        report.append("<br><b>❌ Invalid Emails:</b> ").append(invalidEmailCount);
        report.append("<br><b>📋 List of all emails:</b><br>");

        for (String email : allEmails) {
            report.append(email).append("<br>");
        }

        report.append("<br>============================");

        // 🔹 Force TestNG to print report
        System.out.println(report.toString());
        Reporter.log(report.toString(), true);
    }

    // 📸 Method to capture screenshots
    private void captureScreenshot(String filename) {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destFile = new File("./test-output/screenshots/" + filename + ".png");

        try {
            Files.createDirectories(destFile.getParentFile().toPath());
            Files.copy(srcFile.toPath(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            String relativePath = "screenshots/" + filename + ".png";
            Reporter.log("<br>📸 Screenshot: <a href='" + relativePath + "' target='_blank'>View</a>", true);
        } catch (IOException e) {
            Reporter.log("<br>❌ Screenshot Capture Failed!", true);
        }
    }

    // ✅ Random number generator (min to max)
    public static int getRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }

    // ✅ Random string generator
    public static String generateRandomString(int length) {
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        return generateRandomString(length, characters);
    }

    public static String generateRandomString(int length, String characters) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            sb.append(characters.charAt(index));
        }
        return sb.toString();
    }
}
