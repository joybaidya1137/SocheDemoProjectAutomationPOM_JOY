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

    public void Checkout(){
        WebElement checkout = driver.findElement(By.id("checkout"));
        checkout.click();

    }

    // Locators for elements
    private By firstNameField = By.id("first-name");
    private By lastNameField = By.id("last-name");
    private By postalCodeField = By.id("postal-code");
    private By continueButton = By.id("continue");

    // Actions (Methods)
        public void enterFirstName (String firstName){
        driver.findElement(firstNameField).sendKeys(firstName);
    }

        public void enterLastName (String lastName){
        driver.findElement(lastNameField).sendKeys(lastName);
    }

        public void enterPostalCode (String postalCode){
        driver.findElement(postalCodeField).sendKeys(postalCode);
    }

        public void clickContinue () {
        driver.findElement(continueButton).click();
    }

        // Complete form submission process
        public void fillCheckoutForm (String firstName, String lastName, String postalCode){
        enterFirstName(firstName);
        enterLastName(lastName);
        enterPostalCode(postalCode);
        clickContinue();
    }



    public void FinishButton(){
        WebElement firstNameField = driver.findElement(By.id("finish"));
        firstNameField.click();
        WebElement completed = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[2]/span"));
        String message = completed.getText();
        System.out.println("Checkout Message: " + message);

        WebElement Thank = driver.findElement(By.className("complete-header"));
        String actualMessage = Thank.getText();
        System.out.println("Checkout Message: " + actualMessage);

    }


}