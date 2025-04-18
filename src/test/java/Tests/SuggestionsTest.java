package Tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.thread.IThreadWorkerFactory;
import pages.*;
import UtilityMethods.ScreenshotListener; // Ensure this import matches your package structure

@Listeners(ScreenshotListener.class) // Attach the listener to capture screenshots on failure
public class SuggestionsTest extends BaseTest {

    private PayCioLoginPage payciopage;
    private PayCioHomePage payciohomepage;
    private CreateMerchantPage createmerchantpage;
    private SuggestionPage suggestionpage;

    @BeforeMethod
    public void setUpLoginClass() {
        // Initialize PayCioPage
        payciopage = new PayCioLoginPage(driver);
        payciohomepage = new PayCioHomePage(driver);
        createmerchantpage = new CreateMerchantPage(driver);
        suggestionpage = new SuggestionPage(driver);
        ScreenshotListener.driver = driver;
    }

    @Test
    public void SuggestionsTestScenario() throws InterruptedException {
        payciohomepage.clickWelcomeBackButton();
        suggestionpage.scrollAndClickSuggestions();

        // Define test inputs for suggestions (both positive and negative cases)
        String[] suggestions = {
                "Hi", // ❌ Too short - Negative
                "Hey", // ✅ Valid minimum
                "This is a sample valid suggestion for testing.", // ✅ Valid input
                generateString(300), // ✅ Valid max
                generateString(301) // ❌ Too long - Negative
        };

        // Loop through all test cases
        for (String suggestion : suggestions) {
            System.out.println("🔍 Testing suggestion: \"" + suggestion + "\" (length: " + suggestion.length() + ")");

            // Enter the suggestion in the input box
            Thread.sleep(1500);
            boolean isValid = suggestionpage.enterSuggestion(suggestion);

            // Check if the suggestion is valid
            if (isValid) {
                System.out.println("✅ Suggestion accepted. Proceeding with image upload and submit.");

                // Proceed with image upload and submission for valid suggestions
                suggestionpage.clickOnUploadImage();
                suggestionpage.clickOnChooseGallery();
                suggestionpage.selectImage();
                suggestionpage.clickOnSubmit();
            } else {
                // Handle invalid suggestion
                System.out.println("❌ Suggestion rejected due to invalid length. Skipping upload & submit.");
            }

            // Optional: Reset state if needed before the next iteration
            suggestionpage.scrollAndClickSuggestions();
        }
    }

    // Utility method to generate strings of specific lengths (for testing max length)
    private static String generateString(int length) {
        return "a".repeat(length); // Uses Java 11+ String repeat method
    }
}
