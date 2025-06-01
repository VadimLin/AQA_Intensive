package eu.senla.Waits;

import eu.senla.Driver.Driver;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waits {

  private final WebDriver driver;
  private static WebDriverWait wait;

  public Waits(int timeoutSeconds) {
    this.driver = Driver.getDriver();
    this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(timeoutSeconds));
  }

  public static WebDriverWait getWait() {
    return wait;
  }
}
