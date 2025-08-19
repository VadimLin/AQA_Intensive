package eu.senla;


import eu.senla.Endpoints.Endpoints;
import eu.senla.LogoutPage.LogoutPage;
import eu.senla.PropertyFile.ReadPropertyFile;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LogoutTest extends BaseTest {
  @Test
  public void logoutTest() {
    LogoutPage logoutPage = new LogoutPage(driver);
    loginAsUser();
    logoutPage.openDropDownMenu().clickLogoutButton().getLoginTitle();
    SoftAssert sa = new SoftAssert();
    sa.assertEquals(
        ReadPropertyFile.getProperty("BASEURL") + Endpoints.AUTH_ENDPOINT,
        driver.getCurrentUrl(),
        "Url doesn't match");
    sa.assertAll();
  }
}
