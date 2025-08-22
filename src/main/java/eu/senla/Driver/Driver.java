package eu.senla.Driver;

import eu.senla.Constants.DriverType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public final class Driver {
  private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

  private Driver() {

  }

  public static WebDriver initializeDriver() {
    String browser = System.getProperty("browser", "CHROME");
    if (driver.get() == null) {
      switch (DriverType.valueOf(browser.toUpperCase())) {
        case CHROME -> driver.set(new ChromeDriver());
        case FIREFOX -> driver.set(new FirefoxDriver());
        default -> throw new IllegalArgumentException("Invalid browser name: " + browser);
      }
      driver.get().manage().window().maximize();
    }
    return driver.get();
  }

  public static void quitDriver() {
    if (driver != null) {
      driver.get().quit();
      driver.remove();
    }
  }
}
