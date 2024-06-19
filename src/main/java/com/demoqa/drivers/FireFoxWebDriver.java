package com.demoqa.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class FireFoxWebDriver {


    public static WebDriver loadFireFoxDriver (){
        System.setProperty("webdriver.firefox.driver", "/Users/zhyldyzadylchaeva/Documents/IntelliJ IDEA/DemoQAWinter24/src/main/resources/drivers/geckodriver");

        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        return driver;

//        WebDriverManager.firefoxdriver().setup();
//        FirefoxOptions options = new FirefoxOptions();
//        options.addArguments("--disable-extensions");
//        options.addArguments("--window-size-1920,1080");
//        if(Boolean.parseBoolean(getValue("headless"))) {
//            options.addArguments("--headless");
//        }
//        WebDriver driver = new FirefoxDriver(options);
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//        driver.manage().window().maximize();
//        return driver;
    }
}
