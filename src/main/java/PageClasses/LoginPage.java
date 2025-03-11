package PageClasses;

import Utils.DriverManages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(){
        this.driver= DriverManages.getDriver();
    }



   // private By usernameFild = By.id("");
  //  private By passwordFild = By.id("");


    public void setUsername(String username){
        WebElement usernameField = driver.findElement(By.id("user-name"));
        usernameField.sendKeys(username);

    }
    public void setPassword(String password){
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys(password);
    }
    public void clickLoginButton(){
        WebElement LoginButton = driver.findElement(By.id("login-button"));
        LoginButton.click();
    }

    public void login(String username,String password){
        setUsername(username);
        setPassword(password);
        clickLoginButton();

    }



}
