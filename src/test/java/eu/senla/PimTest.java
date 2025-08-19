package eu.senla;


import com.github.javafaker.Faker;
import eu.senla.Endpoints.Endpoints;
import eu.senla.PimPage.PimPage;
import eu.senla.PropertyFile.ReadPropertyFile;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class PimTest extends BaseTest {

  @Test(description = "Check successful adding of employee")
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
    SoftAssert sa = new SoftAssert();
    sa.assertTrue(
        driver
            .getCurrentUrl()
            .contains(ReadPropertyFile.getProperty("BASEURL") + Endpoints.PIM_ENDPOINT),
        "Incorrect Url");
    sa.assertEquals(pimPage.getTitle(), "PIM");
    sa.assertAll();
    logoutUser();
  }

  @Test
  public void testEmptyFirstNameField() {
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
        .saveEmployee()
        .clearFirstName();
    SoftAssert sa = new SoftAssert();
    sa.assertEquals(
                ReadPropertyFile.getProperty("REQUIRED_ALERT"), pimPage.getRequiredAlert());
    sa.assertTrue(
                driver
                    .getCurrentUrl()
                    .contains(ReadPropertyFile.getProperty("BASEURL") + Endpoints.PIM_ENDPOINT),
                "Incorrect Url");
    sa.assertEquals(pimPage.getPersonalDetailTitle(), "Personal Details");
    sa.assertAll();
  }

  @Test
  public void testEmptyLastNameField() {
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
        .saveEmployee()
        .clearLastName();
    SoftAssert sa = new SoftAssert();
    sa.assertEquals(
                ReadPropertyFile.getProperty("REQUIRED_ALERT"), pimPage.getRequiredAlert());
    sa.assertTrue(
                driver
                    .getCurrentUrl()
                    .contains(ReadPropertyFile.getProperty("BASEURL") + Endpoints.PIM_ENDPOINT),
                "Incorrect Url");
    sa.assertEquals(pimPage.getPersonalDetailTitle(), "Personal Details");
    sa.assertAll();
  }

  @Test
  public void testEditFirstNameAndLastNameFields() {
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
        .saveEmployee()
        .clearFirstName()
        .clearLastName()
        .fillFirstName(firstName)
        .fillLastName(lastName)
        .clickSaveDetailFormButton();
    SoftAssert sa = new SoftAssert();
    sa.assertTrue(
                driver
                    .getCurrentUrl()
                    .contains(ReadPropertyFile.getProperty("BASEURL") + Endpoints.PIM_ENDPOINT),
                "Incorrect Url");
    sa.assertEquals(pimPage.getPersonalDetailTitle(), "Personal Details");
    sa.assertAll();
  }
}
