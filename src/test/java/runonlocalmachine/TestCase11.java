package runonlocalmachine;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class TestCase11 {
    public WebDriver driver;

    @Test(enabled = false)
    public void Login() {

        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://dar-us-salam.com/");
        driver.manage().window().maximize();

        // Login
        driver.findElement(By.xpath("register-button")).click();
        driver.findElement(By.name("email")).sendKeys("dandyrepo@gmail.com");
        driver.findElement(By.name("password")).sendKeys("Sekundayo80%");
        driver.findElement(By.id("submit-login")).click();

        // Assertion
        Assert.assertEquals("Log out", "Log out");

        // Hover
        driver.findElement(By.xpath("//*[@id=\"category-4\"]/a")).click();

        System.out.println(driver.getTitle()+" From firefox2 node");
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();

    }
}
