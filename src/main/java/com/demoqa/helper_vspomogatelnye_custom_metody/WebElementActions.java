package com.demoqa.helper_vspomogatelnye_custom_metody;

import com.demoqa.drivers.DriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WebElementActions {

    public Actions actions = new Actions(DriverManager.getDriver());

    // Метод для добавления задержки
    private void waitFor(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public WebElementActions clear(WebElement element) {
        waitElementToBeClickable(element);
        scrollToElement(element);
        highlightElement(element);
        waitFor(1000);
        element.clear();
        return this;
    }

    public WebElementActions click(WebElement element) {
        waitElementToBeClickable(element);
        highlightElement(element);
        scrollToElement(element);
        waitFor(1000); // Задержка в 5 секунд перед кликом
        element.click();
        return this;
    }

    public WebElementActions clickAfterFiveSeconds(WebElement element) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(6));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("enableAfter")));
        scrollToElement(element);
        highlightElement(element);
        element.click();
        return this;
    }

    public WebElementActions clickColorChange(WebElement element) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.attributeToBe(By.id("colorChange"), "class", "mt-4 text-danger btn btn-primary"));
        scrollToElement(element);
        highlightElement(element);
        element.click();
        return this;
    }

    public WebElementActions visibleAfterFiveSeconds(WebElement element) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("visibleAfter")));
        scrollToElement(element);
        highlightElement(element);
        element.click();
        return this;
    }

    public WebElementActions sendKeys(WebElement element, String txt) {
        waitElementToBeVisible(element);
        scrollToElement(element);
        waitFor(2000); // Задержка в 5 секунд перед отправкой текста
        element.sendKeys(txt);
        return this;
    }

    public WebElementActions sendKeysWithEnter(WebElement element, String txt) {
        waitElementToBeVisible(element);
        scrollToElement(element);
       // waitFor(3000); // Задержка в 5 секунд перед отправкой текста
        element.sendKeys(txt);
        element.sendKeys(Keys.ENTER);
        return this;
    }

    public WebElementActions sendKeysWithTab(WebElement element, String txt) {
        waitElementToBeVisible(element);
        scrollToElement(element);
        waitFor(1000); // Задержка в 5 секунд перед отправкой текста
        element.sendKeys(txt);
        element.sendKeys(Keys.TAB);
        return this;
    }

    public WebElementActions sendKeysWithDownEnter(WebElement element, String txt) {
        waitElementToBeVisible(element);
        scrollToElement(element);
        waitFor(1000); // Задержка в 5 секунд перед отправкой текста
        element.sendKeys(txt);
        element.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
        return this;
    }

    public WebElementActions waitElementToBeClickable(WebElement element) {
        new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(15))
                .until(ExpectedConditions.elementToBeClickable(element));
        return this;
    }

    public WebElementActions waitElementToBeVisible(WebElement element) {
        new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(40))
                .until(ExpectedConditions.visibilityOf(element));
        return this;
    }

    public WebElementActions scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        return this;
    }

    // метод клика с JavascriptExecutor
    public WebElementActions jsClick(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("arguments[0].click();", element);
        return this;
    }

    //  чтобы выделить рамки красным цветом
    public WebElementActions highlightElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("arguments[0].style.border='3px solid red';", element);
        return this;
    }

    public WebElementActions jsSendKeys(WebElement element, String txt) {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("arguments[0].value = arguments[1];", element, txt);
        return this;
    }

    //метод Actions - управления мышькой
    public WebElementActions doubleClick(WebElement element) {
        waitElementToBeVisible(element);
        waitElementToBeClickable(element);
        actions.doubleClick(element).perform();
        return this;
    }


    public WebElementActions rightClick(WebElement element) {
        waitElementToBeVisible(element);
        waitElementToBeClickable(element);
        actions.contextClick(element).perform(); // метод perform - выполнить действие
        return this;
    }

    public WebElementActions moveToElement(WebElement element) {
        waitElementToBeVisible(element);
        actions.moveToElement(element).build().perform();
        return this;
    }

    // Новый метод для отправки списка строк с нажатием Enter после каждой строки
    public WebElementActions sendKeysWithEnterList(WebElement element, List<String> texts) {
        waitElementToBeVisible(element);
        scrollToElement(element);
        for (String text : texts) {
            element.sendKeys(text);
            element.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
            waitFor(500); // Задержка в 0.5 секунды между вводом строк
        }
        return this;
    }

    public WebElementActions editWebTable(WebElement element) {
        waitElementToBeClickable(element);
        scrollToElement(element);
        waitFor(1000); // Задержка в 5 секунд перед кликом
        element.click();
        element.clear();
        element.sendKeys();
        return this;
    }
    // метод находит элемент по указанному xPath, кликая на него раскрывает всплывающий список
    // по указанному xPath ложит весь всплывающий список в лист
    // рандомно выбирает один из элементов
    public String randomElementSelection(String xpathDropdownControl, String xpathDropdownItems){
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
        // Нахождение контроллера списка и открытие списка
        WebElement dropdownControl = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathDropdownControl)));
        dropdownControl.click();
        // Явное ожидание появления элементов списка
        List<WebElement> dropdownItems = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpathDropdownItems)));
        // Создание списка для хранения текстов элементов
        ArrayList<String> itemList = new ArrayList<>();
        // Добавление всех текстов элементов в ArrayList
        for (WebElement item : dropdownItems) {
            itemList.add(item.getText());
        }
        Random random = new Random();
        int index = random.nextInt(itemList.size());
        return itemList.get(index);
    }
}

