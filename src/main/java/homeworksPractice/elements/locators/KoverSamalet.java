package homeworksPractice.elements.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import java.time.Duration;
import java.util.List;

public class KoverSamalet {
    WebDriver driver;

    @BeforeSuite
    void openBrowser() {
        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://dostavka312.kg/");
    }

    @AfterSuite
    void closeBrowser() {

        driver.close();
        driver.quit();
    }

    @BeforeClass
    public void onlineFoodOrderWeb() {

        WebElement linkOnPageOfRestaurants = driver.findElement(By.xpath("//span[normalize-space(text())='Eды']"));
        linkOnPageOfRestaurants.click();

        List<WebElement> listOfRestaurants = driver.findElements(By.xpath("//div[@class='panel-heading']//p[1]"));

        listOfRestaurants.forEach(s -> System.out.println(s.getText()));
        System.out.println("Total Number of Restaurants: " + listOfRestaurants.size());

        WebElement restaurantPishpek = listOfRestaurants.stream()
                .filter(element -> element.getText().equals("Ресторан Пишпек"))
                .findFirst()
                .orElse(null);

        if (restaurantPishpek != null) {
            WebElement pishpek = driver.findElement(By.xpath("//a[@href=\"https://dostavka312.kg/garnirygpt/restoran-pishpek\"]"));
            pishpek.click();
            System.out.println("\nМеню Ресторан Пишпек");
        } else {
            System.out.println("\nРесторан Пишпек закрыт");
        }

    }

    @Test(dataProvider = "menu")
    void printMenu(String menuXPath, String headerXPath) {
        WebElement menuLink = driver.findElement(By.xpath(menuXPath));
        menuLink.click();
        WebElement menuHeader = driver.findElement(By.xpath(headerXPath));
        System.out.println("\n" + menuHeader.getText());
        WebElement productSection = menuHeader.findElement(By.xpath("./following-sibling::div[contains(@class, 'product')]"));
        List<WebElement> menuItems = productSection.findElements(By.xpath(".//div[@class='food-title']/p[@class='product-name']"));
        menuItems.stream()
                .map(WebElement::getText)
                .forEach(System.out::println);
    }

    @DataProvider(name = "menu")
    public String[][] menu() {
        return new String[][]{

                {"//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_0']", "//h2[a[@name='menu_0']]"},
                {"//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_1']", "//h2[a[@name='menu_1']]"},
                {"//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_2']", "//h2[a[@name='menu_2']]"},
                {"//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_3']", "//h2[a[@name='menu_3']]"},
                {"//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_4']", "//h2[a[@name='menu_4']]"},
                {"//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_5']", "//h2[a[@name='menu_5']]"},
                {"//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_6']", "//h2[a[@name='menu_6']]"},
                {"//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_7']", "//h2[a[@name='menu_7']]"},
                {"//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_8']", "//h2[a[@name='menu_8']]"},
                {"//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_9']", "//h2[a[@name='menu_9']]"},
                {"//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_10']", "//h2[a[@name='menu_10']]"},
                {"//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_11']", "//h2[a[@name='menu_11']]"},
                {"//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_12']", "//h2[a[@name='menu_12']]"},
                {"//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_13']", "//h2[a[@name='menu_13']]"},
                {"//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_14']", "//h2[a[@name='menu_14']]"},
                {"//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_15']", "//h2[a[@name='menu_15']]"},
                {"//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_16']", "//h2[a[@name='menu_16']]"},
                {"//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_17']", "//h2[a[@name='menu_17']]"},
                {"//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_18']", "//h2[a[@name='menu_18']]"},
                {"//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_19']", "//h2[a[@name='menu_19']]"},
                {"//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_20']", "//h2[a[@name='menu_20']]"},
                {"//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_21']", "//h2[a[@name='menu_21']]"},
                {"//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_22']", "//h2[a[@name='menu_22']]"},
                {"//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_23']", "//h2[a[@name='menu_23']]"},
                {"//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_24']", "//h2[a[@name='menu_24']]"}

        };
    }
}




























//  List<WebElement> hotRollsList = driver.findElements(By.xpath("//*[@id='WWMainPage']/div[21]"));
//    @Test
//    public void restaurantPishpekBreakfastMenu() {
//        printMenu("//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_0']", "//h2[a[@name='menu_0']]");
//    }
//
//    @Test
//    public void restaurantPishpekColdSnackMenu() {
//        printMenu("//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_1']", "//h2[a[@name='menu_1']]");
//    }
//
//    @Test
//    public void restaurantPishpekSaladsMenu() {
//        printMenu("//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_2']", "//h2[a[@name='menu_2']]");
//    }
//
//    @Test
//    public void restaurantPishpekSoupsMenu() {
//        printMenu("//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_3']", "//h2[a[@name='menu_3']]");
//    }
//
//    @Test
//    public void restaurantPishpekHotOrientalDishesMenu() {
//        printMenu("//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_4']", "//h2[a[@name='menu_4']]");
//    }
//
//    @Test
//    public void restaurantPishpekCreamSoupsMenu() {
//        printMenu("//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_5']", "//h2[a[@name='menu_5']]");
//    }
//
//    @Test
//    public void restaurantPishpekOrientalSoupsMenu() {
//        printMenu("//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_6']", "//h2[a[@name='menu_6']]");
//    }
//
//    @Test
//    public void restaurantPishpekHotAppetizersMenu() {
//        printMenu("//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_7']", "//h2[a[@name='menu_7']]");
//    }
//
//    @Test
//    public void restaurantPishpekBakeryMenu() {
//        printMenu("//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_8']", "//h2[a[@name='menu_8']]");
//    }
//
//    @Test
//    public void restaurantPishpekPastaMenu() {
//        printMenu("//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_9']", "//h2[a[@name='menu_9']]");
//    }
//
//    @Test
//    public void restaurantPishpekSteaksMenu() {
//        printMenu("//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_10']", "//h2[a[@name='menu_10']]");
//    }
//
//    @Test
//    public void restaurantPishpekHotEuropeanDishesMenu() {
//        printMenu("//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_11']", "//h2[a[@name='menu_11']]");
//    }
//
//    @Test
//    public void restaurantPishpekFishMenu() {
//        printMenu("//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_12']", "//h2[a[@name='menu_12']]");
//    }
//
//    @Test
//    public void restaurantPishpekKebabMenu() {
//        printMenu("//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_13']", "//h2[a[@name='menu_13']]");
//    }
//
//    @Test
//    public void restaurantPishpekDishesForCompanyMenu() {
//        printMenu("//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_14']", "//h2[a[@name='menu_14']]");
//    }
//
//    @Test
//    public void restaurantPishpekSideDishesMenu() {
//        printMenu("//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_15']", "//h2[a[@name='menu_15']]");
//    }
//
//    @Test
//    public void restaurantPishpekSaucesMenu() {
//        printMenu("//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_16']", "//h2[a[@name='menu_16']]");
//    }
//
//    @Test
//    public void restaurantPishpekPizzaMenu() {
//        printMenu("//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_17']", "//h2[a[@name='menu_17']]");
//    }
//
//    @Test
//    public void restaurantPishpekDessertMenu() {
//        printMenu("//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_18']", "//h2[a[@name='menu_18']]");
//    }
//
//    @Test
//    public void restaurantPishpekRollsMenu() {
//        printMenu("//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_19']", "//h2[a[@name='menu_19']]");
//    }
//
//    @Test
//    public void restaurantPishpekHotRollsMenu() {
//        printMenu("//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_20']", "//h2[a[@name='menu_20']]");
//    }
//
//    @Test
//    public void restaurantPishpekClassicRollsMenu() {
//        printMenu("//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_21']", "//h2[a[@name='menu_21']]");
//    }
//
//    @Test
//    public void restaurantPishpekAssortedRollsMenu() {
//        printMenu("//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_22']", "//h2[a[@name='menu_22']]");
//    }
//
//    @Test
//    public void restaurantPishpekLemonadesMenu() {
//        printMenu("//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_23']", "//h2[a[@name='menu_23']]");
//    }
//
//    @Test
//    public void restaurantPishpekColdDrinksMenu() {
//        printMenu("//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_24']", "//h2[a[@name='menu_24']]");
//    }
//
//    private void printMenu(String menuXPath, String headerXPath) {
//        WebElement menuLink = driver.findElement(By.xpath(menuXPath));
//        menuLink.click();
//        WebElement menuHeader = driver.findElement(By.xpath(headerXPath));
//        System.out.println("\n" + menuHeader.getText());
//        WebElement productSection = menuHeader.findElement(By.xpath("./following-sibling::div[contains(@class, 'product')]"));
//        List<WebElement> menuItems = productSection.findElements(By.xpath(".//div[@class='food-title']/p[@class='product-name']"));
//        menuItems.stream()
//                .map(WebElement::getText)
//                .forEach(System.out::println);
//    }


//    @Test
//    void restaurantPishpekBreakfastMenu() {
//        WebElement salads = driver.findElement(By.xpath("//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_0']"));
//        salads.click();
//        WebElement saladsHeader = driver.findElement(By.xpath("//h2[a[@name='menu_0']]"));
//        System.out.println("\n" + saladsHeader.getText());
//        WebElement productSalads = saladsHeader.findElement(By.xpath("./following-sibling::div[contains(@class, 'product')]"));
//        List<WebElement> menuSalads = productSalads.findElements(By.xpath(".//div[@class='food-title']/p[@class='product-name']"));
//        menuSalads.stream()
//                .map(WebElement::getText)
//                .forEach(System.out::println);
//
//    }
//
//    @Test
//    void restaurantPishpekColdSnackMenu() {
//
//        WebElement coldSnacksFast = driver.findElement(By.xpath("//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_1']"));
//        coldSnacksFast.click();
//        WebElement coldSnacksHeader = driver.findElement(By.xpath("//h2[a[@name='menu_1']]"));
//        System.out.println("\n" + coldSnacksHeader.getText());
//        WebElement productColdSnacks = coldSnacksHeader.findElement(By.xpath("./following-sibling::div[contains(@class, 'product')]"));
//        List<WebElement> menuColdSnacks = productColdSnacks.findElements(By.xpath(".//div[@class='food-title']/p[@class='product-name']"));
//        menuColdSnacks.stream()
//                .map(WebElement::getText)
//                .forEach(System.out::println);
//
//    }
//
//    @Test
//    void restaurantPishpekSaladsMenu() {
//        WebElement salads = driver.findElement(By.xpath("//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_2']"));
//        salads.click();
//        WebElement saladsHeader = driver.findElement(By.xpath("//h2[a[@name='menu_2']]"));
//        System.out.println("\n" + saladsHeader.getText());
//        WebElement productSalads = saladsHeader.findElement(By.xpath("./following-sibling::div[contains(@class, 'product')]"));
//        List<WebElement> menuSalads = productSalads.findElements(By.xpath(".//div[@class='food-title']/p[@class='product-name']"));
//        menuSalads.stream()
//                .map(WebElement::getText)
//                .forEach(System.out::println);
//
//    }
//
//    @Test
//    void restaurantPishpekSoupsMenu() {
//        WebElement soups = driver.findElement(By.xpath("//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_3']"));
//        soups.click();
//        WebElement soupsHeader = driver.findElement(By.xpath("//h2[a[@name='menu_3']]"));
//        System.out.println("\n" + soupsHeader.getText());
//        WebElement productSoups = soupsHeader.findElement(By.xpath("./following-sibling::div[contains(@class, 'product')]"));
//        List<WebElement> menuSoups = productSoups.findElements(By.xpath(".//div[@class='food-title']/p[@class='product-name']"));
//        menuSoups.forEach(System.out::println);
////                .map(WebElement::getText)
////                .forEach(System.out::println);
//
//    }
//
//    @Test
//    void restaurantPishpekOrientalDishesMenu() {
//        WebElement orientalDishes = driver.findElement(By.xpath("//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_4']"));
//        orientalDishes.click();
//        WebElement orientalDishesHeader = driver.findElement(By.xpath("//h2[a[@name='menu_4']]"));
//        System.out.println("\n" + orientalDishesHeader.getText());
//        WebElement productOrientalDishes = orientalDishesHeader.findElement(By.xpath("./following-sibling::div[contains(@class, 'product')]"));
//        List<WebElement> menuOrientalDishes = productOrientalDishes.findElements(By.xpath(".//div[@class='food-title']/p[@class='product-name']"));
//        menuOrientalDishes.stream()
//                .map(WebElement::getText)
//                .forEach(System.out::println);
//    }
//
//    @Test
//    void restaurantPishpekCreamSoupsMenu() {
//        WebElement creamSoups = driver.findElement(By.xpath("//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_5']"));
//        creamSoups.click();
//        WebElement creamSoupsHeader = driver.findElement(By.xpath("//h2[a[@name='menu_5']]"));
//        System.out.println("\n" + creamSoupsHeader.getText());
//        WebElement productCreamSoups = creamSoupsHeader.findElement(By.xpath("./following-sibling::div[contains(@class, 'product')]"));
//        List<WebElement> menuCreamSoups = productCreamSoups.findElements(By.xpath(".//div[@class='food-title']/p[@class='product-name']"));
//        menuCreamSoups.stream()
//                .map(WebElement::getText)
//                .forEach(System.out::println);
//    }
//
//    @Test
//    void restaurantPishpekOrientalSoupsMenu() {
//
//        WebElement orientalSoups = driver.findElement(By.xpath("//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_6']"));
//        orientalSoups.click();
//        WebElement orientalSoupsHeader = driver.findElement(By.xpath("//h2[a[@name='menu_6']]"));
//        System.out.println("\n" + orientalSoupsHeader.getText());
//        WebElement productOrientalSoups = orientalSoupsHeader.findElement(By.xpath("./following-sibling::div[contains(@class, 'product')]"));
//        List<WebElement> menuOrientalSoups = productOrientalSoups.findElements(By.xpath(".//div[@class='food-title']/p[@class='product-name']"));
//        menuOrientalSoups.stream()
//                .map(WebElement::getText)
//                .forEach(System.out::println);
//
//    }
//
//    @Test
//    void restaurantPishpekAppetizersMenu() {
//        WebElement hotAppetizers = driver.findElement(By.xpath("//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_7']"));
//        hotAppetizers.click();
//        WebElement hotAppetizersHeader = driver.findElement(By.xpath("//h2[a[@name='menu_7']]"));
//        System.out.println("\n" + hotAppetizersHeader.getText());
//        WebElement productHotAppetizers = hotAppetizersHeader.findElement(By.xpath("./following-sibling::div[contains(@class, 'product')]"));
//        List<WebElement> menuHotAppetizers = productHotAppetizers.findElements(By.xpath(".//div[@class='food-title']/p[@class='product-name']"));
//        menuHotAppetizers.stream()
//                .map(WebElement::getText)
//                .forEach(System.out::println);
//
//    }
//
//    @Test
//    void restaurantPishpekBakeryMenu() {
//        WebElement bakery = driver.findElement(By.xpath("//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_8']"));
//        bakery.click();
//        WebElement bakeryHeader = driver.findElement(By.xpath("//h2[a[@name='menu_8']]"));
//        System.out.println("\n" + bakeryHeader.getText());
//        WebElement productBakery = bakeryHeader.findElement(By.xpath("./following-sibling::div[contains(@class, 'product')]"));
//        List<WebElement> menuBakery = productBakery.findElements(By.xpath(".//div[@class='food-title']/p[@class='product-name']"));
//        menuBakery.stream()
//                .map(WebElement::getText)
//                .forEach(System.out::println);
//    }
//
//    @Test
//    void restaurantPishpekPstaMenu() {
//
//        WebElement pasta = driver.findElement(By.xpath("//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_9']"));
//        pasta.click();
//        WebElement pastaHeader = driver.findElement(By.xpath("//h2[a[@name='menu_9']]"));
//        System.out.println("\n" + pastaHeader.getText());
//        WebElement productPasta = pastaHeader.findElement(By.xpath("./following-sibling::div[contains(@class, 'product')]"));
//        List<WebElement> menuPasta = productPasta.findElements(By.xpath(".//div[@class='food-title']/p[@class='product-name']"));
//        menuPasta.stream()
//                .map(WebElement::getText)
//                .forEach(System.out::println);
//    }
//
//    @Test
//    void restaurantPishpekSteaksMenu() {
//        WebElement steaks = driver.findElement(By.xpath("//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_10']"));
//        steaks.click();
//        WebElement steaksHeader = driver.findElement(By.xpath("//h2[a[@name='menu_10']]"));
//        System.out.println("\n" + steaksHeader.getText());
//        WebElement productSteaks = steaksHeader.findElement(By.xpath("./following-sibling::div[contains(@class, 'product')]"));
//        List<WebElement> menuSteaks = productSteaks.findElements(By.xpath(".//div[@class='food-title']/p[@class='product-name']"));
//        menuSteaks.stream()
//                .map(WebElement::getText)
//                .forEach(System.out::println);
//    }
//
//    @Test
//    void restaurantPishpekHotEuropeanDishesMenu() {
//
//        WebElement hotEuropeanDishes = driver.findElement(By.xpath("//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_11']"));
//        hotEuropeanDishes.click();
//        WebElement hotEuropeanDishesHeader = driver.findElement(By.xpath("//h2[a[@name='menu_11']]"));
//        System.out.println("\n" + hotEuropeanDishesHeader.getText());
//        WebElement productHotEuropeanDishes = hotEuropeanDishesHeader.findElement(By.xpath("./following-sibling::div[contains(@class, 'product')]"));
//        List<WebElement> menuHotEuropeanDishes = productHotEuropeanDishes.findElements(By.xpath(".//div[@class='food-title']/p[@class='product-name']"));
//        menuHotEuropeanDishes.stream()
//                .map(WebElement::getText)
//                .forEach(System.out::println);
//    }
//
//    @Test
//    void restaurantPishpekFishDishesMenu() {
//        WebElement fishDishes = driver.findElement(By.xpath("//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_12']"));
//        fishDishes.click();
//        WebElement fishDishesHeader = driver.findElement(By.xpath("//h2[a[@name='menu_12']]"));
//        System.out.println("\n" + fishDishesHeader.getText());
//        WebElement productFishDishes = fishDishesHeader.findElement(By.xpath("./following-sibling::div[contains(@class, 'product')]"));
//        List<WebElement> menuFishDishes = productFishDishes.findElements(By.xpath(".//div[@class='food-title']/p[@class='product-name']"));
//        menuFishDishes.stream()
//                .map(WebElement::getText)
//                .forEach(System.out::println);
//    }
//
//    @Test
//    void restaurantPishpekKebabsMenu() {
//
//        WebElement kebabs = driver.findElement(By.xpath("//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_13']"));
//        kebabs.click();
//        WebElement kebabsHeader = driver.findElement(By.xpath("//h2[a[@name='menu_13']]"));
//        System.out.println("\n" + kebabsHeader.getText());
//        WebElement productKebabs = kebabsHeader.findElement(By.xpath("./following-sibling::div[contains(@class, 'product')]"));
//        List<WebElement> menuKebabs = productKebabs.findElements(By.xpath(".//div[@class='food-title']/p[@class='product-name']"));
//        menuKebabs.stream()
//                .map(WebElement::getText)
//                .forEach(System.out::println);
//    }
//
//    @Test
//    void restaurantPishpekDishesForACompanyMenu() {
//
//        WebElement dishesForACompany = driver.findElement(By.xpath("//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_14']"));
//        dishesForACompany.click();
//        WebElement dishesForACompanyHeader = driver.findElement(By.xpath("//h2[a[@name='menu_14']]"));
//        System.out.println("\n" + dishesForACompanyHeader.getText());
//        WebElement productDishesForACompany = dishesForACompanyHeader.findElement(By.xpath("./following-sibling::div[contains(@class, 'product')]"));
//        List<WebElement> menuDishesForACompany = productDishesForACompany.findElements(By.xpath(".//div[@class='food-title']/p[@class='product-name']"));
//        menuDishesForACompany.stream()
//                .map(WebElement::getText)
//                .forEach(System.out::println);
//    }
//
//    @Test
//    void restaurantPishpekSideDishesMenu() {
//
//        WebElement sideDishes = driver.findElement(By.xpath("//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_15']"));
//        sideDishes.click();
//        WebElement sideDishesHeader = driver.findElement(By.xpath("//h2[a[@name='menu_15']]"));
//        System.out.println("\n" + sideDishesHeader.getText());
//        WebElement productSideDishes = sideDishesHeader.findElement(By.xpath("./following-sibling::div[contains(@class, 'product')]"));
//        List<WebElement> menuSideDishes = productSideDishes.findElements(By.xpath(".//div[@class='food-title']/p[@class='product-name']"));
//        menuSideDishes.stream()
//                .map(WebElement::getText)
//                .forEach(System.out::println);
//    }
//
//    @Test
//    void restaurantPishpekSaucesMenu() {
//
//        WebElement sauces = driver.findElement(By.xpath("//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_16']"));
//        sauces.click();
//        WebElement saucesHeader = driver.findElement(By.xpath("//h2[a[@name='menu_16']]"));
//        System.out.println("\n" + saucesHeader.getText());
//        WebElement productSauces = saucesHeader.findElement(By.xpath("./following-sibling::div[contains(@class, 'product')]"));
//        List<WebElement> menuSauces = productSauces.findElements(By.xpath(".//div[@class='food-title']/p[@class='product-name']"));
//        menuSauces.stream()
//                .map(WebElement::getText)
//                .forEach(System.out::println);
//
//    }
//
//    @Test
//    void restaurantPishpekPizzaMenu() {
//
//        WebElement pizza = driver.findElement(By.xpath("//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_17']"));
//        pizza.click();
//        WebElement pizzaHeader = driver.findElement(By.xpath("//h2[a[@name='menu_17']]"));
//        System.out.println("\n" + pizzaHeader.getText());
//        WebElement productPizza = pizzaHeader.findElement(By.xpath("./following-sibling::div[contains(@class, 'product')]"));
//        List<WebElement> menuPizza = productPizza.findElements(By.xpath(".//div[@class='food-title']/p[@class='product-name']"));
//        menuPizza.stream()
//                .map(WebElement::getText)
//                .forEach(System.out::println);
//    }
//
//    @Test
//    void restaurantPishpekDessertMenu() {
//        WebElement dessert = driver.findElement(By.xpath("//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_18']"));
//        dessert.click();
//        WebElement dessertHeader = driver.findElement(By.xpath("//h2[a[@name='menu_18']]"));
//        System.out.println("\n" + dessertHeader.getText());
//        WebElement productDessert = dessertHeader.findElement(By.xpath("./following-sibling::div[contains(@class, 'product')]"));
//        List<WebElement> menuDessert = productDessert.findElements(By.xpath(".//div[@class='food-title']/p[@class='product-name']"));
//        menuDessert.stream()
//                .map(WebElement::getText)
//                .forEach(System.out::println);
//    }
//
//    @Test
//    void restaurantPishpekRollsMenu() {
//        WebElement rolls = driver.findElement(By.xpath("//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_19']"));
//        rolls.click();
//        WebElement textRolls = driver.findElement(By.xpath("//h2[a[@name='menu_19']]"));
//        System.out.println(" " + " " + textRolls.getText());
//        WebElement listRolls = textRolls.findElement(By.xpath("./following-sibling::div[contains(@class, 'product')]"));
//
//        List<WebElement> menuRolls = listRolls.findElements(By.xpath(".//div[@class='food-title']/p[@class='product-name']"));
//        menuRolls.stream()
//                .map(WebElement::getText)
//                .forEach(System.out::println);
//    }
//
//    @Test
//    void restaurantPishpekHotRollsMenu() {
//        WebElement hotRolls = driver.findElement(By.xpath("//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_20']"));
//        hotRolls.click();
//        WebElement hotRollsHeader = driver.findElement(By.xpath("//h2[a[@name='menu_20']]"));
//        System.out.println("\n" + hotRollsHeader.getText());
//        WebElement productHotRolls = hotRollsHeader.findElement(By.xpath("./following-sibling::div[contains(@class, 'product')]"));
//        List<WebElement> menuHotRolls = productHotRolls.findElements(By.xpath(".//div[@class='food-title']/p[@class='product-name']"));
//        menuHotRolls.stream()
//                .map(WebElement::getText)
//                .forEach(System.out::println);
//    }
//
//    @Test
//    void restaurantPishpekClassicRollsMenu() {
//        WebElement classicRolls = driver.findElement(By.xpath("//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_21']"));
//        classicRolls.click();
//        WebElement classicRollsHeader = driver.findElement(By.xpath("//h2[a[@name='menu_21']]"));
//        System.out.println("\n" + classicRollsHeader.getText());
//        WebElement productClassicRolls = classicRollsHeader.findElement(By.xpath("./following-sibling::div[contains(@class, 'product')]"));
//        List<WebElement> menuClassicRolls = productClassicRolls.findElements(By.xpath(".//div[@class='food-title']/p[@class='product-name']"));
//        menuClassicRolls.stream()
//                .map(WebElement::getText)
//                .forEach(System.out::println);
//    }
//
//    @Test
//    void restaurantPishpekAssortedRollsMenu() {
//        WebElement assortedRolls = driver.findElement(By.xpath("//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_22']"));
//        assortedRolls.click();
//        WebElement assortedRollsHeader = driver.findElement(By.xpath("//h2[a[@name='menu_22']]"));
//        System.out.println("\n" + assortedRollsHeader.getText());
//        WebElement productAssortedRolls = assortedRollsHeader.findElement(By.xpath("./following-sibling::div[contains(@class, 'product')]"));
//        List<WebElement> menuAssortedRolls = productAssortedRolls.findElements(By.xpath(".//div[@class='food-title']/p[@class='product-name']"));
//        menuAssortedRolls.stream()
//                .map(WebElement::getText)
//                .forEach(System.out::println);
//    }
//
//    @Test
//    void restaurantPishpekLemonadesMenu() {
//
//        WebElement lemonades = driver.findElement(By.xpath("//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_23']"));
//        lemonades.click();
//        WebElement lemonadesHeader = driver.findElement(By.xpath("//h2[a[@name='menu_23']]"));
//        System.out.println("\n" + lemonadesHeader.getText());
//        WebElement productLemonades = lemonadesHeader.findElement(By.xpath("./following-sibling::div[contains(@class, 'product')]"));
//        List<WebElement> menuLemonades = productLemonades.findElements(By.xpath(".//div[@class='food-title']/p[@class='product-name']"));
//        menuLemonades.stream()
//                .map(WebElement::getText)
//                .forEach(System.out::println);
//    }
//
//
//    @Test
//    void restaurantPishpekColdDrinksMenu() {
//        WebElement coldDrinks = driver.findElement(By.xpath("//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_24']"));
//        coldDrinks.click();
//        WebElement textColdDrinks = driver.findElement(By.xpath("//h2[a[@name='menu_24']]"));
//        System.out.println(" " + " " + textColdDrinks.getText());
//        WebElement listColdDrinks = textColdDrinks.findElement(By.xpath("./following-sibling::div[contains(@class, 'product')]"));
//
//        List<WebElement> menuColdDrinks = listColdDrinks.findElements(By.xpath(".//div[@class='food-title']/p[@class='product-name']"));
//        menuColdDrinks.stream()
//                .map(WebElement::getText)
//                .forEach(System.out::println);
//    }
