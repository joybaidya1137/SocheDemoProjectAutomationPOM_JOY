package Test;

import PageClasses.ProductsPage;
import Utils.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductsTest extends BaseClass {


    @Test(priority = 1)
    public void testProductPageLoads(){
         ProductsPage productsPage =new ProductsPage();
        Assert.assertTrue(productsPage.isProductPageDisplayed(),"Products page did not load");
    }
    @Test(priority = 2)
    public void testaddProductToCart(){
        ProductsPage productsPage =new ProductsPage();
        productsPage.addProductToCart();
        Assert.assertTrue(productsPage.isProductPageDisplayed(),"product was not Add");
    }


}
