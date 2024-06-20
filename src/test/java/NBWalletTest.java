import com.demoqa.entities_polya_objects.NBWalletEntity;
import com.demoqa.utils.ConfigReader;
import io.qameta.allure.*;
import io.qameta.allure.testng.Tag;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class NBWalletTest extends BaseTest {

    @Description("verify if password is not empty")
    @Owner("Zhyldyz")
    @Tag("Smoke")
    @Severity(SeverityLevel.NORMAL)
    @Story("NBW-23")
    @Epic("Registration")
    @Link("http://188.225.14.33:8080/register")
    @Test(groups = {"Smoke", "UI", "NBW-23"}, description = "verify if password is not empty")
    public void nBWalletRegistrationTest() {

        browserHelper.open(ConfigReader.getValue("baseURL2"));
        NBWalletEntity nbWalletEntity = randomUtils.createRandomNBWalletEntity();
        nbWalletPage.fillUpNBWalletForm(nbWalletEntity);

        // Проверка, что поле пароля не пустое
        String passwordValue = nbWalletPage.passwordInput.getAttribute("value");
        assertTrue(!passwordValue.isEmpty(), "Password field should not be empty");

        // Проверка на наличие сообщения об ошибке
        if (!passwordValue.matches(".*[A-Z].*")) {
            assertTrue(nbWalletPage.alertMassage.isDisplayed(), "Error message should be displayed");
            assertEquals(nbWalletPage.alertMassage.getText(), "Passwords must have at least one uppercase ('A'-'Z').");
        }
    }

}

