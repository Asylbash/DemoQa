package homeworksPractice.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class Test5 {

    WebDriver driver = new ChromeDriver();

    @BeforeMethod(alwaysRun = true)
    public void before() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/zhyldyzadylchaeva/Documents/IntelliJ IDEA/DemoQAWinter24/src/main/resources/drivers/chromedriver");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/text-box");
        Thread.sleep(5000);
        System.out.println("driver is started");
    }


    @DataProvider(name = "word")
    public Object[][] provideWord() {
        return new Object[][]{
                {"Nuta", "nuta@mail.ru", "Bishkek", "Osh"},
                {"Ali", "ali@mail.ru", "Bishkek", "Naryn"},
                {"Aika", "aika@mail.ru", "Bishkek", "Talas"}

        };
    }

    @Test(dataProvider = "word")
    void textBoxTest(String name1,String email1,String currentAddress1,String permanentAddress1) throws InterruptedException {
        WebElement fullName = driver.findElement(By.id("userName"));
        fullName.sendKeys(name1);
        WebElement email = driver.findElement(By.id("userEmail"));
        email.sendKeys(email1);
        WebElement currentAddress = driver.findElement(By.id("currentAddress"));
        currentAddress.sendKeys(currentAddress1);
        WebElement permanentAddress = driver.findElement(By.id("permanentAddress"));
        permanentAddress.sendKeys(permanentAddress1);
        WebElement submit = driver.findElement(By.id("submit"));
        submit.click();
        Thread.sleep(5000);
    }

    @AfterMethod
    public void closeBrowser() {

        driver.close();
        driver.quit();

    }
}
