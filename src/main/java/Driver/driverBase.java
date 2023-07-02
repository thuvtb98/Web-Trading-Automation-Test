package Driver;

import io.qameta.allure.Allure;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class driverBase {
  // create synchronized driver list (trong môi trường đa luồng, trong 1 thời điểm chỉ có 1 luồng
  // được truy cập điểm dữ liệu)
  private static List<driverFactory> webDriverThreadPool =
      Collections.synchronizedList(new ArrayList<driverFactory>());
  // cho phép tạo dữ liệu mà chỉ được read/write bởi 1 luồng cụ thể
  private static ThreadLocal<driverFactory> driverThread;

  @BeforeSuite(alwaysRun = true)
  public static void initWebDriverObject() {
    driverThread =
        ThreadLocal.withInitial(
            () -> {
              driverFactory webDriverThread = new driverFactory();
              webDriverThreadPool.add(webDriverThread);
              return webDriverThread;
            });
  }

  public static WebDriver getChromeDriverInstance() {
    return driverThread.get().getChromeDriver();
  }

  @AfterSuite
  public void quitDriver() {
    for (driverFactory driver : webDriverThreadPool) {
      driver.quitDriver();
    }
  }

  @AfterMethod(alwaysRun = true)
  public void AfterMethods(ITestResult result) {
    getChromeDriverInstance().manage().deleteAllCookies();

    if (result.getStatus() == ITestResult.FAILURE) {
      // Get the test method name
      String methodName = result.getName();
      Calendar calendar = new GregorianCalendar();
      int y = calendar.get(calendar.YEAR);
      int m = calendar.get(calendar.MONTH);
      int d = calendar.get(calendar.DATE);
      int h = calendar.get(calendar.HOUR);
      int min = calendar.get(calendar.MINUTE);
      int sec = calendar.get(calendar.SECOND);

      // Declare file location
      String fileLocation = System.getProperty("user.dir") + "/screenshots/"+ methodName + "-"+ d + "-"+ m + "-"+ y +"-"+ h +"'"+ min +"'"+ sec + ".png";

      // Save screenshot to the system
      // 1. Convert webdriver object to TakeScreenshot
      // 2. Call getScreenshotAs method to create image file
      File screenshot =
          ((TakesScreenshot) getChromeDriverInstance()).getScreenshotAs(OutputType.FILE);
      try {
        // Move image file to new destination
        FileUtils.copyFile(screenshot, new File(fileLocation));
        // FileInputStream is used to read file, then put it into allure report
                try(FileInputStream is = new FileInputStream(fileLocation)){
                  Allure.addAttachment(methodName, is);
                }
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }
}
