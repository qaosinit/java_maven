package tests.task_14;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTests;

public class TestTask14 extends BaseTests {

    @Test
    public void testTask14() {
        loginAdminPage.openAdminPage();
        loginAdminPage.authorizationAdmin();
        adminPage.switchOnMenu("Countries");
        countriesPage.openCountry("Andorra");
        Assert.assertTrue(editCountryPage.checkLink());
    }

}
