import com.demoqa.utils.ConfigReader;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.demoqa.enums.Endpoints.DYNAMIC_PROPERTIES;

public class DynamicPropertiesTest extends BaseTest {

    @Test(description = "Verify is click button enable after 5 seconds")
    public void checkEnableAfterClickTest() {

        browserHelper.open(ConfigReader.getValue("baseURL") + DYNAMIC_PROPERTIES.getEndpoint());
        webElementActions.clickAfterFiveSeconds(demoqa.getDynamicPropertiesPage().enableAfterBtn);

    }

    @Test(description = "Verify is click button change color")
    public void colorChangeClickTest() {

        browserHelper.open(ConfigReader.getValue("baseURL") + DYNAMIC_PROPERTIES.getEndpoint());
        webElementActions.clickColorChange(demoqa.getDynamicPropertiesPage().colorChangeBtn);
        String classValue = driver.findElement(By.id("colorChange")).getAttribute("class");
        Assert.assertEquals(classValue, "mt-4 text-danger btn btn-primary");

    }

    @Test(description = "Verify is click button visible after 5 seconds")
    public void visibleAfterClickTest() {

        browserHelper.open(ConfigReader.getValue("baseURL") + DYNAMIC_PROPERTIES.getEndpoint());
        webElementActions.visibleAfterFiveSeconds(demoqa.getDynamicPropertiesPage().visibleAfterBtn);

    }

}
