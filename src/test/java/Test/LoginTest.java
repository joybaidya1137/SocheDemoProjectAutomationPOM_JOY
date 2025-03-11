package Test;

import PageClasses.LoginPage;
import PageClasses.ProductsPage;
import Utils.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseClass {

    @Test
    public void validLogin(){
        LoginPage loginPage = new LoginPage();
        loginPage.login("standard_user", "secret_sauce");


      // coment er modde ja ace sei gulo sudu login hoice ta varify korar jonno use kora hoy
       // But jodi productTest korar jonno ay comment er gula use korle error dibe

       /* String expectedUrl = "https://www.saucedemo.com/inventory.html";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "Login failed!");

        String ActualTitle = driver.getTitle();
        System.out.println("ActualTitle is:"+ActualTitle);
        String ExpectedTitle = "Swag Labs";
        System.out.println("ExpectedTitle is:"+ExpectedTitle);
        Assert.assertEquals(ActualTitle,ExpectedTitle,"Login failed1");
         */

        // now sobar jonno ay ta use korbo

        ProductsPage productsPage = new ProductsPage();
        Assert.assertTrue(productsPage.isProductPageDisplayed(), "Login failed");



    }


}
