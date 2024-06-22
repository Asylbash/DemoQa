
import com.demoqa.entities_polya_objects.PracticeFormEntity;
import com.demoqa.utils.ConfigReader;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.demoqa.enums.Endpoints.PRACTICE_FORM;
import static org.testng.AssertJUnit.assertEquals;

public class PracticeFormTest extends BaseTest {

    @Test(groups = {"Smoke", "UI", "1410"}, description = "verify is all field is filled up")
    public void practiceFormTest() {
        browserHelper.open(ConfigReader.getValue("baseURL") + PRACTICE_FORM.getEndpoint());
        PracticeFormEntity practiceFormEntity = randomUtils.generateRandomPracticeFormEntity();
        demoqa.getPracticeFormPage().fillUpPracticeForm(practiceFormEntity);
        Assert.assertTrue(true);
        String confirmationMessage = driver.findElement(By.xpath("//*[text()='Thanks for submitting the form']")).getText();
        assertEquals(confirmationMessage, "Thanks for submitting the form");
    }

    @Test(groups = {"Smoke", "UI", "1411"}, description = "verify is all field is filled up")
    public void practiceFormTestDate() throws InterruptedException {
        browserHelper.open(ConfigReader.getValue("baseURL") + PRACTICE_FORM.getEndpoint());
        demoqa.getPracticeFormPage().selectDateMonthYear("29 September 1985");
        Thread.sleep(4000);
    }

}
