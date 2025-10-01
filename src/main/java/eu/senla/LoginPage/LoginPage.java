package eu.senla.LoginPage;

import eu.senla.BasePage.BasePage;
import eu.senla.Driver.Driver;
import eu.senla.Endpoints.Endpoints;
import eu.senla.Waits.Waits;
import io.qameta.allure.Step;
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

  public LoginPage load() {
    load(Endpoints.AUTH_ENDPOINT);
    return this;
  }

  @Step("Enter Username")
  public final LoginPage enterUserName(String userName) {
    Waits.waitVisibilityOfElementLocated(usernameField).sendKeys(userName);
    return this;
  }

  @Step("Enter password")
  public final LoginPage enterPassword(String password) {
    Waits.waitVisibilityOfElementLocated(passwordField).sendKeys(password);
    return this;
  }

  @Step("Submit credentials")
  public final LoginPage clickSubmitButton() {
    Waits.waitVisibilityOfElementLocated(submitButton).click();
    return this;
  }

  @Step("Login to app")
  public LoginPage login(String username, String password) {
    enterUserName(username).enterPassword(password).clickSubmitButton();
    return new LoginPage();
  }

  public String getAlertText() {
    return Waits.waitVisibilityOfElementLocated(alertMessage).getText();
  }

  public String getErrorText() {
    return Waits.waitVisibilityOfElementLocated(errorColor).getText();
  }

  public String getErrorColor() {
    WebElement color = Driver.getDriver().findElement(errorColor);
    return color.getCssValue("color");
  }

  public final LoginPage loginAsUser(String userName, String password) {
    enterUserName(userName).enterPassword(password).clickSubmitButton();
    return new LoginPage();
  }

  @Step
  public LoginPage isLoginSuccessful() {
    Waits.waitVisibilityOfElementLocated(dashboardIndicator);
    return this;
  }
}
