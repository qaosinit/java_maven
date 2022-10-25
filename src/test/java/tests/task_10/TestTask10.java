package tests.task_10;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTests;

public class TestTask10 extends BaseTests {

    @Test
    public void testTask10(){
        mainPage.openMainPage();
        mainPage.moveTo(mainPage.getWebElement("#box-campaigns .product"));
        String name = mainPage.getTextWebElement("#box-campaigns .product .name");
        String regularPrice = mainPage.getTextWebElement("#box-campaigns .product .regular-price");
        String campaignPrice = mainPage.getTextWebElement("#box-campaigns .product .campaign-price");
        Assert.assertTrue(mainPage.colorElementIsGray("#box-campaigns .product .regular-price"));
        Assert.assertEquals(mainPage.getValueCSSWebElement("#box-campaigns .product .regular-price", "text-decoration-line"),"line-through");
        Assert.assertTrue(mainPage.colorElementIsRed("#box-campaigns .product .campaign-price"));
        Assert.assertTrue(Integer.parseInt(mainPage.getValueCSSWebElement("#box-campaigns .product .campaign-price", "font-weight")) >= 700);
        Assert.assertTrue(mainPage.compareSizePrices("#box-campaigns .product .regular-price",
                "#box-campaigns .product .campaign-price"));
        // Переход на страницу тавара
        mainPage.getWebElement("#box-campaigns .product").click();
        Assert.assertEquals(name, productPage.getTextWebElement("#box-product .title"));
        Assert.assertEquals(regularPrice, productPage.getTextWebElement("#box-product .regular-price"));
        Assert.assertEquals(campaignPrice, productPage.getTextWebElement("#box-product .campaign-price"));
        Assert.assertTrue(mainPage.compareSizePrices("#box-product .regular-price",
                "#box-product .campaign-price"));
        Assert.assertTrue(mainPage.colorElementIsGray("#box-product .regular-price"));
        Assert.assertEquals(mainPage.getValueCSSWebElement("#box-product .regular-price", "text-decoration-line"),"line-through");
        Assert.assertTrue(mainPage.colorElementIsRed("#box-product .campaign-price"));
        Assert.assertTrue(Integer.parseInt(mainPage.getValueCSSWebElement("#box-product .campaign-price", "font-weight")) >= 700);

    }
}
