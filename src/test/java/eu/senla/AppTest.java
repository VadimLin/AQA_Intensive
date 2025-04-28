package eu.senla;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/** Unit test for simple App. */
public class AppTest {
  @Test
  public void testApp() {

    Random rand = new Random();
    int randomIntBounded = rand.nextInt(100);

    WebDriver driver = new ChromeDriver();

    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

    System.out.println("Browser is opened");

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    wait.until(
            d -> driver.findElement((By.xpath("//input[@name='username']")))
                            .isDisplayed());
    driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
    wait.until(
            d -> driver.findElement((By.xpath("//input[@name='password']")))
                    .isDisplayed());

    driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
    wait.until(
            d -> driver.findElement((By.tagName("button")))
                    .isDisplayed());
    driver.findElement(By.tagName("button")).click();
    wait.until(
            d -> driver.findElement((By.xpath(".//span[text()='PIM']")))
                    .isDisplayed());
    driver.findElement(By.xpath(".//span[text()='PIM']")).click();

    wait.until(
            d -> driver.findElement((By.xpath(".//button[text()=' Add ']")))
                    .isDisplayed());

    driver.findElement(By.xpath(".//button[text()=' Add ']")).click();

    wait.until(
            d -> driver.findElement((By.xpath("//input[@class='oxd-input oxd-input--active orangehrm-firstname']")))
                    .isDisplayed());

    driver.findElement(By.xpath("//input[@class='oxd-input oxd-input--active orangehrm-firstname']"))
            .sendKeys("Leo");
    wait.until(
            d -> driver.findElement((By.xpath("//input[@class='oxd-input oxd-input--active orangehrm-middlename']")))
                    .isDisplayed());

    driver.findElement(By.xpath("//input[@class='oxd-input oxd-input--active orangehrm-middlename']"))
            .sendKeys("Nar");

    wait.until(
            d -> driver.findElement((By.xpath("//input[@class='oxd-input oxd-input--active orangehrm-lastname']")))
                    .isDisplayed());

    driver.findElement(By.xpath("//input[@class='oxd-input oxd-input--active orangehrm-lastname']"))
            .sendKeys("Do" + + randomIntBounded);


   wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']"))));

      driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")).click();

    wait.until(
            d -> driver.findElement((By.xpath("//h6[@class='oxd-text oxd-text--h6 --strong']")))
                    .isDisplayed());

      driver.quit();
  }
}

