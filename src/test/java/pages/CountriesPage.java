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
        List<String> listCountries = new ArrayList<String>();
        for (WebElement el: getWebElements("tr td:nth-child(5n)")) {
            listCountries.add(el.getText());
        }
        if (!compare(listCountries)){
            result = false;
        }
        return result;
    }

    //метод сравнение по алфавиту
    public boolean checkListCountry(){
        boolean result = true;
        List<WebElement> listCountries = getWebElements("tr td:nth-child(6n)");
        List<Integer> count = new ArrayList<Integer>();
        for (int i=0; i<listCountries.size(); i++) {
            if (!listCountries.get(i).getText().equals("0")){
                count.add(i);
            }
        }
        for (Integer g: count) {
            WebElement element = getWebElements("tr td:nth-child(5n) a").get(g);
            moveTo(element);
            element.click();
            List<String> listZones = new ArrayList<String>();
            List<WebElement> list = getWebElements("#table-zones td:nth-child(3n)");
            for (int i=0; i<list.size()-1; i++) {
                listZones.add(list.get(i).getText());
            }
            if (!compare(listZones)){
                result = false;
                break;
            }
            driver.navigate().back();
        }
        return result;
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
}
