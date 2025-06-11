package eu.senla.RecruitmentPage;

import eu.senla.BasePage.BasePage;
import eu.senla.Waits.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RecruitmentPage extends BasePage {

  private final By recruitModuleLink =
      By.xpath(
          "//span[@class='oxd-text oxd-text--span "
              + "oxd-main-menu-item--name'][normalize-space()='Recruitment']");
  private final By recruitTitle =
      By.cssSelector(".oxd-text.oxd-text--h6.oxd-topbar-header-breadcrumb-module");

  public RecruitmentPage(WebDriver driver) {
    super(driver);
  }

  public RecruitmentPage navigateToRecruitModule() {
    Waits.waitVisibilityOfElementLocated(recruitModuleLink).isDisplayed();
    driver.findElement(recruitModuleLink).click();
    return this;
  }

  public String getTitle() {
    Waits.waitVisibilityOfElementLocated(recruitTitle).isDisplayed();
    return driver.findElement(recruitTitle).getText();
  }
}
