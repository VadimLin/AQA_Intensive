package eu.senla.DashboardPage;

import eu.senla.BasePage.BasePage;
import eu.senla.Waits.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage extends BasePage {
  private final By title =
      By.cssSelector(
          "a[class='oxd-main-menu-item active'] span[class='oxd-text oxd-text--span oxd-main-menu-item--name']");
  private final By timeAtWorkWidget = By.xpath("//div[contains(@class,' orangehrm-dashboard-widget')]"
          + "//p[text()='Time at Work']");
  private final By myActionsWidget = By.xpath("//div[contains(@class,' orangehrm-dashboard-widget')]"
          + "//p[text()='My Actions']");
  private final By quickLaunchWidget = By.xpath("//div[contains(@class,' orangehrm-dashboard-widget')]"
          + "//p[text()='Quick Launch']");
  private final By buzzLatestPostsWidget = By.xpath("//div[contains(@class,' orangehrm-dashboard-widget')]"
          + "//p[text()='Buzz Latest Posts']");
  private final By employeesOnLeaveTodayWidget = By.xpath("//div[contains(@class,' orangehrm-dashboard-widget')]"
          + "//p[text()='Employees on Leave Today']");
  private final By employeeDistributionBySubWidget = By.xpath("//div[contains(@class,' orangehrm-dashboard-widget')]"
          + "//p[text()='Employee Distribution by Sub Unit']");
  private final By employeeDistributionByLocationWidget = By.xpath("//div[contains(@class,' orangehrm-dashboard-widget')]"
          + "//p[text()='Employee Distribution by Sub Unit']");
  public DashboardPage(WebDriver driver) {

    super(driver);
  }
  public DashboardPage timeAtWorkWidgetIsExists() {
    Waits.waitVisibilityOfElementLocated(timeAtWorkWidget).isDisplayed();
    return this;
  }
  public DashboardPage myActionsWidgetIsExists() {
    Waits.waitVisibilityOfElementLocated(myActionsWidget).isDisplayed();
    return this;
  }
  public DashboardPage quickLaunchWidgetIsExists() {
    Waits.waitVisibilityOfElementLocated(quickLaunchWidget).isDisplayed();
    return this;
  }
  public DashboardPage buzzLatestPostsWidgetIsExists() {
    Waits.waitVisibilityOfElementLocated(buzzLatestPostsWidget).isDisplayed();
    return this;
  }
  public DashboardPage employeesOnLeaveTodayWidgetIsExists() {
    Waits.waitVisibilityOfElementLocated(employeesOnLeaveTodayWidget).isDisplayed();
    return this;
  }
  public DashboardPage employeeDistributionBySubWidgetIsExists() {
    Waits.waitVisibilityOfElementLocated(employeeDistributionBySubWidget).isDisplayed();
    return this;
  }
  public DashboardPage employeeDistributionByLocationWidgetIsExists() {
    Waits.waitVisibilityOfElementLocated(employeeDistributionByLocationWidget).isDisplayed();
    return this;
  }

  public String getTitle() {
    Waits.waitVisibilityOfElementLocated(title).isDisplayed();
    return driver.findElement(title).getText();
  }
}
