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

public class Registration2Test {
    WebDriver driver;

    @Test
    public void homePageTest() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("firefox");

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

        System.out.println("Firefox test got passed!");

        // Add products to cart
        driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[2]/input")).click();
        driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[2]/ul[1]/li[2]/a")).click();
        driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[1]/div[1]/div[2]/ul/li[2]/ul/li[1]/a")).click();
        driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[3]/div[1]/div/div[2]/div[3]/div[2]/input")).click();
        driver.findElement(By.id("add-to-cart-button-72")).click();

        String assertion = driver.findElement(By.className("cart-qty")).getText();
        System.out.println(assertion);

        driver.close();
    }
}
