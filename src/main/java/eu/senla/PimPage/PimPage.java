package eu.senla.PimPage;

import eu.senla.BasePage.BasePage;
import eu.senla.Driver.Driver;
import eu.senla.Waits.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PimPage extends BasePage {
  private final WebDriver driver;
  private final Waits waits;
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

  public PimPage(Waits waits) {
    this.driver = Driver.getDriver();
    this.waits = waits;
  }

  public void navigateToPimModule() {
    waits.getWait().until(d -> driver.findElement(pimModuleLink).isDisplayed());
    driver.findElement(pimModuleLink).click();
  }

  public void clickAddEmployee() {
    waits.getWait().until(d -> driver.findElement(addEmployeeButton).isDisplayed());
    driver.findElement(addEmployeeButton).click();
  }

  public void fillEmployeeDetails(String firstName, String middleName, String lastName) {
    waits.getWait().until(d -> driver.findElement(firstNameInput).isDisplayed());
    WebElement fName = driver.findElement(firstNameInput);
    fName.sendKeys(firstName);

    WebElement mName = driver.findElement(middleNameInput);
    mName.sendKeys(middleName);

    WebElement lName = driver.findElement(lastNameInput);
    lName.sendKeys(lastName);
  }

  public void saveEmployee() {
    driver.findElement(saveButton).click();
    waits.getWait().until(d -> d.findElement(employeeListUrl).isDisplayed());
  }
}
