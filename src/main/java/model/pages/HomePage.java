package model.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HomePage {
  private WebDriver driver;
  By companyLogoSelector = By.className("company_logo");
  By afSelector = By.id("Acctno");
  By logoutSelector = By.className("btnGreen3");

  public HomePage(WebDriver driver){
    this.driver = driver;
  }

  public WebElement getLogoWebElem() {
    return driver.findElement(companyLogoSelector) ;
  }

  public WebElement getAfWebElem() {
    return driver.findElement(afSelector);
  }

  public WebElement getLogoutBtn() {
    return driver.findElement(logoutSelector);
  }

  public Select selectAf(){
    Select select = new Select(getAfWebElem());
    return select;
  }

  public void selectAfByValue(String afacctno){
    Select select = new Select(getAfWebElem());
    select.selectByValue(afacctno);
  }

  public void logout(){
    getLogoutBtn().click();
  }

}
