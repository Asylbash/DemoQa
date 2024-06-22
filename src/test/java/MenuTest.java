
import com.demoqa.utils.ConfigReader;
import org.testng.annotations.Test;

import static com.demoqa.enums.Endpoints.MENU;

public class MenuTest extends BaseTest {

    @Test(groups = {"Regression", "UI", "1110"}, description = "Verify move to element methods is work")
    public void moveToElementTest() throws InterruptedException {

        browserHelper.open(ConfigReader.getValue("baseURL") + MENU.getEndpoint());
        webElementActions.moveToElement(demoqa.getMenuPage().mainItem2);
        Thread.sleep(5000);

    }

}
