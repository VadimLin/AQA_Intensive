package eu.senla.Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public final class Driver {
  private static WebDriver driver;

  private Driver() {
  }

  public static WebDriver initializeDriver() {
    if (driver == null) {
      driver = new ChromeDriver();
      driver.manage().window().maximize();
    }
    return driver;
  }

  public static void quitDriver() {
    if (driver != null) {
      driver.quit();
      driver = null;
    }
  }
}
