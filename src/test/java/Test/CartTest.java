package Test;

import PageClasses.CartPage;
import Utils.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest  extends BaseClass {
    CartPage cartPage = new CartPage();


    //cart pase loaded
    @Test(priority = 1)
    public void testCartPageLoads() {
        Assert.assertTrue(cartPage.cartPageDisplayed(), "cart page did not load");
        System.out.println("cart page load successfully");
    }

    @Test(priority = 2)
    public void testCartItemCount() {
        cartPage.printCartItemCount();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test(priority = 3, dependsOnMethods = "testCartPageLoads")
    public void testCheckout() {
        cartPage.Checkout();

    }

    @Test(priority = 4, dependsOnMethods = "testCheckout")
    public void testfillCheckoutForm() {
        cartPage.fillCheckoutForm("joy", "baidya", "1123");
        System.out.println("Current URL: " + driver.getCurrentUrl());
        String actualUrl = driver.getCurrentUrl();
        String ExpectedURL = "https://www.saucedemo.com/checkout-step-two.html";
        Assert.assertEquals(actualUrl, ExpectedURL, "Fail CheckoutForm");
        System.out.println("Successfull Checkout From");
    }

    @Test(priority = 5, dependsOnMethods = "testfillCheckoutForm")
    public void testFinishButton() {
     cartPage.FinishButton();

        WebElement backHomeButton = driver.findElement(By.id("back-to-products"));
        // চেক করা হচ্ছে যে বাটনটি দৃশ্যমান কিনা
        boolean isDisplayed = backHomeButton.isDisplayed();
        System.out.println("Back Home Button Displayed: " + isDisplayed);

        // Assertion
        Assert.assertTrue(isDisplayed, "Back Home button is not displayed!");
        System.out.println("Back Home button is  displayed");

    }
}