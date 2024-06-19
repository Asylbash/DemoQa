package com.demoqa.helper_vspomogatelnye_custom_metody;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.function.Function;


public class FluentWait {

    WebDriver driver;

    // Переход на целевую страницу
//        driver.get("http://example.com");
//
//        // Настройка FluentWait
//        FluentWait<WebDriver> wait = new FluentWait<>(driver)
//                .withTimeout(Duration.ofSeconds(30))       // Общее время ожидания
//                .pollingEvery(Duration.ofSeconds(5))        // Интервал опроса
//                .ignoring(NoSuchElementException.class);    // Игнорирование исключений
//
//        // Ожидание видимости элемента
//        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
//            public WebElement apply(WebDriver driver) {
//                WebElement element = driver.findElement(By.id("dynamic-element-id"));
//                if (element.isDisplayed()) {
//                    return element;
//                } else {
//                    return null;
//                }
//            }
//        });
//
}
