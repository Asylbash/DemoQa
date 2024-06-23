
import com.demoqa.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static com.demoqa.enums.Endpoints.SELECT_MENU;

public class SelectDemoTest extends BaseTest {
    @Test(description = "verify is selected one option")
    void oldSelectMenuTest() throws InterruptedException {

        browserHelper.open(ConfigReader.getValue("baseURL") + SELECT_MENU.getEndpoint());
        WebElement selectMenu = driver.findElement(By.id("oldSelectMenu"));
//        DropdownHelper dropdownHelper = new DropdownHelper(driver);
        dropdownHelper.selectByVisibleText(selectMenu, "Green");
        Thread.sleep(5000);
    }

}
