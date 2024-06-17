package com.luma.base;

import com.luma.utils.DriverUtils;
import com.luma.utils.ReportUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

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
    Allure.step("Create Driver");
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
      Allure.step("Quit Driver");
      driver.quit();
      Reporter.log("INFO: " + browser.toUpperCase() + " driver closed.", true);
      this.driver = null;
    } else {
      Reporter.log("INFO: " + browser.toUpperCase() + " driver is null.", true);
    }
  }

  protected WebDriver getDriver() {
    return this.driver;
  }
}
