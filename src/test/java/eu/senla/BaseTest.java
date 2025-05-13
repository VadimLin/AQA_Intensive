package eu.senla;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BaseTest {
  private static WebDriver driver;
  private static WebDriverWait wait;

  public static WebDriverWait getWait() {
    return wait;
  }

  public static WebDriver getDriver() {
    return driver;
  }

  private static String login = "Admin";
  private static String password = "admin123";
  private static String loginURL;

  public static String getLoginURL() {
    return loginURL;
  }

  public String getLogin() {
    return login;
  }

  public String getPassword() {
    return password;
  }

  static final int DURATION_SEC = 5;

  @BeforeEach
  void setUp() {
    driver = new ChromeDriver();
    wait = new WebDriverWait(driver, Duration.ofSeconds(DURATION_SEC));
    loginURL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
  }

  void loginAsUser() {
    driver.get(loginURL);
    wait.until(d -> driver.findElement(By.xpath("//input[@name='username']")).isDisplayed());
    driver.findElement(By.xpath("//input[@name='username']")).sendKeys(login);
    driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
    driver.findElement(By.tagName("button")).click();
  }

  @AfterEach
  void tearDown() {
    driver.quit();
  }
}
