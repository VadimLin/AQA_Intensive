package eu.senla.PimPage;

import eu.senla.BasePage.BasePage;
import eu.senla.Waits.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PimPage extends BasePage {
  private final By pimModuleLink = By.cssSelector("a[href$='viewPimModule']");
  private final By addEmployeeButton =
      By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']");
  private final By firstNameInput = By.xpath("//input[@placeholder='First Name']");
  private final By middleNameInput = By.xpath("//input[@placeholder='Middle Name']");
  private final By lastNameInput = By.xpath("//input[@placeholder='Last Name']");

  private final By employeeIdInput =
      By.xpath(
          "//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@class='oxd-input oxd-input--active']");
  private final By saveButton = By.cssSelector("button[type='submit']");
  private final By employeeListUrl = By.xpath("//h6[@class='oxd-text oxd-text--h6 --strong']");
  private final By dashboardIndicator =
      By.xpath(
          "//a[@class='oxd-main-menu-item active']/span[@class='oxd-text oxd-text--span oxd-main-menu-item--name']");

  public PimPage(WebDriver driver) {
    super(driver);
  }

  public PimPage navigateToPimModule() {
    Waits.waitVisibilityOfElementLocated(pimModuleLink).isDisplayed();
    driver.findElement(pimModuleLink).click();
    return this;
  }

  public PimPage clickAddEmployee() {
    Waits.waitVisibilityOfElementLocated(addEmployeeButton).isDisplayed();
    driver.findElement(addEmployeeButton).click();
    return this;
  }

  public PimPage fillEmployeeDetails(String firstName, String middleName, String lastName) {
    Waits.waitVisibilityOfElementLocated(firstNameInput).isDisplayed();
    Waits.waitVisibilityOfElementLocated(firstNameInput).sendKeys(firstName);
    Waits.waitVisibilityOfElementLocated(middleNameInput).sendKeys(middleName);
    Waits.waitVisibilityOfElementLocated(lastNameInput).sendKeys(lastName);
    return this;
  }

  public String getTitle() {
    Waits.waitVisibilityOfElementLocated(dashboardIndicator).isDisplayed();
    return driver.findElement(dashboardIndicator).getText();
  }

  public PimPage saveEmployee() {
    Waits.waitVisibilityOfElementLocated(saveButton).click();
    Waits.waitVisibilityOfElementLocated(employeeListUrl).isDisplayed();
    return this;
  }
}
