package com.demoqa.helper_vspomogatelnye_custom_metody;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.LinkedList;
import java.util.Set;

public class BrowserHelper {
    private WebDriver driver;

    public BrowserHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void open(String url) {
        driver.navigate().to(url);
    }

    public void goBack() {
        driver.navigate().back();
    }

    public void goForward() {
        driver.navigate().forward();
    }

    public void refreshThePage() {
        driver.navigate().refresh();
    }

    public Set<String> getWindowHandles() {
        return driver.getWindowHandles();
    }

    public void switchToWindow(int index) {
        LinkedList<String> windowsId = new LinkedList<>(getWindowHandles());
        if (index < 0 || index > windowsId.size())
            throw new IllegalArgumentException("Invalid index : " + index);
        driver.switchTo().window(windowsId.get(index));

    }

    public void switchToParentWindow() {
        LinkedList<String> windowsId = new LinkedList<>(getWindowHandles());
        driver.switchTo().window(windowsId.get(0));
    }

    public void switchToParentWithChildClose() {
        switchToParentWindow();
        LinkedList<String> windowsId = new LinkedList<>(getWindowHandles());

        for (int i = 1; i < windowsId.size(); i++) {
            driver.switchTo().window(windowsId.get(i));
            driver.close();//close tab
        }
        switchToParentWindow();
    }

    public static class WindowHelper {

        private WebDriver driver;
        private WebDriverWait wait;

        public WindowHelper(WebDriver driver) {
            this.driver = driver;
            this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        }

        public Set<String> getWindowHandles() {
            return driver.getWindowHandles();
        }

        public void switchToWindow(int index) {
            LinkedList<String> windowsId = new LinkedList<>(getWindowHandles());
            if (index < 0 || index > windowsId.size()) {
                throw new IllegalArgumentException("You provide wrong index " + index);
            }
            driver.switchTo().window(windowsId.get(index));
        }

        public void switchToParent() {
            LinkedList<String> windowsId = new LinkedList<>(getWindowHandles());
            driver.switchTo().window(windowsId.get(0));
        }

        public void switchToParentWithChildClose() {
            switchToParent();
            LinkedList<String> windowsId = new LinkedList<>(getWindowHandles());
            for (int i = 0; i < windowsId.size(); i++) {
                driver.switchTo().window(windowsId.get(i));
                driver.close();
            }
        }
    }
}
