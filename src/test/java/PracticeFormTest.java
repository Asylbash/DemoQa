import com.demoqa.entities_polya_objects.PracticeFormEntity;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class PracticeFormTest extends BaseTest {

    @Test
    public void practiceFormTest() {
        driver.get("https://demoqa.com/automation-practice-form");
        PracticeFormEntity practiceFormEntity = randomUtils.generateRandomPracticeFormEntity();
        demoqa.getPracticeFormPage().fillUpPracticeForm(practiceFormEntity);
//        Assert.assertTrue(true);
//        String confirmationMessage = driver.findElement(By.xpath("//*[text()='Thanks for submitting the form']")).getText();
//        assertEquals(confirmationMessage, "Thanks for submitting the form");
////        WebElement confirmationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Thanks for submitting the form']")));

    }

    @Test
    public void practiceFormTestDate() throws InterruptedException {
        driver.get("https://demoqa.com/automation-practice-form");
        demoqa.getPracticeFormPage().selectDateMonthYear("29 September 1985");
        Thread.sleep(4000);
    }
//    @Test
//    public void list(){
//        driver.get("https://demoqa.com/automation-practice-form");
//        practiceFormPage.collectFormElements("//*[@class=' css-26l3qy-menu']/div/div[contains(@class, 'option')]");
//    }
}
