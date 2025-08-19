package eu.senla;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.github.javafaker.Faker;
import eu.senla.AdminPage.AdminPage;
import eu.senla.Endpoints.Endpoints;
import eu.senla.PropertyFile.ReadPropertyFile;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AdminTest extends BaseTest {

  @Test
  @DisplayName("Check Admin Page")
  public void adminTest() {
    AdminPage adminPage = new AdminPage(driver);

    loginAsUser();
    adminPage.navigateToAdminModule();

    assertAll(
        () -> assertEquals(adminPage.getAdminTitle(), "Admin"),
        () ->
            assertEquals(
                ReadPropertyFile.getProperty("BASEURL") + Endpoints.ADMIN_ENDPOINT,
                driver.getCurrentUrl(),
                "Incorrect URL"));
    logoutUser();
  }

  @Test
  @DisplayName("Add Job Title")
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
    assertAll(
        () -> assertEquals(adminPage.getJobTitle(), "Job Titles"),
        () ->
            assertEquals(
                ReadPropertyFile.getProperty("BASEURL") + Endpoints.JOB_ENDPOINT,
                driver.getCurrentUrl(),
                "Incorrect URL"));
    logoutUser();
  }

  @Test
  @DisplayName("Delete existing Job Title")
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
    assertAll(
        () -> assertEquals(adminPage.getJobTitle(), "Job Titles"),
        () ->
            assertEquals(
                ReadPropertyFile.getProperty("BASEURL") + Endpoints.JOB_ENDPOINT,
                driver.getCurrentUrl(),
                "Incorrect URL"));
    logoutUser();
  }
}
