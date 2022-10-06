package tests.task_7;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTests;

public class TestTask_7 extends BaseTests {

    @Test
    public void testTask7() {
        mainPage.openMainPage();
        Assert.assertTrue(mainPage.checkHaveSticker());
    }
}
