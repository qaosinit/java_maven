package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.*;

public class BaseTests {
    protected WebDriver driver;
    protected MainPage mainPage;
    protected LoginAdminPage loginAdminPage;
    protected AdminPage adminPage;
    protected CountriesPage countriesPage;
    protected GeoZonesPage geoZonesPage;
    protected CreateAccountPage createAccountPage;
    protected ProductPage productPage;
    protected СheckoutPage сheckoutPage;
    protected CatalogPage catalogPage;
    protected AddNewProductPage addNewProductPage;
    protected EditCountryPage editCountryPage;

    @BeforeMethod
    public void startBrowser() {
        //FirefoxOptions options = new FirefoxOptions();
        //options.setBinary("C:\\Program Files\\Firefox Nightly\\firefox.exe");
        //driver = new FirefoxDriver(options);
        //System.setProperty("webdriver.edge.driver", "C:\\Tools\\msedgedriver.exe");
        //driver = new EdgeDriver();
        //System.setProperty("webdriver.ie.driver", "C:\\Tools\\IEDriverServer.exe");
        //driver = new InternetExplorerDriver();
        //driver = new FirefoxDriver();
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
        countriesPage = new CountriesPage(driver);
        geoZonesPage = new GeoZonesPage(driver);
        createAccountPage = new CreateAccountPage(driver);
        productPage = new ProductPage(driver);
        сheckoutPage = new СheckoutPage(driver);
        catalogPage = new CatalogPage(driver);
        addNewProductPage = new AddNewProductPage(driver);
        editCountryPage = new EditCountryPage(driver);
    }
}
