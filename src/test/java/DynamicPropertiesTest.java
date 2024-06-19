import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DynamicPropertiesTest extends BaseTest {

    @Test(description = "Verify is click button enable after 5 seconds")
    public void checkEnableAfterClickTest() {
        driver.get("https://demoqa.com/dynamic-properties");
        webElementActions.clickAfterFiveSeconds(demoqa.getDynamicPropertiesPage().enableAfterBtn);
    }

    @Test(description = "Verify is click button change color")
    public void colorChangeClickTest() {
        driver.get("https://demoqa.com/dynamic-properties");
        webElementActions.clickColorChange(demoqa.getDynamicPropertiesPage().colorChangeBtn);
        String classValue = driver.findElement(By.id("colorChange")).getAttribute("class");
        Assert.assertEquals(classValue, "mt-4 text-danger btn btn-primary");

    }

    @Test(description = "Verify is click button visible after 5 seconds")
    public void visibleAfterClickTest(){
        driver.get("https://demoqa.com/dynamic-properties");
        webElementActions.visibleAfterFiveSeconds(demoqa.getDynamicPropertiesPage().visibleAfterBtn);
    }

}
