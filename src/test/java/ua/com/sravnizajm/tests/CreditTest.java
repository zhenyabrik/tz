package ua.com.sravnizajm.tests;

import ua.com.sravnizajm.config.BaseTest;
import ua.com.sravnizajm.utils.Constants;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ua.com.sravnizajm.utils.Log;
import ua.com.sravnizajm.utils.TestListener;

@Listeners(TestListener.class)
public class CreditTest extends BaseTest {

    private String expectedCreditAmount;
    private String actualCreditAmount;

    @Test()
    public void chooseCreditWithMinCommission() {
        page.sravniZaymPage.openPage(Constants.URL);
        page.sravniZaymPage.moveCreditAmountSlider(page.sravniZaymPage.getSlider());

        expectedCreditAmount = page.myWalletNetUa.getCreditAmount(page.sravniZaymPage.creditAmountField);
        Log.info("expectedCreditAmount " + expectedCreditAmount);

        page.sravniZaymPage.createCommissionAmountList();
        wait.visibleThenClick(page.sravniZaymPage.getSubmitButton());
        functions.moveToSecondWindow();
        wait.visible(page.myWalletNetUa.getCalcBody());

        actualCreditAmount = page.myWalletNetUa.getCreditAmount(page.myWalletNetUa.creditAmountField);
        Log.info("actualCreditAmount " + actualCreditAmount);

        if (actualCreditAmount.equals(expectedCreditAmount)){
            Log.info("КРЕДИТ ВЗЯТЬ МОЖНО");
        } else {
            Log.error("КРЕДИТ ВЗЯТЬ НЕЛЬЗЯ");
        }

        functions.assertStrings(actualCreditAmount, expectedCreditAmount);
    }
}
