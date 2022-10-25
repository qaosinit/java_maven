package pages;

import org.openqa.selenium.WebDriver;

public class СheckoutPage extends HelperPages {
    public СheckoutPage(WebDriver driver) {
        super(driver);
    }

    public int countRowsInTableOrderSummary(){
        return getWebElements("#box-checkout-summary tr:not(.header) .item").size();
    }

    public boolean checkCountRowsInTableOrderSummary(String countRows){
        return waitToBeTextInElement("#box-checkout-summary tbody tr:nth-child(2)>td:nth-of-type(1)", countRows);
    }
}
