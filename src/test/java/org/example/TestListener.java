package org.example;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener
{
    public ExtentReports extent = ExtentManager.getReports();
    public ExtentTest test;


    public void onTestStart(ITestResult result) {

        test = extent.createTest(result.getMethod().getMethodName());
        System.out.println("STARTED : " + result.getName());
    }

    public void onTestSuccess(ITestResult result) {
        test.pass("Test Passed");
        System.out.println("PASSED : " + result.getName());
    }

    public void onTestFailure(ITestResult result) {
        test.fail(result.getThrowable());
        System.out.println("FAILED : " + result.getName());
    }

    public void onTestSkipped(ITestResult result) {
        test.skip("Test Skipped");
        System.out.println("SKIPPED : " + result.getName());
    }

    public void onFinish(ITestContext context) {
        extent.flush();
        System.out.println("Execution Completed");
    }
}
