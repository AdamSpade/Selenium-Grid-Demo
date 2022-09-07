package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Locators2 {

    public static WebDriver driver;

    @BeforeAll
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setupTest() {
        // commented out because BoniGarcia dependency pulls the webdriver instead
//        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @AfterEach
    public void teardown() {
        driver.quit();
    }

    @Test
    public void test() {
        String name = "Adam";
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        try {
            driver.findElement(By.cssSelector("input#inputUsername")).sendKeys(name);
            driver.findElement(By.name("inputPassword")).sendKeys("rahulshettyacademy");
            TimeUnit.SECONDS.sleep(1);

            driver.findElement(By.className("signInBtn")).click();
            TimeUnit.SECONDS.sleep(1);

            driver.findElement(By.tagName("p")).getText();
            TimeUnit.SECONDS.sleep(1);

            Assert.assertEquals(driver.findElement(By.tagName("p")).getText(),"You are successfully logged in.");
            Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(), "Hello " + name + ",");
            TimeUnit.SECONDS.sleep(1);

            driver.findElement(By.cssSelector("button.logout-btn")).click();

            TimeUnit.SECONDS.sleep(2);
            driver.quit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
