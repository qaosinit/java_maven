package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddNewProductPage extends HelperPages {
    public AddNewProductPage(WebDriver driver) {
        super(driver);
    }

    public void setStatus(String status){
        if (" Enabled".contains(status)){
            getWebElement("input[type=\"radio\"][value=\"1\"]").click();
        }else {
            getWebElement("input[type=\"radio\"][value=\"0\"]").click();
        }
    }

    public void switchTabs(String nameTab){
        for (WebElement el: getWebElements(".tabs li>a")) {
            if (el.getText().equals(nameTab)){
             el.click();
            }
        }
    }

    public void inputValueInDescription(String value){
        getWebElement(".trumbowyg-editor").clear();
        getWebElement(".trumbowyg-editor").sendKeys(value);
    }
}
