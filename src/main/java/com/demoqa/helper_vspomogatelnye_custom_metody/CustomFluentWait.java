package com.demoqa.helper_vspomogatelnye_custom_metody;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.function.Function;

public class CustomFluentWait {

    private WebDriver driver;
    private Wait<WebDriver> wait;

    public CustomFluentWait(WebDriver driver) {
        this.driver = driver;
        this.wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))       // Общее время ожидания
                .pollingEvery(Duration.ofSeconds(5))       // Интервал опроса
                .ignoring(NoSuchElementException.class);   // Игнорирование исключений
    }

    /**
     * Метод для ожидания видимости элемента по заданному локатору.
     *
     * @param locator Локатор элемента.
     * @return Найденный видимый элемент.
     */
    public WebElement waitForElementVisible(By locator) {
        return wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                WebElement element = driver.findElement(locator);
                if (element.isDisplayed()) {
                    return element;
                } else {
                    return null;
                }
            }
        });
    }

    /**
     * Метод для ожидания кликабельности элемента по заданному локатору.
     *
     * @param locator Локатор элемента.
     * @return Найденный кликабельный элемент.
     */
    public WebElement waitForElementClickable(By locator) {
        return wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                WebElement element = driver.findElement(locator);
                if (element.isEnabled()) {
                    return element;
                } else {
                    return null;
                }
            }
        });
    }
}
