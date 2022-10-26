package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.MoveTargetOutOfBoundsException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.math.BigDecimal;
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

    //Ожмдание НЕ видимости элемента на странице
    public boolean waitElementNotVisibility(String locator) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSecond);
        return wait.until(ExpectedConditions.refreshed(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(locator))));
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
        String locator = "input[name=\'" + nameField + "\']";
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
        try {
            Actions action = new Actions(driver);
            action.moveToElement(element).perform();
        } catch (MoveTargetOutOfBoundsException ex){
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        }
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
        String SizeLess = getValueCSSWebElement(locatorSizeLess, "font-size");
        String SizeMore = getValueCSSWebElement(locatorSizeMore, "font-size");
        double SizeMoreDbl = Double.parseDouble(SizeMore.substring(0, (SizeMore.length()-2)));
        double SizeLessDbl = Double.parseDouble(SizeLess.substring(0, (SizeLess.length()-2)));
        BigDecimal f1 = new BigDecimal(SizeMoreDbl);
        BigDecimal f2 = new BigDecimal(SizeLessDbl);
        System.out.println(f1.compareTo(f2));
        if (f1.compareTo(f2) != 1){
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

    public int getRandomNumber(int max){
        return (int) (Math.random() * ++max);
    }

    // метод выбора в выпадающем списке
    public void selectValueInDropDownList(String locatorCss, String textValue){
        Select select = new Select(getWebElement(locatorCss));
        select.selectByVisibleText(textValue);
    }

    // метод выбора в выпадающем списке
    public void selectValueInDropDown(String nameField, String textValue){
        driver.findElement(By.xpath("//td[text()='" + nameField + "']//span[@role=\"presentation\"]")).click();
        for (WebElement el: getWebElements(".select2-results__options li")) {
            if (el.getText().equals(textValue)){
                moveTo(el);
                el.click();
                break;
            }
        }
    }

    //метод ожидания текста в элементе
    public boolean waitToBeTextInElement(String locator, String text){
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSecond);
        return wait.until(ExpectedConditions.refreshed(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector(locator), text)));
    }

    public boolean checkCountInBasket(String countProduct){
        return waitToBeTextInElement(".quantity", countProduct);
    }

    //метод ожидания исчезновения элемента
    public boolean waitStalenessOfElement(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSecond);
        driver.navigate().refresh();
        return wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(element)));
    }

    public void backToPage(){
        driver.navigate().back();
    }

    public void loadFile(String nameFile){
        getWebElement("input[type=file]").sendKeys(
                System.getProperty("user.dir") + "\\src\\main\\resources\\" + nameFile);
    }

    public void setDatepicker(String cssSelector, String date) {
        getWebElement(cssSelector).isDisplayed();
        ((JavascriptExecutor) driver).executeScript( String.format("$('{0}').datepicker('setDate', '{1}')", cssSelector, date));
    }


}
