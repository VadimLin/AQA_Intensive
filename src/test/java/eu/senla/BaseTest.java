package eu.senla;

import eu.senla.Driver.Driver;
import eu.senla.LoginPage.LoginPage;
import eu.senla.LogoutPage.LogoutPage;
import eu.senla.PropertyFile.ReadPropertyFile;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
  protected String login = ReadPropertyFile.getProperty("USERNAME");
  protected String password = ReadPropertyFile.getProperty("PASSWORD");
  protected WebDriver driver;

  @BeforeMethod
  void setUp() {
    driver = Driver.initializeDriver();
  }

//  @BeforeMethod
//  final void apiLogin() {
//    init();
//
//    ApiLogin authenticate =
//        new ApiLogin(Endpoints.MAIN_URL + Endpoints.WEB_EP + Endpoints.DASHBOARD_URL);
//
//    authenticate.login();
//  }

  final void init() {
    Driver.initializeDriver()
        .get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
  }

  @AfterMethod
  void tearDown() {
    Driver.quitDriver();
  }

  public void loginAsUser() {
    LoginPage loginPage = new LoginPage(driver);
    loginPage.load().login(login, password);
  }

  public void logoutUser() {
    new LogoutPage(driver).openDropDownMenu().clickLogoutButton();
  }
}
