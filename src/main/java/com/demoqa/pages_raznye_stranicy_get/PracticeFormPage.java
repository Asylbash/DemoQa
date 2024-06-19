package com.demoqa.pages_raznye_stranicy_get;

import com.demoqa.drivers.DriverManager;
import com.demoqa.entities_polya_objects.PracticeFormEntity;
import com.demoqa.helper_vspomogatelnye_custom_metody.WebElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class PracticeFormPage extends BasePage {

    @FindBy(id = "firstName")
    public WebElement firstNameInput;

    @FindBy(id = "lastName")
    public WebElement lastNameInput;

    @FindBy(id = "userEmail")
    public WebElement userEmailInput;

    @FindBy(xpath = "//label[normalize-space(text())='Female']")
    public WebElement genderFemaleRadioBtn;

    @FindBy(xpath = "//label[normalize-space(text())='Male']")
    public WebElement genderMaleRadioBtn;

    @FindBy(xpath = "//label[normalize-space(text())='Other']")
    public WebElement genderOtherRadioBtn;

    @FindBy(id = "userNumber")
    public WebElement userMobileNumber;

    @FindBy(id = "subjectsInput")
    public WebElement subjectsInput;

    @FindBy(xpath = "//*[normalize-space(text())='Sports']")
    public WebElement sportHobbyCheckboxBtn;
    @FindBy(xpath = "//*[normalize-space(text())='Reading']")
    public WebElement readingHobbyCheckboxBtn;
    @FindBy(xpath = "//*[normalize-space(text())='Music']")
    public WebElement musicHobbyCheckboxBtn;

    @FindBy(id = "uploadPicture")
    public WebElement selectPicture;

    @FindBy(id = "currentAddress")
    public WebElement currentAddressInput;

    @FindBy(id = "react-select-3-input")
    public WebElement stateInput;

    @FindBy(id = "react-select-4-input")
    public WebElement cityInput;

    @FindBy(id = "submit")
    public WebElement submitBtn;
    @FindBy(xpath = "//div[@class=' css-1hwfws3']/div[text()='Select State']")
    public WebElement stateBtn;

    @FindBy(xpath = "//*[@class=' css-26l3qy-menu']/div/div[contains(@class, 'option')]")
    public WebElement stateCityOptions;
    @FindBy(xpath = "//div[@class=' css-1hwfws3']/div[text()='Select City']")
    public WebElement cityBtn;

    @FindBy(className = "react-datepicker__input-container")
    public WebElement datePickerBtn;

    public PracticeFormPage selectDateMonthYear(String dateMonthYear) {
        String[] dateMonthYearsParts = dateMonthYear.split(" ");
        String date = dateMonthYearsParts[0];
        String month = dateMonthYearsParts[1];
        String year = dateMonthYearsParts[2];
        webElementActions.click(datePickerBtn);
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
        WebElement monthDropDown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("react-datepicker__month-select")));
        WebElement yearDropDown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("react-datepicker__year-select")));
        dropdownHelper.selectByVisibleText(monthDropDown, month)
                .selectByVisibleText(yearDropDown, year);
        WebElement day = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class, 'react-datepicker__day') and not (contains(@class, 'react-datepicker__day--outside-month')) and text()='" + date + "']")));
        webElementActions.click(day);

        return this;
    }

    public PracticeFormPage fillUpPracticeForm(PracticeFormEntity practiceFormEntity) {
        webElementActions.sendKeys(firstNameInput, practiceFormEntity.getFirstName())
                .sendKeys(lastNameInput, practiceFormEntity.getLastName())
                .sendKeys(userEmailInput, practiceFormEntity.getEmail())
                // .click(genderFemaleRadioBtn) not random
                .click(selectGender(practiceFormEntity.getGender()))
                // .jsClick(webElementActions.randomElementSelection("//input[@name ='gender']"))
                .sendKeys(userMobileNumber, practiceFormEntity.getMobileNumber())
//                .sendKeysWithEnter(subjectInput, practiceFormEntity.getSubject())
                .sendKeysWithEnterList(subjectsInput, practiceFormEntity.getSubjects())
                .click(selectHobby(practiceFormEntity.getHobby()))
                // .clickRandomElements("//input[@type='checkbox']");
                .sendKeys(selectPicture, practiceFormEntity.getSelectPic())
                .sendKeys(currentAddressInput, practiceFormEntity.getCurrentAddress())
                .sendKeysWithEnter(stateInput, practiceFormEntity.getState())
                .sendKeysWithEnter(cityInput, webElementActions.randomElementSelection("//div[@class=' css-1hwfws3']/div[text()='Select City']", "//div[contains(@class,'menu')]//div[contains(@class,'option')]"))
                .click(submitBtn);
        return this;
    }

    public List<String> getSelectStateOptions() {
        return dropdownHelper.getAllDivOptions(stateBtn, "//div[contains(@class,'menu')]//div[contains(@class,'option')]");
    }


    private WebElement selectGender(String gender) {
        switch (gender) {
            case "Male":
                return genderMaleRadioBtn;
            case "Female":
                return genderFemaleRadioBtn;
            case "Other":
                return genderOtherRadioBtn;
            default:
                throw new IllegalArgumentException("Invalid gender: " + gender);
        }
    }

    private WebElement selectHobby(String hobby) {
        return switch (hobby) {
            case "Sports" -> sportHobbyCheckboxBtn;
            case "Reading" -> readingHobbyCheckboxBtn;
            case "Music" -> musicHobbyCheckboxBtn;
            default -> throw new IllegalArgumentException("Invalid hobby: " + hobby);
        };
    }
}
