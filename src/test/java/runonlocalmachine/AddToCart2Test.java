package runonlocalmachine;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import utility.RandomEmailGenerator;

import java.util.ArrayList;
import java.util.List;

import static org.openqa.selenium.Keys.RETURN;


public class AddToCart2Test {
    public String randomEmail;
    public WebDriver driver;

    @Test(priority = 1)
    public void registrationAndAddItemsToCart() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();

        driver.findElement(By.className("ico-login")).click();
        randomEmail = RandomEmailGenerator.generateRandomEmail();
        driver.findElement(By.id("Email")).sendKeys(randomEmail);
        driver.findElement(By.id("Password")).sendKeys("tester123");
        driver.findElement(By.xpath("//input[@value='Log in']")).click();


        System.out.println(randomEmail);

        Thread.sleep(2000);


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

    @AfterMethod
    public void tearDown() {

        driver.quit();
    }

}