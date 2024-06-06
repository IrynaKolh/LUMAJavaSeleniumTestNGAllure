package com.luma.test;

import com.luma.base.BaseTest;
import com.luma.data.*;
import io.qameta.allure.*;
import org.openqa.selenium.*;
import org.testng.*;
import org.testng.annotations.*;

public class NavigationTest extends BaseTest {

  @Test(description = "TC-01 Open Base URL")
  @Story("Navigation")
  @Severity(SeverityLevel.BLOCKER)
  @Description("TC-01 Open Base URL")
  @Link(TestData.BASE_URL)
  public void testOpenBaseURL() {
    Allure.step("Setup expected results");
    final String expectedResult = TestData.BASE_URL + "/";
    final String expectedTitle = TestData.TITLE;

    Allure.step("Go to base url");
    getDriver().get(TestData.BASE_URL);
    Allure.step("Collect url and title");
    final String actualResult = getDriver().getCurrentUrl();
    final String actualTitle = getDriver().getTitle();

    Allure.step("Verify actualURL as expectedURL");
    Assert.assertEquals(actualResult, expectedResult);
    Allure.step("Verify actualTitle as expectedTitle");
    Assert.assertEquals(actualTitle, expectedTitle);
  }

  @Test(dataProvider = "naviigationData", dataProviderClass = TestData.class)
  @Story("Navigation Menu")
  @Severity(SeverityLevel.CRITICAL)
  @Description("TC-02 Navigate to Menu Links" )
  public void testNavigationMenu(String baseUrl, By locator, String expectedUrl, String expectedTitle) {

    Allure.step("Go to base url");
    getDriver().get(baseUrl);
    Allure.step("Go to " + expectedTitle);
    getDriver().findElement(locator).click();

    Allure.step("Collect url and title");
    final String actualUrl = getDriver().getCurrentUrl();
    final String actualTitle = getDriver().getTitle();

    Allure.step("Verify actualURL as expectedURL");
    Assert.assertEquals(actualUrl, expectedUrl);

    Allure.step("Verify actualTitle as expectedTitle");
    Assert.assertEquals(actualTitle, expectedTitle);
  }
}
