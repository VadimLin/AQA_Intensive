package eu.senla;

import java.time.Duration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {


  @Test
  public void testLogin() {

    getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(getDurationSec()));

    getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

    System.out.println("Browser is opened");

    getDriver().findElement((By.xpath("//input[@name='username']"))).sendKeys(getLogin());

    getDriver().findElement(By.xpath("//input[@name='password']")).sendKeys(getPassword());

    getDriver().findElement(By.tagName("button")).click();

    getDriver().quit();
  }
}
