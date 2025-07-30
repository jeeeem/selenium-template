package com.example;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
  private static final Logger log = LoggerFactory.getLogger(BaseTest.class);
  protected WebDriver driver;
  private Dimension targetSize = new Dimension(1920, 1080);
  private String url = "https://www.saucedemo.com/";

  @BeforeClass
  public void setUp() {
    driver = new ChromeDriver();
    driver.manage().window().setSize(targetSize);

    log.info("Navigating to: " + url);
    driver.get(url);
  }

  @AfterClass
  public void tearDown() {
    driver.quit();
  }
}
