package com.luma.model;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BreadcrumbsMenu {

  @FindBy(xpath = "//h1")
  private WebElement productName;

  protected ProductPage(WebDriver driver) {
    super(driver);
  }

  @Step("Collect Actual Product Name Text.")
  public String getProductName() {
    return productName.getText();
  }
}
