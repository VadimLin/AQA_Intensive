package eu.senla;

import eu.senla.Driver.Driver;
import eu.senla.Endpoints.Endpoints;
import eu.senla.LoginPage.LoginPage;
import eu.senla.LogoutPage.LogoutPage;
import eu.senla.PropertyFile.ReadPropertyFile;
import eu.senla.Registration.ApiLogin;
import groovy.util.logging.Slf4j;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

@Slf4j
public class BaseTest {
  protected String login = ReadPropertyFile.getProperty("USERNAME");
  protected String password = ReadPropertyFile.getProperty("PASSWORD");

  @BeforeMethod
  public void setUp() {
    Driver.getDriver();
  }

//    @BeforeMethod
//    final void apiLogin() {
//      init();
//
//      ApiLogin authenticate =
//          new ApiLogin(Endpoints.MAIN_URL + Endpoints.WEB_EP + Endpoints.DASHBOARD_URL);
//
//      authenticate.login();
//    }
//
//    final void init() {
//      Driver.initializeDriver()
//          .get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
//    }

  @AfterMethod
  public void tearDown() {
    Driver.quitDriver();
  }

  public void loginAsUser() {
    LoginPage loginPage = new LoginPage();
    loginPage.load().login(login, password);
  }

  public void logoutUser() {
    new LogoutPage().openDropDownMenu().clickLogoutButton();
  }
}
