package eu.senla;

import eu.senla.Endpoints.Endpoints;
import eu.senla.LogoutPage.LogoutPage;
import eu.senla.PropertyFile.ReadPropertyFile;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LogoutTest extends BaseTest {
    @DisplayName("Check successful logout")
    @Tag("smoke")
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
