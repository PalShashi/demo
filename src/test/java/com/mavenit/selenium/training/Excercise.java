package com.mavenit.selenium.training;

//import com.mavenit.selenium.training.page_objects.LocatorHelper;
import com.mavenit.selenium.training.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static com.mavenit.selenium.training.HooksExcercise.driver;
import static junit.framework.TestCase.fail;

public class Excercise extends DriverManager {
   // LocatorHelper helper = new LocatorHelper();

    public void priceRangeFilter(String priceRange) {
        List<WebElement> filterprices = driver.findElements(By.cssSelector("\".dc-filter__option\""));
        for (WebElement filterprice : filterprices) {
            int counter = 0;
            if (filterprice.getText().equalsIgnoreCase(priceRange)) {
                counter++;
                filterprice.click();
                break;

            }
            if (counter == 0) {
                fail("filter choice not available" + priceRange);
            }
        }
        try {
            Thread.sleep(9000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

        public List<Double> getProductPrice(){
        List<Double> collectedPrices = new ArrayList<Double>();
       List<WebElement> webelementPrices=driver.findElements(By.cssSelector(""));
       for(WebElement webelementprice : webelementPrices){
           String priceInString=webelementprice.getText().replace("£","");
           double priceInDouble=Double.parseDouble(priceInString);
           collectedPrices.add(priceInDouble);

       }
       if (collectedPrices.size()==0){
           fail("nothing collect may be product is not available ");

       }
       return collectedPrices;

        }

















 //////////////************************************************////////////////


public void priceFilter(){

}

}
