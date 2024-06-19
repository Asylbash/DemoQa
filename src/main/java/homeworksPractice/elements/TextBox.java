package homeworksPractice.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import org.testng.annotations.*;

public class TextBox {

    WebDriver driver;

    @BeforeClass
    public void openBrowser() {

        System.setProperty("webdriver.chrome.driver", "/Users/zhyldyzadylchaeva/Documents/IntelliJ IDEA/DemoQAWinter24/src/main/resources/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test(dataProvider = "textBoxDataProvider")
    public void textBoxTest(String name, String email, String currAddress, String permAddress) {

        driver.get("https://demoqa.com/text-box");

        WebElement fullName = driver.findElement(By.id("userName"));
        fullName.sendKeys(name);

        WebElement userEmail = driver.findElement(By.id("userEmail"));
        userEmail.sendKeys(email);

        WebElement currentAddress = driver.findElement(By.id("currentAddress"));
        currentAddress.sendKeys(currAddress);

        WebElement permanentAddress = driver.findElement(By.id("permanentAddress"));
        permanentAddress.sendKeys(permAddress);

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

    }

    @DataProvider(name = "textBoxDataProvider")
    public Object[][] textBoxDataProvider() {

        return new Object[][]{
                {"Zhyldyz Adylchaeva", "asylbash@gmail.com", "Elebaeva 3 - 77", "via U.Foscolo 9"},
                {"Aikanysh", "aikanysh@gmail.com", "123 Main St, Anytown", "456 Elm St, Othertown"},
                {"Nargiza", "nargiza@gmail.com", "21 Pushkina St, Tokmok", "58 Moskovskaya St, Bishkek"}
        };
    }

    @AfterClass
    public void closeBrowser() {

        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }
}


