package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperPages {
    final WebDriver driver;
    private int timeOutInSecond = 5;
    protected String baseUrl = "http://localhost";

    public HelperPages(WebDriver driver) {
        this.driver = driver;
    }

    //Ожмдание видимости элемента на странице
    public void waitElementVisibility(String locator) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSecond);
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator))));
    }

    //метод ожидания кликабельности элемента
    public void waitElementToBeClickable(String locator) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSecond);
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(By.xpath(locator))));
    }

    //получение WebElement по локатору с ожиданием
    public WebElement getWebElement(String locator) {
        waitElementVisibility(locator);
        return driver.findElement(By.xpath(locator));
    }

    //Клик кнопки
    public void clickButton(String nameButton) {
        String locator = "//button[text()='" + nameButton + "']";
        waitElementToBeClickable(locator);
        getWebElement(locator).click();
    }

    //ввод значения в поле по его аттрибуту name
    public void inputInField(String nameField, String value) {
        String locator = "//input[@name='" + nameField + "']";
        waitElementToBeClickable(locator);
        getWebElement(locator).sendKeys(value);
    }

    //метод клика по чекбоксу
    public void clickCheckbox(String nameCheckbox){
        String locator = "//label[text()='" + nameCheckbox + "']//input[@type='checkbox']";
        waitElementToBeClickable(locator);
        getWebElement(locator).click();
    }

}
