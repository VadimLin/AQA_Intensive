package eu.senla.LoginPage;

import static eu.senla.Waits.Waits.getWait;

import eu.senla.BasePage.BasePage;
import eu.senla.Driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
  private final WebDriver driver;

  private final By usernameField = By.xpath("//input[@name='username']");
  private final By passwordField = By.xpath("//input[@name='password']");
  private final By submitButton = By.tagName("button");
  private final By alertMessage =
      By.xpath("//div/div/p[@class='oxd-text oxd-text--p oxd-alert-content-text']");
  private final By errorColor = By.xpath("//input[@name='username']/following::span");
  private final By dashboardIndicator =
      By.xpath(
          "//a[@class='oxd-main-menu-item active']/span[@class='oxd-text oxd-text--span oxd-main-menu-item--name']");

  public LoginPage() {
    this.driver = Driver.getDriver();
  }

  public LoginPage open() {
    driver.get(LOGIN_URL);
    return new LoginPage();
  }

  public LoginPage login(String username, String password) {
    getWait().until(d -> driver.findElement(usernameField).isDisplayed());
    driver.findElement(usernameField).sendKeys(username);
    driver.findElement(passwordField).sendKeys(password);
    driver.findElement(submitButton).click();
    return new LoginPage();
  }

  public String getAlertText() {
    getWait().until(d -> driver.findElement(alertMessage).isDisplayed());
    return driver.findElement(alertMessage).getText();
  }

  public String getErrorText() {
    getWait().until(d -> driver.findElement(errorColor).isDisplayed());
    return driver.findElement(errorColor).getText();
  }

  public String getErrorColor() {
    WebElement color = driver.findElement(errorColor);
    return color.getCssValue("color");
  }

  public boolean isLoginSuccessful() {
    getWait().until(d -> driver.findElement(dashboardIndicator).isDisplayed());
    return driver.findElement(dashboardIndicator).isDisplayed();
  }
}
