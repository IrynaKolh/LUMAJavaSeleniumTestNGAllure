package com.luma.data;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;

public class TestData {
  public static  final String BASE_URL = "https://magento.softwaretestingboard.com";
  public static  final String TITLE = "Home Page";

  public static class NavMenuData {
    //  NavBar Menu
    public static final String WHATS_NEW_TITLE = "What's New";
    public static final String WHATS_NEW_URL = BASE_URL + "/what-is-new.html";
    public static final By WHATS_NEW_MENU = By.xpath("//nav//span[text()=\"What's New\"]");

    public static final String WOMEN_TITLE = "Women";
    public static final String WOMEN_URL = BASE_URL + "/women.html";
    public static final By WOMEN_MENU = By.xpath("//nav//span[text()='Women']");

    public static final String MEN_TITLE = "Men";
    public static final String MEN_URL = BASE_URL + "/men.html";
    public static final By MEN_MENU = By.xpath("//nav//span[text()='Men']");

    public static final String GEAR_TITLE = "Gear";
    public static final String GEAR_URL = BASE_URL + "/gear.html";
    public static final By GEAR_MENU = By.xpath("//nav//span[text()='Gear']");

    public static final String SALE_TITLE = "Sale";
    public static final String SALE_URL = BASE_URL + "/sale.html";
    public static final By SALE_MENU = By.xpath("//nav//span[text()='Sale']");
  }

  @DataProvider(name = "navigationData")
  public static Object[][] getNavMenuData() {
    return new Object [][] {
      {BASE_URL, NavMenuData.WHATS_NEW_MENU, NavMenuData.WHATS_NEW_URL, NavMenuData.WHATS_NEW_TITLE},
      {BASE_URL, NavMenuData.WOMEN_MENU, NavMenuData.WOMEN_URL, NavMenuData.WOMEN_TITLE},
      {BASE_URL, NavMenuData.MEN_MENU, NavMenuData.MEN_URL, NavMenuData.MEN_TITLE},
      {BASE_URL, NavMenuData.GEAR_MENU, NavMenuData.GEAR_URL, NavMenuData.GEAR_TITLE},
      {BASE_URL, NavMenuData.SALE_MENU, NavMenuData.SALE_URL, NavMenuData.SALE_TITLE}
    };
  }
}
