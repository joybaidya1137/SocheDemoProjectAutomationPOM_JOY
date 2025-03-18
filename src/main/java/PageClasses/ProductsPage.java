package PageClasses;

import Utils.DriverManages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

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


       public void RemoveProducts() {
           List<WebElement> RemoveButton = driver.findElements(By.xpath("//button[contains(text(),'Remove')]"));
           if (!RemoveButton.isEmpty()) {
               RemoveButton.get(0).click();
               System.out.println("Remove button clicked");
           }else {
               System.out.println(" NO clicked Remove button");
           }
       }

      public int getRemoveButtonCount() {
         return driver.findElements(By.xpath("//button[contains(text(),'Remove')]")).size();
       // Returns the count of remove buttons
    }

   // Select sorting option("Name (Z to A)")

     public void selectSortingOption1(String option){
        WebElement dropdown = driver.findElement(By.className("product_sort_container"));
        dropdown.sendKeys(option);
        System.out.println("Selected option:" +option);

    }


// oporer eselectSortingOption1 and niche selectSortingOption1 same kaj kore
    public void selectSortingOption() {
        WebElement dropdown = driver.findElement(By.className("product_sort_container"));
        Select select = new Select(dropdown);
        select.selectByVisibleText("Price (high to low)");// Selecting sorting option by value and(" Price (high to low)")
    }

// dropDown  e productsTest ai method er jonno Loop Use korci
public void selectSortingOption2(String optionText) {
    WebElement dropdown = driver.findElement(By.className("product_sort_container"));
    dropdown.sendKeys(optionText);
    System.out.println("Selected option: " + optionText);
}


    //View the cart
    public void viewCart(){
    // WebElement cartButton = driver.findElement(By.xpath("//a[@class=\"shopping_cart_link\"]"));
        WebElement cartButton = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[1]/div[3]/a"));
        cartButton.click();
        System.out.println("Cart button clicked");
    }




}
