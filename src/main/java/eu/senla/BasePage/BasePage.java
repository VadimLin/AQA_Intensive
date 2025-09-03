package eu.senla.BasePage;

import eu.senla.Driver.Driver;
import eu.senla.PropertyFile.ReadPropertyFile;
import org.openqa.selenium.WebDriver;

public class BasePage {

  public static final String LOGIN_URL = ReadPropertyFile.getProperty("BASEURL");

  public void load(String endpoint) {
    WebDriver driver = Driver.getDriver();
    driver.get(LOGIN_URL + endpoint);
  }
}
