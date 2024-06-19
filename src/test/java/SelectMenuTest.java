import com.demoqa.pages_raznye_stranicy_get.BasePage;
import org.testng.annotations.Test;

import java.util.List;

public class SelectMenuTest extends BaseTest {
    @Test
    public void testGetAllSelectOptions() {
        driver.get("https://demoqa.com/select-menu");
        List<String> options = demoqa.getSelectMenuPage().getSelectOptions();
        for (String option : options) {
            System.out.println(option);
        }
    }

    @Test
    public void testGetAllDivSelectOptions() {
        driver.get("https://demoqa.com/select-menu");
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