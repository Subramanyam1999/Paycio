package UtilityMethods;

import org.testng.*;

public class TestListener implements ITestListener {

    private long startTime;

    @Override
    public void onTestStart(ITestResult result) {
        startTime = System.currentTimeMillis();
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        long duration = System.currentTimeMillis() - startTime;
        Reporter.log("✅ Test Passed: " + result.getName() + " | Execution Time: " + duration + "ms", true);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        long duration = System.currentTimeMillis() - startTime;
        Reporter.log("❌ Test Failed: " + result.getName() + " | Execution Time: " + duration + "ms", true);
    }
}
