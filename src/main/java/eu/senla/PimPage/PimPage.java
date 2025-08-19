package eu.senla.PimPage;

import eu.senla.BasePage.BasePage;
import eu.senla.Waits.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PimPage extends BasePage {
  private final By pimModuleLink = By.cssSelector("a[href$='viewPimModule']");
  private final By addEmployeeButton =
      By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']");
  private final By firstNameInput = By.xpath("//input[@placeholder='First Name']");
  private final By middleNameInput = By.xpath("//input[@placeholder='Middle Name']");
  private final By lastNameInput = By.xpath("//input[@placeholder='Last Name']");
  private final By saveButton = By.cssSelector("button[type='submit']");
  private final By employeeListUrl = By.xpath("//h6[@class='oxd-text oxd-text--h6 --strong']");
  private final By dashboardIndicator =
      By.xpath(
          "//a[@class='oxd-main-menu-item active']/span[@class='oxd-text oxd-text--span oxd-main-menu-item--name']");
  private final By personalDetailTitle = By.xpath("//h6[text()='Personal Details']");
  private final By alertMessage = By.xpath("//span[contains(@class, 'oxd-input-group__message')]");
  private final By saveDetailFormButton =
      By.xpath(
          "//div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']"
              + "//button[@type='submit']");

  public PimPage(WebDriver driver) {
    super(driver);
  }

  public PimPage navigateToPimModule() {
    Waits.waitVisibilityOfElementLocated(pimModuleLink).click();
    return this;
  }

  public PimPage clickAddEmployee() {
    Waits.waitVisibilityOfElementLocated(addEmployeeButton).click();
    return this;
  }

  public PimPage fillEmployeeDetails(String firstName, String middleName, String lastName) {
    Waits.waitVisibilityOfElementLocated(firstNameInput).sendKeys(firstName);
    Waits.waitVisibilityOfElementLocated(middleNameInput).sendKeys(middleName);
    Waits.waitVisibilityOfElementLocated(lastNameInput).sendKeys(lastName);
    return this;
  }

  public String getTitle() {
    return Waits.waitVisibilityOfElementLocated(dashboardIndicator).getText();
  }

  public PimPage saveEmployee() {
    Waits.waitVisibilityOfElementLocated(saveButton).click();
    Waits.waitVisibilityOfElementLocated(employeeListUrl);
    return this;
  }

  public PimPage fillFirstName(String firstName) {
    Waits.waitVisibilityOfElementLocated(firstNameInput).sendKeys(firstName);
    return this;
  }

  public PimPage fillLastName(String lastName) {
    Waits.waitVisibilityOfElementLocated(lastNameInput).sendKeys(lastName);
    return this;
  }

  public PimPage clearFirstName() {
    WebElement firstNameElement = Waits.waitVisibilityOfElementLocated(firstNameInput);
    firstNameElement.click();
    firstNameElement.sendKeys(Keys.CONTROL, "a");
    firstNameElement.sendKeys(Keys.BACK_SPACE);
    return this;
  }

  public PimPage clearLastName() {
    WebElement lastNameElement = Waits.waitVisibilityOfElementLocated(lastNameInput);
    lastNameElement.click();
    lastNameElement.sendKeys(Keys.CONTROL, "a");
    lastNameElement.sendKeys(Keys.BACK_SPACE);
    return this;
  }

  public String getRequiredAlert() {
    return Waits.waitVisibilityOfElementLocated(alertMessage).getText();
  }

  public String getPersonalDetailTitle() {
    return Waits.waitVisibilityOfElementLocated(personalDetailTitle).getText();
  }

  public PimPage clickSaveDetailFormButton() {
    Waits.waitVisibilityOfElementLocated(saveDetailFormButton).click();
    return this;
  }
}
