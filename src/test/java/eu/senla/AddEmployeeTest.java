package eu.senla;

import static org.junit.jupiter.api.Assertions.assertTrue;

import eu.senla.Driver.Driver;
import eu.senla.PimPage.PimPage;
import java.util.Random;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AddEmployeeTest extends BaseTest {

  @Test
  @DisplayName("Check successful adding of employee")
  public void testAddEmployee() {
    PimPage pimPage = new PimPage();
    final int num = 1000;

    String firstName = "Leo";
    String middleName = "Nar";
    String lastName = "Do" + new Random().nextInt(num);

    loginAsUser();
    pimPage
        .navigateToPimModule()
        .clickAddEmployee()
        .fillEmployeeDetails(firstName, middleName, lastName)
        .saveEmployee();

    assertTrue(
        Driver.getDriver().getCurrentUrl().contains("viewPersonalDetails/empNumber"),
        "Incorrect Url");
  }
}
