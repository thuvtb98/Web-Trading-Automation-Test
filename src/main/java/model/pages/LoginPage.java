package model.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
  private WebDriver driver;
  private By usernameSelector = By.id("UserName");
  private By passwordSelector = By.id("Password");
  private By loginTimeOutSelector = By.id("LoginTimeOut");
  private By loginBtnSelector = By.cssSelector("[type='submit']");
  private By validationErrors = By.xpath("//div[@class='validation-summary-errors']/ul/li");

  public LoginPage(WebDriver driver){
    this.driver = driver;
  }

  public WebElement usernameElem(){
    return driver.findElement(usernameSelector);
  }

  public WebElement passwordElem(){
    return driver.findElement(passwordSelector);
  }

  public WebElement loginTimeOutElem(){
    return driver.findElement(loginTimeOutSelector);
  }

  public WebElement loginBtnElem(){
    return driver.findElement(loginBtnSelector);
  }

  public List<WebElement> getValidationErrors() {
    return driver.findElements(validationErrors);
  }

  public LoginPage clearUsername(){
    usernameElem().clear();
    return this;
  }

  public LoginPage clearTimeout(){
    loginTimeOutElem().clear();
    return this;
  }

  public LoginPage inputUsername(String username){
    usernameElem().sendKeys(username);
    return this;
  }

  public LoginPage inputPassword(String password){
    passwordElem().sendKeys(password);
    return this;
  }

  public LoginPage inputTimeOut(String timeout){
    loginTimeOutElem().sendKeys(timeout);
    return this;
  }

  public void clickLoginBtn(){
    loginBtnElem().click();
  }

}
