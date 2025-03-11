package PageClasses;

import Utils.DriverManages;
import org.openqa.selenium.WebDriver;

public class CartPage {
    private WebDriver driver;

    public CartPage(){
        this.driver= DriverManages.getDriver();
    }


}
