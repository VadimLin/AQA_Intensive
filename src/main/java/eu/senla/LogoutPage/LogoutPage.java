package eu.senla.LogoutPage;

import eu.senla.BasePage.BasePage;
import eu.senla.Waits.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogoutPage extends BasePage {
    private final By dropDownMenu = By.cssSelector(".oxd-icon.bi-caret-down-fill.oxd-userdropdown-icon");
    private final By logoutButton = By.xpath("//a[text()='Logout']");
    private final By loginTitle = By.xpath("//h5[text()='Login']");

    public LogoutPage(WebDriver driver) {
        super(driver);
    }

    public LogoutPage openDropDownMenu() {
        Waits.waitVisibilityOfElementLocated(dropDownMenu).click();
        return this;
    }
    public LogoutPage clickLogoutButton() {
        Waits.waitVisibilityOfElementLocated(logoutButton).click();
        return this;
    }
    public String getLoginTitle() {
       return Waits.waitVisibilityOfElementLocated(loginTitle).getText();
    }
}
