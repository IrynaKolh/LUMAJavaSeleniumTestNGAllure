package com.luma.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chromium.ChromiumOptions;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Map;

public class DriverUtils {

  private static final ChromeOptions chromeOptions;
  private static final ChromiumOptions<ChromeOptions> chromiumOptions;
  private static final FirefoxOptions firefoxOptions;

  static  {
    chromeOptions = new ChromeOptions();
    chromeOptions.addArguments("--incognito");
    chromeOptions.addArguments("--headless");
    chromeOptions.addArguments("--window-size=1920,1080");
    chromeOptions.addArguments("--disable-gpu");
    chromeOptions.addArguments("--no-sandbox");
    chromeOptions.addArguments("--disable-dev-shm-usage");
    chromeOptions.addArguments("--disable-web-security");
    chromeOptions.addArguments("--allow-running-insecure-content");
    chromeOptions.addArguments("--ignore-certificate-errors");

    firefoxOptions = new FirefoxOptions();
    firefoxOptions.addArguments("--incognito");
    firefoxOptions.addArguments("--headless");
    firefoxOptions.addArguments("--window-size=1920,1080");
//    firefoxOptions.addArguments("--disable-gpu");
//    firefoxOptions.addArguments("--no-sandbox");
//    firefoxOptions.addArguments("--disable-dev-shm-usage");
//    firefoxOptions.addArguments("--disable-web-security");
//    firefoxOptions.addArguments("--allow-running-insecure-content");
//    firefoxOptions.addArguments("--ignore-certificate-errors");

    chromiumOptions = chromeOptions;

  }

  private static WebDriver createChromeDriver(WebDriver driver) {
    if (driver != null) {
      driver.quit();
    }

    ChromeDriver chromeDriver = new ChromeDriver(chromeOptions);
    chromeDriver.executeCdpCommand("Network.enable", Map.of());
    chromeDriver.executeCdpCommand("Network.setExtraHTTPHeaders", Map.of("headers", Map.of("accept-language", "en-US,en;q=0.9")));

    return chromeDriver;
  }

//  private static WebDriver createChromiumDriver(WebDriver driver) {
//    if (driver != null) {
//      driver.quit();
//    }
//
//    ChromiumDriver chromiumDriver = new ChromiumDriver(chromiumOptions);
//    chromiumDriver.executeCdpCommand("Network.enable", Map.of());
//    chromiumDriver.executeCdpCommand("Network.setExtraHTTPHeaders", Map.of("headers", Map.of("accept-language", "en-US,en;q=0.9")));
//
//    return chromiumDriver;
//  }

  private static WebDriver createFirefoxDriver(WebDriver driver) {
    if (driver != null) {
      driver.quit();
    }

    FirefoxDriver firefoxDriver = new FirefoxDriver(firefoxOptions);
//    firefoxDriver.executeCdpCommand("Network.enable", Map.of());
//    firefoxDriver.executeCdpCommand("Network.setExtraHTTPHeaders", Map.of("headers", Map.of("accept-language", "en-US,en;q=0.9")));

    return firefoxDriver;
  }

  public static WebDriver createDriver(String browser, WebDriver driver) {
    switch (browser) {
      case "chrome" -> {
        return createChromeDriver(driver);
      }
      case "firefox" -> {
        return createFirefoxDriver(driver);
      }
      default -> {
        return null;
      }
    }

//    if(browser.equals("chrome")) {
//      driver = DriverUtils.createChromeDriver(driver);
//      return driver;
//    } else {
//      return null;
//    }
  }

}
