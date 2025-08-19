package eu.senla;

import com.github.javafaker.Faker;
import eu.senla.Driver.Driver;
import eu.senla.Endpoints.Endpoints;
import eu.senla.PropertyFile.ReadPropertyFile;
import eu.senla.RecruitmentPage.RecruitmentPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class RecruitmentTest extends BaseTest {

  @Test(description = "Successful add candidate with all fields")
  public void addCandidateTest() {
    Faker faker = new Faker();
    final int words = 5;
    String firstName = faker.name().firstName();
    String middleName = faker.name().nameWithMiddle();
    String lastName = faker.name().lastName();
    String email = faker.internet().emailAddress();
    String contactNumber = faker.phoneNumber().phoneNumber();
    String keywords = faker.lorem().words(words).toString();
    String notes = faker.lorem().sentence();

    String correctContactNumber = contactNumber.replaceAll("[^0-9+\\-\\/()]", "");

    RecruitmentPage recruitmentPage = new RecruitmentPage(driver);
    loginAsUser();
    recruitmentPage
        .navigateToRecruitModule()
        .clickAddButton()
        .enterFirstName(firstName)
        .enterMiddleName(middleName)
        .enterLastName(lastName)
        .openDropDownMenu()
        .chooseFromListVacancies()
        .enterEmail(email)
        .enterContactNumber(correctContactNumber)
        .enterKeywords(keywords)
        .enterNotes(notes)
        .clickSaveButton()
        .isConfimed();
    SoftAssert sa = new SoftAssert();
    sa.assertEquals(recruitmentPage.getTitle(), "Recruitment");
    sa.assertTrue(
                Driver.initializeDriver()
                    .getCurrentUrl()
                    .contains(
                        ReadPropertyFile.getProperty("BASEURL") + Endpoints.CANDIDATE_ENDPOINT),
                "Incorrect Url");
    sa.assertAll();
    logoutUser();
  }

  @Test(description = "Successful adding only with required fields")
  public void successfulAddCandidateOnlyWithRequiredFields() {
    Faker faker = new Faker();
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String email = faker.internet().emailAddress();

    RecruitmentPage recruitmentPage = new RecruitmentPage(driver);
    loginAsUser();
    recruitmentPage
        .navigateToRecruitModule()
        .clickAddButton()
        .fillOnlyRequiredCandidateFields(firstName, lastName, email)
        .isConfimed();
    SoftAssert sa = new SoftAssert();
    sa.assertEquals(recruitmentPage.getTitle(), "Recruitment");
    sa.assertTrue(
                driver
                    .getCurrentUrl()
                    .contains(
                        ReadPropertyFile.getProperty("BASEURL") + Endpoints.CANDIDATE_ENDPOINT),
                "Incorrect Url");
    sa.assertAll();
    logoutUser();
  }

//  @ParameterizedTest(
//      name = "Check adding candidate with valid firstName and lastName, and invalid email in {0}")
//  @MethodSource("getCredentials")
//  public void addCandidateWithInvalidData(
//      String description, String firstname, String lastname, String email) {
//    RecruitmentPage recruitmentPage = new RecruitmentPage(driver);
//    loginAsUser();
//    recruitmentPage
//        .navigateToRecruitModule()
//        .clickAddButton()
//        .fillOnlyRequiredCandidateFields(firstname, lastname, email);
//
//    assertAll(
//        () ->
//            assertEquals(
//                ReadPropertyFile.getProperty("EMAIL_ALERT"), recruitmentPage.getEmailAlertText()),
//        () ->
//            assertEquals(
//                ReadPropertyFile.getProperty("BASEURL") + Endpoints.CANDIDATE_ENDPOINT,
//                driver.getCurrentUrl(),
//                "Url doesn't match"));
//    logoutUser();
//  }
//
//  @ParameterizedTest(name = "Check adding candidate with empty {0}")
//  @MethodSource("getEmptyCredentials")
//  public void addCandidateWithEmptyData(
//      String description, String firstname, String lastname, String email) {
//    RecruitmentPage recruitmentPage = new RecruitmentPage(driver);
//    loginAsUser();
//    recruitmentPage
//        .navigateToRecruitModule()
//        .clickAddButton()
//        .fillOnlyRequiredCandidateFields(firstname, lastname, email);
//
//    assertAll(
//        () ->
//            assertEquals(
//                ReadPropertyFile.getProperty("REQUIRED_ALERT"), recruitmentPage.getRequiredAlert()),
//        () ->
//            assertEquals(
//                ReadPropertyFile.getProperty("BASEURL") + Endpoints.CANDIDATE_ENDPOINT,
//                driver.getCurrentUrl(),
//                "Url doesn't match"));
//    logoutUser();
//  }
//
//  private static Stream<Arguments> getCredentials() {
//    return Stream.of(
//        Arguments.of("without @", "John", "Lee", "test.com"),
//        Arguments.of("without comma", "Jack", "Low", "test@testcom"),
//        Arguments.of("with dots in a row", "Adam", "Saimons", "test@test..com"),
//        Arguments.of("with @ in a row", "Charlie", "Coyle", "test@@test.com"));
//  }
//
//  private static Stream<Arguments> getEmptyCredentials() {
//    return Stream.of(
//        Arguments.of("firstname", "", "Lee", "test@test.com"),
//        Arguments.of("lastname", "John", "", "test2@test.com"),
//        Arguments.of("email", "John", "Lee", ""),
//        Arguments.of("all fields", "", "", ""));
//  }
}
