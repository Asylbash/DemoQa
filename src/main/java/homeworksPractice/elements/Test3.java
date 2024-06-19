package homeworksPractice.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class Test3 {

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
    public void fillAndSubmit(String userName, String userEmail, String currentAddress, String permanentAddress) {
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/text-box");

        fillField("userName", userName);
        fillField("userEmail", userEmail);
        fillField("currentAddress", currentAddress);
        fillField("permanentAddress", permanentAddress);

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();
    }

    private void fillField(String fieldName, String value) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement field = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(fieldName)));
        field.sendKeys(value);
    }

    @DataProvider(name = "textBoxDataProvider")
    public Object[][] textBoxDataProvider() {
        return new Object[][]{
                {"Zhyldyz Adylchaeva", "asylbash@gmail.com", "Elebaeva 3 - 77", "via U.Foscolo 9"},
                {"Aikanysh", "aikanysh@gmail.com", "123 Main St, Anytown", "456 Elm St, Othertown"},
                {"Nargiza", "nargiza@gmail.com", "21 Pushkina St, Tokmok", "58 Moskovskaya St, Bishkek"}
        };
    }
}

