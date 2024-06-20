package com.demoqa.pages_raznye_stranicy_get;

import com.demoqa.entities_polya_objects.NBWalletEntity;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NBWalletPage extends BasePage{
    @FindBy(id = "password")
    public WebElement passwordInput;

    @FindBy(id = "first-name")
    public WebElement firstNameInput;

    @FindBy(id = "last-name")
    public WebElement lastNameInput;

    @FindBy(id = "email")
    public WebElement emailInput;

    @FindBy(id = "phone")
    public WebElement phoneNumberInput;

    @FindBy(id = "file")
    public WebElement loadPict;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement registerBtn;
    @FindBy(xpath = "//*[@class='alert alert-danger']")
    public WebElement alertMassage;

    @Step("fill up fields on NBWallet register page")
    public NBWalletPage fillUpNBWalletForm(NBWalletEntity nbWalletEntity) {
        webElementActions.sendKeys(firstNameInput, nbWalletEntity.getFirstName())
                .sendKeys(lastNameInput, nbWalletEntity.getLastName())
                .sendKeys(emailInput, nbWalletEntity.getEmail())
                .sendKeys(phoneNumberInput, String.valueOf(nbWalletEntity.getPhoneNumber()))
                .sendKeys(loadPict, nbWalletEntity.getSelectPic())
                .sendKeys(passwordInput, nbWalletEntity.getPassword())
                .click(registerBtn);
        return this;
    }


}
