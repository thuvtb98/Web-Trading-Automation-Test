package Ultilities;

import java.io.File;
import java.io.FileInputStream;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelReader{
  private File excelFileLocation;
  private String sheetName;
  private FileInputStream fis;
  private Workbook workbook;
  private Sheet sheet;
  private int totalRow;
  private int totalColumn;

  public ExcelReader(File excelFileLocation, String sheetName){
    this.excelFileLocation = excelFileLocation;
    this.sheetName = sheetName;

    try{
      fis = new FileInputStream(excelFileLocation);
      workbook = WorkbookFactory.create(fis);
      sheet = workbook.getSheet(this.sheetName);
      totalRow = sheet.getPhysicalNumberOfRows();
      totalColumn = sheet.getRow(0).getPhysicalNumberOfCells();
      fis.close();
    }catch (Exception e){
      e.printStackTrace();
    }
  }

  public String getCellValue(int rowNo, int ColNo){
    Row row = sheet.getRow(rowNo);
    Cell cell = row.getCell(ColNo);

    if(cell == null){
      return "";
    }
    switch (cell.getCellType()) {
      case STRING:
        return cell.getStringCellValue();
      case NUMERIC:
        NumberFormat numberFormat = new DecimalFormat("#.####");
        return String.valueOf(numberFormat.format(cell.getNumericCellValue()));
      case BOOLEAN:
        return String.valueOf(cell.getBooleanCellValue());
      case FORMULA:
        return cell.getCellFormula();
      default:
        return "";
    }
  }

  public int getTotalRow(){ return this.totalRow;};

  public int getTotalColumn(){ return this.totalColumn;};

}
