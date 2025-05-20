package eu.senla;

import eu.senla.Driver.Driver;
import eu.senla.Waits.Waits;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.WebDriver;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BaseTest {

  protected WebDriver driver;
  protected Waits waits;

  public static final String LOGIN_URL =
      "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
  protected String login = "Admin";
  protected String password = "admin123";
  static final int DURATION_SEC = 5;

  @BeforeEach
  void setUp() {
    driver = Driver.getDriver();
    waits = new Waits(DURATION_SEC);
  }

  @AfterEach
  void tearDown() {
    Driver.quitDriver();
  }
}
