package homeworksPractice.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Testpage {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // Указываем путь к драйверу Chrome
        System.setProperty("webdriver.chrome.driver", "/Users/zhyldyzadylchaeva/Documents/IntelliJ IDEA/DemoQAWinter24/src/main/resources/drivers/chromedriver");

        // Создаем экземпляр браузера Chrome
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void closeBrowser() {
        // Закрываем браузер
        driver.close();
        driver.quit();
    }

    @Test
    public void fillFormAndSubmit() throws InterruptedException {

        driver.manage().window().maximize();

        // Открываем страницу с формой
        driver.get("https://demoqa.com/text-box");

        // Заполняем поля формы
        fillField("userName", "Nargiza");
        fillField("userEmail", "nargizaknd210986@gmail.com");
        fillField("currentAddress", "21 Pushkina St, Tokmok");
        fillField("permanentAddress", "58 Moskovskaya St, Bishkek");

        // Нажимаем на кнопку Submit
        WebElement submitButton = driver.findElement(By.id("submit")); // Находится кнопка "Submit" по ее идентификатору
        submitButton.click(); //Нажимается на кнопку "Submit"
    }

    private void fillField(String fieldName, String value) throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        Thread.sleep(5000);
        // Находим поле по его имени и вводим значение
        WebElement field = driver.findElement(By.id(fieldName)); // Находится поле формы по его уникальному идентификатору (id)
        field.sendKeys(value); //В поле формы вводится переданное значение
    }
}