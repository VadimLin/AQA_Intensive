package eu.senla.DashboardPage;

import eu.senla.BasePage.BasePage;
import eu.senla.Waits.Waits;
import org.openqa.selenium.WebDriver;

public class DashboardPage extends BasePage {
  private Waits waits;

  public DashboardPage(WebDriver driver, Waits waits) {
    super();
    this.waits = waits;
  }
}
