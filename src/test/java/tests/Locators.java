package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Locators {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
//        System.setProperty("webdriver.edge.driver", "src/test/resources/msedgedriver.exe");
        WebDriver driver = new ChromeDriver();
//        WebDriver driver = new EdgeDriver();
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        try {
//            driver.findElement(By.id("inputUsername")).sendKeys("rahul");
            driver.findElement(By.cssSelector("input#inputUsername")).sendKeys("rahul");
            driver.findElement(By.name("inputPassword")).sendKeys("hello123");
            TimeUnit.SECONDS.sleep(1);

            driver.findElement(By.className("signInBtn")).click();
            TimeUnit.SECONDS.sleep(1);

            if(driver.findElement(By.cssSelector("p.error")).getText().equals("* Incorrect username or password")) {
                System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
                driver.findElement(By.linkText("Forgot your password?")).click();
                TimeUnit.SECONDS.sleep(1);

                // using xpath as locatorr
                driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Adam");
                driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("test@example.com");
                driver.findElement(By.xpath("//input[@placeholder='Phone Number']")).sendKeys("1234567890");
                driver.findElement(By.xpath("//input[@placeholder='Phone Number']")).clear();
                TimeUnit.SECONDS.sleep(1);

                driver.findElement(By.xpath("//input[@type='text'][3]")).sendKeys("0987654321");
                TimeUnit.SECONDS.sleep(1);

                driver.findElement(By.cssSelector("input[placeholder='Email']")).clear();
                TimeUnit.SECONDS.sleep(1);

                driver.findElement(By.cssSelector("input[placeholder='Email']:nth-child(3)")).sendKeys("example@test.com");
                TimeUnit.SECONDS.sleep(1);

                driver.findElement(By.cssSelector("button.reset-pwd-btn")).click();
                TimeUnit.SECONDS.sleep(1);

                if(driver.findElement(By.cssSelector("p.infoMsg")).getText().equals("Please use temporary password 'rahulshettyacademy' to Login.")) {
                    System.out.println("Please use temporary password 'rahulshettyacademy' to Login.");
                    driver.findElement(By.cssSelector("button.go-to-login-btn")).click();
                    TimeUnit.SECONDS.sleep(1);
                }

            }
            TimeUnit.SECONDS.sleep(2);
            driver.quit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
