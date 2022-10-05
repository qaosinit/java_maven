package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AdminPage extends HelperPages {
    public AdminPage(WebDriver driver) {
        super(driver);
    }

    public boolean checkAuthorizationAdmin(){
        return getWebElement("a[href*='/admin/logout.php']").isDisplayed();
    }

    //метод переклбчения по меню админки
    public void switchOnMenu(String nameBlock){
        List <WebElement> menu = getWebElements("#app-");
        for (WebElement el : menu ) {
            if (el.findElement(By.cssSelector("[class=name]")).getText().equals(nameBlock)){
                el.click();
                break;
            }
        }
    }

    //метод переклбчения по субменю админки
    public void switchOnSubMenu(String nameSubBlock){
        List <WebElement> subMenu = getWebElements("ul[id=box-apps-menu] ul li");
        for (WebElement element : subMenu ) {
            if (element.findElement(By.cssSelector("[class=name]")).getText().equals(nameSubBlock)) {
                element.click();
                break;
            }
        }
    }


}
