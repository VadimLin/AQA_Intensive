package eu.senla;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


import eu.senla.LoginPage.LoginPage;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class LoginTest extends BaseTest {

  @Test
  @Order(0)
  @Tag("smoke")
  @DisplayName("Check Sign In with valid credentials")
  public void testValidLogin() {
    LoginPage loginPage = new LoginPage(waits);
    loginPage.open();
    loginPage.login(login, password);
    assertTrue(loginPage.isLoginSuccessful(), "Unsuccessful Login");
    assertEquals(
        "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index",
        driver.getCurrentUrl(),
        "Unsuccessful Login");
  }

  @ParameterizedTest(name = "Check Sign In with invalid {0}")
  @Order(1)
  @Tag("extended")
  @MethodSource("getCredentials")
  public void testInvalidLogin(String description, String username, String pwd) {
    LoginPage loginPage = new LoginPage(waits);
    loginPage.open();
    loginPage.login(username, pwd);
    String alertText = loginPage.getAlertText();
    assertEquals("Invalid credentials", alertText);
    assertEquals(
        "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login",
        driver.getCurrentUrl(),
        "Url doesn't match");
  }

  @ParameterizedTest(name = "Check Sign In with empty {0}")
  @Order(2)
  @Tag("extended")
  @MethodSource("getEmptyCredentials")
  public void testEmptyLogin(String description, String username, String pwd) {
    LoginPage loginPage = new LoginPage(waits);
    loginPage.open();
    loginPage.login(username, pwd);
    String requiredText = loginPage.getErrorText();
    String color = loginPage.getErrorColor();

    assertAll(
        () -> assertEquals("Required", requiredText),
        () -> assertEquals("rgba(235, 9, 16, 1)", color, "Color value doesn't match"),
        () ->
            assertEquals(
                "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login",
                driver.getCurrentUrl(),
                "Url doesn't match"));
  }

  private static Stream<Arguments> getCredentials() {
    return Stream.of(
        Arguments.of("password", "Admin", "123"),
        Arguments.of("username", "asdasda", "admin1234"),
        Arguments.of("password and username", "adsdasd", "1234"));
  }

  private static Stream<Arguments> getEmptyCredentials() {
    return Stream.of(
        Arguments.of("password", "Admin", ""),
        Arguments.of("username", "", "admin1234"),
        Arguments.of("password and username", "", ""));
  }
}
