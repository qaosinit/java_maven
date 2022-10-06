package pages;

import org.openqa.selenium.WebDriver;

public class LoginAdminPage extends HelperPages {
    public LoginAdminPage(WebDriver driver) {
        super(driver);
    }

    public void openAdminPage(){
        driver.get(baseUrl + "/litecart/admin");
    }

    public void authorizationAdmin(){
        inputInField("username", "admin");
        inputInField("password", "admin");
        clickCheckbox("remember_me");
        clickButton("Login");
    }
}
