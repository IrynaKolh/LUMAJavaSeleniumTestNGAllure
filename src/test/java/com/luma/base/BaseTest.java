package com.luma.base;

import com.luma.utils.*;
import io.github.bonigarcia.wdm.*;
import org.openqa.selenium.*;
import org.testng.annotations.*;

public abstract class BaseTest {

  private WebDriver driver;

  @BeforeSuite
  public void setupWebDriverManager(){
    WebDriverManager.chromedriver().setup();
  }

  @BeforeMethod
  protected void setupDriver() {

    this.driver = DriverUtils.createChromeDriver(getDriver());
  }

  @AfterMethod
  protected void teardown() {
    if (this.driver != null) {
      driver.quit();
      this.driver = null;
    }
  }



  public WebDriver getDriver() {
    return this.driver;
  }


}
