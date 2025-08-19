package eu.senla;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import eu.senla.DashboardPage.DashboardPage;
import eu.senla.Endpoints.Endpoints;
import eu.senla.PropertyFile.ReadPropertyFile;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DashBoardTest extends BaseTest {

  @Test
  @DisplayName("Check existing widgets on DashboardPage")
  public void dashboardTest() {
    DashboardPage dashboardPage = new DashboardPage(driver);
//    loginAsUser();
    assertEquals(dashboardPage.getTitle(), "Dashboard");
    dashboardPage
            .timeAtWorkWidgetIsExists()
            .myActionsWidgetIsExists()
            .quickLaunchWidgetIsExists()
            .buzzLatestPostsWidgetIsExists()
            .employeesOnLeaveTodayWidgetIsExists()
            .employeeDistributionBySubWidgetIsExists()
            .employeeDistributionByLocationWidgetIsExists();
    assertAll(
        () -> assertEquals(dashboardPage.getTitle(), "Dashboard"),
        () ->
            assertEquals(
                ReadPropertyFile.getProperty("BASEURL")
                    + Endpoints.DASHBOARD_ENDPOINT,
                driver.getCurrentUrl(),
                "Incorrect URL"));
    logoutUser();
  }
}
