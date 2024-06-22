import com.demoqa.utils.ConfigReader;
import org.testng.annotations.Test;

import static com.demoqa.enums.Endpoints.ALERT;

public class AlertTest extends BaseTest {

    @Test(groups = {"E2E", "UI", "1011"}, description = "Alert test")
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
    void alertTestDismiss() throws InterruptedException {
        browserHelper.open(ConfigReader.getValue("baseURL") + ALERT.getEndpoint());
        webElementActions.click(demoqa.getAlertPage().dismissAlertBtn);
        Thread.sleep(3000);
        alertHelper.dismissAlert();
        Thread.sleep(3000);
    }

    @Test(groups = {"E2E", "UI", "1012"}, description = "Alert test2")
    void isAlertPresentClick() throws InterruptedException {
        browserHelper.open(ConfigReader.getValue("baseURL") + ALERT.getEndpoint());
        webElementActions.click(demoqa.getAlertPage().seeAlertBtn);
        Thread.sleep(3000);
        alertHelper.isAlertPresent();
        Thread.sleep(3000);
    }

}
