package com.demoqa.pages_raznye_stranicy_get;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenuPage extends BasePage{
    @FindBy(xpath = "//a[text()='Main Item 2']")
    public WebElement mainItem2;

}
