package homeworksPractice.elements.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;

public class NambaDemeo {

    WebDriver driver;

    @BeforeSuite
    void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "/Users/zhyldyzadylchaeva/Documents/IntelliJ IDEA/DemoQAWinter24/src/main/resources/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://nambafood.kg/");
    }

    @Test
    public void openLinks() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        // driver.get("https://nambafood.kg/");
        WebElement foodButton = driver.findElement(By.xpath("(//a[@href='/food'])[1]"));
        foodButton.click();
        WebElement evropeanButton = driver.findElement(By.xpath("//a[@href='/cafe/ievropieiskaia-kukhnia']"));
        evropeanButton.click();
        WebElement cafePaulButton = driver.findElement(By.xpath("//a[@href='/paul']"));
        cafePaulButton.click();
        WebElement zakazButton = driver.findElement(By.xpath("/html/body/main/section[2]/div[1]/span[6]/div/div[2]/div[2]/button"));
        zakazButton.click();
        WebElement korzina = driver.findElement(By.xpath("//a[@href='/paul/make-order']"));
        korzina.click();
        WebElement checkoutOrder = driver.findElement(By.xpath("//a[@href='/paul/checkout']"));
        checkoutOrder.click();
    }

//    @Test
//    void fillData() {
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
//        WebElement fullName = driver.findElement(By.id("food_order_client_name"));
//        fullName.sendKeys("Jakshylyk");
//
//        WebElement address = driver.findElement(By.xpath("//input[@id='food_order_address']"));
//        address.sendKeys("12 микрорайон 62/5");
//
//        WebElement addressNumber = driver.findElement(By.id("food_order_door_code"));
//        addressNumber.sendKeys(" 5 этаж, квартира 23");
//
//        WebElement phone = driver.findElement(By.id("food_order_phone"));
//        phone.sendKeys(" +996550516216");
//
//        //tab_item-0
//        WebElement payment = driver.findElement(By.xpath("//h2[@aria-controls='tab_item-0']"));
//        payment.click();
//
//        WebElement moneyChange = driver.findElement(By.id("food_order_money_change"));
//        moneyChange.sendKeys("1080 som");
//
//        WebElement order = driver.findElement(By.id("payment_cash"));
//        order.click();
//    }

//    void textNambaFood() {
//        String textBoxText = driver.findElement(By.tagName("h1")).getText();
//        System.out.println(textBoxText);
//    }

    @AfterSuite
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();

        }
    }
}
