package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CatalogPage extends HelperPages {
    public CatalogPage(WebDriver driver) {
        super(driver);
    }

    public void clickAddNewProduct(){
        getWebElement("[href*=edit_product]").click();
    }

    public boolean checkHaveProduct(String nameProduct){
        while (driver.findElements(By.xpath("//*[contains(@class, 'folder')]/following-sibling::a")).size()!=0){
            for (WebElement e : driver.findElements(By.xpath("//*[contains(@class, 'folder')]/following-sibling::a"))) {
                if(Integer.parseInt(e.getCssValue("font-weight"))< 700){
                    e.click();
                }
            }
        }
        boolean result = false;
        for (WebElement el: getWebElements(".row >td:nth-child(3) a")) {
            if (el.getText().equals(nameProduct)){
                result = true;
                break;
            }
        }
        return result;
    }

    public void openAllFolder(){
        while (driver.findElements(By.xpath("//*[contains(@class, 'folder')]/following-sibling::a")).size()!=0){
            for (WebElement e : driver.findElements(By.xpath("//*[contains(@class, 'folder')]/following-sibling::a"))) {
                if(Integer.parseInt(e.getCssValue("font-weight"))< 700){
                    e.click();
                }
            }
        }
    }
}
