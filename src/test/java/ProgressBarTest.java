import com.demoqa.drivers.DriverManager;
import com.demoqa.utils.ConfigReader;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;


import static com.demoqa.enums.Endpoints.PROGRESS_BAR;
import static org.testng.Assert.assertEquals;

public class ProgressBarTest extends BaseTest {

    @Test(description = "Verify is progress bar stopping at 70")
    public void progressBarTest() throws InterruptedException {

        browserHelper.open(ConfigReader.getValue("baseURL") + PROGRESS_BAR.getEndpoint());
        //webElementActions.click(progressBarPage.startStopButton);
        demoqa.getProgressBarPage().startProgressBar();
        Thread.sleep(2000);
        webElementActions.click(demoqa.getProgressBarPage().startStopButton);
        Thread.sleep(6000);

        System.out.println(demoqa.getProgressBarPage().aria_valuenow.getAttribute("aria-valuenow"));
        assertEquals(demoqa.getProgressBarPage().aria_valuenow.getAttribute("aria-valuenow"), "70");

    }

    @Test(description = "Test progress bar stopping at 53%")
    public void testProgressBarAt53Percent() {
        browserHelper.open(ConfigReader.getValue("baseURL") + PROGRESS_BAR.getEndpoint());
        demoqa.getProgressBarPage().startProgressBar();

        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
        wait.until(driver -> {

                    int value = Integer.parseInt(demoqa.getProgressBarPage().aria_valuenow.getAttribute("aria-valuenow"));
                    System.out.println("Current progress: " + value + "%");
                    if (value >= 53) {
                        demoqa.getProgressBarPage().startStopButton.click(); // Останавливаем прогресс-бар
                        return true;
                    }
                    return false;
                }
        );

        int progressBarValue = demoqa.getProgressBarPage().getProgressBarValue();
        assertEquals(progressBarValue, 53, "Progress bar should be at 53%");
    }

    @Test(description = "Test progress bar stopping at 52%")
    public void testProgressBarAt52Percent1() {
        browserHelper.open(ConfigReader.getValue("baseURL") + PROGRESS_BAR.getEndpoint());
        demoqa.getProgressBarPage().startProgressBar();
        while (true) {

            String value = demoqa.getProgressBarPage().aria_valuenow.getAttribute("aria-valuenow");
            System.out.println("Current progress: " + value + "%");
            if (value.equals("52")) {
                demoqa.getProgressBarPage().startStopButton.click();
                break;
            }
        }
        String progressBarValue = demoqa.getProgressBarPage().aria_valuenow.getAttribute("aria-valuenow");
        assertEquals(progressBarValue, "52", "Progress bar should be at 52%");
    }

}


