package homeworksPractice.elements.timer;

import com.demoqa.drivers.ChromeWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class CheckBoxHM2405 {

    WebDriver driver;

    @BeforeClass
    public void openBrowser() {

        System.setProperty("webdriver.chrome.driver", "/Users/zhyldyzadylchaeva/Documents/IntelliJ IDEA/DemoQAWinter24/src/main/resources/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }

    @AfterClass
    public void closeBrowser() {

        driver.close();
        driver.quit();
    }

    @Test
    public void checkBoxTest() throws InterruptedException {

        driver.get("https://demoqa.com");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement clickElements = driver.findElement(By.xpath("//h5[normalize-space(text())='Elements']"));
        clickElements.click();

//        WebElement clickD = driver.findElement(By.xpath("//*[@id=\"item-8\"]"));
//        clickD.click();

        WebElement clickCheckBox = driver.findElement(By.id("item-1"));
        clickCheckBox.click();

        WebElement expandButtonHome = driver.findElement(By.xpath("//*[@id='tree-node']/ol/li/span/button"));
        expandButtonHome.click();

        WebElement expandAllButton = driver.findElement(By.xpath("//button[@title='Expand all']"));
        expandAllButton.click();

        WebElement chooseDesktopFile = driver.findElement(By.xpath("//span[normalize-space(text())='Desktop']"));
        chooseDesktopFile.click();
        Thread.sleep(3000);

//        WebElement resultAfterClick = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("result")));
//        String resultText = resultAfterClick.getText();
//        assertTrue(resultAfterClick.isDisplayed());

//        assertTrue(resultText.equalsIgnoreCase());
             //   contains("desktop"));
//       assertTrue(resultText.contains("notes"));
//      assertTrue(resultText.contains("commands"));
//
//        WebElement ChekBox2 = driver.findElement(By.xpath("//label[@for='tree-node-documents']"));
//        actions.moveToElement(ChekBox2).click().perform();
//
//
//        resultElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='result']")));
//        resultText = resultElement.getText();
//
//        Assert.assertTrue(resultText.contains("desktop"));
//        Assert.assertTrue(resultText.contains("notes"));
//        Assert.assertTrue(resultText.contains("commands"));
//        Assert.assertTrue(resultText.contains("documents"));
//        Assert.assertTrue(resultText.contains("workspace"));
//        Assert.assertTrue(resultText.contains("react"));
//        Assert.assertTrue(resultText.contains("angular"));
//        Assert.assertTrue(resultText.contains("veu"));
//        Assert.assertTrue(resultText.contains("office"));
//        Assert.assertTrue(resultText.contains("public"));
//        Assert.assertTrue(resultText.contains("private"));
//        Assert.assertTrue(resultText.contains("classified"));
//        Assert.assertTrue(resultText.contains("general"));


    }
}
