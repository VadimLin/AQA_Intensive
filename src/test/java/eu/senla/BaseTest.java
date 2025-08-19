package eu.senla;

import eu.senla.Driver.Driver;
import eu.senla.Endpoints.Endpoints;
import eu.senla.LoginPage.LoginPage;
import eu.senla.LogoutPage.LogoutPage;
import eu.senla.PropertyFile.ReadPropertyFile;
import eu.senla.Registration.ApiLogin;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.WebDriver;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BaseTest {
  protected String login = ReadPropertyFile.getProperty("USERNAME");
  protected String password = ReadPropertyFile.getProperty("PASSWORD");
  protected WebDriver driver;

  @BeforeEach
  void setUp() {
    driver = Driver.initializeDriver();
  }


  @BeforeEach
  final void apiLogin() {
    init();

    ApiLogin authenticate = new ApiLogin(Endpoints.MAIN_URL + Endpoints.WEB_EP + Endpoints.DASHBOARD_URL);

    authenticate.login();
  }

  final void init() {
    Driver.initializeDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
  }

  @AfterEach
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
