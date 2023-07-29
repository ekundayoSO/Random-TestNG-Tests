package crossbrowserexecution;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.util.List;

public class DeleteCartTest extends Base {

    @Test
    public void deleteItems() {

        //Login
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();

        driver.findElement(By.className("ico-login")).click();
        driver.findElement(By.id("Email")).sendKeys("kvM@net.com");
        driver.findElement(By.id("Password")).sendKeys("tester123");
        driver.findElement(By.xpath("//input[@value='Log in']")).click();

        // Delete products from cart
        driver.findElement(By.xpath("//span[contains(text(),'Shopping cart')]")).click();
        List<WebElement> checkboxes = driver.findElements(By.xpath("//td/input[@type='checkbox']"));
        for (WebElement checkbox : checkboxes) {
            checkbox.click();
        }

        driver.findElement(By.xpath("//input[@value='Update shopping cart']")).click();

        String expectedMsg = "Your Shopping Cart is empty!";
        String actualMsg = driver.findElement(By.xpath("//*[contains(text(),'Your Shopping Cart is empty!')]")).getText();
        Assert.assertEquals(actualMsg, expectedMsg);

        System.out.println(actualMsg);
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