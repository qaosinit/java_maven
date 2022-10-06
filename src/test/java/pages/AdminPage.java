package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class AdminPage extends HelperPages {
    public AdminPage(WebDriver driver) {
        super(driver);
    }

    public boolean checkAuthorizationAdmin(){
        return getWebElement("a[href*='/admin/logout.php']").isDisplayed();
    }


    //метод проверки меню админки
    public boolean checkMenu(){
        boolean result = true;
        int menuSize = getWebElements("#app-").size();
        for (int i = 0; i<menuSize; i++) {
            getWebElements("#app-").get(i).click();
            if (!isElementPresent("h1")) {
                result = false;
                break;
            }
            int sizeSubMenu;
            try {
                sizeSubMenu = driver.findElements(By.cssSelector("[id=box-apps-menu] ul li")).size();
            } catch (NoSuchElementException ex) {
                sizeSubMenu=0;
            }
            if (sizeSubMenu > 0) {
                for (int j = 0; j < sizeSubMenu; j++) {
                    getWebElements("[id=box-apps-menu] ul li").get(j).click();
                    if (!isElementPresent("h1")) {
                        result = false;
                        break;
                    }
                }
            }
            if (!result){break;}
        }
        return result;
    }


}
