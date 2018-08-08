package ua.com.sravnizajm.pages;

import ua.com.sravnizajm.utils.Functions;
import ua.com.sravnizajm.utils.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.*;

public class SravniZaymPage {

    private WebDriver driver;
    private Wait wait;
    private Functions functions;

    public SravniZaymPage(WebDriver driver, Wait wait) {
        this.driver = driver;
        this.wait = wait;
        functions = new Functions(driver, wait);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//*[@class='submit'])[10]")
    private WebElement submitButton;
    @FindBy(xpath = "(//*[@class='noUi-pips noUi-pips-horizontal'])[1]")
    private WebElement slider;
    @FindBy(xpath = "(//*[@class='noUi-value noUi-value-horizontal noUi-value-large'])[3]")
    public WebElement creditAmountField;


    public WebElement getSlider() {
        return slider;
    }

    public WebElement getSubmitButton() {
        return submitButton;
    }

    public void openPage(String pages) {
        driver.get(pages);
    }

    public void moveCreditAmountSlider(WebElement element) {
        int x = 40;
        int width = element.getSize().getWidth();
        Actions move = new Actions(driver);
        move.moveToElement(element, ((width * x) / 100), 0).click();
        move.build().perform();
    }

    int indexOfMinimum;
    public void createCommissionAmountList() {
        ArrayList<String> obtainedList = new ArrayList();
        List<WebElement> elementList = driver.findElements(By.xpath("//ul[@class='noFirst']//div[3]/span[@class='value']/div[@class='cell']/span"));
        for(WebElement we:elementList){
            obtainedList.add(we.getText());
        }

        ArrayList<Integer> sortedList = new ArrayList(obtainedList.size()) ;
        for (String myInt : obtainedList)
        {
            sortedList.add(Integer.valueOf(myInt));
        }

        System.out.println("commission are: " + sortedList);
        indexOfMinimum = sortedList.indexOf(Collections.min(sortedList));
        System.out.println(indexOfMinimum);


    }
}
