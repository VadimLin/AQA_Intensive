package eu.senla.LoginPage;

import eu.senla.BasePage.BasePage;
import eu.senla.Driver.Driver;
import eu.senla.Waits.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
  private final WebDriver driver;
  private final Waits waits;

  private final By usernameField = By.xpath("//input[@name='username']");
  private final By passwordField = By.xpath("//input[@name='password']");
  private final By submitButton = By.tagName("button");
  private final By alertMessage =
      By.xpath("//div/div/p[@class='oxd-text oxd-text--p oxd-alert-content-text']");
  private final By errorColor = By.xpath("//input[@name='username']/following::span");
  private final By dashboardIndicator =
      By.xpath(
          "//a[@class='oxd-main-menu-item active']/span[@class='oxd-text oxd-text--span oxd-main-menu-item--name']");

  public LoginPage(Waits waits) {
    this.driver = Driver.getDriver();
    this.waits = waits;
  }

  public void open() {
    driver.get(LOGIN_URL);
  }

  public void login(String username, String password) {
    waits.getWait().until(d -> driver.findElement(usernameField).isDisplayed());
    driver.findElement(usernameField).sendKeys(username);
    driver.findElement(passwordField).sendKeys(password);
    driver.findElement(submitButton).click();
  }

  public String getAlertText() {
    waits.getWait().until(d -> driver.findElement(alertMessage).isDisplayed());
    return driver.findElement(alertMessage).getText();
  }

  public String getErrorText() {
    waits.getWait().until(d -> driver.findElement(errorColor).isDisplayed());
    return driver.findElement(errorColor).getText();
  }

  public String getErrorColor() {
    WebElement color = driver.findElement(errorColor);
    return color.getCssValue("color");
  }

  public boolean isLoginSuccessful() {
    waits.getWait().until(d -> driver.findElement(dashboardIndicator).isDisplayed());
    return driver.findElement(dashboardIndicator).isDisplayed();
  }
}
