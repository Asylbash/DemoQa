package homeworksPractice.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class TextBox3 {

    private WebDriver driver;


    @BeforeMethod
    public void openBrowser() {

        System.setProperty("webdriver.chrome.driver", "/Users/zhyldyzadylchaeva/Documents/IntelliJ IDEA/DemoQAWinter24/src/main/resources/drivers/chromedriver");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterMethod
    public void closeBrowser() {

        driver.close();
        driver.quit();
    }

    @Test(dataProvider = "textBoxDataProvider")
    public void fillAndSubmit(String userName, String userEmail, String currentAddress, String permanentAddress) throws InterruptedException {

        driver.manage().window().maximize();
        driver.get("https://demoqa.com/text-box");

        fillField("userName", userName);
        fillField("userEmail", userEmail);
        fillField("currentAddress", currentAddress);
        fillField("permanentAddress", permanentAddress);

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();
    }

    private void fillField(String fieldName, String value) throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//        Thread.sleep(5000);
        WebElement field = driver.findElement(By.id(fieldName));
        field.sendKeys(value);
    }

    @DataProvider(name = "textBoxDataProvider")
    public Object[][] textBoxDataProvider() {
        return new Object[][]{
                {"Zhyldyz", "asylbash@gmail.com", "via Ugo Foscolo 9", "via Roma 7"},
                {"Aikanysh", "aikanysh@gmail.com", "123 Main St, Anytown", "456 Elm St, Othertown"},
                {"Nargiza", "nargiza@gmail.com", "21 Pushkina St, Tokmok", "58 Moskovskaya St, Bishkek"}
        };
    }

}
//public class Main {
//    public static void main(String[] args) {
//        // Установка пути к драйверу Chrome
//        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
//
//        // Инициализация драйвера
//        WebDriver driver = new ChromeDriver();
//
//        // Открытие веб-страницы
//        driver.get("Uwww.demoqa");
//
//        // Найти веб-элемент
//        WebElement element = driver.findElement(By.id("ID_ЭЛЕМЕНТА"));
//
//        // Сохранить текст элемента в строку
//        String elementText = element.getText();
//
//        String texelemconv = driver.findElement(By.id("ID_ЭЛЕМЕНТА")).getText();
//
//        // Печать сохраненного текста
//        System.out.println(elementText);

        // Закрытие драйвера
//        driver.quit();
//    }
//}