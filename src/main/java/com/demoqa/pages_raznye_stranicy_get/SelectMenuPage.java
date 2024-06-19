package com.demoqa.pages_raznye_stranicy_get;

import com.demoqa.drivers.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class SelectMenuPage extends BasePage {

    @FindBy(id = "oldSelectMenu")
    public WebElement selectMenu;

    @FindBy(xpath = "//*[@id='withOptGroup']/div[@class=' css-yk16xz-control']")
    public WebElement selectValue;
    @FindBy(id = "selectOne")
    public WebElement selectOne;

    @FindBy(xpath = "//*[contains(text(), 'Select...')]")
    public WebElement multiSelectDropDown;
    @FindBy(id = "cars")
    public WebElement standardMultiSelect;

    public List<String> getSelectOptions() {
        return dropdownHelper.getAllSelectOptions(selectMenu);
    }

    public List<String> getSelectOneOptions() {
        return dropdownHelper.getAllDivOptions(selectOne, "//*[@class=' css-26l3qy-menu']");
    }

    public List<String> getSelectValueOptions() {
        return dropdownHelper.getAllDivOptions(selectValue, " //*[@class=' css-26l3qy-menu']");
    }

    public List<String> getMultiSelectDropDownOptions() {
        return dropdownHelper.getAllDivOptions(multiSelectDropDown, " //*[@class=' css-26l3qy-menu']");
    }

    public List<String> getStandardMultiSelectDropDownOptions() {
        return dropdownHelper.getAllDivOptions(standardMultiSelect, "//*[@id='cars']/option");
    }

    //div[contains(@id, 'option')]
}
