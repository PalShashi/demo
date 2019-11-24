package com.mavenit.selenium.training.page_objects;

import com.mavenit.selenium.training.HooksExcercise;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.fail;

public class LocatorHelperExcercise extends HooksExcercise {


    public void search1(String item) {

        WebElement search = driver.findElement(By.id("search"));

        //driver.findElement(By.cssSelector(".dc-input.nostyle.dc-input-clear-icon")).clear();
        search.clear();
        search.sendKeys(item);
        search.sendKeys(Keys.ENTER); // or
        // driver.findElement(By.cssSelector(".dc-button-text")).click();
       // String actual= search.getText();
        //return actual;
        try{
            Thread.sleep(9000);
        }catch(InterruptedException e){
            e.printStackTrace();}

    }

    public String getThumbNail(){
        String actualThumbnail = driver.findElement(By.xpath("//span[text()='Laptops']")).getText();
        //or
       //return driver.findElement(By.xpath("//span[text()='Laptops']")).getText();
        //or
        return actualThumbnail;

        //System.out.println(actualThumbnail);
    }
public String currentUrl(){

       return driver.getCurrentUrl();
}
public String pageTitle(){
    return driver.findElement(By.cssSelector(".pageTitle")).getText();
}
public void applyPriceFilter(String priceRange)  {
    List<WebElement> filters = driver.findElements(By.cssSelector(".dc-filter__option"));
    int counter =0;
    for (WebElement filter : filters) {
        String filterContent =filter.getText();
        System.out.println(filterContent); // to see how the products are storing in filter

        if (filterContent.equalsIgnoreCase(priceRange)) {
            counter++;
            filter.click();
            //driver.findElement(By.cssSelector(".dc-filter__option")).click();
            break;
        }
         /*do not put else condition here othere wise loop will not run till ends
         else
       {
          fail("this price range does have any product please change the price range "+priceRange);
       }
       //if (counter==0){
    fail("this filter choice not available "+priceRange);
}

       */


    }
    try{
        Thread.sleep(9000);
    }catch(InterruptedException e){
        e.printStackTrace();
    }
}
     public List<Double> selectProductUsingPriceFilter(){
        List<Double> price = new ArrayList<Double>();
        List<WebElement> filteredElements=driver.findElements(By.cssSelector(".price"));
         for(WebElement filterElement:filteredElements){
             System.out.println( filterElement.getText());
             String collectedprices=filterElement.getText().replaceAll("£","");
            double priceInDouble= Double.parseDouble(collectedprices);
            price.add(priceInDouble);

         }
         if (price.size()==0){
             fail("Nothing is collected may be product is zero");
          }
         return price;
    }

    /*public void selectFromSuggestion(String item, By by){
        List <WebElement> suggestionsElements=driver.findElements(By.cssSelector(".dc-search-suggestions"));
        int listSize=suggestionsElements.size();
        if(listSize==0){
            fail("i do not have suggestion for you"+item);
        }
       int randomNumberIndex= new RandomNumberHelper().generateRandomNumber(listSize);
        WebElement selectedElement = suggestionsElements.get(randomNumberIndex);
       String selectedSuggestion= selectedElement.getText();
        selectedElement.click();
       //suggestionsElements.get(randomNumberIndex).click();
    }
public void selectDepartmentFromSuggestion(String item){
        selectFromSuggestion(item,By.cssSelector("dc-search-suggestions__suggestion dc-search-suggestions__suggestion--term"));

}public void selectProductFromSuggestion(String item){
        selectFromSuggestion(item,By.cssSelector("dc-search-suggestions__suggestion dc-search-suggestions__suggestion--sayt"));
*/
}




