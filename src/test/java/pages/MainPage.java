package pages;

import org.openqa.selenium.WebDriver;

public class MainPage extends HelperPages {
    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void openMainPage(){
        driver.get(baseUrl + "/litecart");
    }
}
