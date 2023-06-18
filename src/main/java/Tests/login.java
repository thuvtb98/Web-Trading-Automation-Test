package Tests;

import Driver.driverBase;
import Ultilities.DataProviderFactory;
import Ultilities.ExcelReader;
import Ultilities.URL;
import java.io.File;
import model.pages.HomePage;
import model.pages.LoginPage;
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
//    softAssert.assertTrue(homePage.getLogoWebElem().isDisplayed(), "The company's logo is not displayed!");
//    Assert.assertEquals(homePage.selectAf().getFirstSelectedOption().getText(), afacctno);
//}

  @Test(dataProvider = "FailLoginData", dataProviderClass = DataProviderFactory.class)
  public void LoginWithInCorrectCredential(String username, String password, String alert){
    WebDriver driver = getChromeDriverInstance();
    String TestUrl = URL.currentTestUrl("LOGIN_PAGE");
    driver.get(TestUrl);
    SoftAssert softAssert = new SoftAssert();
    LoginPage loginPage = new LoginPage(driver);

    loginPage
        .clearUsername()
        .inputUsername(username)
        .inputPassword(password)
        .clickLoginBtn();

    int lenght = loginPage.getValidationErrors().size();
    System.out.println(lenght);
//    switch (lenght){
//      case 0:
//        Assert.assertEquals(loginPage.getValidationErrors().get(0).getText(), alert);
//        break;
//      case 1:
//        Assert.assertEquals(loginPage.getValidationErrors().get(0).getText().concat(loginPage.getValidationErrors().get(1).getText()), alert);
//        break;
//    }
//    lenght = 0;
  }

}
