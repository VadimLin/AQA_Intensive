package eu.senla;

import eu.senla.Endpoints.Endpoints;
import eu.senla.LoginPage.LoginPage;
import eu.senla.PropertyFile.ReadPropertyFile;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginTest extends BaseTest {
private final int priorityNumber = 3;
  @Test(priority = 1, groups = "smoke", description = "Check Sign In with valid credentials")
  public void testValidLogin() {

    LoginPage loginPage = new LoginPage(driver);
    loginPage.load().login(login, password).isLoginSuccessful();
    SoftAssert sa = new SoftAssert();
    sa.assertEquals(
        ReadPropertyFile.getProperty("BASEURL") + Endpoints.DASHBOARD_ENDPOINT,
        driver.getCurrentUrl(),
        "Unsuccessful Login");
    sa.assertAll();
  }

  @Test(
      description = "Check Sign In with invalid {0}",
      priority = 2,
      groups = "extended",
      dataProvider = "getCredentials",
      dataProviderClass = ProjectDataProvider.class)
  public void testInvalidLogin(String description, String username, String pwd) {
    LoginPage loginPage = new LoginPage(driver);
    loginPage.load().login(username, pwd);
    SoftAssert sa = new SoftAssert();
    sa.assertEquals("Invalid credentials", loginPage.getAlertText());
    sa.assertEquals(
        ReadPropertyFile.getProperty("BASEURL") + Endpoints.AUTH_ENDPOINT,
        driver.getCurrentUrl(),
        "Url doesn't match");
    sa.assertAll();
  }

  @Test(
      description = "Check Sign In with empty {0}",
      priority = priorityNumber,
      groups = "extended",
      dataProvider = "getEmptyCredentials",
      dataProviderClass = ProjectDataProvider.class)
  public void testEmptyLogin(String description, String username, String pwd) {
    LoginPage loginPage = new LoginPage(driver);
    loginPage.load().login(username, pwd);
    SoftAssert sa = new SoftAssert();
    sa.assertEquals("Required", loginPage.getErrorText());
    sa.assertEquals(
        ReadPropertyFile.getProperty("COLOR"),
        loginPage.getErrorColor(),
        "Color value doesn't match");
    sa.assertEquals(
        ReadPropertyFile.getProperty("BASEURL") + Endpoints.AUTH_ENDPOINT,
        driver.getCurrentUrl(),
        "Url doesn't match");
    sa.assertAll();
  }
}
