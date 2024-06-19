package com.demoqa.pages_raznye_stranicy_get;

import com.demoqa.drivers.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

import java.time.Duration;

public class ProgressBarPage extends BasePage{
    @FindBy(id = "startStopButton")
    public WebElement startStopButton;

@FindBy(id = "progressBar")
    public WebElement progressBar;

@FindBy(xpath = "//div[@aria-valuenow]")
    public WebElement aria_valuenow;



    public void startProgressBar() {

        webElementActions.click(startStopButton);
    }

    public int getProgressBarValue() {
        String value = aria_valuenow.getAttribute("aria-valuenow");
        return Integer.parseInt(value);
    }
}





