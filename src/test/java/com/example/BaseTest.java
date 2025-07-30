package com.example;

import java.util.logging.Logger;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.example.pages.BasePage;
import com.example.utils.LoggerConfig;

public class BaseTest {
  protected WebDriver driver;
  protected Logger logger = Logger.getLogger(this.getClass().getName());
  private Dimension targetSize = new Dimension(1920, 1080);

  @BeforeClass
  public void setUp() {
    // Logger  setup
    LoggerConfig.setup();

    driver = new ChromeDriver();
    driver.manage().window().setSize(targetSize);

    String url = "https://www.saucedemo.com/";
    driver.get(url);
  }

  @AfterClass
  public void tearDown() {
    driver.quit();
  }
}
