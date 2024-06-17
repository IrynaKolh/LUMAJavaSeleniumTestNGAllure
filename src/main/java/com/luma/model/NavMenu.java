package com.luma.model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import io.qameta.allure.Step;

abstract class NavMenu extends BasePage {

  @FindBy(linkText = "Gear")
  private WebElement gearTopMenu;

  protected NavMenu(WebDriver driver) {
    super(driver);
  }

  @Step("Click Gear Top Menu.")
  public GearPage clickGearTopMenu() {
    gearTopMenu.click();

    return new GearPage(getDriver());
  }
}
