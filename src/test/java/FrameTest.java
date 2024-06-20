
import com.demoqa.utils.ConfigReader;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.demoqa.enums.Endpoints.FRAMES;

public class FrameTest extends BaseTest {

    @Test(description = "Verify that driver can switch to another farame")
    public void switchToAnotherFrame() {

        browserHelper.open(ConfigReader.getValue("baseURL") + FRAMES.getEndpoint());
        iframeHelper.switchToFrame("frame1");
        System.out.println(driver.findElement(By.id("sampleHeading")).getText());
        iframeHelper.switchToParentFrame();
        System.out.println(driver.findElement(By.tagName("h1")).getText());

    }

}
