package model.pages;

import Driver.driverBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginPage{
  private WebDriver driver;
  private By usernameSelector = By.id("UserName");
  private By passwordSelector = By.id("Password");
  private By LoginTimeOutSelector = By.id("LoginTimeOut");
  private By LoginBtnSelector = By.cssSelector("[type='submit']");

  public loginPage(WebDriver driver){
    this.driver = driver;
  }

  public WebElement usernameElem(){
    return driver.findElement(usernameSelector);
  }

  public WebElement passwordElem(){
    return driver.findElement(passwordSelector);
  }

  public WebElement LoginTimeOutElem(){
    return driver.findElement(LoginTimeOutSelector);
  }

  public WebElement LoginBtnElem(){
    return driver.findElement(LoginBtnSelector);
  }

  public loginPage inputUsername(String username){
    usernameElem().sendKeys(username);
    return this;
  }

  public loginPage inputPassword(String password){
    passwordElem().sendKeys(password);
    return this;
  }

  public loginPage inputTimeOut(String timeout){
    LoginTimeOutElem().sendKeys(timeout);
    return this;
  }

  public void clickLoginBtn(){
    LoginBtnElem().click();
  }

}
