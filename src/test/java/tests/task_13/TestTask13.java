package tests.task_13;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTests;

public class TestTask13 extends BaseTests {

    @Test
    public void testTask13() {
        mainPage.openMainPage();
        mainPage.openFirstProduct();
        productPage.addProductToCart();
        Assert.assertTrue(productPage.checkCountInBasket("1"));
        mainPage.backToPage();
        mainPage.openFirstProduct();
        productPage.addProductToCart();
        Assert.assertTrue(productPage.checkCountInBasket("2"));
        mainPage.backToPage();
        mainPage.openFirstProduct();
        productPage.addProductToCart();
        Assert.assertTrue(productPage.checkCountInBasket("3"));
        productPage.clickLink("Checkout »");
        WebElement rowTable = сheckoutPage.getWebElement("#box-checkout-summary table");
        сheckoutPage.clickButton("Remove");
        Assert.assertTrue(сheckoutPage.waitStalenessOfElement(rowTable));
        rowTable = сheckoutPage.getWebElement("#box-checkout-summary table");
        сheckoutPage.clickButton("Remove");
        Assert.assertTrue(сheckoutPage.waitStalenessOfElement(rowTable));
        rowTable = сheckoutPage.getWebElement("#box-checkout-summary table");
        сheckoutPage.clickButton("Remove");
        Assert.assertTrue(сheckoutPage.waitStalenessOfElement(rowTable));
    }

}
