package eu.senla.BasePage;

import eu.senla.PropertyFile.ReadPropertyFile;
import org.openqa.selenium.WebDriver;

public class BasePage {
  protected WebDriver driver;
  public static final String LOGIN_URL = ReadPropertyFile.getProperty("BASEURL");

  public BasePage(WebDriver driver) {
    this.driver = driver;
  }

  public void load(String endpoint) {
    driver.get(LOGIN_URL + endpoint);
  }
}
