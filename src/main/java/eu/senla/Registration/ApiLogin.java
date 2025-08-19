package eu.senla.Registration;

import eu.senla.Client.LoginHelper;
import eu.senla.Driver.Driver;
import org.openqa.selenium.Cookie;




public class ApiLogin {

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

        Driver.initializeDriver().manage().deleteCookieNamed("orangehrm");
        Driver.initializeDriver().manage().addCookie(cookie);
        Driver.initializeDriver().get(this.targetUrl);
    }
}

