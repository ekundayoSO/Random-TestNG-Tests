package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class Base {

    public WebDriver driver;
    public WebDriver initializeBrowser(String browserName) throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();

        if(browserName.equals("chrome")) {
            dc.setBrowserName("chrome");
        } else if(browserName.equals("firefox")) {
            dc.setBrowserName("firefox");
        } else if(browserName.equals("edge")) {
            dc.setBrowserName("edge");
        }

        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), dc);

        return driver;
    }

}


