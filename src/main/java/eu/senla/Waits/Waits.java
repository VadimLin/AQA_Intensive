package eu.senla.Waits;

import eu.senla.Driver.Driver;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waits {
  static final Duration TIMEOUT = Duration.ofSeconds(5);

  public static WebElement wait(final ExpectedCondition<WebElement> expectedCondition) {
    return new WebDriverWait(Driver.initializeDriver(), TIMEOUT)
        .withMessage("The element isn't visible")
        .until(expectedCondition);
  }

  public static WebElement waitVisibilityOfElementLocated(final By locator) {
    return wait(ExpectedConditions.visibilityOfElementLocated(locator));
  }
}
