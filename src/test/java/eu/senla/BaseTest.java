package eu.senla;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
  private WebDriver driver = new ChromeDriver();
  private String login = "Admin";
  private String password = "admin123";

  public WebDriver getDriver() {
    return driver;
  }


  public String getLogin() {
    return login;
  }

  public String getPassword() {
    return password;
  }

  @BeforeTest
  public void setUp() {
    final int duration = 3;
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(duration));
    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    loginAsUser();
  }

  protected void loginAsUser() {
    driver.findElement(By.xpath("//input[@name='username']")).sendKeys(login);
    driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
    driver.findElement(By.tagName("button")).click();
  }

  @AfterTest
  public void tearDown() {
    driver.quit();
  }
}
