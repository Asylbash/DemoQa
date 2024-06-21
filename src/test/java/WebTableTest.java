import com.demoqa.entities_polya_objects.Employee;
import com.demoqa.utils.ConfigReader;
import org.testng.annotations.Test;

import java.util.List;

import static com.demoqa.enums.Endpoints.WEBTABLE;
import static org.testng.Assert.assertTrue;

public class WebTableTest extends BaseTest {
    @Test(description = "verify is new employee is added")
    public void addNewEmployeeTest() throws InterruptedException {

        browserHelper.open(ConfigReader.getValue("baseURL") + WEBTABLE.getEndpoint());
        demoqa.getWebTablePage().addNewEmployee(randomUtils.createMockEmployee());
        List<Employee> employees = demoqa.getWebTablePage().getEmployeesFormTable();
        for (Employee employee : employees) {
            System.out.println(employee);
        }

    }

    @Test(description = "verify is new employee in list")
    public void findNewAddedEmployeeAssert() throws InterruptedException {

        browserHelper.open(ConfigReader.getValue("baseURL") + WEBTABLE.getEndpoint());
        Employee employee = randomUtils.createMockEmployee();
        demoqa.getWebTablePage().addNewEmployee(employee);
        List<Employee> employees = demoqa.getWebTablePage().getEmployeesFormTable();
        // Flag dlya poiska, esli nashel
        boolean employeeFound = false;
        for (Employee employee1 : employees) {
            if (employee.equals(employee1)) {
                System.out.println(employee);
                System.out.println(employee1);
                employeeFound = true;
                break; // vyhod iz loopa if the employee is found
            }
        }

        // Assert that the employee was added successfully
        assertTrue(employeeFound, "The new employee was not found in the web table");
    }

    /**
     * Метод для поиска сотрудника по электронной почте и редактирования его данных.
     * <p>
     * Этот метод выполняет следующие действия:
     * 1. Проверяет наличие сотрудника с указанной электронной почтой в таблице сотрудников.
     * 2. Если сотрудник не найден, выбрасывает исключение IllegalArgumentException с сообщением, что email не найден.
     * 3. Если сотрудник найден, открывает форму редактирования сотрудника.
     * 4. В зависимости от переданного параметра oldValue, находит соответствующее поле и заменяет его значение на newValue:
     * - "firstName" - редактирует имя.
     * - "lastName" - редактирует фамилию.
     * - "age" - редактирует возраст.
     * - "email" - редактирует электронную почту.
     * - "salary" - редактирует зарплату.
     * - "department" - редактирует отдел.
     * 5. После замены значения, нажимает кнопку "Submit" для сохранения изменений.
     *
     * @paramemail    Электронная почта сотрудника, чьи данные необходимо изменить.
     * @paramoldValue Поле, которое необходимо изменить (например, "firstName", "lastName", "age" и т.д.).
     * @paramnewValue Новое значение для указанного поля.
     * @return Возвращает текущий объект WebTablePage для возможности цепочки вызовов.
     * @throws IllegalArgumentException Если указанный email не найден или указано недопустимое значение поля.
     */

    @Test(description = "edit exist employee dates using email and verify updates")
    public void editValuesTest() {

        browserHelper.open(ConfigReader.getValue("baseURL") + WEBTABLE.getEndpoint());
        demoqa.getWebTablePage().editEmployeeData("cierra@example.com", "age", "34");
        List<Employee> employees = demoqa.getWebTablePage().getEmployeesFormTable();
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    @Test(groups = {"Smoke", "UI", "DQA-33"}, description = "delete employee by email")
    public void deleteEmployeeByEmail() {
        browserHelper.open(ConfigReader.getValue("baseURL") + WEBTABLE.getEndpoint());
        demoqa.getWebTablePage().deleteEmployeeByEmail("cierra@example.com");
    }

//    @Test(description = "verify updates")
//    public void editValuesTest1() {
//        driver.get("https://demoqa.com/webtables");
//        String[] newValues = {"John", "Doe", "30", "john.doe@example.com", "500000", "IT"};
//        demoqa.getWebTablePage().editEmployee("cierra@example.com", newValues);
//        List<Employee> employees = demoqa.getWebTablePage().getEmployeesFormTable();
//        for (Employee employee : employees) {
//            System.out.println(employee);
//        }
//    }
}
