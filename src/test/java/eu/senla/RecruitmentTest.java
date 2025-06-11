package eu.senla;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import eu.senla.Driver.Driver;
import eu.senla.PropertyFile.ReadPropertyFile;
import eu.senla.RecruitmentPage.RecruitmentPage;
import org.junit.jupiter.api.Test;

public class RecruitmentTest extends BaseTest {

  @Test
  public void recruitTest() {
    RecruitmentPage recruitmentPage = new RecruitmentPage(driver);
    loginAsUser();
    recruitmentPage.navigateToRecruitModule();

    assertAll(
        () -> assertEquals(recruitmentPage.getTitle(), "Recruitment"),
        () ->
            assertEquals(
                ReadPropertyFile.getProperty("BASEURL")
                    + ReadPropertyFile.getProperty("RECRUITMENT_ENDPOINT"),
                Driver.initializeDriver().getCurrentUrl(),
                "Incorrect URL"));
  }
}
