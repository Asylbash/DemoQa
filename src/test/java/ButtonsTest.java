import com.demoqa.utils.ConfigReader;
import io.qameta.allure.*;
import io.qameta.allure.testng.Tag;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.demoqa.enums.Endpoints.BUTTONS;

public class ButtonsTest extends BaseTest {

    @Test(groups = {"Regression", "UI", "1210"}, description = "Verify double click button is working properly")
    @Description("verify is double click work correctly")
    @Owner("Zhyldyz")
    @Tag("Smoke")
    @Severity(SeverityLevel.CRITICAL)
    @Story("NBW-1")
    @Epic("Registration")
    @Link("www.demoqa.com")
    public void doubleClickTest() {

        browserHelper.open(ConfigReader.getValue("baseURL") + BUTTONS.getEndpoint());
        webElementActions.doubleClick(demoqa.getButtonsPage().doubleClickBtn);
        Assert.assertEquals(demoqa.getButtonsPage().doubleClickMessage.getText(), "You have done a double click");

    }

    @Test(groups = {"Regression", "UI", "1211"}, description = "Verify right click button is working properly")
    public void rightClickTest() {

        browserHelper.open(ConfigReader.getValue("baseURL") + BUTTONS.getEndpoint());
        webElementActions.rightClick(demoqa.getButtonsPage().rightClickBtn);
        Assert.assertEquals(demoqa.getButtonsPage().rightClickMessage.getText(), "You have done a right click");

    }

    @Test(groups = {"Regression", "UI", "1212"}, description = "Verify clickMe button is working properly")
    public void clickMeTest() {

        browserHelper.open(ConfigReader.getValue("baseURL") + BUTTONS.getEndpoint());
        webElementActions.click(demoqa.getButtonsPage().clickMeBtn);
        Assert.assertEquals(demoqa.getButtonsPage().clickMeMessage.getText(), "You have done a dynamic click");

    }
}
