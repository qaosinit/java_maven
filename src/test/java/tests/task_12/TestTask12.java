package tests.task_12;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTests;

public class TestTask12 extends BaseTests {

    @Test
    public void testTask13() {
        loginAdminPage.openAdminPage();
        loginAdminPage.authorizationAdmin();
        adminPage.switchOnMenu("Catalog");
        catalogPage.clickAddNewProduct();
        addNewProductPage.setStatus("Enabled");
        addNewProductPage.inputInField("name[en]", "Duck new");
        addNewProductPage.inputInField("code", "1234");
        addNewProductPage.inputInField("quantity", "12");
        addNewProductPage.loadFile("duck.png");
        addNewProductPage.inputInField("date_valid_from", "12.12.2021");
        addNewProductPage.inputInField("date_valid_to", "12.12.2022");
        addNewProductPage.switchTabs("Information");
        addNewProductPage.selectValueInDropDownList("select[name='manufacturer_id']", "ACME Corp.");
        addNewProductPage.inputInField("keywords", "test, duck");
        addNewProductPage.inputInField("short_description[en]", "short description");
        addNewProductPage.inputValueInDescription("description for new duck");
        addNewProductPage.inputInField("head_title[en]", "Title for duck");
        addNewProductPage.inputInField("meta_description[en]", "meta description for new duck");
        addNewProductPage.switchTabs("Prices");
        addNewProductPage.inputInField("purchase_price", "22");
        addNewProductPage.selectValueInDropDownList("select[name*='currency']", "Euros");
        addNewProductPage.inputInField("gross_prices[EUR]", "0,25");
        addNewProductPage.clickButton("Save");
        addNewProductPage.waitElementVisibility(".notice.success");
        Assert.assertTrue(catalogPage.checkHaveProduct("Duck new"));
    }

}
