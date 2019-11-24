package com.mavenit.selenium.training;


import com.mavenit.selenium.training.page_objects.BasketPage;
import com.mavenit.selenium.training.page_objects.HomePage;
//import com.mavenit.selenium.training.page_objects.LocatorHelper;
import com.mavenit.selenium.training.page_objects.ProductDiscriptionPage;
import com.mavenit.selenium.training.page_objects.ResultsPage;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.fail;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class RegressionSuite {

    //private LocatorHelper helper = new LocatorHelper();

private HomePage homePage = new HomePage();
private ResultsPage resultsPage =new ResultsPage();
private ProductDiscriptionPage productDiscriptionPage = new ProductDiscriptionPage();
private BasketPage basketPage = new BasketPage();


    public RegressionSuite() {
    }

    @Test
    public void searchTest() {
        homePage.openBrowser();
        String searchTerm = "laptops";
        homePage.search(searchTerm);
        String actualTitle = resultsPage.getPageTitle();
        String actualThumNail =resultsPage.getThumbNail();
        String actualCurrentUrl = homePage.getCurrentUrl();

        //assertThat(actualTitle, is(equalToIgnoringCase(searchTerm)));
        assertThat(actualThumNail, is(equalToIgnoringCase(searchTerm)));
        assertThat(actualCurrentUrl, containsString(searchTerm));

    }

    @Test
    public void addProductToBasketTest() {
        homePage.search("cable");
        String expected = resultsPage.selectAnyProduct();
        productDiscriptionPage.addProductToBasket();
        String actual = basketPage.getProuctsInBasket();
        assertThat(actual, is(equalToIgnoringCase(expected)));
    }
@Test
    public void addProductToBasketUsingFilters(){
        homePage.search("cable");
        resultsPage.selectPrice("");
        resultsPage.selectAnyProduct();
        //resultsPage.addProductToBasket();
        String actual = basketPage.getProuctsInBasket();
        //assertThat(actual, is(equalToIgnoringCase(expected)));

    }
@Test
    public void productPriceFilter() {

        String priceRange = "£299-£499"; // expected result
    //String[] l = priceRange.replaceAll("£", "").split("-");

    List<String> expectedList = Arrays.asList(priceRange.replaceAll("£","").split("-"));
   // Arrys.asList convert string to array as String array
    String min1= expectedList.get(0);
    String max1=expectedList.get(1); // but this is string we need to change to double in order to do comparison
    double min= Double.parseDouble(expectedList.get(0));
    double max=Double.parseDouble(expectedList.get(1));
   // Double.parseDouble(l.);
        homePage.openBrowser();
        homePage.search("laptop");
        resultsPage.selectPrice(priceRange);
    List<Double> actualPriceList = resultsPage.productprice(); // actual result

    //assertThat(actualPriceList,both(is(greaterThanOrEqualTo(min))).and(everyItem(is(lessThanOrEqualTo(max))));

    }
}
