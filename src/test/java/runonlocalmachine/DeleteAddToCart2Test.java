package runonlocalmachine;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import utility.RandomEmailGenerator;

import java.util.List;


public class DeleteAddToCart2Test {
public String randomEmail;
public WebDriver driver;

    @Test(priority = 2)
    public void deleteItems() throws InterruptedException {

        //Login
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();

        driver.findElement(By.className("ico-login")).click();
        randomEmail = RandomEmailGenerator.generateRandomEmail();
        driver.findElement(By.id("Email")).sendKeys(randomEmail);
        driver.findElement(By.id("Password")).sendKeys("tester123");
        driver.findElement(By.xpath("//input[@value='Log in']")).click();

        Thread.sleep(5000);


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


    @AfterMethod
    public void tearDown() {
        driver.quit();

    }
}