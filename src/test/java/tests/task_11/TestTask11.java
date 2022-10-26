package tests.task_11;

import org.testng.annotations.Test;
import tests.BaseTests;

public class TestTask11 extends BaseTests {

    @Test
    public void testTask11(){
        String email = "ivanov" + Integer.toString(mainPage.getRandomNumber(1000)) + "@mail.com";
        String password = "1234567890";
        mainPage.openMainPage();
        mainPage.clickLink("New customers click here");
        createAccountPage.inputInField("company", "Test comp");
        createAccountPage.inputInField("firstname", "Ivan");
        createAccountPage.inputInField("lastname", "Ivanov");
        createAccountPage.inputInField("address1", "Moscow");
        createAccountPage.inputInField("postcode", "44571");
        createAccountPage.inputInField("city", "Moscow");
        createAccountPage.selectValueInDropDown( "Country ", "United States");
        createAccountPage.selectValueInDropDownList("select[name=zone_code]", "New Mexico");
        createAccountPage.inputInField("email", email);
        createAccountPage.inputInField("phone", "+79663214569");
        createAccountPage.inputInField("password", password);
        createAccountPage.inputInField("confirmed_password", password);
        createAccountPage.clickButton("Create Account");
        mainPage.clickLink("Logout");
        mainPage.inputInField("email", email);
        mainPage.inputInField("password", password);
        mainPage.clickButton("Login");
        mainPage.clickLink("Logout");
    }
}
