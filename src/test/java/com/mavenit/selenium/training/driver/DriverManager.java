package com.mavenit.selenium.training.driver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DriverManager {
    // placed  or copied hooks class here and change setup() to openBrowser

        public static WebDriver driver;

        public void openBrowser() {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.get("https://www.currys.co.uk");
            //driver.get("https://www.currys.co.uk/gbuk/index.html");
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }

        public String getCurrentUrl()
        {
            return driver.getCurrentUrl();
        }


        public void closeBrowser() {
            driver.quit();
        }
    }


