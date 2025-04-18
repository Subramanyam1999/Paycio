package UtilityMethods;

import org.testng.*;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotListener implements ITestListener {
    public static WebDriver driver;

    private void captureScreenshot(String status, ITestResult result) {
        if (driver == null) return;

        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String fileName = "test-output/screenshots/" + result.getName() + "_" + status + "_" + timeStamp + ".png";

        try {
            File dest = new File(fileName);
            dest.getParentFile().mkdirs();
            Files.copy(src.toPath(), dest.toPath());
            Reporter.log("📷 Screenshot [" + status + "]: <a href='" + fileName + "'>View</a>", true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        captureScreenshot("FAIL", result);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        captureScreenshot("PASS", result);
    }
}
