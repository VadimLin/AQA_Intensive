package eu.senla;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Random;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AddEmployeeTest extends BaseTest {

  @Test
  @DisplayName("Проверка успешного добавления сотрудника")
  public void testAddEmployee() {
    loginAsUser();
    Random rand = new Random();
    final int num = 1000;
    int randomIntBounded = rand.nextInt(num);
    getWait()
        .until(d -> getDriver().findElement(By.cssSelector("a[href$='viewPimModule']")))
        .isDisplayed();

    getDriver().findElement(By.cssSelector("a[href$='viewPimModule']")).click();

    assertEquals(
        "https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList",
        getDriver().getCurrentUrl(),
        "Incorrect Url");

    getWait()
        .until(
            d ->
                getDriver()
                    .findElement(
                        (By.xpath(
                            "//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")))
                    .isDisplayed());

    getDriver()
        .findElement(
            By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']"))
        .click();

    getWait()
        .until(
            d ->
                getDriver()
                    .findElement(
                        (By.xpath(
                            "//input[@class='oxd-input oxd-input--active orangehrm-firstname']")))
                    .isDisplayed());

    WebElement fName;

    fName =
        getDriver()
            .findElement(
                By.xpath("//input[@class='oxd-input oxd-input--active orangehrm-firstname']"));

    String inputFirstName = "Leo";

    fName.sendKeys(inputFirstName);

    String actualFirstName = fName.getAttribute("value");

    getWait()
        .until(
            d ->
                getDriver()
                    .findElement(
                        (By.xpath(
                            "//input[@class='oxd-input oxd-input--active orangehrm-middlename']")))
                    .isDisplayed());

    WebElement mName;

    mName =
        getDriver()
            .findElement(
                By.xpath("//input[@class='oxd-input oxd-input--active orangehrm-middlename']"));

    String inputMiddleName = "Nar";

    mName.sendKeys(inputMiddleName);

    String actualMiddleName = mName.getAttribute("value");

    getWait()
        .until(
            d ->
                getDriver()
                    .findElement(
                        (By.xpath(
                            "//input[@class='oxd-input oxd-input--active orangehrm-lastname']")))
                    .isDisplayed());

    WebElement lName;

    lName =
        getDriver()
            .findElement(
                By.xpath("//input[@class='oxd-input oxd-input--active orangehrm-lastname']"));

    String inputLastName = "Do" + randomIntBounded;
    lName.sendKeys(inputLastName);

    String actualLastName = lName.getAttribute("value");

    assertAll(
        () -> assertEquals(inputFirstName, actualFirstName, "The first name does not match"),
        () -> assertEquals(inputMiddleName, actualMiddleName, "The middle name does not match"),
        () -> assertEquals(inputLastName, actualLastName, "The last name does not match"),
        () ->
            assertEquals(
                "https://opensource-demo.orangehrmlive.com/web/index.php/pim/addEmployee",
                getDriver().getCurrentUrl(),
                "Incorrect Url"),
        () ->
            assertTrue(
                getDriver()
                    .findElement(
                        By.xpath(
                            "//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']"))
                    .isEnabled(),
                "Button is disabled"));

    getDriver()
        .findElement(
            By.xpath(
                "//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']"))
        .click();

    getWait()
        .until(
            d ->
                getDriver()
                    .findElement((By.xpath("//h6[@class='oxd-text oxd-text--h6 --strong']")))
                    .isDisplayed());
  }
}
