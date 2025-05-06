package eu.senla;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BaseTest {
  private WebDriver driver;

  public BaseTest() {
    driver = new ChromeDriver();
  }
  private final int durationSec = 5;
  private String login = "Admin";
  private String password = "admin123";

  public WebDriver getDriver() {
    return driver;
  }

  public int getDurationSec() {
    return durationSec;
  }

  public String getLogin() {
    return login;
  }

  public String getPassword() {
    return password;
  }



  public void loginAsUser() {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationSec));
    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    wait.until(d -> driver.findElement(By.xpath("//input[@name='username']"))
            .isDisplayed());
    driver.findElement(By.xpath("//input[@name='username']")).sendKeys(login);
    driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
    driver.findElement(By.tagName("button")).click();
  }

  public void tearDown() {
    driver.quit();
  }
}
