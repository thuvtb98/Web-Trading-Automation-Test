package Driver;

import org.openqa.selenium.WebDriver;

public class driverFactory {

  private WebDriver driver;

  public WebDriver getChromeDriver(){
    if(driver == null){
      driver = webDriver.getChromeDriver();
    }
    return driver;
  }

  void quitDriver(){
    if(driver != null){
      driver.quit();
      driver = null;
    }
  }

}
