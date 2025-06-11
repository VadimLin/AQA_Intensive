package eu.senla;

import eu.senla.Driver.Driver;
import eu.senla.LoginPage.LoginPage;
import eu.senla.PropertyFile.ReadPropertyFile;
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

  @AfterEach
  void tearDown() {
    Driver.quitDriver();
  }

  public void loginAsUser() {
    LoginPage loginPage = new LoginPage(driver);
    loginPage.load().login(login, password);
  }
}
