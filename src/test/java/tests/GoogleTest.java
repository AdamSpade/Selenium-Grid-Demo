package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class GoogleTest {

    @Test
    public void HomepageCheck() throws MalformedURLException {

        WebDriver driver;
        URL url = new URL("http://10.0.0.52:4444/");

        DesiredCapabilities desCap = new DesiredCapabilities();
        desCap.setCapability(CapabilityType.BROWSER_NAME, "chrome");
        desCap.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);

        driver = new RemoteWebDriver(url, desCap);
        driver.get("https://www.google.com/");
        System.out.println(driver.getTitle());

        WebElement element;
        element = driver.findElement(By.name("q"));
        element.sendKeys("Rubber Ducky");
        element.submit();
//        driver.findElement(By.name("q")).sendKeys("Rubber Ducky");

        System.out.println("Beginning Timer");

        int sec = 0;
        while(sec < 5) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            sec++;
            System.out.println("Seconds passed: " + sec);
        }
        driver.close();
    }
}
