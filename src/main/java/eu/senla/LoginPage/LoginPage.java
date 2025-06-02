package eu.senla.LoginPage;

import eu.senla.BasePage.BasePage;
import eu.senla.Waits.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

  private final By usernameField = By.xpath("//input[@name='username']");
  private final By passwordField = By.xpath("//input[@name='password']");
  private final By submitButton = By.tagName("button");
  private final By alertMessage =
      By.xpath("//div/p[@class='oxd-text oxd-text--p oxd-alert-content-text']");
  private final By errorColor = By.xpath("//input[@name='username']/following::span");
  private final By dashboardIndicator =
      By.xpath(
          "//a[@class='oxd-main-menu-item active']/span[@class='oxd-text oxd-text--span oxd-main-menu-item--name']");

  public LoginPage() {
    super();
  }

  public LoginPage open() {
    driver.get(LOGIN_URL);
    return new LoginPage();
  }

  public final LoginPage enterUserName(String userName) {
    Waits.waitVisibilityOfElementLocated(usernameField).sendKeys(userName);
    return this;
  }

  public final LoginPage enterPassword(String password) {
    Waits.waitVisibilityOfElementLocated(passwordField).sendKeys(password);
    return this;
  }

  public final LoginPage clickSubmitButton() {
    Waits.waitVisibilityOfElementLocated(submitButton).click();
    return this;
  }

  public LoginPage login(String username, String password) {
    enterUserName(username).enterPassword(password).clickSubmitButton();
    return new LoginPage();
  }

  public String getAlertText() {
    Waits.waitVisibilityOfElementLocated(alertMessage).isDisplayed();
    return driver.findElement(alertMessage).getText();
  }

  public String getErrorText() {
    Waits.waitVisibilityOfElementLocated(errorColor).isDisplayed();
    return driver.findElement(errorColor).getText();
  }

  public String getErrorColor() {
    WebElement color = driver.findElement(errorColor);
    return color.getCssValue("color");
  }

  public boolean isLoginSuccessful() {
    Waits.waitVisibilityOfElementLocated(dashboardIndicator).isDisplayed();
    return driver.findElement(dashboardIndicator).isDisplayed();
  }
}
