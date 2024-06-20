package com.demoqa.pages_raznye_stranicy_get;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlertPage extends BasePage {

    @FindBy(id = "confirmButton")
    public WebElement confirmAlertBtn;

    @FindBy(id = "confirmButton")
    public WebElement dismissAlertBtn;

    @FindBy(id = "alertButton")
    public WebElement seeAlertBtn;

    @FindBy(id = "timerAlertButton")
    public WebElement appearAfter5AlertBtn;

    @FindBy(id = "promtButton")
    public WebElement promtBtn;

}
