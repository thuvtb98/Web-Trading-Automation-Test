package Tests;

import Driver.driverBase;
import Ultilities.DataProviderFactory;
import java.util.ArrayList;
import java.util.List;
import model.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class placeOrderForStock extends driverBase {
  @Test(dependsOnMethods = {"Tests.login.LoginWithCorrectCredential"} ,dataProvider = "OrderSuccessfullyData", dataProviderClass = DataProviderFactory.class)
  public void placeOrderWithSuccess(
      String af,
      String orderType,
      String symbol,
      String qtty,
      String price,
      String BS,
      String priceType) {
    WebDriver driver = getChromeDriverInstance();
    HomePage homePage = new HomePage(driver);

    homePage
        .selectAfByValue(af)
        .selectOrderTypeByText(orderType)
        .inputSymbol(symbol)
        .inputQuantity(qtty)
        .inputPrice(price)
        .selectBSByText(BS)
        .selectPriceTypeByText(priceType)
        .clickOrderBtn();
    homePage.chooseActiveWaitingOrderTab();

    List<List<WebElement>> ActiveWaitingOrderList = new ArrayList<>();
    ActiveWaitingOrderList.add(homePage.getBSInTabElem());
    ActiveWaitingOrderList.add(homePage.getSymbolInTabElem());
    ActiveWaitingOrderList.add(homePage.getStatusInTabElem());
    ActiveWaitingOrderList.add(homePage.getPriceTypeInTabElem());
    ActiveWaitingOrderList.add(homePage.getQuantityInTabElem());
    ActiveWaitingOrderList.add(homePage.getPriceInTabElem());

    StringBuilder actualOrder = new StringBuilder();
    for(List<WebElement> list : ActiveWaitingOrderList){
      for(WebElement elem : list){
        actualOrder.append(elem).append(",");
      }
    }

    System.out.println(actualOrder.toString());
  }
}
