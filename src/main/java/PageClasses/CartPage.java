package PageClasses;

import Utils.DriverManages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CartPage {
    private WebDriver driver;

    public CartPage(){

        this.driver= DriverManages.getDriver();
    }


    //Check if cart Page is displayed
    public boolean cartPageDisplayed(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cart_contents_container")));
        return driver.findElement(By.id("cart_contents_container")).isDisplayed();
    }

    public void printCartItemCount() {
        List<WebElement> cartNumber = driver.findElements(By.className("shopping_cart_badge"));
        if (cartNumber.size() > 0) {
            String count = cartNumber.get(0).getText();
            System.out.println("Total items in cart: " + count);
        } else {
            System.out.println("Cart is empty.");
        }
    }




}
