package homeworksPractice.elements.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class OrderKoversamalet {

    WebDriver driver;

    @BeforeClass
    void openBrowser() {
        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://dostavka312.kg/");
    }

    @AfterClass
    void closeBrowser() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }

    @Test
    public void orderKFC() {
        WebElement allEstablishments = driver.findElement(By.xpath("//*[@id=\"tab-01\"]/div/p/a/img"));
        allEstablishments.click();

        WebElement kfcRestaurant = driver.findElement(By.xpath("//a[@href='https://dostavka312.kg/garnirygpt/kfc-moskovskaja']"));
        kfcRestaurant.click();

        WebElement orderKombo = driver.findElement(By.xpath("//a[@href='https://dostavka312.kg/garnirygpt/kfc-moskovskaja#menu_0']"));
        orderKombo.click();

        WebElement addToBasket = driver.findElement(By.xpath("//p[normalize-space(text())='Баскет L Комбо']/following-sibling::form/button"));
        addToBasket.click();

        WebElement openBasket = driver.findElement(By.xpath("//div[@class='icon_pulse']"));
        openBasket.click();

        WebElement buttonOformit = driver.findElement(By.xpath("//a[@href = 'https://dostavka312.kg/cart']"));
        buttonOformit.click();

        WebElement name = driver.findElement(By.xpath("//input[@name = 'name']"));
        name.sendKeys("Bermet");

        WebElement address = driver.findElement(By.xpath("//input[@name = 'address']"));
        address.sendKeys("Токтогул 9");

        WebElement phone = driver.findElement(By.xpath("//input[@placeholder='Ваш телефон']"));
        phone.sendKeys("0555004500");

        WebElement chang = driver.findElement(By.xpath("//input[@name='money']"));
        chang.sendKeys("400");

        WebElement buttonZakazat = driver.findElement(By.xpath("//button[@class='btn btn-yellow btn-lg btn-savecart']"));
        buttonZakazat.click();

    }
}
