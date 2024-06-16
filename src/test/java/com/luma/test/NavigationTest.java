package com.luma.test;

import com.luma.base.BaseTest;
import com.luma.data.TestData;
import io.qameta.allure.Description;
import io.qameta.allure.Link;
import io.qameta.allure.Allure;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Severity;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NavigationTest extends BaseTest {

  @Test(
    description = "TC-01 Open Base URL",
    groups = {"Smoke", "Regretion"},
    testName = "NAVIGATION | Navigate to base URL"
  )
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

  @Test(
    description = "TC-02 Top Menu Navigation",
    dataProvider = "navigationData",
    dataProviderClass = TestData.class,
    groups = {"Smoke", "Regretion"},
    testName = "NAVIGATION | Navigate to top menus"
  )
  @Story("Navigation Menu")
  @Severity(SeverityLevel.CRITICAL)
  @Description("To verify that the top menu navigation on the website functions correctly by ensuring that clicking on menu items directs the user to the expected URL with the expected title.")
  @Link(TestData.BASE_URL)
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
