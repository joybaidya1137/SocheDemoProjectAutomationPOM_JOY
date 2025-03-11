package Utils;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseClass {
    protected WebDriver driver;
    @BeforeSuite
   public void setUp(){
     driver = DriverManages.getDriver();
     driver.get("https://www.saucedemo.com");
        String title = driver.getTitle();
        System.out.println(title);
    }

    @AfterSuite
    public void tearDown(){
        DriverManages.quitDriver();

    }
}
