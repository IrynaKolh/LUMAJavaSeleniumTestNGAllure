package com.luma.test;

import com.luma.base.BaseTest;
import com.luma.data.TestData;
import com.luma.model.HomePage;
import com.luma.model.ProductPage;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductPageTest extends BaseTest {
  @Test(
      testName = "PRODUCT | Product Details",
      description = "TC-03 Verify Product Details on Product Page",
      groups = {"regression"}
  )
  @Story("Product Details")
  @Severity(SeverityLevel.NORMAL)
  @Description("To verify that the product page displays the correct product name and breadcrumb menu text " +
      "for the 'Driven Backpack'.")
  @Link(TestData.DRIVEN_BACKPACK_PRODUCT_URL)
  public void testProduct() {
    Allure.step("Go to base url");
    getDriver().get(TestData.BASE_URL);

    ProductPage productPage = new HomePage(getDriver())
        .clickGearTopMenu()
        .clickBagsSideMenu()
        .clickProductImg(TestData.DRIVEN_BACKPACK_PRODUCT_NAME);

    final String actualProductName = productPage.getProductName();
    final String breadcrumbsMenuText = productPage.getBreadcrumbsMenuText();

    Allure.step(
        "Verify actual '" + actualProductName + "' equals to '" + TestData.DRIVEN_BACKPACK_PRODUCT_NAME + "'"
    );
    Assert.assertEquals(actualProductName, TestData.DRIVEN_BACKPACK_PRODUCT_NAME);
    Allure.step(
        "Verify actual '" + breadcrumbsMenuText + "' equals to '" + TestData.DRIVEN_BACKPACK_PRODUCT_PAGE_BREADCRUMBS_MENU + "'"
    );
    Assert.assertEquals(breadcrumbsMenuText, TestData.DRIVEN_BACKPACK_PRODUCT_PAGE_BREADCRUMBS_MENU);
  }
}
