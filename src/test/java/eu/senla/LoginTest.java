package eu.senla;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {

  @Test
  @Order(0)
  @Tag("smoke")
  @DisplayName("Check Sign In with valid credentials")
  public void testValidLogin() {
    getDriver().get(getLoginURL());

    getWait()
        .until(d -> getDriver().findElement(By.xpath("//input[@name='username']")).isDisplayed());

    getDriver().findElement((By.xpath("//input[@name='username']"))).sendKeys(getLogin());

    getDriver().findElement(By.xpath("//input[@name='password']")).sendKeys(getPassword());

    getDriver().findElement(By.tagName("button")).click();
    getWait().until(d -> getDriver().findElement((By.xpath("//span[text()='PIM']"))).isDisplayed());
    assertTrue(
        getDriver().findElement(By.xpath("//span[text()='PIM']")).isDisplayed(),
        "Unsuccessful Login");
    assertEquals(
        "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index",
        getDriver().getCurrentUrl(),
        "Unsuccessful Login");
  }

  @ParameterizedTest(name = "Check Sign In with invalid {0}")
  @Order(1)
  @Tag("extended")
  @MethodSource("getCredentials")
  public void testInvalidLogin(String description, String name, String password) {

    getDriver().get(getLoginURL());

    getWait()
        .until(d -> getDriver().findElement(By.xpath("//input[@name='username']")).isDisplayed());

    getDriver().findElement((By.xpath("//input[@name='username']"))).sendKeys(name);

    getDriver().findElement(By.xpath("//input[@name='password']")).sendKeys(password);

    getDriver().findElement(By.tagName("button")).click();

    getWait()
        .until(
            d ->
                getDriver()
                    .findElement((By.xpath("//p[text()='Invalid credentials']")))
                    .isDisplayed());

    String alert =
        getDriver().findElement((By.xpath("//p[text()='Invalid credentials']"))).getText();

    assertAll(
        () -> assertNotNull(getLoginURL()),
        () ->
            assertEquals(
                "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login",
                getDriver().getCurrentUrl(),
                "Incorrect loginUrl"),
        () -> assertEquals(alert, "Invalid credentials"));
  }

  @ParameterizedTest(name = "Check Sign In with empty {0}")
  @Order(2)
  @Tag("extended")
  @MethodSource("getEmptyCredentials")
  public void testEmptyLogin(String description, String name, String password) {

    getDriver().get(getLoginURL());

    getWait()
        .until(d -> getDriver().findElement(By.xpath("//input[@name='username']")).isDisplayed());

    getDriver().findElement((By.xpath("//input[@name='username']"))).sendKeys(name);

    getDriver().findElement(By.xpath("//input[@name='password']")).sendKeys(password);

    getDriver().findElement(By.tagName("button")).click();

    getWait()
        .until(
            d ->
                getDriver()
                    .findElement(
                        (By.xpath("//input[@name='username']/following::span[text()='Required']")))
                    .isDisplayed());

    String err =
        getDriver()
            .findElement((By.xpath("//input[@name='username']/following::span[text()='Required']")))
            .getText();

    assertAll(
        () -> assertNotNull(getLoginURL()),
        () ->
            assertEquals(
                "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login",
                getDriver().getCurrentUrl(),
                "Incorrect loginUrl"),
        () -> assertEquals("Required", err));
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
