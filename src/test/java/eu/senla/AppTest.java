package eu.senla;

import java.time.Duration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/** Unit test for simple App. */
public class AppTest {

  @Test
  public void testApp() {

    WebDriver driver = new ChromeDriver();

    final int implicitWaitSeconds = 10;

    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWaitSeconds));

    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

    System.out.println("Browser is opened");

    driver.findElement(By.xpath("//h5[text()='Login']"));

    driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");

    driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");

    driver.findElement(By.tagName("button")).click();

    driver.findElement(By.xpath(".//span[text()='Admin']")).click();

    driver.findElement(By.xpath("//label[text()='Username']/../..//input"));

    driver.findElement(By.xpath("//label[text()='User Role']/../../div/div")).click();

    driver.findElement(By.xpath("//div[@role='listbox']//span[text()='Admin']")).click();

    driver.findElement(By.xpath(".//button[text()=' Search ']")).click();

    driver.findElement(By.xpath(".//button[text()=' Add ']")).click();

    driver.quit();
   }
 }
