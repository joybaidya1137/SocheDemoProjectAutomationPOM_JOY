package Test;

import PageClasses.CartPage;
import Utils.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest  extends BaseClass {
    CartPage cartPage = new CartPage();


    //cart pase loaded
    @Test(priority = 1)
    public void testCartPageLoads(){
        Assert.assertTrue(cartPage.cartPageDisplayed(),"cart page did not load");
        System.out.println("cart page load successfully");
    }

    @Test(priority = 2)
    public void testCartItemCount() {
       cartPage. printCartItemCount();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
