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
    loginAsUser();
    PimPage pimPage = new PimPage(waits);
    pimPage.navigateToPimModule();
    pimPage.clickAddEmployee();

    Random rand = new Random();
    final int num = 1000;
    String firstName = "Leo";
    String middleName = "Nar";
    String lastName = "Do" + new Random().nextInt(num);

    pimPage.fillEmployeeDetails(firstName, middleName, lastName);
    pimPage.saveEmployee();

    assertTrue(driver.getCurrentUrl().contains("viewPersonalDetails/empNumber"), "Incorrect Url");
  }

  private void loginAsUser() {
    LoginPage loginPage = new LoginPage(waits);
    loginPage.open();
    loginPage.login(login, password);
    assertTrue(loginPage.isLoginSuccessful(), "Unsuccessful login");
  }
}
