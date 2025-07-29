package com.example;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AppTest {

   WebDriver driver;

   @BeforeClass
   public void setUp() {
      driver = new ChromeDriver();
      driver.manage().window().setSize(new Dimension(1920, 1080));
      driver.get("https://www.saucedemo.com/");
   }

   @AfterClass
   public void tearDown() {
      driver.quit();
   }

   @Test
   public void testGetTitle() {
      String title = driver.getTitle();
      Assert.assertEquals(title, "Swag Labs");
      System.out.println(title + " has the same title");
   }
}
