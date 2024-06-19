package homeworksPractice.elements.timer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class Demoqa {

    // 1//button[@id="enableAfter"] after5 sec aktiven

    // 2 //button[@id="colorChange"] 5 sec pomenyaet cvet
    // 3 //button[@id="visibleAfter"] 5sec poyavitsya

    WebDriver driver;

    @BeforeClass
    public void openBrowser() {

        System.setProperty("webdriver.chrome.driver", "/Users/zhyldyzadylchaeva/Documents/IntelliJ IDEA/DemoQAWinter24/src/main/resources/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }

    @Test
    public void textBoxTestClick() throws InterruptedException {

        driver.get("https://demoqa.com/dynamic-properties");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));

        wait.until(ExpectedConditions.elementToBeClickable(By.id("enableAfter"))).click();

        wait.until(ExpectedConditions.attributeToBe(By.id("colorChange"), "class", "mt-4 text-danger btn btn-primary"));
        String colorChangeButton = driver.findElement(By.id("colorChange")).getAttribute("class");
        System.out.println(colorChangeButton);

        wait.until(ExpectedConditions.elementToBeClickable(By.id("colorChange"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("visibleAfter")));
        driver.findElement(By.id("visibleAfter")).click();
        Thread.sleep(3000);

    }


    @AfterClass
    public void closeBrowser() {

        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }
}
