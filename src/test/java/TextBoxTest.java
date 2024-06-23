
import com.demoqa.entities_polya_objects.TextBoxEntity;
import com.demoqa.utils.ConfigReader;
import io.qameta.allure.*;
import io.qameta.allure.testng.Tag;
import org.testng.annotations.Test;

import static com.demoqa.enums.Endpoints.TEXT_BOX;

public class TextBoxTest extends BaseTest {

    @Test(groups = {"Smoke", "UI", "1310"}, description = "verify is all field is filled up")
    @Owner("Zhyldyz")
    @Tag("Smoke")
    @Severity(SeverityLevel.NORMAL)
    @Story("1310")
    @Epic("TextBox")
    @Link("www.demoqa.com")
    public void textBoxTest() {

        browserHelper.open(ConfigReader.getValue("baseURL") + TEXT_BOX.getEndpoint());
        TextBoxEntity textBoxEntity = randomUtils.generateRandomTextBoxEntity();
        demoqa.getTextBoxPage().fillUpTextBoxForm(textBoxEntity);

    }
}
