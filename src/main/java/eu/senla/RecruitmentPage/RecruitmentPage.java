package eu.senla.RecruitmentPage;

import eu.senla.BasePage.BasePage;
import eu.senla.Waits.Waits;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RecruitmentPage extends BasePage {

  private final By recruitModuleLink =
      By.xpath(
          "//span[@class='oxd-text oxd-text--span "
              + "oxd-main-menu-item--name'][normalize-space()='Recruitment']");
  private final By recruitTitle =
      By.cssSelector(".oxd-text.oxd-text--h6.oxd-topbar-header-breadcrumb-module");

  private final By addButton = By.xpath("//div[@class='orangehrm-header-container']/child::button");
  private final By firstNameField = By.xpath("//input[@placeholder='First Name']");
  private final By middleNameField = By.xpath("//input[@placeholder='Middle Name']");
  private final By lastNameField = By.xpath("//input[@placeholder='Last Name']");
  private final By dropDownVacancyMenu =
      By.xpath("//div[@class='oxd-select-text--after']/child::i");
  private final By listOfVacancies = By.cssSelector("div[role='listbox'] div:nth-of-type(3) span");
  private final By emailField =
      By.xpath("//label[contains(text(),'Email')]/parent::div/following::div[1]/input");
  private final By contactNumberField =
      By.xpath("//label[text()='Contact Number']/parent::div/following::div[1]/input");
  private final By keywordsField =
      By.xpath("//input[@placeholder='Enter comma seperated words...']");
  private final By notesField = By.xpath("//textarea[@placeholder='Type here']");
  private final By saveButton = By.cssSelector("button[type='submit']");
  private final By confirmMessage = By.xpath("//div[@id='oxd-toaster_1']//p[text()='Success']");
  private final By alertMessage = By.xpath("//span[contains(@class, 'oxd-input-group__message')]");
  private final By alertEmailMessage =
      By.xpath(
          "//input[@class='oxd-input oxd-input--active "
              + "oxd-input--error']/ancestor::div/span[contains(@class, 'oxd-input-group__message')]");

  public RecruitmentPage(WebDriver driver) {
    super(driver);
  }

  @Step("Navigate to Recruitment tab")
  public RecruitmentPage navigateToRecruitModule() {
    Waits.waitVisibilityOfElementLocated(recruitModuleLink).click();
    return this;
  }

  public String getTitle() {
    return Waits.waitVisibilityOfElementLocated(recruitTitle).getText();
  }

  @Step("Click save button")
  public RecruitmentPage clickAddButton() {
    Waits.waitVisibilityOfElementLocated(addButton).click();
    return this;
  }

  @Step("Fill First Name field")
  public RecruitmentPage enterFirstName(String firstname) {
    Waits.waitVisibilityOfElementLocated(firstNameField).sendKeys(firstname);
    return this;
  }

  @Step("Fill Middle Name field")
  public RecruitmentPage enterMiddleName(String middlename) {
    Waits.waitVisibilityOfElementLocated(middleNameField).sendKeys(middlename);
    return this;
  }

  @Step("Fill Last Name field")
  public RecruitmentPage enterLastName(String lastname) {
    Waits.waitVisibilityOfElementLocated(lastNameField).sendKeys(lastname);
    return this;
  }

  @Step("Open dropdown vacancy menu")
  public RecruitmentPage openDropDownMenu() {
    Waits.waitVisibilityOfElementLocated(dropDownVacancyMenu).click();
    return this;
  }

  @Step("Click on vacancy")
  public RecruitmentPage chooseFromListVacancies() {
    Waits.waitVisibilityOfElementLocated(listOfVacancies).click();
    return this;
  }

  @Step("Fill email field")
  public RecruitmentPage enterEmail(String email) {
    Waits.waitVisibilityOfElementLocated(emailField).sendKeys(email);
    return this;
  }

  @Step("Fill contact number field")
  public RecruitmentPage enterContactNumber(String number) {
    Waits.waitVisibilityOfElementLocated(contactNumberField).sendKeys(number);
    return this;
  }

  @Step("Fill keywords field")
  public RecruitmentPage enterKeywords(String keywords) {
    Waits.waitVisibilityOfElementLocated(keywordsField).sendKeys(keywords);
    return this;
  }

  @Step("Fill notes field")
  public RecruitmentPage enterNotes(String notes) {
    Waits.waitVisibilityOfElementLocated(notesField).sendKeys(notes);
    return this;
  }

  @Step("Confirmation message")
  public RecruitmentPage isConfimed() {
    Waits.waitVisibilityOfElementLocated(confirmMessage);
    return this;
  }

  @Step("Click save button")
  public RecruitmentPage clickSaveButton() {
    Waits.waitVisibilityOfElementLocated(saveButton).click();
    return this;
  }

  @Step("Fill required fields")
  public RecruitmentPage fillOnlyRequiredCandidateFields(
      String firstName, String lastName, String email) {
    Waits.waitVisibilityOfElementLocated(firstNameField).sendKeys(firstName);
    Waits.waitVisibilityOfElementLocated(lastNameField).sendKeys(lastName);
    Waits.waitVisibilityOfElementLocated(emailField).sendKeys(email);
    Waits.waitVisibilityOfElementLocated(saveButton).click();
    return this;
  }

  public String getEmailAlertText() {
    return Waits.waitVisibilityOfElementLocated(alertEmailMessage).getText();
  }

  public String getRequiredAlert() {
    return Waits.waitVisibilityOfElementLocated(alertMessage).getText();
  }
}
