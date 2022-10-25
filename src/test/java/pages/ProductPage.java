package pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ProductPage extends HelperPages {
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void addProductToCart(){
        try {
            if (waitElementNotVisibility("#box-product select")){
                clickButton("Add To Cart");
            }
        }catch (TimeoutException ex){
            Select select = new Select(getWebElement("#box-product select"));
            select.selectByIndex(1);
            clickButton("Add To Cart");
        }
    }
}
