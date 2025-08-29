package eu.senla.Leave;

import eu.senla.Waits.Waits;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class LeavePage {
  private final By leaveModuleLink = By.xpath("//a[@href='/web/index.php/leave/viewLeaveModule']");
  private final By assignLeaveMenu =
      By.xpath("//a[@class='oxd-topbar-body-nav-tab-item'][text()='Assign Leave']");
  private final By leaveTitle = By.xpath("//p[@class='oxd-text oxd-text--p orangehrm-main-title']");
  private final By assignEmployeeNameField =
      By.xpath("//div[@class='oxd-autocomplete-text-input--before']/following::input[1]");
  private final By assignEmployeeSearchBox =
      By.cssSelector("div[role='listbox'] div:nth-of-type(1) span");

  private final By assignLeaveTypeField = By.xpath("//div[contains(text(),'-- Select --')]");

  private final By entitlementsDropDown =
      By.xpath("//span[normalize-space()='Entitlements']//i[@class='oxd-icon bi-chevron-down']");
  private final By addEntitlementsButton = By.xpath("//a[text()='Add Entitlements']");
  private final By entitlementField =
      By.xpath(
          "//div[@class='oxd-input-group oxd-input-field-bottom-space']"
              + "//div//input[@class='oxd-input oxd-input--active']");
  private final By saveButton = By.cssSelector("button[type='submit']");

  private final By confirmButton = By.xpath("//button[normalize-space()='Confirm']");
  private final By fromDateInput =
      By.xpath("//div[@class='oxd-autocomplete-text-input--before']/following::input[2]");
  private final By toDateInput =
      By.xpath("//div[@class='oxd-autocomplete-text-input--before']/following::input[3]");
  private final By assignButton = By.xpath("//button[@type='submit']");
  private final By confirmationMessage = By.id("oxd-toaster_1");

  @Step("Navigate to Leave tab")
  public LeavePage navigateToLeavePage() {
    Waits.waitVisibilityOfElementLocated(leaveModuleLink).click();
    return this;
  }

  @Step("Click entitlements Dropdown")
  public LeavePage openEntitlementsMenu() {
    Waits.waitVisibilityOfElementLocated(entitlementsDropDown).click();
    return this;
  }

  @Step("Click add entitlements")
  public LeavePage clickAddEntitlements() {
    Waits.waitVisibilityOfElementLocated(addEntitlementsButton).click();
    return this;
  }

  @Step("Fill entitlement field")
  public LeavePage fillEntitlementField(int days) {
    Waits.waitVisibilityOfElementLocated(entitlementField).sendKeys(String.valueOf(days));
    return this;
  }

  @Step("Click save button")
  public LeavePage clickSaveButton() {
    Waits.waitVisibilityOfElementLocated(saveButton).click();
    return this;
  }

  @Step("Click confirmation button")
  public LeavePage clickConfirmButton() {
    Waits.waitVisibilityOfElementLocated(confirmButton).click();
    return this;
  }

  @Step("Click Assign Leave tab")
  public LeavePage openAssignLeaveMenu() {
    Waits.waitVisibilityOfElementLocated(assignLeaveMenu).click();
    return this;
  }

  @Step("Fill employee name field")
  public LeavePage fillEmployeeName(String employee) {
    Waits.waitVisibilityOfElementLocated(assignEmployeeNameField).sendKeys(employee);
    return this;
  }

  @Step("Click Leave Type")
  public LeavePage clickListbox() {
    Waits.waitVisibilityOfElementLocated(assignEmployeeSearchBox).click();
    return this;
  }

  @Step("Choose Leave Type")
  public LeavePage openLeaveTypeDropDown(String leaveType) {
    By leaveTypeFromListbox = By.xpath("//span[text()='" + leaveType + "']");
    Waits.waitVisibilityOfElementLocated(assignLeaveTypeField).click();
    Waits.waitVisibilityOfElementLocated(leaveTypeFromListbox).click();
    return this;
  }

  @Step("Fill From Date field")
  public final LeavePage inputDateFrom(String date) {
    Waits.waitVisibilityOfElementLocated(fromDateInput).sendKeys(date);
    return this;
  }

  @Step("Fill To Date field")
  public final LeavePage inputDateTo(String date) {
    Waits.waitVisibilityOfElementLocated(toDateInput).sendKeys(Keys.CONTROL + "a");
    Waits.waitVisibilityOfElementLocated(toDateInput).sendKeys(Keys.DELETE);
    Waits.waitVisibilityOfElementLocated(toDateInput).sendKeys(date);
    return this;
  }

  @Step("Click Assign button")
  public final LeavePage clickAssignButton() {
    Waits.waitVisibilityOfElementLocated(assignButton).click();
    return this;
  }

  @Step("Confirmation message")
  public final LeavePage isConfirmed() {
    Waits.waitVisibilityOfElementLocated(confirmationMessage).isDisplayed();
    return this;
  }
}
