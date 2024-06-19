package com.demoqa.listener;

import com.demoqa.drivers.DriverManager;
import org.testng.ITestListener;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;

public class ScreenshotListener implements ITestListener {

    WebDriver driver = DriverManager.getDriver();

    @Override
    public void onTestFailure(ITestResult result) {
        if (driver != null){
            saveScreenshotPNG();
        }
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshotPNG() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Hello OnStart");
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Hello on TestStart");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Hello onTestSuccess");
    }

    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
    }
}