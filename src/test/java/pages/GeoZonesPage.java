package pages;

import org.openqa.selenium.WebDriver;

public class GeoZonesPage extends HelperPages{
    public GeoZonesPage(WebDriver driver) {
        super(driver);
    }

    //Проверка сортировки геозон на странице геозон
    public boolean checkSortGeoZones(){
        boolean result = true;
        int countGeoZones = getWebElements("td:nth-child(3n)>a").size();
        for (int i=0; i<countGeoZones; i++) {
            getWebElements("td:nth-child(3n)>a").get(i).click();
            if (!compare(listStringToGetText("#table-zones td:nth-child(3n) option[selected=selected]"))){
                result = false;
                break;
            }
            driver.navigate().back();
        }
        return result;
    }

}
