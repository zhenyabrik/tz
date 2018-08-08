package ua.com.sravnizajm.utils;

import org.openqa.selenium.*;
import org.testng.Assert;

import java.util.ArrayList;

public class Functions {
    private WebDriver driver;
    private Wait wait;

    public Functions(WebDriver driver, Wait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    //asserts
    public void assertStrings(String stringActual, String stringExpected)  {
        try {
            Assert.assertEquals(stringActual, stringExpected);
        }catch (AssertionError assertionException){
            assertionException.printStackTrace();
            throw assertionException;
        }
    }

    public void assertObjects(Object objectActual, Object objectExpected)  {
        try {
            Assert.assertEquals(objectActual, objectExpected);
        }catch (AssertionError assertionException){
            assertionException.printStackTrace();
            throw assertionException;
        }
    }

    public void moveToSecondWindow() {
        ArrayList<String> tabsWindows = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabsWindows.get(1));
    }
}