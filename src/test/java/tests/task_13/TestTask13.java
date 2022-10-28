package tests.task_13;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTests;

public class TestTask13 extends BaseTests {

    @Test
    public void testTask13() {
        mainPage.openMainPage();
        int count = 3;
        for (int i=0; i<count; i++) {
            mainPage.openFirstProduct();
            productPage.addProductToCart();
            Assert.assertTrue(productPage.checkCountInBasket(Integer.toString(i+1)));
            productPage.backToPage();
        }
        mainPage.clickLink("Checkout »");
        сheckoutPage.clearBasket();
    }

}
