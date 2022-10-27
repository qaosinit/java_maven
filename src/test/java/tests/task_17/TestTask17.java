package tests.task_17;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTests;

import java.util.List;

public class TestTask17 extends BaseTests {

    @Test
    public void testTask17() {
        loginAdminPage.openAdminPage();
        loginAdminPage.authorizationAdmin();
        adminPage.switchOnMenu("Catalog");
        catalogPage.openAllFolder();
        List<WebElement> listProduct = catalogPage.getWebElements(".row >td:nth-child(3) a[href*='edit_product']");
        for (int i=0; i<listProduct.size(); i++) {
            catalogPage.waitElementToBeClickable(catalogPage.getWebElements(".row >td:nth-child(3) a[href*='edit_product']").get(i));
            catalogPage.getWebElements(".row >td:nth-child(3) a[href*='edit_product']").get(i).click();
            Assert.assertTrue(driver.manage().logs().get("browser").getAll().size() == 0, driver.manage().logs().get("browser").getAll().toString());
            catalogPage.backToPage();
        }
    }

}
