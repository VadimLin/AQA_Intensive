package eu.senla;
import eu.senla.DashboardPage.DashboardPage;
import eu.senla.Endpoints.Endpoints;
import eu.senla.PropertyFile.ReadPropertyFile;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class DashBoardTest extends BaseTest {

  @Test(description = "Check existing widgets on DashboardPage")
  public void dashboardTest() {
    DashboardPage dashboardPage = new DashboardPage(driver);
   loginAsUser();
    SoftAssert sa = new SoftAssert();
    sa.assertEquals(dashboardPage.getTitle(), "Dashboard");
    dashboardPage
        .timeAtWorkWidgetIsExists()
        .myActionsWidgetIsExists()
        .quickLaunchWidgetIsExists()
        .buzzLatestPostsWidgetIsExists()
        .employeesOnLeaveTodayWidgetIsExists()
        .employeeDistributionBySubWidgetIsExists()
        .employeeDistributionByLocationWidgetIsExists();
    sa.assertEquals(dashboardPage.getTitle(), "Dashboard");
    sa.assertEquals(
                ReadPropertyFile.getProperty("BASEURL") + Endpoints.DASHBOARD_ENDPOINT,
                driver.getCurrentUrl(),
                "Incorrect URL");
    sa.assertAll();
    logoutUser();
  }
}
