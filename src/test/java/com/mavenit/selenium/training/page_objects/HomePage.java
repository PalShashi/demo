package com.mavenit.selenium.training.page_objects;

import com.mavenit.selenium.training.Hooks;
import com.mavenit.selenium.training.driver.DriverManager;
import com.mavenit.selenium.training.utils.RandomNumberHelper;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends DriverManager {
    public String searchitem;

    public void search(String item) {
        driver.findElement(By.id("search")).clear();
        driver.findElement(By.id("search")).clear();
        //driver.findElement(By.id("search")).sendKeys(item);
        //driver.findElement(By.cssSelector(".dc-search-fieldset__submit-button")).click();
        this.searchitem=item;
        enterSearchItem(item);
        clickSearch();
    }
    public void enterSearchItem(String item){
        driver.findElement(By.id("search")).sendKeys(item);
    }
    private void clickSearch(){
        driver.findElement(By.cssSelector(".dc-search-fieldset__submit-button")).click();
    }
    public void selectDepartmentFromSuggestion(String item) {
        selectFromSuggestion(item, By.cssSelector("dc-search-suggestions__suggestion dc-search-suggestions__suggestion--term"));

    }
    public void selectFromSuggestion(String item, By by) {
        List<WebElement> suggestionsElements = driver.findElements(By.cssSelector(".dc-search-suggestions"));
        int listSize = suggestionsElements.size();
        if (listSize == 0) {
            Assert.fail("i do not have suggestion for you" + item);
        }
        int randomNumberIndex = new RandomNumberHelper().generateRandomNumber(listSize);
        WebElement selectedElement = suggestionsElements.get(randomNumberIndex);
        String selectedSuggestion = selectedElement.getText();
        selectedElement.click();
        //suggestionsElements.get(randomNumberIndex).click();
    }



    public void selectProductFromSuggestion(String item) {
        selectFromSuggestion(item, By.cssSelector("dc-search-suggestions__suggestion dc-search-suggestions__suggestion--sayt"));

    }
}
