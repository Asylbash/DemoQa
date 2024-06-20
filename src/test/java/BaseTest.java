import com.demoqa.drivers.DriverManager;
import com.demoqa.helper_vspomogatelnye_custom_metody.*;
import com.demoqa.pages_raznye_stranicy_get.*;
import com.demoqa.utils.RandomUtils;
import homeworksPractice.elements.timer.Demoqa;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    protected WebDriver driver;
    protected RandomUtils randomUtils;
    protected WebElementActions webElementActions;
    protected AlertHelper alertHelper;

    protected BrowserHelper browserHelper;
    protected DropdownHelper dropdownHelper;
    protected IframeHelper iframeHelper;

    protected DemoQA demoqa;
    protected NBWalletPage nbWalletPage;

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        driver = DriverManager.getDriver();
        randomUtils = new RandomUtils();
        webElementActions = new WebElementActions();
        alertHelper = new AlertHelper(driver);
        browserHelper = new BrowserHelper(driver);
        dropdownHelper = new DropdownHelper(driver);
        demoqa = new DemoQA();
        demoqa.setUp();
        iframeHelper = new IframeHelper(driver);
        nbWalletPage = new NBWalletPage();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        DriverManager.closeDriver();
    }
}