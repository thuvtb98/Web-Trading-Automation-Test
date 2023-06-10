package Tests;

import Driver.webDriver;
import Ultilities.URL;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;

public class Login {
  @Test
  public void LoginWithCorrectCredential(){
    WebDriver driver = webDriver.getChromeDriver();
    String TestUrl = URL.currentTestUrl("LOGIN_PAGE");
    driver.get(TestUrl);

    //debug only
    try {
      Thread.sleep(2000);
    } catch (Exception ignore) {
    }

    driver.quit();
  }
}
