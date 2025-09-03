package eu.senla.DashboardPage;

import eu.senla.BasePage.BasePage;
import eu.senla.Waits.Waits;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class DashboardPage extends BasePage {
  private final By title =
      By.cssSelector(
          "a[class='oxd-main-menu-item active'] span[class='oxd-text oxd-text--span oxd-main-menu-item--name']");
  private final By timeAtWorkWidget =
      By.xpath(
          "//div[contains(@class,' orangehrm-dashboard-widget')]" + "//p[text()='Time at Work']");
  private final By myActionsWidget =
      By.xpath(
          "//div[contains(@class,' orangehrm-dashboard-widget')]" + "//p[text()='My Actions']");
  private final By quickLaunchWidget =
      By.xpath(
          "//div[contains(@class,' orangehrm-dashboard-widget')]" + "//p[text()='Quick Launch']");
  private final By buzzLatestPostsWidget =
      By.xpath(
          "//div[contains(@class,' orangehrm-dashboard-widget')]"
              + "//p[text()='Buzz Latest Posts']");
  private final By employeesOnLeaveTodayWidget =
      By.xpath(
          "//div[contains(@class,' orangehrm-dashboard-widget')]"
              + "//p[text()='Employees on Leave Today']");
  private final By employeeDistributionBySubWidget =
      By.xpath(
          "//div[contains(@class,' orangehrm-dashboard-widget')]"
              + "//p[text()='Employee Distribution by Sub Unit']");
  private final By employeeDistributionByLocationWidget =
      By.xpath(
          "//div[contains(@class,' orangehrm-dashboard-widget')]"
              + "//p[text()='Employee Distribution by Sub Unit']");

  @Step("Check that widget timeAtWorkWidgetIsExists is exist on the page")
  public DashboardPage timeAtWorkWidgetIsExists() {
    Waits.waitVisibilityOfElementLocated(timeAtWorkWidget);
    return this;
  }

  @Step("Check that widget myActionsWidgetIsExists is exist on the page")
  public DashboardPage myActionsWidgetIsExists() {
    Waits.waitVisibilityOfElementLocated(myActionsWidget);
    return this;
  }

  @Step("Check that widget quickLaunchWidgetIsExists is exist on the page")
  public DashboardPage quickLaunchWidgetIsExists() {
    Waits.waitVisibilityOfElementLocated(quickLaunchWidget);
    return this;
  }

  @Step("Check that widget buzzLatestPostsWidgetIsExists is exist on the page")
  public DashboardPage buzzLatestPostsWidgetIsExists() {
    Waits.waitVisibilityOfElementLocated(buzzLatestPostsWidget);
    return this;
  }

  @Step("Check that widget employeesOnLeaveTodayWidgetIsExists is exist on the page")
  public DashboardPage employeesOnLeaveTodayWidgetIsExists() {
    Waits.waitVisibilityOfElementLocated(employeesOnLeaveTodayWidget);
    return this;
  }

  @Step("Check that widget employeeDistributionBySubWidgetIsExists is exist on the page")
  public DashboardPage employeeDistributionBySubWidgetIsExists() {
    Waits.waitVisibilityOfElementLocated(employeeDistributionBySubWidget);
    return this;
  }

  @Step("Check that widget employeeDistributionByLocationWidgetIsExists is exist on the page")
  public DashboardPage employeeDistributionByLocationWidgetIsExists() {
    Waits.waitVisibilityOfElementLocated(employeeDistributionByLocationWidget);
    return this;
  }

  public String getTitle() {
    return Waits.waitVisibilityOfElementLocated(title).getText();
  }
}
