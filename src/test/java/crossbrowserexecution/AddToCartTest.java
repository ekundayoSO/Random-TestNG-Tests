package crossbrowserexecution;


import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utility.RandomEmailGenerator;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import static org.openqa.selenium.Keys.RETURN;


public class AddToCartTest extends Base {
    public String randomEmail;

    @Test
    public void registrationAndAddItemsToCart() throws InterruptedException {

        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();

        driver.findElement(By.className("ico-register")).click();
        driver.findElement(By.id("gender-female")).click();
        driver.findElement(By.id("FirstName")).sendKeys("Sarah");
        driver.findElement(By.id("LastName")).sendKeys("Moore");
        randomEmail = RandomEmailGenerator.generateRandomEmail();
        driver.findElement(By.id("Email")).sendKeys(randomEmail);
        driver.findElement(By.id("Password")).sendKeys("tester123");
        driver.findElement(By.id("ConfirmPassword")).sendKeys("tester123");
        driver.findElement(By.id("register-button")).click();

        System.out.println(randomEmail);

        // Add products to cart
        String[] items =
                {       "Blue Jeans",
                        "Smartphone",
                        "Computing and Internet",
                        "Black & White Diamond Heart",
                        "Casual Golf Belt",
                        "Health Book",
                        "3rd Album"
                };

        for (String item : items) {
            driver.findElement(By.xpath("//input[@value='Search store']")).sendKeys(item, RETURN);
            driver.findElement(By.cssSelector("h2 a")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//input[@value='Add to cart']")).click();
        }

        // Delete products from cart
        driver.findElement(By.linkText("Shopping cart")).click();

        List<WebElement> itemsInCartElements = driver.findElements(By.cssSelector("product-name"));
        List<String> itemsInCart = new ArrayList<>();

        itemsInCartElements.forEach(item -> {
            String itemText = item.getText();
            itemsInCart.add(itemText);
        });

        if(itemsInCart.isEmpty()) {
            System.out.println("Products in the shopping Cart:");
            for (String item : itemsInCart) {
                System.out.println(item);
            }
            } else {
                System.out.println("Shopping Cart is Empty");
            }
        }


    @BeforeMethod
    public void setup() throws MalformedURLException {
        driver = initializeBrowser("chrome");
    }

    @AfterMethod
    public void tearDown() {

        driver.quit();
    }

}