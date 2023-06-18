package Tests;

import Driver.driverBase;
import Ultilities.DataProviderFactory;
import Ultilities.ExcelReader;
import Ultilities.URL;
import java.io.File;
import model.pages.HomePage;
import model.pages.LoginPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class login extends driverBase {
  //  @Test(dataProvider = "PassLoginData", dataProviderClass = DataProviderFactory.class)
  //  public void LoginWithCorrectCredential(String username, String password, String afacctno){
  //    WebDriver driver = getChromeDriverInstance();
  //    String TestUrl = URL.currentTestUrl("LOGIN_PAGE");
  //    driver.get(TestUrl);
  //    SoftAssert softAssert = new SoftAssert();
  //
  //    LoginPage loginPage = new LoginPage(driver);
  //    loginPage
  //        .clearUsername()
  //        .inputUsername(username)
  //        .inputPassword(password)
  //        .clickLoginBtn();
  //
  //    HomePage homePage = new HomePage(driver);
  //    softAssert.assertTrue(homePage.getLogoWebElem().isDisplayed(), "The company's logo is not
  // displayed!");
  //    Assert.assertEquals(homePage.selectAf().getFirstSelectedOption().getText(), afacctno);
  // }

  @Test(dataProvider = "FailLoginData", dataProviderClass = DataProviderFactory.class)
  public void LoginWithInCorrectCredential(String username, String password, String alert)
      throws InterruptedException {
    WebDriver driver = getChromeDriverInstance();
    String TestUrl = URL.currentTestUrl("LOGIN_PAGE");
    driver.get(TestUrl);
    SoftAssert softAssert = new SoftAssert();
    LoginPage loginPage = new LoginPage(driver);

    loginPage.clearUsername().inputUsername(username).inputPassword(password).clickLoginBtn();

    Thread.sleep(2000);

    String liValue = "";
    for (WebElement li : loginPage.getValidationErrors()) {
      liValue = liValue.concat(li.getText());
    }
    Assert.assertEquals(liValue, alert);
    }
}
