package eu.senla;

import java.time.Duration;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AddEmployeeTest extends BaseTest {
 private WebDriver driver = getDriver();
  @BeforeTest
  @Override
  public void setUp() {

    super.setUp();
  }

  @Test
  public void testAddEmployee() {

    Random rand = new Random();
    final int num = 1000;
    int randomIntBounded = rand.nextInt(num);

    final int durationSec = 5;

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationSec));
    wait.until(d -> driver.findElement((By.xpath(".//span[text()='PIM']"))).isDisplayed());
    driver.findElement(By.xpath(".//span[text()='PIM']")).click();

    wait.until(d -> driver.findElement((By.xpath(".//button[text()=' Add ']"))).isDisplayed());

    driver.findElement(By.xpath(".//button[text()=' Add ']")).click();

    wait.until(
        d ->
            driver
                .findElement(
                    (By.xpath("//input[@class='oxd-input oxd-input--active orangehrm-firstname']")))
                .isDisplayed());

    driver
        .findElement(By.xpath("//input[@class='oxd-input oxd-input--active orangehrm-firstname']"))
        .sendKeys("Leo");
    wait.until(
        d ->
            driver
                .findElement(
                    (By.xpath(
                        "//input[@class='oxd-input oxd-input--active orangehrm-middlename']")))
                .isDisplayed());

    driver
        .findElement(By.xpath("//input[@class='oxd-input oxd-input--active orangehrm-middlename']"))
        .sendKeys("Nar");

    wait.until(
        d ->
            driver
                .findElement(
                    (By.xpath("//input[@class='oxd-input oxd-input--active orangehrm-lastname']")))
                .isDisplayed());

    driver
        .findElement(By.xpath("//input[@class='oxd-input oxd-input--active orangehrm-lastname']"))
        .sendKeys("Do" + randomIntBounded);

    driver
        .findElement(
            By.xpath(
                "//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']"))
        .click();

    wait.until(
        d ->
            driver
                .findElement((By.xpath("//h6[@class='oxd-text oxd-text--h6 --strong']")))
                .isDisplayed());
  }

  @AfterTest
  @Override
  public void tearDown() {
    super.tearDown();

  }
}
