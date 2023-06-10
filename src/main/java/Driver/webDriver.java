package Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class webDriver {

  public static WebDriver getChromeDriver() {
      WebDriver driver;
      String path = System.getProperty("user.dir");
      String chromePath = path.concat("/src/main/driverFiles/chromedriver.exe");

      System.setProperty("webdriver.chrome.driver", chromePath);
      System.setProperty("webdriver.http.factory", "jdk-http-client");

    return new ChromeDriver();
  }
}
