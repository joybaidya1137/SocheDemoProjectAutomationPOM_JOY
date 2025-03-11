package PageClasses;

import Utils.DriverManages;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(){
        this.driver= DriverManages.getDriver();
    }
}
