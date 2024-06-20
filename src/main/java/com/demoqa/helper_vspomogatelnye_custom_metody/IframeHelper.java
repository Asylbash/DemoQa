package com.demoqa.helper_vspomogatelnye_custom_metody;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class IframeHelper {

    private WebDriver driver;
    private WebDriverWait wait;

    public IframeHelper(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public IframeHelper switchToFrame(WebElement element) {
        try {
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
        } catch (
                TimeoutException e) {
            e.printStackTrace();
        }
        return this;
    }

    public void switchToParentFrame() {
        driver.switchTo().parentFrame();
    }

    public void switchToFrame(String nameOfID) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(nameOfID));
    }


}
