package eu.senla.Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public final class Driver {
  private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

  private Driver() {

  }

  public static WebDriver initializeDriver() {
    String browser = System.getProperty("browser");
    if (driver.get() == null) {
      switch (browser.toLowerCase()) {
        case "chrome" -> driver.set(new ChromeDriver());
        case "firefox" -> driver.set(new FirefoxDriver());
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
