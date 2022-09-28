package pages;

import org.openqa.selenium.WebDriver;

public class AdminPage extends HelperPages {
    public AdminPage(WebDriver driver) {
        super(driver);
    }

    public boolean checkAuthorizationAdmin(){
        return getWebElement("//a[contains(@href, '/admin/logout.php')]").isDisplayed();
    }
}
