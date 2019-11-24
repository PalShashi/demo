package com.mavenit.selenium.training.page_objects;

//import com.mavenit.selenium.training.Hooks;
import com.mavenit.selenium.training.Hooks;
import com.mavenit.selenium.training.driver.DriverManager;
import com.mavenit.selenium.training.utils.RandomNumberHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.fail;

public class ResultsPage extends DriverManager
{
    public String getPageTitle() {
        return driver.findElement(By.className("pageTitle")).getText();
    }
    public String getThumbNail() {
        return driver.findElement(By.className("current")).getText();
    }

    public String selectAnyProduct() {
        List<WebElement> productWebelements = driver.findElements(By.className("productTitle"));
        int productCount = productWebelements.size();
        int randomNumber = new RandomNumberHelper().generateRandomNumber(productCount);
        String prouctSelected = productWebelements.get(randomNumber).getText();
        productWebelements.get(randomNumber).click();

        return prouctSelected;
    }
    public void selectPrice(String priceRange) {
        List<WebElement> filters = driver.findElements(By.cssSelector(".dc-filter__option"));
        int counter = 0;
        for (WebElement filter : filters) {

            if (filter.getText().equalsIgnoreCase(priceRange))
            // get Text read all the values and return string
            {
                counter++;
                filter.click();
                break;
            } /*else{
                 fail("filter choise not available "+ priceRange);
             }*/
            if (counter == 0) {
                fail("filter choice not available " + priceRange);
            }
        }
        // Thread.sleep(9000); and throws exception at method level throws InterruptedException Or
        // define exception in try catch block
        try {
            Thread.sleep(9000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
    public List<Double> productprice() {
        List<Double> collectedPrices = new ArrayList<Double>();
        List<WebElement> priceWebelements = driver.findElements(By.cssSelector(".price"));
        for (WebElement priceWebelement : priceWebelements) {
            String priceInString = priceWebelement.getText().replaceAll("£", "");
            Double priceInDouble = Double.parseDouble(priceInString);

            collectedPrices.add(priceInDouble);

        }
        if (collectedPrices.size() == 0) {
            fail("Nothing is to be collected may be product is zero");
        }
        return collectedPrices;
    }


}
