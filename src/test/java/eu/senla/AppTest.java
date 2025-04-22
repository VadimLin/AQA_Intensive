package eu.senla;

import java.util.logging.Level;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;

/** Unit test for simple App. */
public class AppTest {

  @Test
  public void testApp() {
    LoggingPreferences logs = new LoggingPreferences();
    logs.enable(LogType.DRIVER, Level.ALL);

    ChromeOptions options = new ChromeOptions();
    options.setCapability("goog:loggingPrefs", logs);

    WebDriver driver = new ChromeDriver(options);

    // Open site
    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

    System.out.println("Browser is opened");

    //      driver.manage()
    //              .logs()
    //              .get(LogType.DRIVER)
    //              .forEach(logEntry -> System.out.println(logEntry.getMessage()));

    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }

    // Find title Login
    driver.findElement(By.xpath("//h5[text()='Login']"));

    // Find username field and input text
    driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");

    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }

    // Find password field and input password
    driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");

    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }

    // Click button Login
    driver.findElement(By.tagName("button")).click();

    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }

    // Open Admin Tab
    driver.findElement(By.xpath(".//span[text()='Admin']")).click();

    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }

    // Find username field
    driver.findElement(By.xpath("//div[2]/input"));

    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }

    // Open drop-down menu in user role
    driver.findElement(By.xpath("//div[2]/i")).click();
    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }

    // Choose Admin option
    driver.findElement(By.xpath("//div[@role='listbox']//span[text()='Admin']")).click();

    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }

    // Click Search button
    driver.findElement(By.xpath(".//button[text()=' Search ']")).click();

    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }

    // Click Add button
    driver.findElement(By.xpath(".//button[text()=' Add ']")).click();

    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }

    driver.quit();
  }
}
