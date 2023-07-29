package randomtest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class TestRegistrationLogin {
   WebDriver driver;

    @Test(enabled = false)
    public void registrationTest() throws InterruptedException {
        driver.findElement(By.xpath("//a[contains(text(),'My Account')]")).click();
        driver.findElement(By.name("email")).sendKeys("bug405@gmail.com");
        driver.findElement(By.id("reg_password")).sendKeys("Testing@2024!!");
        Thread.sleep(10000);
        driver.findElement(By.name("register")).click();

        String myUsername = driver.findElement(By.xpath("//body/div[@id='pagewrap']/div[@id='body']/div[@id='layout']/div[@id='content']/div[@id='page-36']/div[1]/div[1]/div[1]/p[1]")).getText();

        if(myUsername.contains("bug405")) {
            System.out.println("Registration1Test was successful");
        } else {
            System.out.println("Oops! Check your registration details again");
        }

    }

    @Test(priority = 2)
    public void loginTest() {

        driver.findElement(By.xpath("//a[contains(text(),'My Account')]")).click();
        driver.findElement(By.id("username")).sendKeys("dandy@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Testing@2023");
        driver.findElement(By.name("login")).click();

        String myUsername = driver.findElement(By.xpath("//body/div[@id='pagewrap']/div[@id='body']/div[@id='layout']/div[@id='content']/div[@id='page-36']/div[1]/div[1]/div[1]/p[1]")).getText();

        if(myUsername.contains("dandy")) {
            System.out.println("Login was successful");
        } else {
            System.out.println("Oops! Check your login test details again");
        }

    }

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("https://practice.automationtesting.in/#google_vignette/");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}
