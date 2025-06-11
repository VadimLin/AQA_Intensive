package eu.senla.AdminPage;

import eu.senla.BasePage.BasePage;
import eu.senla.Waits.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminPage extends BasePage {

  private final By adminModuleLink = By.xpath("//a[@href='/web/index.php/admin/viewAdminModule']");

  private final By jobDropDown = By.xpath("//span[normalize-space()='Job']");
  private final By jobTitlesOption = By.xpath("//a[normalize-space()='Job Titles']");
  private final By addButton = By.xpath("//i[@class='oxd-icon bi-plus oxd-button-icon']");
  private final By jobTitle = By.xpath("//h6[normalize-space()='Job Titles']");
  private final By jobTitleField =
      By.xpath(
          "//div[@class='oxd-input-group oxd-input-field-bottom-space']"
              + "//div//input[@class='oxd-input oxd-input--active']");
  private final By saveButton = By.cssSelector("button[type='submit']");
  private final By adminTitle =
      By.cssSelector(".oxd-text.oxd-text--h6.oxd-topbar-header-breadcrumb-module");
  private final By rowTable = By.xpath("//div[@role='rowgroup']");

  public AdminPage(WebDriver driver) {
    super(driver);
  }

  public AdminPage navigateToAdminModule() {
    Waits.waitVisibilityOfElementLocated(adminModuleLink).isDisplayed();
    driver.findElement(adminModuleLink).click();
    return this;
  }

  public String getAdminTitle() {
    Waits.waitVisibilityOfElementLocated(adminTitle).isDisplayed();
    return driver.findElement(adminTitle).getText();
  }

  public AdminPage clickDropDownMenu() {
    Waits.waitVisibilityOfElementLocated(jobDropDown).click();
    return this;
  }

  public AdminPage clickJobTitlesOption() {
    Waits.waitVisibilityOfElementLocated(jobTitlesOption).click();
    return this;
  }

  public AdminPage clickAddButton() {
    Waits.waitVisibilityOfElementLocated(addButton).click();
    return this;
  }

  public AdminPage fillJobTitlefield(String jobTitle) {
    Waits.waitVisibilityOfElementLocated(jobTitleField).sendKeys(jobTitle);
    return this;
  }

  public AdminPage saveJobTitle() {
    Waits.waitVisibilityOfElementLocated(saveButton).click();
    Waits.waitVisibilityOfElementLocated(jobTitle).isDisplayed();
    return this;
  }

  public String getJobTitle() {
    Waits.waitVisibilityOfElementLocated(jobTitle).isDisplayed();
    return driver.findElement(jobTitle).getText();
  }
}
