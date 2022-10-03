package tests.task_2;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTests;

public class TestTask2 extends BaseTests {

    @Test
    public void testTask2() {
        loginAdminPage.openAdminPage();
        loginAdminPage.inputInField("username", "admin");
        loginAdminPage.inputInField("password", "admin");
        loginAdminPage.clickCheckbox(" Remember Me");
        loginAdminPage.clickButton("Login");
        Assert.assertTrue(adminPage.checkAuthorizationAdmin());
    }
}
