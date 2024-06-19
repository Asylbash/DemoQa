package homeworksPractice.elements.locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations .*;

import java.time.Duration;

public class TextBoxAssert {
    WebDriver driver;

    @BeforeTest
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

        String text1 = driver.findElement(By.xpath("//p[@id='name']")).getText();
        System.out.println(text1);
        String text2 = driver.findElement(By.xpath("//p[@id='email']")).getText();
        System.out.println(text2);
        String text3 = driver.findElement(By.xpath("//p[@id='currentAddress']")).getText();
        System.out.println(text3);
        String text4 = driver.findElement(By.xpath("//p[@id='permanentAddress']")).getText();
        System.out.println(text4);

        // Assert the output
        Assert.assertEquals(text1, "Name:" + name);
        Assert.assertEquals(text2, "Email:" + email);
        Assert.assertEquals(text3, "Current Address :" + currAddress);
        Assert.assertEquals(text4, "Permananet Address :" + permAddress);
    }

    @DataProvider(name = "textBoxDataProvider")
    public Object[][] textBoxDataProvider() {
        return new Object[][]{
                {"Zhyldyz Adylchaeva", "asylbash@gmail.com", "Elebaeva 3 - 77", "via U.Foscolo 9"},
                {"Aikanysh", "aikanysh@gmail.com", "123 Main St, Anytown", "456 Elm St, Othertown"},
                {"Nargiza", "nargiza@gmail.com", "21 Pushkina St, Tokmok", "58 Moskovskaya St, Bishkek"}
        };
    }

    @AfterTest
    public void closeBrowser() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }
}

