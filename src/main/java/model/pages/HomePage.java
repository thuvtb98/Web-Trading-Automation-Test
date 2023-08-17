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
  By symbolSelector = By.xpath("//td[@class='NOrder_td_input']/input[@id='Symbol']");
  By quantitySelector = By.xpath("//td[@class='NOrder_td_input']/input[@id='Qtty']");
  By priceSelector = By.xpath("//td[@class='NOrder_td_input']/input[@id='Price']");
  By BSSelector = By.id("Side");
  By priceTypeSelector = By.id("PriceType");
  By orderSelector = By.id("btn_NormalOrder");
  By tradingPassSelector = By.id("TradingPassword_TK");
  By confirmBtnSelector = By.id("preview_advance_order_button_submit");
  By orderWaitingActiveTabSelector = By.xpath("//li[@id='tabControlRight_T1']/div[@class='tabOrder']");
  By refeshOrderSelector = By.xpath("//li[@id='tabControlRight_AT1']//td[2]");
  By bSInTabSelector = By.xpath("//tr[contains(@id, 'NormalOrderGrid_DXDataRow0')]/td[7]");
  By symbolInTabSelector = By.xpath("//tr[contains(@id, 'NormalOrderGrid_DXDataRow0')]/td[8]");
  By statusInTabSelector = By.xpath("//tr[contains(@id, 'NormalOrderGrid_DXDataRow0')]/td[9]");
  By priceTypeInTabSelector = By.xpath("//tr[contains(@id, 'NormalOrderGrid_DXDataRow0')]/td[10]");
  By quantityInTabSelector = By.xpath("//tr[contains(@id, 'NormalOrderGrid_DXDataRow0')]/td[11]");
  By priceInTabSelector = By.xpath("//tr[contains(@id, 'NormalOrderGrid_DXDataRow0')]/td[12]");
  By checkboxOrderSelector = By.xpath("//tr[contains(@id, 'NormalOrderGrid_DXDataRow')]/td[1]");
  By matchOrderTabSelector = By.xpath("//li[@id='tabControlRight_T2']//div[@class='tabOrder']");
  By refreshSelector = By.xpath("//form[@name='Order']//input[@id='btn_ClearNormalOrder']");
  By symboyLabelSelector = By.xpath("//td[@class='NOrder_td_lable'][normalize-space()='Mã CK']");
  //  By symbolInTabSelector = By.xpath("//tr[contains(@id, 'NormalOrderGrid_DXDataRow')]/td[8]");
  //  By statusInTabSelector = By.xpath("//tr[contains(@id, 'NormalOrderGrid_DXDataRow')]/td[9]");
  //  By priceTypeInTabSelector = By.xpath("//tr[contains(@id,
  // 'NormalOrderGrid_DXDataRow')]/td[10]");
  //  By quantityInTabSelector = By.xpath("//tr[contains(@id,
  // 'NormalOrderGrid_DXDataRow')]/td[11]");
  //  By priceInTabSelector = By.xpath("//tr[contains(@id, 'NormalOrderGrid_DXDataRow')]/td[12]");
  By btnOKSelector = By.className("buttonOK");
  By messageSelector = By.id("messageErrorDiv");

  public By getBtnOKSelector() {
    return btnOKSelector;
  }

  public By getAfSelector() {
    return afSelector;
  }

  public By getSymbolSelector() {
    return symbolSelector;
  }

  public By getBSSelector() {
    return BSSelector;
  }

  public By getOrderTypeSelector() {
    return orderTypeSelector;
  }

  public By getQuantitySelector() {
    return quantitySelector;
  }

  public By getPriceSelector() {
    return priceSelector;
  }

  public By getPriceTypeSelector() {
    return priceTypeSelector;
  }

  public By getTradingPassSelector() {
    return tradingPassSelector;
  }

  public By getOrderWaitingActiveTabSelector() {
    return orderWaitingActiveTabSelector;
  }

  public HomePage(WebDriver driver) {
    this.driver = driver;
  }

  public WebElement getBtnOKElem() {
    return driver.findElement(btnOKSelector);
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

  public WebElement getTradingPassElem() {
    return driver.findElement(tradingPassSelector);
  }

  public WebElement getConfirmBtnElem() {
    return driver.findElement(confirmBtnSelector);
  }

  public WebElement getWaitActiveTabElem() {
    return driver.findElement(orderWaitingActiveTabSelector);
  }

  public WebElement getBSInTabElem() {
    return driver.findElement(bSInTabSelector);
  }

  public WebElement getSymbolInTabElem() {
    return driver.findElement(symbolInTabSelector);
  }

  public WebElement getStatusInTabElem() {
    return driver.findElement(statusInTabSelector);
  }

  public WebElement getPriceTypeInTabElem() {
    return driver.findElement(priceTypeInTabSelector);
  }

  public WebElement getQuantityInTabElem() {
    return driver.findElement(quantityInTabSelector);
  }

  public WebElement getPriceInTabElem() {
    return driver.findElement(priceInTabSelector);
  }

  public List<WebElement> getCheckboxOrderElem() {
    return driver.findElements(checkboxOrderSelector);
  }

  public WebElement getMessageElem() {
    return driver.findElement(messageSelector);
  }

  public WebElement getRefreshOrderElem() {
    return driver.findElement(refeshOrderSelector);
  }

  public WebElement getMatchOrderTabElem(){
    return driver.findElement(matchOrderTabSelector);
  }

  public WebElement getRefreshSelector(){
    return driver.findElement(refreshSelector);
  }

  public WebElement getSymbolLabelElem(){
    return driver.findElement(symboyLabelSelector);
  }

//  public List<WebElement> getBSInTabElem() {
//    return driver.findElements(bSInTabSelector);
//  }
//
//  public List<WebElement> getSymbolInTabElem() {
//    return driver.findElements(symbolInTabSelector);
//  }
//
//  public List<WebElement> getStatusInTabElem() {
//    return driver.findElements(statusInTabSelector);
//  }
//
//  public List<WebElement> getPriceTypeInTabElem() {
//    return driver.findElements(priceTypeInTabSelector);
//  }
//
//  public List<WebElement> getQuantityInTabElem() {
//    return driver.findElements(quantityInTabSelector);
//  }
//
//  public List<WebElement> getPriceInTabElem() {
//    return driver.findElements(priceInTabSelector);
//  }

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

  public void inputTradingPass(String tradingPass) {
    getTradingPassElem().sendKeys(tradingPass);
  }

  public void clickConfirmBtn() {
    getConfirmBtnElem().click();
  }

  public void clickBtnOK() {
    getBtnOKElem().click();
  }

  public void chooseActiveWaitingOrderTab() {
    getWaitActiveTabElem().click();
  }

  public void logout() {
    getLogoutBtn().click();
  }
}
