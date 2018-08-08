package ua.com.sravnizajm.config;

import ua.com.sravnizajm.pages.MyWalletNetUaPage;
import org.openqa.selenium.WebDriver;
import ua.com.sravnizajm.utils.TestListener;
import ua.com.sravnizajm.utils.Wait;
import ua.com.sravnizajm.pages.SravniZaymPage;

public class BasePage extends BaseTest {
    public SravniZaymPage sravniZaymPage;
    public MyWalletNetUaPage myWalletNetUa;
    public TestListener testListener;

    public BasePage(WebDriver driver, Wait wait) {
        sravniZaymPage = new SravniZaymPage(driver, wait);
        myWalletNetUa = new MyWalletNetUaPage(driver, wait);
        testListener = new TestListener();
    }
}
