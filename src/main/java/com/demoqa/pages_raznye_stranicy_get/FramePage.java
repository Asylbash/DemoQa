package com.demoqa.pages_raznye_stranicy_get;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FramePage extends BasePage {
    @FindBy(id = "frame1")
    public WebElement frame1;

    @FindBy(id = "sampleHeading")
    public WebElement frame1Text;

    @FindBy(xpath = "//h1[@class='text-center']") //tagName = "h1"
    public WebElement textCenter;

}
