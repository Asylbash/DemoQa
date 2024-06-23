import com.demoqa.utils.ConfigReader;
import io.qameta.allure.*;
import io.qameta.allure.testng.Tag;
import org.testng.annotations.Test;

import static com.demoqa.enums.Endpoints.ALERT;

public class AlertTest extends BaseTest {

    @Test(groups = {"E2E", "UI", "1011"}, description = "Alert test")
    @Owner("Zhyldyz")
    @Tag("E2E")
    @Severity(SeverityLevel.NORMAL)
    @Story("1011")
    @Epic("Alerts")
    @Link("www.demoqa.com")
    void alertTestAccept() throws InterruptedException {
        browserHelper.open(ConfigReader.getValue("baseURL") + ALERT.getEndpoint());
        webElementActions.click(demoqa.getAlertPage().confirmAlertBtn);
        Thread.sleep(3000);
        alertHelper.acceptAlert();
        Thread.sleep(3000);

        webElementActions.click(demoqa.getAlertPage().promtBtn);
        // Ожидание алерта и ввод текста
        alertHelper.acceptPromptZh("hi");
    }

    @Test(groups = {"E2E", "UI", "1010"}, description = "Alert test1")
    @Owner("Zhyldyz")
    @Tag("E2E")
    @Severity(SeverityLevel.NORMAL)
    @Story("1010")
    @Epic("Alerts")
    @Link("www.demoqa.com")
    void alertTestDismiss() throws InterruptedException {
        browserHelper.open(ConfigReader.getValue("baseURL") + ALERT.getEndpoint());
        webElementActions.click(demoqa.getAlertPage().dismissAlertBtn);
        Thread.sleep(3000);
        alertHelper.dismissAlert();
        Thread.sleep(3000);
    }

    @Test(groups = {"E2E", "UI", "1012"}, description = "Alert test2")
    @Owner("Zhyldyz")
    @Tag("E2E")
    @Severity(SeverityLevel.NORMAL)
    @Story("1012")
    @Epic("Alerts")
    @Link("www.demoqa.com")
    void isAlertPresentClick() throws InterruptedException {
        browserHelper.open(ConfigReader.getValue("baseURL") + ALERT.getEndpoint());
        webElementActions.click(demoqa.getAlertPage().seeAlertBtn);
        Thread.sleep(3000);
        alertHelper.isAlertPresent();
        Thread.sleep(3000);
    }

}
