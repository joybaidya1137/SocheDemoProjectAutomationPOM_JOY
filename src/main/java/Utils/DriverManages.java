package Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManages {
    private static WebDriver driver;

    private DriverManages(){
        //this is Private constructor to prevent instantiation
    }


    // 1.getDriver
    public static WebDriver getDriver(){
        if (driver==null){
            ///System.setProperty("webDriver.chrome.driver", "src/main/resources/chromedriver");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();

        }
         return driver;
    }

    //2.Quit Driver
    public static void quitDriver(){
        if (driver != null) {
            driver.quit();
            driver = null;   //optional
        }
    }


}

