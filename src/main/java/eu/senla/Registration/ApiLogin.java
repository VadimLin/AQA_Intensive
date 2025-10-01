package eu.senla.Registration;

import eu.senla.Client.LoginHelper;
import eu.senla.Driver.Driver;
import org.openqa.selenium.Cookie;

public class ApiLogin implements LoginStrategy{

  private String targetUrl;

  public ApiLogin(String url) {
    this.targetUrl = url;
  }

  public final void login() {
    Cookie cookie =
        new Cookie.Builder("orangehrm", LoginHelper.getCookie())
            .domain("opensource-demo.orangehrmlive.com")
            .path("/web")
            .isHttpOnly(true)
            .sameSite("Lax")
            .build();

    Driver.getDriver().manage().deleteCookieNamed("orangehrm");
    Driver.getDriver().manage().addCookie(cookie);
    Driver.getDriver().get(this.targetUrl);
  }
}
