package homeworksPractice.elements.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class А {
    WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

    @Test
    public void findFood() {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://dostavka312.kg/");

        // Находим раздел "Еда" и кликаем по нему
        WebElement edaElement = driver.findElement(By.xpath("//img[@alt='edaG']"));
        edaElement.click();

        // Находим названия всех заведений и ложим их в List
        List<WebElement> listOfEstablishments = driver.findElements(By.xpath("//div[@class='panel-heading']//p[1]"));

//          Перебор всех заведений через стрим апи и вывод на консоль
        listOfEstablishments.stream()
                .map(WebElement::getText)
                .forEach(System.out::println);

// Вывод на консоль общего количества заведений
        System.out.println("\nОбщее количество заведений равно: " + listOfEstablishments.size());

        // Поиск ресторана Пишпек

        WebElement pishpek = listOfEstablishments.stream()
                .filter(element -> element.getText().equals("Ресторан Пишпек"))
                .findFirst()
                .orElse(null);

        // Если найден Ресторан Пишпек, то перейти к его меню
        if (pishpek != null) {
            pishpek.click();
            System.out.println("\nРесторан Пишпек найден, переходим к его меню");
        } else {
            System.out.println("\nИскомое заведение не найдено");
        }

        WebElement menuElement = driver.findElement(By.xpath("//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek']"));
        menuElement.click();

        List<WebElement> menu1 = driver.findElements(By.xpath("//a[@href=\"https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_0\"]"));
        menu1.forEach(s -> System.out.println(s.getText()));

    }

    //   @Test
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
//    @Test(dataProvider = "menu")
//    void printMenu(String menuXPath, String headerXPath) {
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
//
//    @DataProvider(name = "menu")
//    public String[][] menu() {
//        return new String[][]{
//
//                {"//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_0']", "//h2[a[@name='menu_0']]"},
//                {"//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_1']", "//h2[a[@name='menu_1']]"},
//                {"//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_2']", "//h2[a[@name='menu_2']]"},
//                {"//a[@href='https://dostavka312.kg/garnirygpt/restoran-pishpek#menu_3']", "//h2[a[@name='menu_3']]"}
//
//        };
//    }

}


