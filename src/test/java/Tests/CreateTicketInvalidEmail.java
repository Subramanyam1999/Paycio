package Tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.*;
import UtilityMethods.ScreenshotListener; // Ensure this import matches your package structure

import java.net.MalformedURLException;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;


@Listeners(ScreenshotListener.class) // Attach the listener to capture screenshots on failure
public class CreateTicketInvalidEmail extends BaseTest {

    private PayCioLoginPage payciopage;
    private PayCioHomePage payciohomepage;
    private CreateMerchantPage createmerchantpage;
    private CreateTicket createticket;

    @BeforeMethod
    public void setUpLoginClass() {
        // Initialize PayCioPage
        payciopage = new PayCioLoginPage(driver);
        payciohomepage = new PayCioHomePage(driver);
        createmerchantpage = new CreateMerchantPage(driver);
        createticket = new CreateTicket(driver);
        ScreenshotListener.driver = driver;

    }

    int stepsPassed = 0;  // To keep track of the steps passed

    @Test(priority = 4)
    public void CreateTicketInvalidEmail() throws InterruptedException {

        // Step 1: Click the 'Allow' button
        try {
            payciopage.clickAllowButton();
            stepsPassed++;
            System.out.println("Step 1: Clicked 'Allow' button - Passed");
        } catch (Exception e) {
            System.out.println("Step 1: Failed to click 'Allow' button");
        }

        // Step 2: Click the 'Skip' button
        try {
            payciopage.clickSkipButton();
            stepsPassed++;
            System.out.println("Step 2: Clicked 'Skip' button - Passed");
        } catch (Exception e) {
            System.out.println("Step 2: Failed to click 'Skip' button");
        }

        // Step 3: Click the 'Assistance' text view
        try {
            createticket.clickAssistanceTextView();
            stepsPassed++;
            System.out.println("Step 3: Clicked 'Assistance' TextView - Passed");
        } catch (Exception e) {
            System.out.println("Step 3: Failed to click 'Assistance' TextView");
        }
        Thread.sleep(3000);
        // Step 4: Enter mobile number
        try {
            createticket.enterMobileNumber();

            stepsPassed++;
            System.out.println("Step 4: Entered mobile number - Passed");
        } catch (Exception e) {
            System.out.println("Step 4: Failed to enter mobile number");
        }

        // Step 5: Enter your name
        try {
            createticket.enterYourName();
            stepsPassed++;
            System.out.println("Step 5: Entered name - Passed");
        } catch (Exception e) {
            System.out.println("Step 5: Failed to enter name");
        }

        // Step 6: Enter email
        try {
          createticket.enter_invalid_email();
            stepsPassed++;
            System.out.println("Step 6: Entered email - Passed");
        } catch (Exception e) {
            System.out.println("Step 6: Failed to enter email");
        }

        // Step 7: Select the issue type
        try {
            createticket.selectIssueType();
            stepsPassed++;
            System.out.println("Step 7: Selected issue type - Passed");
        } catch (Exception e) {
            System.out.println("Step 7: Failed to select issue type");
        }

        // Step 8: Select 'Login Issue'
        try {
            createticket.selectLoginIssue();
            stepsPassed++;
            System.out.println("Step 8: Selected 'Login Issue' - Passed");
        } catch (Exception e) {
            System.out.println("Step 8: Failed to select 'Login Issue'");
        }

        // Step 9: Click the confirm button
        try {
            createticket.clickConfirmButton();
            stepsPassed++;
            System.out.println("Step 9: Clicked 'Confirm' button - Passed");
        } catch (Exception e) {
            System.out.println("Step 9: Failed to click 'Confirm' button");
        }

        // Step 10: Enter issue text
        try {
            createticket.enterIssueText();
            stepsPassed++;
            System.out.println("Step 10: Entered issue text - Passed");
        } catch (Exception e) {
            System.out.println("Step 10: Failed to enter issue text");
        }

        // Print summary of steps passed
        System.out.println("Total steps passed: " + stepsPassed + "/10");

        // If you want to use assertions to mark the test as failed based on steps:
        assertEquals("Not all steps passed", 10, stepsPassed);
        // Step 11: Click 'Upload Image'
        try {
            createticket.clickUploadImage();
            stepsPassed++;
            System.out.println("Step 11: Clicked 'Upload Image' button - Passed");
        } catch (Exception e) {
            System.out.println("Step 11: Failed to click 'Upload Image' button");
        }


        // Step 12: Click 'Choose from Gallery'
        try {
            createticket.clickChooseFromGallery();
            stepsPassed++;
            System.out.println("Step 12: Clicked 'Choose from Gallery' button - Passed");
        } catch (Exception e) {
            System.out.println("Step 12: Failed to click 'Choose from Gallery' button");
        }

// Step 13: Click 'ImageView'
        try {
            createticket.clickImageView();
            stepsPassed++;
            System.out.println("Step 13: Clicked 'ImageView' - Passed");
        } catch (Exception e) {
            System.out.println("Step 13: Failed to click 'ImageView'");
        }
        Thread.sleep(4000);
// Step 14: Click 'Submit Button'
        try {
            createticket.clickSubmitButton();
            stepsPassed++;
            System.out.println("Step 14: Clicked 'Submit' button - Passed");
        } catch (Exception e) {
            System.out.println("Step 14: Failed to click 'Submit' button");
        }



    }
}