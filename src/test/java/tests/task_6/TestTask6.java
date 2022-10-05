package tests.task_6;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTests;

public class TestTask6 extends BaseTests {

    @Test
    public void testTask6() {
        loginAdminPage.openAdminPage();
        loginAdminPage.authorizationAdmin();
        adminPage.switchOnMenu("Appearence");
        Assert.assertTrue(adminPage.isElementPresent("h1"));
        adminPage.switchOnSubMenu( "Template");
        Assert.assertTrue(adminPage.isElementPresent("h1"));
        adminPage.switchOnSubMenu( "Logotype");
        Assert.assertTrue(adminPage.isElementPresent("h1"));
        //
        adminPage.switchOnMenu("Catalog");
        Assert.assertTrue(adminPage.isElementPresent("h1"));
        adminPage.switchOnSubMenu("Catalog");
        Assert.assertTrue(adminPage.isElementPresent("h1"));
        adminPage.switchOnSubMenu( "Product Groups");
        Assert.assertTrue(adminPage.isElementPresent("h1"));
        adminPage.switchOnSubMenu( "Option Groups");
        Assert.assertTrue(adminPage.isElementPresent("h1"));
        adminPage.switchOnSubMenu( "Manufacturers");
        Assert.assertTrue(adminPage.isElementPresent("h1"));
        adminPage.switchOnSubMenu( "Suppliers");
        Assert.assertTrue(adminPage.isElementPresent("h1"));
        adminPage.switchOnSubMenu( "Delivery Statuses");
        Assert.assertTrue(adminPage.isElementPresent("h1"));
        adminPage.switchOnSubMenu( "Sold Out Statuses");
        Assert.assertTrue(adminPage.isElementPresent("h1"));
        adminPage.switchOnSubMenu( "Quantity Units");
        Assert.assertTrue(adminPage.isElementPresent("h1"));
        adminPage.switchOnSubMenu( "CSV Import/Export");
        Assert.assertTrue(adminPage.isElementPresent("h1"));
        //
        adminPage.switchOnMenu("Countries");
        Assert.assertTrue(adminPage.isElementPresent("h1"));
        //
        adminPage.switchOnMenu("Currencies");
        Assert.assertTrue(adminPage.isElementPresent("h1"));
        //
        adminPage.switchOnMenu("Customers");
        Assert.assertTrue(adminPage.isElementPresent("h1"));
        adminPage.switchOnSubMenu( "Customers");
        Assert.assertTrue(adminPage.isElementPresent("h1"));
        adminPage.switchOnSubMenu( "CSV Import/Export");
        Assert.assertTrue(adminPage.isElementPresent("h1"));
        adminPage.switchOnSubMenu( "Newsletter");
        Assert.assertTrue(adminPage.isElementPresent("h1"));
        //
        adminPage.switchOnMenu("Geo Zones");
        Assert.assertTrue(adminPage.isElementPresent("h1"));
        //
        adminPage.switchOnMenu("Languages");
        Assert.assertTrue(adminPage.isElementPresent("h1"));
        adminPage.switchOnSubMenu( "Languages");
        Assert.assertTrue(adminPage.isElementPresent("h1"));
        adminPage.switchOnSubMenu( "Storage Encoding");
        Assert.assertTrue(adminPage.isElementPresent("h1"));
        //
        adminPage.switchOnMenu("Modules");
        Assert.assertTrue(adminPage.isElementPresent("h1"));
        adminPage.switchOnSubMenu( "Background Jobs");
        Assert.assertTrue(adminPage.isElementPresent("h1"));
        adminPage.switchOnSubMenu("Customer");
        Assert.assertTrue(adminPage.isElementPresent("h1"));
        adminPage.switchOnSubMenu( "Shipping");
        Assert.assertTrue(adminPage.isElementPresent("h1"));
        adminPage.switchOnSubMenu( "Payment");
        Assert.assertTrue(adminPage.isElementPresent("h1"));
        adminPage.switchOnSubMenu( "Order Total");
        Assert.assertTrue(adminPage.isElementPresent("h1"));
        adminPage.switchOnSubMenu( "Order Success");
        Assert.assertTrue(adminPage.isElementPresent("h1"));
        adminPage.switchOnSubMenu( "Order Action");
        Assert.assertTrue(adminPage.isElementPresent("h1"));
        //
        adminPage.switchOnMenu("Orders");
        Assert.assertTrue(adminPage.isElementPresent("h1"));
        adminPage.switchOnSubMenu( "Orders");
        Assert.assertTrue(adminPage.isElementPresent("h1"));
        adminPage.switchOnSubMenu( "Order Statuses");
        Assert.assertTrue(adminPage.isElementPresent("h1"));
        //
        adminPage.switchOnMenu("Pages");
        Assert.assertTrue(adminPage.isElementPresent("h1"));
        //
        adminPage.switchOnMenu("Reports");
        Assert.assertTrue(adminPage.isElementPresent("h1"));
        adminPage.switchOnSubMenu( "Monthly Sales");
        Assert.assertTrue(adminPage.isElementPresent("h1"));
        adminPage.switchOnSubMenu( "Most Sold Products");
        Assert.assertTrue(adminPage.isElementPresent("h1"));
        adminPage.switchOnSubMenu( "Most Shopping Customers");
        Assert.assertTrue(adminPage.isElementPresent("h1"));
        //
        adminPage.switchOnMenu("Settings");
        Assert.assertTrue(adminPage.isElementPresent("h1"));
        adminPage.switchOnSubMenu( "Store Info");
        Assert.assertTrue(adminPage.isElementPresent("h1"));
        adminPage.switchOnSubMenu( "Defaults");
        Assert.assertTrue(adminPage.isElementPresent("h1"));
        adminPage.switchOnSubMenu( "General");
        Assert.assertTrue(adminPage.isElementPresent("h1"));
        adminPage.switchOnSubMenu( "Listings");
        Assert.assertTrue(adminPage.isElementPresent("h1"));
        adminPage.switchOnSubMenu( "Images");
        Assert.assertTrue(adminPage.isElementPresent("h1"));
        adminPage.switchOnSubMenu( "Checkout");
        Assert.assertTrue(adminPage.isElementPresent("h1"));
        adminPage.switchOnSubMenu( "Advanced");
        Assert.assertTrue(adminPage.isElementPresent("h1"));
        adminPage.switchOnSubMenu( "Security");
        Assert.assertTrue(adminPage.isElementPresent("h1"));
        //
        adminPage.switchOnMenu("Slides");
        Assert.assertTrue(adminPage.isElementPresent("h1"));
        //
        adminPage.switchOnMenu("Tax");
        Assert.assertTrue(adminPage.isElementPresent("h1"));
        adminPage.switchOnSubMenu( "Tax Classes");
        Assert.assertTrue(adminPage.isElementPresent("h1"));
        adminPage.switchOnSubMenu( "Tax Rates");
        Assert.assertTrue(adminPage.isElementPresent("h1"));
        //
        adminPage.switchOnMenu("Translations");
        Assert.assertTrue(adminPage.isElementPresent("h1"));
        adminPage.switchOnSubMenu( "Search Translations");
        Assert.assertTrue(adminPage.isElementPresent("h1"));
        adminPage.switchOnSubMenu( "Search Translations");
        Assert.assertTrue(adminPage.isElementPresent("h1"));
        adminPage.switchOnSubMenu( "CSV Import/Export");
        Assert.assertTrue(adminPage.isElementPresent("h1"));
        //
        adminPage.switchOnMenu("Users");
        Assert.assertTrue(adminPage.isElementPresent("h1"));
        //
        adminPage.switchOnMenu("vQmods");
        Assert.assertTrue(adminPage.isElementPresent("h1"));
        adminPage.switchOnSubMenu("vQmods");
        Assert.assertTrue(adminPage.isElementPresent("h1"));
    }
}
