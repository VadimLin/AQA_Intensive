package eu.senla.BasePage;

import eu.senla.Driver.Driver;
import eu.senla.PropertyFile.ReadPropertyFile;
import org.openqa.selenium.WebDriver;

public class BasePage {
  protected WebDriver driver;
  public static final String LOGIN_URL = ReadPropertyFile.getProperty("BASEURL");

  public BasePage() {
    this.driver = Driver.getDriver(); // инициализация драйвера
  }
}
