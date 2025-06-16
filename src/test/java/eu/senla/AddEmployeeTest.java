package eu.senla;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.github.javafaker.Faker;
import eu.senla.Driver.Driver;
import eu.senla.Endpoints.Endpoints;
import eu.senla.PimPage.PimPage;
import eu.senla.PropertyFile.ReadPropertyFile;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AddEmployeeTest extends BaseTest {

  @Test
  @DisplayName("Check successful adding of employee")
  public void testAddEmployee() {

    PimPage pimPage = new PimPage(driver);
    Faker faker = new Faker();
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String middleName = faker.funnyName().name();

    loginAsUser();
    pimPage
        .navigateToPimModule()
        .clickAddEmployee()
        .fillEmployeeDetails(firstName, middleName, lastName)
        .saveEmployee();

    assertTrue(
        Driver.initializeDriver().getCurrentUrl().contains(ReadPropertyFile.getProperty("BASEURL")
                + Endpoints.PIM_ENDPOINT),
        "Incorrect Url");
    assertEquals(pimPage.getTitle(), "PIM");

    logoutUser();
  }
}
