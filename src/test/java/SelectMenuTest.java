
import com.demoqa.utils.ConfigReader;
import org.testng.annotations.Test;

import java.util.List;

import static com.demoqa.enums.Endpoints.SELECT_MENU;

public class SelectMenuTest extends BaseTest {
    @Test(description = "verify is collected in list all options")
    public void testGetAllSelectOptions() {

        browserHelper.open(ConfigReader.getValue("baseURL") + SELECT_MENU.getEndpoint());
        List<String> options = demoqa.getSelectMenuPage().getSelectOptions();
        for (String option : options) {
            System.out.println(option);
        }
    }

    @Test(description = "verify is collected in list all options")
    public void testGetAllDivSelectOptions() {

        browserHelper.open(ConfigReader.getValue("baseURL") + SELECT_MENU.getEndpoint());
        List<String> multiSelectDropDownOptions = demoqa.getSelectMenuPage().getMultiSelectDropDownOptions();
        List<String> selectOneOptions = demoqa.getSelectMenuPage().getSelectOneOptions();
        List<String> selectValueOptions = demoqa.getSelectMenuPage().getSelectValueOptions();
        List<String> standardMultiSelect = demoqa.getSelectMenuPage().getStandardMultiSelectDropDownOptions();

        System.out.println("Select One Options: " + selectOneOptions);
        System.out.println("Select Value Options: " + selectValueOptions);
        System.out.println("MultiSelect Drop Down Options: " + multiSelectDropDownOptions);
        System.out.println("Standard MultiSelect Drop Down Options: " + standardMultiSelect);

    }

}
//@FindBy(xpath = "//div[contains(@class,'option')]")
//public List<WebElement> selectValueOptions;