import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.Scanner;

public class BrowserHelperTest extends BaseTest {

    @Test
    void test123() throws InterruptedException {
        browserHelper.open("https://demoqa.com/browser-windows");
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
        browserHelper.open("https://demoqa.com/browser-windows");
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
