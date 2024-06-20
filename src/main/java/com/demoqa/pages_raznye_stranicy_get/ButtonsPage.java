package com.demoqa.pages_raznye_stranicy_get;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ButtonsPage extends BasePage {

    @FindBy(id = "doubleClickBtn")
    public WebElement doubleClickBtn;

    @FindBy(id = "doubleClickMessage")
    public WebElement doubleClickMessage;

    @FindBy(id = "rightClickBtn")
    public WebElement rightClickBtn;

    @FindBy(id = "rightClickMessage")
    public WebElement rightClickMessage;

    @FindBy(id = "P6Tzl")
    public WebElement clickMeBtn;
    @FindBy(id = "dynamicClickMessage")
    public WebElement clickMeMessage;

}
