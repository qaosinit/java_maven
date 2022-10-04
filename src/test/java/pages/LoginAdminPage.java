package pages;

import org.openqa.selenium.WebDriver;

public class LoginAdminPage extends HelperPages {
    public LoginAdminPage(WebDriver driver) {
        super(driver);
    }

    public void openAdminPage(){
        driver.get(baseUrl + "/litecart/admin");
    }
}
