package eu.senla.listeners;

import eu.senla.Driver.Driver;
import eu.senla.Util.ScreenshotUtil;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ScreenshotListener implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver driver = Driver.initializeDriver();
        if (driver != null) {
            ScreenshotUtil.takeScreenshot(driver);
        } else {
            System.out.println("WebDriver is null. Screenshot not taken.");
        }
    }

}
