package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class ToDoTest {

    public WebDriver driver;
    String url = "https://lambdatest.github.io/sample-todo-app/";
    String node = "http://192.168.56.1:4444";
//    String node = "http://10.0.0.52:4444";
//    String node = "http://10.255.5.126:4444";
//    String node = "http://10.1.74.4:4444/";

    String str = "https://dzone.com/articles/selenium-grid-4-tutorial-for-distributed-testing";
    boolean status = false;

    @BeforeClass
    public void testSetUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setBrowserName("chrome");

        /* The execution happens on the Selenium Grid with the address mentioned earlier */
        driver = new RemoteWebDriver(new URL(node), caps);
    }

    @Test
    public void test_ToDo_App() throws InterruptedException {
        driver.navigate().to(url);
        driver.manage().window().maximize();

        TimeUnit.SECONDS.sleep(2);

        try {
            /* Mark done first two items in the list */
            driver.findElement(By.name("li1")).click();

            TimeUnit.SECONDS.sleep(2);

            driver.findElement(By.name("li2")).click();

            TimeUnit.SECONDS.sleep(2);

            /* Add an item to the list */
            driver.findElement(By.id("sampletodotext")).sendKeys("Yay, let's add it to the list");

            TimeUnit.SECONDS.sleep(2);

            driver.findElement(By.id("addbutton")).click();

            TimeUnit.SECONDS.sleep(2);

            /* Check that the items selected are added to list */
            String enteredText = driver.findElement(By.xpath("/html/body/div/div/div/ul/li[6]/span")).getText();
            if(enteredText.equals("Yay, let's add it to the list")) {
                status = true;
            }
            System.out.println("Selenium Grid 4 Standalone Testing Is Complete");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @AfterClass
    public void tearDown() {
        if(driver != null) {
            driver.quit();
        }
    }

}
