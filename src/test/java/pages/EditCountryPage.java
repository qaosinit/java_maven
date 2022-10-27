package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EditCountryPage extends HelperPages{
    public EditCountryPage(WebDriver driver) {
        super(driver);
    }

    public boolean checkLink(){
        boolean result = true;
        for (WebElement el: getWebElements("a>[class*='external-link']")) {
            if (!checkWorkLink(el)){
                result = false;
                break;
            }
        }
        return  result;
    }
}
