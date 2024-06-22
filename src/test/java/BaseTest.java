import com.demoqa.drivers.DriverManager;
import com.demoqa.helper_vspomogatelnye_custom_metody.*;
import com.demoqa.pages_raznye_stranicy_get.DemoQA;
import com.demoqa.pages_raznye_stranicy_get.NBWalletPage;
import com.demoqa.utils.RandomUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    protected WebDriver driver;
    protected WebElementActions webElementActions;
    protected AlertHelper alertHelper;

    protected BrowserHelper browserHelper;
    protected IframeHelper iframeHelper;
    protected DropdownHelper dropdownHelper;
    protected CustomFluentWait customFluentWait;

    protected DemoQA demoqa;
    protected NBWalletPage nbWalletPage;
    protected RandomUtils randomUtils;

    @BeforeClass(alwaysRun = true)
    public void setUp() {

        driver = DriverManager.getDriver();
        webElementActions = new WebElementActions();
        alertHelper = new AlertHelper(driver);
        browserHelper = new BrowserHelper(driver);
        dropdownHelper = new DropdownHelper(driver);
        iframeHelper = new IframeHelper(driver);
        customFluentWait = new CustomFluentWait(driver);
        randomUtils = new RandomUtils();
        demoqa = new DemoQA();
        demoqa.setUp();
        nbWalletPage = new NBWalletPage();


    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws InterruptedException {

        Thread.sleep(3000);
        DriverManager.closeDriver();

    }

}
