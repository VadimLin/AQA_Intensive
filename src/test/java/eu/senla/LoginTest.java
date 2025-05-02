package eu.senla;

import java.time.Duration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest extends BaseTest {

  @Test
  public void testLogin() {

    final int durationSec = 3;

    WebDriver driver = new ChromeDriver();

    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(durationSec));

    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

    System.out.println("Browser is opened");

    driver.findElement((By.xpath("//input[@name='username']"))).sendKeys(getLogin());

    driver.findElement(By.xpath("//input[@name='password']")).sendKeys(getPassword());

    driver.findElement(By.tagName("button")).click();

    driver.quit();
  }
}
