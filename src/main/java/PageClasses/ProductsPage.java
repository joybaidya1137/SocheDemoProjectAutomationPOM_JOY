package PageClasses;

import Utils.DriverManages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ProductsPage {

    private WebDriver driver;

    public ProductsPage(){
        this.driver= DriverManages.getDriver();
    }

    //Check if Products Page is displayed
    public boolean isProductPageDisplayed(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("inventory_list")));
        return driver.findElement(By.className("inventory_list")).isDisplayed();
    }

   // get List of all product names
    public List<WebElement> getAllProducts(){
       return driver.findElements(By.className("inventory_item_name"));
    }



    public void addProductToCart(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Add to cart')]")));

        List<WebElement>addToCartButton= driver.findElements(By.xpath("//button[contains(text(),'Add to cart')]"));
        if(!addToCartButton.isEmpty()){
            addToCartButton.get(0).click();
            System.out.println("Add to cart fast button clicked");
            addToCartButton.get(1).click();
            System.out.println("Add to cart 2nd button clicked");
            addToCartButton.get(2).click();
            System.out.println("Add to cart 3rd button clicked");

        }



    }




}
