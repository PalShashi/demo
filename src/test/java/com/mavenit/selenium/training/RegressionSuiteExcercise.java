package com.mavenit.selenium.training;

import com.mavenit.selenium.training.page_objects.LocatorHelperExcercise;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class RegressionSuiteExcercise extends LocatorHelperExcercise {
    LocatorHelperExcercise helper = new LocatorHelperExcercise();
    @Test
    public void searchProduct()  {
        String searchItem="laptops";
        helper.setUp1();
        helper.search1(searchItem);
    String actualThumbNail= helper.getThumbNail();
    String actualTitle=helper.pageTitle();
    String actualCurrentUrl= helper.currentUrl();

    assertThat(actualTitle,is(equalToIgnoringCase(searchItem)));
    assertThat(actualThumbNail,is(equalToIgnoringCase(searchItem)));
    assertThat(actualCurrentUrl, containsString(searchItem));

    }
    @Test
    public void addProductToBasketUsingFilter() throws InterruptedException {
       String priceRange="£499.00 - £699.00";
        helper.setUp1();
        helper.search1("Laptops");

        helper.applyPriceFilter(priceRange);
        helper.selectProductUsingPriceFilter();


    }
@Test
public void suggestedDepSearchTest(){
    String searchItem="laptop";
    helper.setUp1();
    helper.search1(searchItem);
   // helper.selectDepartmentFromSuggestion(searchItem);
    String actual = helper.getThumbNail();
    assertThat(actual,is(equalToIgnoringCase(searchItem)));

}
@Test
    public void suggestedItemSearchTest(){
    String searchItem="cable";
    helper.setUp1();
    helper.search1(searchItem);
    //helper.selectProductFromSuggestion(searchItem);
    String actual = helper.getThumbNail();
    assertThat(actual,is(equalToIgnoringCase(searchItem)));
    }

}

