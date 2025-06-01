package eu.senla.PimPage;

import static eu.senla.Waits.Waits.getWait;

import eu.senla.BasePage.BasePage;
import eu.senla.Driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PimPage extends BasePage {
  private final WebDriver driver;
  private final By pimModuleLink = By.cssSelector("a[href$='viewPimModule']");
  private final By addEmployeeButton =
      By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']");
  private final By firstNameInput =
      By.xpath("//input[@class='oxd-input oxd-input--active orangehrm-firstname']");
  private final By middleNameInput =
      By.xpath("//input[@class='oxd-input oxd-input--active orangehrm-middlename']");
  private final By lastNameInput =
      By.xpath("//input[@class='oxd-input oxd-input--active orangehrm-lastname']");
  private final By saveButton =
      By.xpath(
          "//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']");
  private final By employeeListUrl = By.xpath("//h6[@class='oxd-text oxd-text--h6 --strong']");

  public PimPage() {
    this.driver = Driver.getDriver();
  }

  public void navigateToPimModule() {
    getWait().until(d -> driver.findElement(pimModuleLink).isDisplayed());
    driver.findElement(pimModuleLink).click();
  }

  public void clickAddEmployee() {
    getWait().until(d -> driver.findElement(addEmployeeButton).isDisplayed());
    driver.findElement(addEmployeeButton).click();
  }

  public void fillEmployeeDetails(String firstName, String middleName, String lastName) {
    getWait().until(d -> driver.findElement(firstNameInput).isDisplayed());
    driver.findElement(firstNameInput).sendKeys(firstName);
    driver.findElement(middleNameInput).sendKeys(middleName);
    driver.findElement(lastNameInput).sendKeys(lastName);
  }

  public void saveEmployee() {
    driver.findElement(saveButton).click();
    getWait().until(d -> d.findElement(employeeListUrl).isDisplayed());
  }
}
