package eu.senla;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import eu.senla.Driver.Driver;
import eu.senla.PimPage.PimPage;
import eu.senla.PropertyFile.ReadPropertyFile;
import net.datafaker.Faker;
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
                + ReadPropertyFile.getProperty("PIM_ENDPOINT")),
        "Incorrect Url");
    assertEquals(pimPage.getTitle(), "PIM");
  }
}
