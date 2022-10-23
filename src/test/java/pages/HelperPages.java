package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
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

    //получение текста WebElement по локатору с ожиданием
    public String getTextWebElement(String locator) {
        return getWebElement(locator).getText();
    }

    //получение значения аттрибута WebElement по локатору с ожиданием
    public String getValueAttributeWebElement(String locator, String nameAttribute) {
        return getWebElement(locator).getAttribute(nameAttribute);
    }

    //получение значения CSS WebElement по локатору с ожиданием
    public String getValueCSSWebElement(String locator, String nameCss) {
        return getWebElement(locator).getCssValue(nameCss);
    }

    //получение размера WebElement по локатору с ожиданием
    public Dimension getSizeWebElement(String locator) {
        return getWebElement(locator).getSize();
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

    // метод сранения размеров двух WebElement по локаторам
    public boolean compareSizePrices(String locatorSizeLess, String locatorSizeMore){
        boolean result = true;
        int heightRegularPrice = getSizeWebElement(locatorSizeLess).height;
        int widthRegularPrice = getSizeWebElement(locatorSizeLess).width;
        int heightCampaignPrice = getSizeWebElement(locatorSizeMore).height;
        int widthCampaignPrice = getSizeWebElement(locatorSizeMore).width;
        if (heightRegularPrice>heightCampaignPrice & widthRegularPrice>widthCampaignPrice){
            result = false;
        }
        return result;
    }

    // метод проверки, что у элемента серый цвет
    public boolean colorElementIsGray(String locator){
        boolean result = true;
        String color = getValueCSSWebElement(locator, "color")
                .replace("rgba(", "").replace(")", "");
        String[] numColor = color.split(",");
        if (!numColor[0].equals(numColor[1]) & !numColor[1].equals(numColor[2]))
            result = false;
        return result;
    }

    // метод проверки, что у элемента красный цвет
    public boolean colorElementIsRed(String locator){
        boolean result = true;
        String color = getValueCSSWebElement(locator, "color")
                .replace("rgba(", "").replace(")", "");
        String[] numColor = color.split(",");
        if (!numColor[1].equals(" 0") & !numColor[2].equals(" 0"))
            result = false;
        return result;
    }


}
