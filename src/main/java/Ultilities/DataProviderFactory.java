package Ultilities;

import java.io.File;
import org.testng.annotations.DataProvider;

public class DataProviderFactory {
  public Object[][] createObjectData(String sheetName, File excelFileLocation){
    int startRowIndex = 1;
    int startColIndex = 0;

    ExcelReader excelReader = new ExcelReader(excelFileLocation, sheetName);
    int totalRow = excelReader.getTotalRow();
    int totalCol = excelReader.getTotalColumn();

    Object[][] data = new Object[totalRow - startRowIndex][totalCol - startColIndex];
    for(int startRow = startRowIndex; startRow < totalRow; startRow++)
    {
      for(int startCol = startColIndex; startCol < totalCol; startCol++){
        data[startRow - startRowIndex][startCol] = excelReader.getCellValue(startRow, startCol);
      }
    }
    return data;
  }

  @DataProvider
  public Object[][] PassLoginData() {
    File excelFileLocation = new File(System.getProperty("user.dir") + "/src/main/dataProviderFiles/" + "LoginData.xlsx");
    String sheetName = "Sheet1";
    Object[][] LoginData = createObjectData(sheetName, excelFileLocation);
    return LoginData;
  }

  @DataProvider
  public Object[][] FailLoginData() {
    File excelFileLocation = new File(System.getProperty("user.dir") + "/src/main/dataProviderFiles/" + "LoginData.xlsx");
    String sheetName = "Sheet2";
    Object[][] LoginData = createObjectData(sheetName, excelFileLocation);
    return LoginData;
  }



}
