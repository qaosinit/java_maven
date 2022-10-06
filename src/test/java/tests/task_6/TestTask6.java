package tests.task_6;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTests;

public class TestTask6 extends BaseTests {

    @Test
    public void testTask6() {
        loginAdminPage.openAdminPage();
        loginAdminPage.authorizationAdmin();
        Assert.assertTrue(adminPage.checkMenu());
    }
}
