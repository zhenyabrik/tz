package ua.com.sravnizajm.pages;

import ua.com.sravnizajm.utils.Functions;
import ua.com.sravnizajm.utils.Wait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyWalletNetUaPage {

    private WebDriver driver;
    private Wait wait;
    private Functions functions;

    public MyWalletNetUaPage(WebDriver driver, Wait wait) {
        this.driver = driver;
        this.wait = wait;
        functions = new Functions(driver, wait);
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "calc")
    private WebElement calcBody;

    @FindBy(id = "amountval-val")
    public WebElement creditAmountField;

    @FindBy(className = "amount-to-return")
    private WebElement amountToReturnField;


    public WebElement getCalcBody() {
        return calcBody;
    }

    public WebElement getCreditAmountField() {
        return creditAmountField;
    }

    public WebElement getAmountToReturnField() {
        return amountToReturnField;
    }

    public String getCreditAmount(WebElement element) {
        return element.getText();
    }

    public String getCreditAmount2(WebElement element) {
        return element.getAttribute("span");
    }

}
