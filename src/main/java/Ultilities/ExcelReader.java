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
    String cellValue = "";
    CellType cellType = cell.getCellType();

    if(cellType.equals(CellType.STRING)) {
      cellValue = cell.getStringCellValue();
    }

    if(cellType.equals(CellType.NUMERIC)){
      NumberFormat numberFormat = new DecimalFormat("#.####");
      cellValue = String.valueOf(numberFormat.format(cell.getNumericCellValue()));
    }

    return cellValue;
  }

  public int getTotalRow(){ return this.totalRow;};

  public int getTotalColumn(){ return this.totalColumn;};

}
