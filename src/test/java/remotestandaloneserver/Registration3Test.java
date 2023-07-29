package remotestandaloneserver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Registration3Test {
    WebDriver driver;

    @Test
    public void homePageTest() {

        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();

        // Register new user
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();

        // Fill all details and click register button
        driver.findElement(By.className("ico-register")).click();
        driver.findElement(By.id("gender-male")).click();
        driver.findElement(By.id("FirstName")).sendKeys("Long");
        driver.findElement(By.id("LastName")).sendKeys("Roller");
        String randomEmail = RandomStringUtils.randomAlphanumeric(2) + "@gmail.com";
        driver.findElement(By.id("Email")).sendKeys(randomEmail);
        driver.findElement(By.id("Password")).sendKeys("Abc@123");
        driver.findElement(By.id("ConfirmPassword")).sendKeys("Abc@123");
        driver.findElement(By.id("register-button")).click();

        Assert.assertEquals("Logout", "Logout");

        System.out.println("MicosoftEdge test got passed!");

        driver.close();
    }
}
