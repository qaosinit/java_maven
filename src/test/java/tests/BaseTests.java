package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BaseTests {
    private WebDriver driver;

    @BeforeMethod
    public void startBrowser()  {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void taskFirst(){
        driver.get("https://translate.yandex.ru/");
    }


    @AfterMethod
    public void quitBrowser() {
        driver.quit();
    }
}
