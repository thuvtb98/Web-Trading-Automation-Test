package Driver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class driverBase {
  //create synchronized driver list (trong môi trường đa luồng, trong 1 thời điểm chỉ có 1 luồng được truy cập điểm dữ liệu)
  private static List<driverFactory> webDriverThreadPool = Collections.synchronizedList(new ArrayList<driverFactory>());
  // cho phép tạo dữ liệu mà chỉ được read/write bởi 1 luồng cụ thể
  private static ThreadLocal<driverFactory> driverThread;

  @BeforeSuite(alwaysRun = true)
  public static void initWebDriverObject(){
      driverThread = ThreadLocal.withInitial(()->{
      driverFactory webDriverThread = new driverFactory();
      webDriverThreadPool.add(webDriverThread);
      return webDriverThread;
    });
  }

  public static WebDriver getChromeDriverInstance(){
    return driverThread.get().getChromeDriver();
  }

  @AfterSuite(alwaysRun = true)
  public void afterSuite(){
    for(driverFactory driver : webDriverThreadPool)
    {
      driver.quitDriver();
    }
  }
}
