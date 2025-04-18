package UtilityMethods;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import pages.BaseTest;

import java.io.File;
import java.io.IOException;

public class MethodNameListener extends BaseTest implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        Reporter.log("Starting test: " + result.getMethod().getMethodName(), true);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        Reporter.log("Test passed: " + result.getMethod().getMethodName(), true);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Reporter.log("Test failed: " + result.getMethod().getMethodName(), true);
        Reporter.log("Reason: " + result.getThrowable(), true);

        // Capture screenshot on failure
        WebDriver driver = getDriver(); // Assumes getDriver() method in BaseTest returns WebDriver instance
        if (driver != null) {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String screenshotPath = "screenshots/" + result.getMethod().getMethodName() + ".png";
            try {
                FileUtils.copyFile(screenshot, new File(screenshotPath));
                Reporter.log("Screenshot saved at: " + screenshotPath, true);
            } catch (IOException e) {
                Reporter.log("Failed to save screenshot: " + e.getMessage(), true);
            }
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        Reporter.log("Test skipped: " + result.getMethod().getMethodName(), true);
    }

    @Override
    public void onStart(ITestContext context) {
        Reporter.log("Starting Test Suite: " + context.getName(), true);
    }

    @Override
    public void onFinish(ITestContext context) {
        Reporter.log("Finishing Test Suite: " + context.getName(), true);
    }
}
