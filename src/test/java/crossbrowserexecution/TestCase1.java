package crossbrowserexecution;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class TestCase1 extends Base {
    public WebDriver driver;

    @Test(enabled = false)
    public void Login() {

        driver.get("https://dar-us-salam.com/");
        driver.manage().window().maximize();

        // Login
        driver.findElement(By.xpath("register-button")).click();
        driver.findElement(By.name("email")).sendKeys("dandyrepo@gmail.com");
        driver.findElement(By.name("password")).sendKeys("Testing@2023");
        driver.findElement(By.id("submit-login")).click();

        // Assertion
        Assert.assertEquals("Log out", "Log out");

        // Hover
        driver.findElement(By.xpath("//*[@id=\"category-4\"]/a")).click();

        System.out.println(driver.getTitle()+" From firefox2 node");
    }


    @BeforeMethod
    public void setup() throws MalformedURLException {
        driver = initializeBrowser("firefox");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();

    }
}
