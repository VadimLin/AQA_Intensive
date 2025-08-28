package eu.senla.Driver;

import static eu.senla.PropertyFile.ReadPropertyFile.getProperty;

import eu.senla.Constants.DriverType;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public final class Driver {
  private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

  private Driver() {

  }

  public static WebDriver initializeDriver() {

    if (driver.get() == null) {
      String browser = System.getProperty("browser", "CHROME");
      if (Boolean.parseBoolean(getProperty("selenoidEnable"))) {
        initRemoteDriver(browser);
      } else {
        initLocalDriver(browser);
      }
    }
    return driver.get();
  }

  private static void initRemoteDriver(String browser) {
    try {
      DesiredCapabilities capabilities = new DesiredCapabilities();
      switch (DriverType.valueOf(browser.toUpperCase())) {
        case CHROME -> {
          ChromeOptions chromeOptions = new ChromeOptions();
          chromeOptions.addArguments("--no-sandbox");
          chromeOptions.addArguments("--disable-dev-shm-usage");
          chromeOptions.addArguments("--start-maximized");
          if (Boolean.parseBoolean(getProperty("headless"))) {
            chromeOptions.addArguments("--headless=new");
          }
          chromeOptions.setCapability(
              "selenoid:options",
              Map.of(
                  "enableVNC", true,
                  "enableVideo", true,
                  "enableLog", true));
          capabilities.merge(chromeOptions);
        }
        case FIREFOX -> {
          FirefoxOptions firefoxOptions = new FirefoxOptions();
          if (Boolean.parseBoolean(getProperty("headless"))) {
            firefoxOptions.addArguments("--headless");
          }
          firefoxOptions.setCapability(
              "selenoid:options",
              Map.of(
                  "enableVNC", true,
                  "enableVideo", true,
                  "enableLog", true));
          capabilities.merge(firefoxOptions);
        }
        default -> throw new IllegalArgumentException("Unsupported remote browser: " + browser);
      }
      driver.set(new RemoteWebDriver(new URL(getProperty("selenoidUrl")), capabilities));

    } catch (MalformedURLException e) {
      throw new RuntimeException("Invalid Selenoid URL", e);
    }
  }

  private static void initLocalDriver(String browser) {
    switch (DriverType.valueOf(browser.toUpperCase())) {
      case CHROME -> {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        /*                if (Boolean.parseBoolean(getProperty("headless"))) {
            options.addArguments("--headless=new");
        }*/
        driver.set(new ChromeDriver(options));
      }
      case FIREFOX -> {
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--width=1920");
        options.addArguments("--height=1080");
        /*                if (Boolean.parseBoolean(getProperty("headless"))) {
            options.addArguments("--headless");
        }*/
        driver.set(new FirefoxDriver(options));
      }
      default -> throw new IllegalArgumentException("Передан неподдерживаемый браузер");
    }
    driver.get().manage().window().maximize();
  }

  public static void quitDriver() {
    if (driver != null) {
      driver.get().quit();
      driver.remove();
    }
  }
}
