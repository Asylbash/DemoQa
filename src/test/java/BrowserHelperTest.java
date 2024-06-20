import com.demoqa.utils.ConfigReader;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.demoqa.enums.Endpoints.BROWSER_WINDOWS;

public class BrowserHelperTest extends BaseTest {

    @Test
    void test123() throws InterruptedException {

        browserHelper.open(ConfigReader.getValue("baseURL") + BROWSER_WINDOWS.getEndpoint());
        driver.findElement(By.xpath("//span[text()='Alerts']")).click();
        Thread.sleep(2000);
        browserHelper.goBack();
        Thread.sleep(2000);
        browserHelper.goForward();
        Thread.sleep(2000);
        browserHelper.refreshThePage();

    }

    @Test
    void test7() throws InterruptedException {

        browserHelper.open(ConfigReader.getValue("baseURL") + BROWSER_WINDOWS.getEndpoint());
        Thread.sleep(2000);
        driver.findElement(By.id("tabButton")).click();
        driver.findElement(By.id("tabButton")).click();
        driver.findElement(By.id("tabButton")).click();
        driver.findElement(By.id("tabButton")).click();
        driver.findElement(By.id("tabButton")).click();
        Thread.sleep(3000);
        browserHelper.switchToWindow(0);
        Thread.sleep(5000);
        browserHelper.switchToParentWithChildClose();
        Thread.sleep(5000);

    }

}
