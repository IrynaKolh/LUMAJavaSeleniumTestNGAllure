package com.luma.base;

import com.luma.utils.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.*;
import org.testng.annotations.*;

public abstract class BaseTest {

  private WebDriver driver;
//  private final String browser = "chrome";
//  private final String browser = "firefox";

  @BeforeSuite
  public void setupWebDriverManager() {

    WebDriverManager.chromedriver().setup();
    WebDriverManager.firefoxdriver().setup();
//    WebDriverManager.edgedriver().setup();
//    WebDriverManager.operadriver().setup();
//    WebDriverManager.chromiumdriver().setup();
//    WebDriverManager.iedriver().setup();
  }

  @Parameters("browser")
  @BeforeMethod(alwaysRun = true)
  protected void setupDriver(@Optional("chrome") String browser, ITestResult result) {
    Reporter.log("___________________________________________________________________________", true);
    Reporter.log("RUN " + result.getMethod().getMethodName(), true);
    this.driver = DriverUtils.createDriver(browser, this.driver);
    if (getDriver() == null) {
      Reporter.log("ERROR: Unknown parameter 'browser' - '" + browser + "'.", true);
      System.exit(1);
    }

    Reporter.log("INFO: " + browser.toUpperCase() + " driver created", true);

//    if(this.browser.equals("chrome")) {
//      this.driver = DriverUtils.createChromeDriver(getDriver());
//      Reporter.log("INFO: Chrome browser");
//    } else {
//      Reporter.log("ERROR: Unknown parameter 'browser' - '"+ browser +"'.", true);
//      System.exit(1);
//    }
  }

  @Parameters("browser")
  @AfterMethod(alwaysRun = true)
  protected void teardown(@Optional("chrome") String browser, ITestResult result) {
    Reporter.log("STOP " + result.getMethod().getMethodName() + ": " + ReportUtils.getTestStatus(result), true);
    if (this.driver != null) {
      driver.quit();
      Reporter.log("INFO: " + browser.toUpperCase() + " driver closed.", true);
      this.driver = null;
    } else {
      Reporter.log("INFO: " + browser.toUpperCase() + " driver is null.", true);
    }
  }

  public WebDriver getDriver() {
    return this.driver;
  }
}
