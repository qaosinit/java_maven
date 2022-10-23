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
        String colorRegularPrice = mainPage.getValueCSSWebElement("#box-campaigns .product .regular-price", "color");
        String colorCampaignPrice = mainPage.getValueCSSWebElement("#box-campaigns .product .campaign-price", "color");
        String weightCampaignPrice = mainPage.getValueCSSWebElement("#box-campaigns .product .campaign-price", "font-weight");
        String textDecorationRegularPrice = mainPage.getValueCSSWebElement("#box-campaigns .product .regular-price", "text-decoration-line");

        Assert.assertTrue(mainPage.compareSizePrices("#box-campaigns .product .regular-price",
                "#box-campaigns .product .campaign-price"));

        mainPage.getWebElement("#box-campaigns .product").click();
        Assert.assertEquals(name, productPage.getTextWebElement("#box-product .title"));
        Assert.assertEquals(regularPrice, productPage.getTextWebElement("#box-product .regular-price"));
        Assert.assertEquals(campaignPrice, productPage.getTextWebElement("#box-product .campaign-price"));
        Assert.assertTrue(mainPage.compareSizePrices("#box-product .regular-price",
                "#box-product .campaign-price"));

    }
}
