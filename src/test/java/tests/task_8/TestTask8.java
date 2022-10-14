package tests.task_8;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTests;

public class TestTask8 extends BaseTests {

    @Test
    public void testTask8(){
        loginAdminPage.openAdminPage();
        loginAdminPage.authorizationAdmin();
        adminPage.checkAuthorizationAdmin();
        adminPage.switchOnMenu("Countries");
        Assert.assertTrue(countriesPage.checkListCountries());
        Assert.assertTrue(countriesPage.checkListCountry());

    }
}
