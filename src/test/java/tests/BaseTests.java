package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.AdminPage;
import pages.LoginAdminPage;
import pages.MainPage;

public class BaseTests {
    private WebDriver driver;
    protected MainPage mainPage;
    protected LoginAdminPage loginAdminPage;
    protected AdminPage adminPage;

    @BeforeMethod
    public void startBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        initPage();
    }

    @AfterMethod
    public void quitBrowser() {
        driver.quit();
    }

    public void initPage() {
        mainPage = new MainPage(driver);
        loginAdminPage = new LoginAdminPage(driver);
        adminPage = new AdminPage(driver);
    }
}
