package Test;

import PageClasses.ProductsPage;
import Utils.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductsTest extends BaseClass {
    ProductsPage productsPage =new ProductsPage();

    @Test(priority = 1)
    public void testProductPageLoads(){

        Assert.assertTrue(productsPage.isProductPageDisplayed(),"Products page did not load");
    }
    @Test(priority = 2)
    public void testaddProductToCart(){
        productsPage.addProductToCart();
        Assert.assertTrue(productsPage.isProductPageDisplayed(),"product was not Add");
    }


    @Test(priority = 3 )
    public void testRemoveProducts(){
        productsPage.addProductToCart();
        int beforeRemoveCount =productsPage.getRemoveButtonCount();
        Assert.assertTrue(beforeRemoveCount > 0, "No product available to remove.");

        productsPage.RemoveProducts();
        int afterRemoveCount = productsPage.getRemoveButtonCount();

        Assert.assertEquals(afterRemoveCount,beforeRemoveCount-1,"Product was not removed successfully");
        try{
            Thread.sleep(1000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

// test 4,5,6 is same droupdown er upor and 6 no e loop ues kora hoiche
    @Test(priority = 4)
      public void testSelectSortingOption1() {
        productsPage.selectSortingOption1("Name (Z to A)");
        Assert.assertTrue(productsPage.isProductPageDisplayed(), "Sorting did not apply");
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("Error occurred during this test filed: " + e.getMessage());
        }
    }


   @Test(priority = 5)
   public void testSelectSortingOption2() {
       productsPage.selectSortingOption();
       try{
           Thread.sleep(1000);
       } catch (Exception e) {
           throw new RuntimeException(e);
       }
   }



@Test(priority = 6)
public void testSelectSortingOptions3() {
    String[] sortingOptions = {"Name (A to Z)", "Name (Z to A)", "Price (low to high)", "Price (high to low)"};

    for (String option : sortingOptions) {
        productsPage.selectSortingOption2(option);
        Assert.assertTrue(productsPage.isProductPageDisplayed(), "Sorting did not apply for: " + option);
        try{
            Thread.sleep(1000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}


    @Test(priority = 7, dependsOnMethods="testProductPageLoads")
    public void navigateCartpage()  {
        productsPage.viewCart();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }



}
