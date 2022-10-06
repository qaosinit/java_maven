package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class MainPage extends HelperPages {
    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void openMainPage() {
        driver.get(baseUrl + "/litecart");
    }

    //метод проверки наличия стикиров у товаров  на главной странице
    public boolean checkHaveSticker() {
        boolean haveOneSticker = true;
        for (WebElement el : getWebElements(".product")) {
            moveTo(el);
            if (el.findElements(By.cssSelector(".sticker")).size()!=1){
                haveOneSticker = false;
                break;
            }
        }
        return haveOneSticker;
    }
}
