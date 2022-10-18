package tests.task_9;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTests;

public class TestTask9 extends BaseTests {

    @Test
    public void testTask9(){
        loginAdminPage.openAdminPage();
        loginAdminPage.authorizationAdmin();
        adminPage.switchOnMenu("Geo Zones");
        Assert.assertTrue(geoZonesPage.checkSortGeoZones());
    }
}
