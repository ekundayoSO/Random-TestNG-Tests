package remotestandaloneserver;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Registration1Test {
    WebDriver driver;

    @Test
    public void homePageTest() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("MicrosoftEdge");

        URL url = new URL("http://localhost:4444");

        driver = new RemoteWebDriver(url, capabilities);


        // Register new user
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();

        // Fill all details and click register button
        driver.findElement(By.className("ico-register")).click();
        driver.findElement(By.id("gender-male")).click();
        driver.findElement(By.id("FirstName")).sendKeys("Long");
        driver.findElement(By.id("LastName")).sendKeys("Roller");
        String randomEmail = RandomStringUtils.randomAlphanumeric(10) + "@gmail.com";
        driver.findElement(By.id("Email")).sendKeys(randomEmail);
        driver.findElement(By.id("Password")).sendKeys("Abc@123");
        driver.findElement(By.id("ConfirmPassword")).sendKeys("Abc@123");
        driver.findElement(By.id("register-button")).click();

        Assert.assertEquals("Logout", "Logout");

        System.out.println("MicrosoftEdge test got passed!");

        driver.close();
    }
}
