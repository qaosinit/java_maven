package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HelperPages {
    final WebDriver driver;
    private int timeOutInSecond = 5;
    //protected String baseUrl = "http://192.168.111.46/";
    protected String baseUrl = "http://localhost";

    public HelperPages(WebDriver driver) {
        this.driver = driver;
    }

    //Ожмдание видимости элемента на странице
    public void waitElementVisibility(String locator) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSecond);
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locator))));
    }

    //метод ожидания кликабельности элемента
    public void waitElementToBeClickable(String locator) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSecond);
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(By.cssSelector(locator))));
    }

    //получение WebElement по локатору с ожиданием
    public WebElement getWebElement(String locator) {
        waitElementVisibility(locator);
        return driver.findElement(By.cssSelector(locator));
    }

    //получение WebElement по локатору с ожиданием
    public List<WebElement> getWebElements(String locator) {
        waitElementVisibility(locator);
        return driver.findElements(By.cssSelector(locator));
    }

    //Клик кнопки
    public void clickButton(String nameButton) {
        String locator = "button[value=" + nameButton + "]";
        waitElementToBeClickable(locator);
        getWebElement(locator).click();
    }

    //ввод значения в поле по его аттрибуту name
    public void inputInField(String nameField, String value) {
        String locator = "input[name=" + nameField + "]";
        waitElementToBeClickable(locator);
        getWebElement(locator).sendKeys(value);
    }

    //метод клика по чекбоксу
    public void clickCheckbox(String nameCheckbox){
        String locator = "label input[type=checkbox]";
        if (getWebElements(locator).size()>1){
            locator = "label input[type=checkbox][name="+ nameCheckbox +"]";
            waitElementToBeClickable(locator);
            getWebElement(locator).click();
        } else {
            waitElementToBeClickable(locator);
            getWebElement(locator).click();
        }
    }

    // метод наличия элемента
    public boolean isElementPresent(String locator){
        try {
            getWebElement(locator);
            return true;
        } catch (NoSuchElementException ex){
            return false;
        }
    }

}
