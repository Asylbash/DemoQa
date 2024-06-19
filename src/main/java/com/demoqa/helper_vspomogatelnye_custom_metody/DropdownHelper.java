package com.demoqa.helper_vspomogatelnye_custom_metody;

import com.demoqa.drivers.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DropdownHelper {
    public WebDriver driver;

    public DropdownHelper(WebDriver driver) {
        this.driver = driver;
    }

    public DropdownHelper selectByVisibleText(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByVisibleText(value);
        return this;
    }

    public DropdownHelper selectByValue(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByValue(value);
        return this;
    }

    // Метод для получения всех опций из <select> элемента в список
    public List<String> getAllDivOptions(WebElement divElement, String optionsXPath) {
        WebElementActions webElementActions = new WebElementActions();
        webElementActions.click(divElement);
//        divElement.click();
        List<WebElement> options = driver.findElements(By.xpath(optionsXPath));
        return options.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public List<String> collectAllDivOptions(String optionsXPath) {
        List<WebElement> options = driver.findElements(By.xpath(optionsXPath));

        if (options.isEmpty()) {
            System.out.println("No options found for XPath: " + optionsXPath);  // Логирование, если список пустой
        } else {
            System.out.println("Found options: " + options.stream().map(WebElement::getText).collect(Collectors.toList()));  // Логирование найденных опций
        }

        return options.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    // Метод для получения всех опций из <select> элемента в список
    public List<String> getAllSelectOptions(WebElement element) {
        Select select = new Select(element);
        List<WebElement> options = select.getOptions();
        List<String> optionTexts = new ArrayList<>();
        for (WebElement option : options) {
            optionTexts.add(option.getText());
        }
        return optionTexts;
    }
}
