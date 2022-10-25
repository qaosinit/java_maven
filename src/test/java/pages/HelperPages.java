package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Collections;
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
        return driver.findElements(By.cssSelector(locator));
    }

    //Клик кнопки
    public void clickButton(String valueButton) {
        String locator = "button[value='" + valueButton + "']";
        waitElementToBeClickable(locator);
        getWebElement(locator).click();
    }

    //Клик ссылки
    public void clickLink(String textLink) {
        String locator = "//a[text()=\'" + textLink + "\']";
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSecond);
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(By.xpath(locator))));
        driver.findElement(By.xpath(locator)).click();
    }

    //ввод значения в поле по его аттрибуту name
    public void inputInField(String nameField, String value) {
        String locator = "input[name=" + nameField + "]";
        waitElementToBeClickable(locator);
        getWebElement(locator).clear();
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
        } catch (TimeoutException ex){
            return false;
        }
    }

    //Перемешение к элементу
    public void moveTo(WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
    }

    public boolean compare(List<String> items){
        boolean result=true;
        List<String> list = new ArrayList<String>();
        list.addAll(items);
        Collections.sort(list);
        for (int i=0; i<items.size(); i++) {
            if (!list.get(i).equals(items.get(i))){
                result = false;
                System.out.println("element_1 = " + list.get(i));
                System.out.println("element_2 = " + items.get(i));
                break;
            }
        }
        return result;
    }

    public List<String> listStringToGetText(String locatorCss){
        List<WebElement> items = getWebElements(locatorCss);
        List<String> list = new ArrayList<String>();
        for (WebElement el: items) {
            list.add(el.getText());
        }
        return list;
    }

    public int getRandomNumber(int max){
        return (int) (Math.random() * ++max);
    }

    // метод выбора в выпадающем списке
    public void selectValueInDropDownList(String locatorCss, String textValue){
        Select select = new Select(getWebElement(locatorCss));
        select.selectByValue(textValue);
    }


}
