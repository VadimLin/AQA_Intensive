package eu.senla;

import eu.senla.Driver.Driver;
import eu.senla.LoginPage.LoginPage;
import eu.senla.PropertyFile.ReadPropertyFile;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BaseTest {
  protected String login = ReadPropertyFile.getProperty("USERNAME");
  protected String password = ReadPropertyFile.getProperty("PASSWORD");

  @BeforeEach
  void setUp() {
    Driver.getDriver().get(ReadPropertyFile.getProperty("BASEURL"));
  }

  @AfterEach
  void tearDown() {
    Driver.quitDriver();
  }

  public void loginAsUser() {
    LoginPage loginPage = new LoginPage();
    loginPage.open().login(login, password);
  }
}
