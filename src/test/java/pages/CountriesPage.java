package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.*;

public class CountriesPage extends HelperPages {
    public CountriesPage(WebDriver driver) {
        super(driver);
    }

    //метод перехода на страницу
    public void openCountriesPage() {
        driver.get(baseUrl + "/litecart/admin/?app=countries&doc=countries");
    }

    //метод сравнение по алфавиту
    public boolean checkListCountries(){
        boolean result = true;
        List<WebElement> items = getWebElements("tr td:nth-child(5n)");
        if (!compare(items)){
            result = false;
        }
        return result;
    }

    //метод сравнение по алфавиту
    public boolean checkListCountry(){
        boolean result = true;
        List<WebElement> items = getWebElements("tr td:nth-child(6n)");
        List<Integer> count = new ArrayList<Integer>();
        for (int i=0; i<items.size(); i++) {
            if (!items.get(i).getText().equals("0")){
                count.add(i);
            }
        }
        for (Integer g: count) {
            WebElement element = getWebElements("tr td:nth-child(5n) a").get(g);
            moveTo(element);
            element.click();
            List<WebElement> listZones = getWebElements("#table-zones td:nth-child(3n) input[type=hidden]");
            if (!compare(listZones)){
                result = false;
                break;
            }
            driver.navigate().back();
        }
        return result;
    }

    public boolean compare(List<WebElement> items){
        boolean result=true;
        List<String> listCountries = new ArrayList<String>();
        for (WebElement el: items) {
            listCountries.add(el.getText());
        }
        Collections.sort(listCountries);
        for (int i=1; i<items.size(); i++) {
            if (!listCountries.get(i).equals(items.get(i).getText())){
                result = false;
                System.out.println("element_1 = " + listCountries.get(i));
                System.out.println("element_2 = " + items.get(i).getText());
                break;
            }
        }
        return result;
    }
}
