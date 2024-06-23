
import com.demoqa.utils.ConfigReader;
import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.demoqa.enums.Endpoints.FRAMES;

public class FrameTest extends BaseTest {

    @Test(description = "Verify that driver can switch to another farame")
    @Owner("Zhyldyz")
   // @Tag("E2E")
    @Severity(SeverityLevel.NORMAL)
   // @Story("1012")
    @Epic("Frames")
    @Link("www.demoqa.com")
    public void switchToAnotherFrame() {

        browserHelper.open(ConfigReader.getValue("baseURL") + FRAMES.getEndpoint());
        iframeHelper.switchToFrame("frame1");
        System.out.println(driver.findElement(By.id("sampleHeading")).getText());
        iframeHelper.switchToParentFrame();
        System.out.println(driver.findElement(By.tagName("h1")).getText());

    }

}
