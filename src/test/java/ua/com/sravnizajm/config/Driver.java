package ua.com.sravnizajm.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.util.concurrent.TimeUnit;

public class Driver {
    protected WebDriver driver;
    private final int IMPLICIT_WAIT = 10;

    public void createMyDriver() {
        DesiredCapabilities capability;
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");
        capability = DesiredCapabilities.chrome();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");
        capability.setCapability(ChromeOptions.CAPABILITY, options);
        driver = new ChromeDriver(capability);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
    }

    public WebDriver getDriver(){
        return driver;
    }
}
