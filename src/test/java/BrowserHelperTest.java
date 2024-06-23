import com.demoqa.utils.ConfigReader;
import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.demoqa.enums.Endpoints.BROWSER_WINDOWS;

public class BrowserHelperTest extends BaseTest {

    @Test(description = "verify if navigate back then forward and refresh page")
    @Owner("Zhyldyz")
    //@Tag("E2E")
    @Severity(SeverityLevel.NORMAL)
    //@Story("1012")
    @Epic("Browsers")
    @Link("www.demoqa.com")
    void browsersTest() throws InterruptedException {

        browserHelper.open(ConfigReader.getValue("baseURL") + BROWSER_WINDOWS.getEndpoint());
        driver.findElement(By.xpath("//span[text()='Alerts']")).click();
        Thread.sleep(2000);
        browserHelper.goBack();
        Thread.sleep(2000);
        browserHelper.goForward();
        Thread.sleep(2000);
        browserHelper.refreshThePage();

    }

    @Test(description = "verify if switch to new windows then back to parent window and close others")
    @Owner("Zhyldyz")
    //@Tag("E2E")
    @Severity(SeverityLevel.NORMAL)
    //@Story("1012")
    @Epic("Browsers")
    @Link("www.demoqa.com")
    @Description("verify if switch to new windows then back to parent window and close others")
    void switchWindowsAndCloseTest() throws InterruptedException {

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
