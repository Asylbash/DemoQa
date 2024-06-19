package homeworksPractice.elements.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class BasicLocators {

    /*
    * Locator	 ->   Description
  * class name	->    Locates elements whose class name contains the search value (compound class names are not permitted)
   *css selector	 ->   Locates elements matching a CSS selector
   * id	      ->      Locates elements whose ID attribute matches the search value
   * name	  ->      Locates elements whose NAME attribute matches the search value
   * link text	  ->   Locates anchor elements whose visible text matches the search value
   * partial link text	-> Locates anchor elements whose visible text contains the search value. If multiple elements are matching, only the first one will be selected.
   * tag name	->     Locates elements whose tag name matches the search value
   * xpath	  ->       Locates elements matching an XPath expression
*/

    WebDriver driver;

    @Test(description = "Find by ID")
    public void openBrowser() {

        System.setProperty("webdriver.chrome.driver", "/Users/zhyldyzadylchaeva/Documents/IntelliJ IDEA/DemoQAWinter24/src/main/resources/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://demoqa.com/text-box");
        WebElement fullName = driver.findElement(By.xpath("(//textarea[@class='form-control'])[1]"));
        fullName.sendKeys("Elebaeva 3-77");

        String text = driver.findElement(By.xpath("//label[text()='Permanent Address']")).getText();
        System.out.println(text);



        driver.close();
        driver.quit();


    }
}
