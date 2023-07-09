package Tests;

import Driver.driverBase;
import Ultilities.DataProviderFactory;
import Ultilities.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import model.pages.HomePage;
import model.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class placeOrderForStock extends driverBase {
  @Test(dataProvider = "OrderSuccessfullyData", dataProviderClass = DataProviderFactory.class)
  public void placeOrderWithSuccess(
      String username,
      String password,
      String af,
      String orderType,
      String symbol,
      String qtty,
      String price,
      String BS,
      String priceType,
      String tradingPass){

    WebDriver driver = getChromeDriverInstance();
    String TestUrl = URL.currentTestUrl("LOGIN_PAGE");
    driver.get(TestUrl);
    driver.manage().window().maximize();
//    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    LoginPage loginPage = new LoginPage(driver);
    loginPage.login(username, password);
    HomePage homePage = new HomePage(driver);
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

    wait.until(ExpectedConditions.visibilityOfElementLocated(homePage.getAfSelector()));
    wait.until(ExpectedConditions.visibilityOfElementLocated(homePage.getOrderTypeSelector()));
    wait.until(ExpectedConditions.visibilityOfElementLocated(homePage.getSymbolSelector()));
    wait.until(ExpectedConditions.visibilityOfElementLocated(homePage.getQuantitySelector()));
    wait.until(ExpectedConditions.visibilityOfElementLocated(homePage.getPriceSelector()));
    wait.until(ExpectedConditions.visibilityOfElementLocated(homePage.getBSSelector()));
    wait.until(ExpectedConditions.visibilityOfElementLocated(homePage.getPriceTypeSelector()));

    //calculate the number of orders in waiting active tab before place new an order
    int numberOfOrdersBefore = 0;
    for(WebElement elem : homePage.getCheckboxOrderElem()){
      numberOfOrdersBefore += 1;
    }

    try{
    homePage
        .selectAfByValue(af)
        .selectOrderTypeByText(orderType)
        .inputSymbol(symbol)
        .inputQuantity(qtty)
        .inputPrice(price)
        .selectBSByText(BS)
        .selectPriceTypeByText(priceType)
        .clickOrderBtn();
    }catch (org.openqa.selenium.StaleElementReferenceException ex){
      homePage
          .selectAfByValue(af)
          .selectOrderTypeByText(orderType)
          .inputSymbol(symbol)
          .inputQuantity(qtty)
          .inputPrice(price)
          .selectBSByText(BS)
          .selectPriceTypeByText(priceType)
          .clickOrderBtn();
    }

//    String mainWindowHandle = driver.getWindowHandle();
//    for (String windowHandle : driver.getWindowHandles()) {
//      if (!windowHandle.equals(mainWindowHandle)) {
//        driver.switchTo().window(windowHandle);
//        break;
//      }
//    }
    homePage.inputTradingPass(tradingPass);
    homePage.clickConfirmBtn();
    wait.until(ExpectedConditions.visibilityOfElementLocated(homePage.getBtnOKSelector()));
    String msg = homePage.getMessageElem().getText();
    homePage.clickBtnOK();
//    driver.switchTo().window(mainWindowHandle);
//    wait.until(ExpectedConditions.visibilityOfElementLocated(homePage.getOrderWaitingActiveTabSelector()));
//    homePage.chooseActiveWaitingOrderTab();

    homePage.getRefreshOrderElem().click();

    int numberOfOrdersAfter = 0;
    for(WebElement elem : homePage.getCheckboxOrderElem()){
      numberOfOrdersAfter += 1;
    }

    Assert.assertEquals(msg, "Lệnh đặt thành công!");
    Assert.assertEquals(numberOfOrdersAfter, numberOfOrdersBefore + 1);

    List<WebElement> ActiveWaitingOrderList = new ArrayList<>();
    ActiveWaitingOrderList.add(homePage.getBSInTabElem());
    ActiveWaitingOrderList.add(homePage.getSymbolInTabElem());
    ActiveWaitingOrderList.add(homePage.getStatusInTabElem());
    ActiveWaitingOrderList.add(homePage.getPriceTypeInTabElem());
    ActiveWaitingOrderList.add(homePage.getQuantityInTabElem());
    ActiveWaitingOrderList.add(homePage.getPriceInTabElem());

    System.out.println("Im tired!");

    StringBuilder actualOrder = new StringBuilder();
    for(WebElement elem : ActiveWaitingOrderList){
        actualOrder.append(elem.getText()).append(";");
    }
    System.out.println(actualOrder);
  }
}
