package eu.senla;

import eu.senla.Driver.Driver;
import eu.senla.LoginPage.LoginPage;
import eu.senla.LogoutPage.LogoutPage;
import eu.senla.PropertyFile.ReadPropertyFile;
import eu.senla.Registration.ChooseLoginStrategy;
import groovy.util.logging.Slf4j;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

@Slf4j
public class BaseTest {
  protected String login = ReadPropertyFile.getProperty("USERNAME");
  protected String password = ReadPropertyFile.getProperty("PASSWORD");
  protected ChooseLoginStrategy loginStrategy;

  @BeforeMethod
  public void setUp() {
    Driver.getDriver();
    loginStrategy = new ChooseLoginStrategy();
      loginStrategy.chooseLoginStrategy();
  }

  @AfterMethod
  public void tearDown() {
    Driver.quitDriver();
  }

  public void logoutUser() {
    new LogoutPage().openDropDownMenu().clickLogoutButton();
  }
}
