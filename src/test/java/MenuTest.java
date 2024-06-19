import com.demoqa.pages_raznye_stranicy_get.BasePage;
import org.testng.annotations.Test;

public class MenuTest extends BaseTest {

    @Test(description = "Verify move to element methods is work")
    public void moveToElementTest() throws InterruptedException {
        browserHelper.open("https://demoqa.com/menu");
        webElementActions.moveToElement(demoqa.getMenuPage().mainItem2);
        Thread.sleep(5000);
    }

}
