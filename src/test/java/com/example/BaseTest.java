package com.example;

import static org.assertj.core.api.Assertions.assertThat;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.apache.logging.log4j.ThreadContext;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.example.listeners.ScreenshotOnFailureListener;
import com.example.utils.AllureUtils;
import com.example.utils.LoggerConfig;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.testng.AllureTestNg;

@Listeners({ AllureTestNg.class, ScreenshotOnFailureListener.class })
public class BaseTest {
  private static final Logger log = LoggerFactory.getLogger(BaseTest.class);
  private String url = "https://www.saucedemo.com/";
  protected WebDriver driver;
  protected String logFileName;

  @BeforeClass
  public void setUp() {
    LoggerConfig.setup();
    WebDriverManager.chromedriver().setup();
    ChromeOptions options = new ChromeOptions();
    boolean isHeadless = Boolean.parseBoolean(System.getProperty("headless", "false"));
    if (isHeadless) {
      options.addArguments("--headless=new"); // use "--headless=new" for Chrome 109+, or "--headless"
      options.addArguments("--disable-gpu");
      options.addArguments("--window-size=1920,1080"); // useful for consistent screenshots
      options.addArguments("--no-sandbox"); // required in many CI/CD Linux environments
      options.addArguments("--disable-dev-shm-usage"); // fix shared memory issues
      options.addArguments("--disable-gpu"); // optional but common
      options.addArguments("--user-data-dir=/tmp/chrome-" + UUID.randomUUID()); // isolate profile
    }

    driver = new ChromeDriver(options);
    Allure.step("Navigate to saucedemo site", () -> {
      log.info("Navigating to: {}", url);
      driver.get(url);
      AllureUtils.takeScreenshot(driver);
    });
  }

  @BeforeMethod
  public void logSetup(ITestResult result) {
    String testName = result.getMethod().getMethodName();
    String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
    logFileName = testName + "_" + timestamp;

    // Set context value for Log4j
    ThreadContext.put("logFileName", logFileName);
    log.debug("Setting up log file: {}.log", logFileName);
  }

  @Test
  @Description("Verify Login title")
  public void verifyPage(){
    String title = driver.getTitle();
    assertThat(title)
        .as("Verify Page Title")
        .isEqualTo("Swag1 Labs");
  };

  @AfterMethod
  public void attachmentLog() {
    AllureUtils.attachLog(logFileName);

    // Remove context leaks for the next following tests
    ThreadContext.remove("logFileName");
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() {
    driver.quit();
  }
}
