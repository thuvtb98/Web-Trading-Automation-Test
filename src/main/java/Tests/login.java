package Tests;

import Driver.driverBase;
import Driver.webDriver;
import Ultilities.ExcelReader;
import Ultilities.URL;
import java.io.File;
import model.pages.loginPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;

public class login extends driverBase {
  @Test(dataProvider = "LoginData", description = "Login with data set")
  public void LoginWithCorrectCredential(String username, String password, String timeout){
    WebDriver driver = getChromeDriverInstance();
    String TestUrl = URL.currentTestUrl("LOGIN_PAGE");
    driver.get(TestUrl);

    loginPage loginPage = new loginPage(driver);
    loginPage
        .inputUsername(username)
        .inputPassword(password)
        .inputTimeOut(timeout)
        .clickLoginBtn();
  }

  @DataProvider
  public Object[][] LoginData() {
    File excelFileLocation = new File(System.getProperty("user.dir") + "/src/main/dataProviderFiles/" + "LoginData.xlsx");
    String sheetName = "Sheet1";
    int startRowIndex = 1;
    int startColIndex = 0;
    ExcelReader excelReader = new ExcelReader(excelFileLocation, sheetName);
    int totalRow = excelReader.getTotalRow();
    int totalCol = excelReader.getTotalColumn();

    Object[][] loginData = new Object[totalRow - startRowIndex][totalCol - startColIndex];
    for(int startRow = startRowIndex; startRow < totalRow; startRow++)
    {
      for(int startCol = startColIndex; startCol < totalCol; startCol++){
        loginData[startRow - startRowIndex][startCol] = excelReader.getCellValue(startRow, startCol);
      }
    }
    return loginData;
  }
}
