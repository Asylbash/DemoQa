package com.demoqa.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.time.Duration;

import static com.demoqa.utils.ConfigReader.getValue;

public class EdgeWebDriver {


    public static WebDriver loadEdgeDriver() {

        WebDriverManager.edgedriver().setup();
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--disable-extensions");
        options.addArguments("--window-size-1920,1080");
        if (Boolean.parseBoolean(getValue("headless"))) {
            options.addArguments("--headless");
        }
        WebDriver driver = new EdgeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        return driver;

    }
}

