package ua.com.sravnizajm.config;

import org.testng.annotations.*;
import ua.com.sravnizajm.utils.Functions;
import ua.com.sravnizajm.utils.Log;
import ua.com.sravnizajm.utils.TestListener;
import ua.com.sravnizajm.utils.Wait;

public class BaseTest extends Driver {
    protected Wait wait;
    protected Functions functions;
    protected BasePage page;
    protected Log log;
    protected TestListener testListener;

    @BeforeMethod(alwaysRun = true)
    public void setup() {
        super.createMyDriver();
        wait = new Wait(driver);
        page = new BasePage(driver, wait);
        functions = new Functions(driver, wait);
        log = new Log();
        testListener = new TestListener();
    }

    @AfterMethod(alwaysRun=true)
    public void tearDown(){
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
