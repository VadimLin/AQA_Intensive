package eu.senla;


import static org.junit.jupiter.api.Assertions.assertTrue;

import eu.senla.LoginPage.LoginPage;
import eu.senla.PimPage.PimPage;
import java.util.Random;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AddEmployeeTest extends BaseTest {

  @Test
  @DisplayName("Check successful adding of employee")
  public void testAddEmployee() {
    new LoginTest().loginAsUser();
    new PimPage().navigateToPimModule();
    new PimPage().clickAddEmployee();


    final int num = 1000;
    String firstName = "Leo";
    String middleName = "Nar";
    String lastName = "Do" + new Random().nextInt(num);

    new PimPage().fillEmployeeDetails(firstName, middleName, lastName);
    new PimPage().saveEmployee();

    assertTrue(driver.getCurrentUrl().contains("viewPersonalDetails/empNumber"), "Incorrect Url");
  }

}
