package eu.senla;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.github.javafaker.Faker;
import eu.senla.AdminPage.AdminPage;
import eu.senla.Endpoints.Endpoints;
import eu.senla.PropertyFile.ReadPropertyFile;


public class AdminTest extends BaseTest {

  @Test(description = "Check Admin Page")
  public void adminTest() {
    AdminPage adminPage = new AdminPage(driver);

    loginAsUser();
    adminPage.navigateToAdminModule();
    SoftAssert sa = new SoftAssert();
    sa.assertEquals(adminPage.getAdminTitle(), "Admin");
        sa.assertEquals(
                ReadPropertyFile.getProperty("BASEURL") + Endpoints.ADMIN_ENDPOINT,
                driver.getCurrentUrl(),
                "Incorrect URL");
    sa.assertAll();
    logoutUser();
  }

  @Test(description = "Add Job Title")
  public void addJobTitle() {
    Faker faker = new Faker();
    String randomJobTitle = faker.job().title();
    AdminPage adminPage = new AdminPage(driver);
    loginAsUser();
    adminPage
        .navigateToAdminModule()
        .clickDropDownMenu()
        .clickJobTitlesOption()
        .clickAddButton()
        .fillJobTitlefield(randomJobTitle)
        .saveJobTitle()
        .isConfirmedMessage();
    SoftAssert sa = new SoftAssert();
     sa.assertEquals(adminPage.getJobTitle(), "Job Titles");
     sa.assertEquals(
                ReadPropertyFile.getProperty("BASEURL") + Endpoints.JOB_ENDPOINT,
                driver.getCurrentUrl(),
                "Incorrect URL");
     sa.assertAll();
    logoutUser();
  }

  @Test(description = "Delete existing Job Title")
  public void deleteJobTitle() {
    Faker faker = new Faker();
    String randomJobTitle = faker.job().title();
    AdminPage adminPage = new AdminPage(driver);
    loginAsUser();
    adminPage
        .navigateToAdminModule()
        .clickDropDownMenu()
        .clickJobTitlesOption()
        .clickAddButton()
        .fillJobTitlefield(randomJobTitle)
        .saveJobTitle()
        .isConfirmedMessage()
        .deleteExistingJobTitle(randomJobTitle)
        .confirmDelete()
        .isConfirmDeleteMessage();
    SoftAssert sa = new SoftAssert();
        sa.assertEquals(adminPage.getJobTitle(), "Job Titles");
        sa.assertEquals(
                ReadPropertyFile.getProperty("BASEURL") + Endpoints.JOB_ENDPOINT,
                driver.getCurrentUrl(),
                "Incorrect URL");
    logoutUser();
  }
}
