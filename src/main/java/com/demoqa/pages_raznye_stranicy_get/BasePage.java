package com.demoqa.pages_raznye_stranicy_get;

import com.demoqa.drivers.DriverManager;
import com.demoqa.helper_vspomogatelnye_custom_metody.*;
import org.openqa.selenium.support.PageFactory;

import java.sql.Driver;

public abstract class BasePage {

    public BasePage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    // используя драйвер, инициализирует поля заданного класса


    public WebElementActions webElementActions = new WebElementActions();
    public BrowserHelper browserHelper = new BrowserHelper(DriverManager.getDriver());
    public DropdownHelper dropdownHelper = new DropdownHelper(DriverManager.getDriver());
    public AlertHelper alertHelper = new AlertHelper(DriverManager.getDriver());

    public IframeHelper iframeHelper = new IframeHelper(DriverManager.getDriver());

}
