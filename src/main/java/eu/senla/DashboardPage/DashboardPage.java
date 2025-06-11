package eu.senla.DashboardPage;

import eu.senla.BasePage.BasePage;
import eu.senla.Waits.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage extends BasePage {
  private final By title =
      By.cssSelector(
          "a[class='oxd-main-menu-item active'] span[class='oxd-text oxd-text--span oxd-main-menu-item--name']");

  public DashboardPage(WebDriver driver) {
    super(driver);
  }

  public String getTitle() {
    Waits.waitVisibilityOfElementLocated(title).isDisplayed();
    return driver.findElement(title).getText();
  }
}
