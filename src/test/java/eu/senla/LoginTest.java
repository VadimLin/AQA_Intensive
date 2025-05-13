package eu.senla;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {

  @Test
  @Order(0)
  @Tag("smoke")
  @DisplayName("Check Sign In with valid credentials")
  public void testValidLogin() {
    getDriver().get(LOGIN_URL);

    getWait()
        .until(d -> getDriver().findElement(By.xpath("//input[@name='username']")).isDisplayed());

    getDriver().findElement((By.xpath("//input[@name='username']"))).sendKeys(getLogin());

    getDriver().findElement(By.xpath("//input[@name='password']")).sendKeys(getPassword());

    getDriver().findElement(By.tagName("button")).click();
    getWait()
        .until(
            d ->
                getDriver()
                    .findElement(
                        (By.xpath(
                            "//a[@class='oxd-main-menu-item active']/span[@class='oxd-text oxd-text--span oxd-main-menu-item--name']")))
                    .isDisplayed());
    assertTrue(
        getDriver()
            .findElement(
                By.xpath(
                    "//a[@class='oxd-main-menu-item active']/span[@class='oxd-text oxd-text--span oxd-main-menu-item--name']"))
            .isDisplayed(),
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

    getDriver().get(LOGIN_URL);

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
                        (By.xpath(
                            "//div/div/p[@class='oxd-text oxd-text--p oxd-alert-content-text']")))
                    .isDisplayed());

    String alert =
        getDriver()
            .findElement(
                (By.xpath("//div/div/p[@class='oxd-text oxd-text--p oxd-alert-content-text']")))
            .getText();

    assertAll(
        () -> assertNotNull(LOGIN_URL),
        () ->
            assertEquals(
                "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login",
                getDriver().getCurrentUrl(),
                "Incorrect loginUrl"),
        () -> assertEquals("Invalid credentials", alert));
  }

  @ParameterizedTest(name = "Check Sign In with empty {0}")
  @Order(2)
  @Tag("extended")
  @MethodSource("getEmptyCredentials")
  public void testEmptyLogin(String description, String name, String password) {

    getDriver().get(LOGIN_URL);

    getWait()
        .until(d -> getDriver().findElement(By.xpath("//input[@name='username']")).isDisplayed());

    getDriver().findElement((By.xpath("//input[@name='username']"))).sendKeys(name);

    getDriver().findElement(By.xpath("//input[@name='password']")).sendKeys(password);

    getDriver().findElement(By.tagName("button")).click();

    getWait()
        .until(
            d ->
                getDriver()
                    .findElement((By.xpath("//input[@name='username']/following::span")))
                    .isDisplayed());

    String err =
        getDriver().findElement((By.xpath("//input[@name='username']/following::span"))).getText();

    WebElement element =
        getDriver().findElement((By.xpath("//input[@name='username']/following::span")));

    String colorValue = element.getCssValue("color");
    System.out.println("Element color is " + colorValue);
    String expectedColor = "rgba(235, 9, 16, 1)";
    assertAll(
        () -> assertNotNull(LOGIN_URL),
        () ->
            assertEquals(
                "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login",
                getDriver().getCurrentUrl(),
                "Incorrect loginUrl"),
        () -> assertEquals("Required", err),
        () -> assertEquals(expectedColor, colorValue, "Color value doesn't match"));
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
