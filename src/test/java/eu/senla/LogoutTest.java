package eu.senla;

import eu.senla.Endpoints.Endpoints;
import eu.senla.LogoutPage.LogoutPage;
import eu.senla.PropertyFile.ReadPropertyFile;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LogoutTest extends BaseTest {
    @Test
    public void logoutTest() {
        LogoutPage logoutPage = new LogoutPage(driver);
        loginAsUser();
        logoutPage.openDropDownMenu().clickLogoutButton().getLoginTitle();
        assertEquals(
                ReadPropertyFile.getProperty("BASEURL") + Endpoints.AUTH_ENDPOINT,
                driver.getCurrentUrl(),
                "Url doesn't match");
    }
}
