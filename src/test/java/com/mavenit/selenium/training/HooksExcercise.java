package com.mavenit.selenium.training;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class HooksExcercise {
    public static WebDriver driver;
    public void setUp1(){
        WebDriverManager.chromedriver().setup();
         //WebDriver driver = new ChromeDriver();
        driver= new ChromeDriver(); // if not define then nullpointer exception
        driver.get("https://www.currys.co.uk/gbuk/index.html");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }
}
