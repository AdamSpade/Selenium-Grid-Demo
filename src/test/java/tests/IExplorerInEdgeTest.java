package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class IExplorerInEdgeTest {

    public WebDriver driver;
    String node = "http://localhost:4444";

    @BeforeClass
    public void testSetUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
//        caps.setBrowserName("chrome");
        caps.setBrowserName("edge");

        /* The execution happens on the Selenium Grid with the address mentioned earlier */
        driver = new RemoteWebDriver(new URL(node), caps);
    }

    @Test
    public void internetExplorerInEdgeTest() {
        InternetExplorerOptions ieOptions = new InternetExplorerOptions();
        ieOptions.attachToEdgeChrome();
        ieOptions.withEdgeExecutablePath("C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe");

        WebDriver driver = new InternetExplorerDriver(ieOptions);

        driver.get("http://www.bing.com");
        WebElement element = driver.findElement(By.id("sb_form_q"));
        element.sendKeys("WebDriver", Keys.RETURN);

        driver.close();
    }
}
