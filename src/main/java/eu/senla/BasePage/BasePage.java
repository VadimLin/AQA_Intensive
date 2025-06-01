package eu.senla.BasePage;

import eu.senla.Driver.Driver;
import org.openqa.selenium.WebDriver;

public class BasePage {

  public static final String LOGIN_URL =
          "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";


  private final WebDriver driver;

  public BasePage() {
    this.driver = Driver.getDriver();
  }
}