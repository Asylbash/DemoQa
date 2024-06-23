
import com.demoqa.utils.ConfigReader;
import io.qameta.allure.*;
import io.qameta.allure.testng.Tag;
import org.testng.annotations.Test;

import static com.demoqa.enums.Endpoints.MENU;

public class MenuTest extends BaseTest {

    @Test(groups = {"Regression", "UI", "1110"}, description = "Verify move to element methods is work")
    @Owner("Zhyldyz")
    @Tag("Regression")
    @Severity(SeverityLevel.NORMAL)
    @Story("1110")
    @Epic("Menu")
    @Link("www.demoqa.com")
    public void moveToElementTest() throws InterruptedException {

        browserHelper.open(ConfigReader.getValue("baseURL") + MENU.getEndpoint());
        webElementActions.moveToElement(demoqa.getMenuPage().mainItem2);
        Thread.sleep(5000);

    }

}
