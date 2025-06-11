package eu.senla;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import eu.senla.DashboardPage.DashboardPage;
import eu.senla.Driver.Driver;
import eu.senla.PropertyFile.ReadPropertyFile;
import org.junit.jupiter.api.Test;

public class DashBoardTest extends BaseTest {

  @Test
  public void dashboardTest() {
    DashboardPage dashboardPage = new DashboardPage(driver);
    loginAsUser();
    assertAll(
        () -> assertEquals(dashboardPage.getTitle(), "Dashboard"),
        () ->
            assertEquals(
                ReadPropertyFile.getProperty("BASEURL")
                    + ReadPropertyFile.getProperty("DASHBOARD_ENDPOINT"),
                Driver.initializeDriver().getCurrentUrl(),
                "Incorrect URL"));
  }
}
