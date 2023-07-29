package remotestandaloneserver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class HomepageTest {
    WebDriver driver;

    @Test
    public void homePageTest() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");

        URL url = new URL("http://localhost:4444");

        driver = new RemoteWebDriver(url, capabilities);

        driver.manage().window().maximize();

        driver.get("https://demowebshop.tricentis.com/");

        System.out.println(driver.getTitle());

        driver.quit();

    }

}
