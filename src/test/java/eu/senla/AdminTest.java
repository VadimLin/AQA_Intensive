package eu.senla;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import eu.senla.AdminPage.AdminPage;
import eu.senla.Driver.Driver;
import eu.senla.PropertyFile.ReadPropertyFile;
import net.datafaker.Faker;
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
                ReadPropertyFile.getProperty("BASEURL")
                    + ReadPropertyFile.getProperty("ADMIN_ENDPOINT"),
                Driver.initializeDriver().getCurrentUrl(),
                "Incorrect URL"));
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
        .isConfirmedMessage()
        .getJobTitle();
    assertAll(
        () -> assertEquals(adminPage.getJobTitle(), "Job Titles"),
        () ->
            assertEquals(
                ReadPropertyFile.getProperty("BASEURL")
                    + ReadPropertyFile.getProperty("JOB_ENDPOINT"),
                Driver.initializeDriver().getCurrentUrl(),
                "Incorrect URL"));
  }

  @Test
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
            .isConfirmedMessage();

    adminPage.deleteExistingJobTitle(randomJobTitle).confirmDelete().isConfirmDeleteMessage();
  }
}
