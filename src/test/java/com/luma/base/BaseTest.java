package com.luma.base;

import io.github.bonigarcia.wdm.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.testng.annotations.*;

public abstract class BaseTest {

  private WebDriver driver;

  @BeforeMethod
  protected void setupClass() {
    WebDriverManager.chromedriver().setup();
    createChromeDriver();
  }

  @AfterMethod
  protected void teardown() {
    if (this.driver != null) {
      driver.quit();
      this.driver = null;
    }
  }

  private void createChromeDriver() {
    if (this.driver == null) {
      this.driver = new ChromeDriver();
    }
  }

  public WebDriver getDriver() {
    return this.driver;
  }


}
