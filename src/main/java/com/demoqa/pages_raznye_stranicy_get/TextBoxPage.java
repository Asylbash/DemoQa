package com.demoqa.pages_raznye_stranicy_get;

import com.demoqa.entities_polya_objects.PracticeFormEntity;
import com.demoqa.entities_polya_objects.TextBoxEntity;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TextBoxPage extends BasePage {

    @FindBy(xpath = "//*[@id='userName']")
    public WebElement fullNameInput;

    // WebElement userNameInput = DriverManager.getDriver().findElement(By.id("userName"));

    @FindBy(id = "userEmail")
    public WebElement emailInput;

    @FindBy(id = "currentAddress")
    WebElement currentAddressInput;

    @FindBy(id = "permanentAddress")
    public WebElement permanentAddresseInput;

    @FindBy(id = "submit")
    public WebElement submitBtn;

    public TextBoxPage fillUpTextBoxForm(String fullname, String email, String currentAddress, String permanentAddress) {
        webElementActions.sendKeys(fullNameInput, fullname)
                .sendKeys(emailInput, email)
                .sendKeys(currentAddressInput, currentAddress)
                .sendKeys(permanentAddresseInput, permanentAddress)
                .click(submitBtn);
        return this;
    }

    public TextBoxPage fillUpTextBoxForm(TextBoxEntity textBoxEntity) {
        webElementActions.sendKeys(fullNameInput, textBoxEntity.getFullName())
                .sendKeys(emailInput, textBoxEntity.getEmail())
                .sendKeys(currentAddressInput, textBoxEntity.getCurrentAddress())
                .sendKeys(permanentAddresseInput, textBoxEntity.getPermanentAddress())
                .click(submitBtn);
        return this;
    }
}

