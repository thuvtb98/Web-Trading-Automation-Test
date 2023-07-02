package model.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HomePage {
  private WebDriver driver;
  By companyLogoSelector = By.className("company_logo");
  By afSelector = By.id("Acctno");
  By logoutSelector = By.className("btnGreen3");
  By orderTypeSelector = By.xpath("//select[@class='dropdown normal_dropdown_custom' and @id='ordertype']");
  By symbolSelector = By.id("Symbol");
  By quantitySelector = By.id("Qtty");
  By priceSelector = By.id("Price");
  By BSSelector = By.id("Side");
  By priceTypeSelector = By.id("PriceType");
  By orderSelector = By.id("btn_NormalOrder");
  By orderWaitingActiveTabSelector = By.id("tabOrderActive");
  By bSInTabSelector = By.id("NormalOrderGrid_tccell0_6");
  By symbolInTabSelector = By.xpath("//tr[contains(@id, 'NormalOrderGrid_DXDataRow')]/td[8]");
  By statusInTabSelector = By.xpath("//tr[contains(@id, 'NormalOrderGrid_DXDataRow')]/td[9]");
  By priceTypeInTabSelector = By.xpath("//tr[contains(@id, 'NormalOrderGrid_DXDataRow')]/td[10]");
  By quantityInTabSelector = By.xpath("//tr[contains(@id, 'NormalOrderGrid_DXDataRow')]/td[11]");
  By priceInTabSelector = By.xpath("//tr[contains(@id, 'NormalOrderGrid_DXDataRow')]/td[12]");

  public HomePage(WebDriver driver) {
    this.driver = driver;
  }

  public WebElement getLogoWebElem() {
    return driver.findElement(companyLogoSelector);
  }

  public WebElement getAfWebElem() {
    return driver.findElement(afSelector);
  }

  public WebElement getLogoutBtn() {
    return driver.findElement(logoutSelector);
  }

  public WebElement getOrderTypeWebElem() {
    return driver.findElement(orderTypeSelector);
  }

  public WebElement getQuantityElem() {
    return driver.findElement(quantitySelector);
  }

  public WebElement getPriceElem() {
    return driver.findElement(priceSelector);
  }

  public WebElement getBSElem() {
    return driver.findElement(BSSelector);
  }

  public WebElement getPriceTypeElem() {
    return driver.findElement(priceTypeSelector);
  }

  public WebElement getSymbolElem() {
    return driver.findElement(symbolSelector);
  }

  public WebElement getOrderElem() {
    return driver.findElement(orderSelector);
  }

  public WebElement getWaitActiveTabElem() {
    return driver.findElement(orderWaitingActiveTabSelector);
  }

  public List<WebElement> getBSInTabElem() {
    return driver.findElements(bSInTabSelector);
  }

  public List<WebElement> getSymbolInTabElem() {
    return driver.findElements(symbolInTabSelector);
  }

  public List<WebElement> getStatusInTabElem() {
    return driver.findElements(statusInTabSelector);
  }

  public List<WebElement> getPriceTypeInTabElem() {
    return driver.findElements(priceTypeInTabSelector);
  }

  public List<WebElement> getQuantityInTabElem() {
    return driver.findElements(quantityInTabSelector);
  }

  public List<WebElement> getPriceInTabElem() {
    return driver.findElements(priceInTabSelector);
  }

  public Select selectAf() {
    Select select = new Select(getAfWebElem());
    return select;
  }

  public Select selectOrderType() {
    Select select = new Select(getOrderTypeWebElem());
    return select;
  }

  public Select selectBS() {
    Select select = new Select(getBSElem());
    return select;
  }

  public Select selectPriceType() {
    Select select = new Select(getPriceElem());
    return select;
  }

  public HomePage selectAfByValue(String afacctno) {
    Select select = new Select(getAfWebElem());
    select.selectByValue(afacctno);
    return this;
  }

  public HomePage selectBSByText(String BS) {
    Select select = new Select(getBSElem());
    select.selectByVisibleText(BS);
    return this;
  }

  public HomePage inputSymbol(String symbol) {
    getSymbolElem().sendKeys(symbol);
    return this;
  }

  public HomePage inputQuantity(String qtty) {
    getQuantityElem().sendKeys(qtty);
    return this;
  }

  public HomePage inputPrice(String price) {
    getPriceElem().sendKeys(price);
    return this;
  }

  public HomePage selectOrderTypeByText(String orderType) {
    Select select = new Select(getOrderTypeWebElem());
    select.selectByVisibleText(orderType);
    return this;
  }

  public HomePage selectPriceTypeByText(String priceType) {
    Select select = new Select(getPriceTypeElem());
    select.selectByVisibleText(priceType);
    return this;
  }

  public void clickOrderBtn() {
    getOrderElem().click();
  }

  public void chooseActiveWaitingOrderTab() {
    getWaitActiveTabElem().click();
  }

  public void logout() {
    getLogoutBtn().click();
  }
}
