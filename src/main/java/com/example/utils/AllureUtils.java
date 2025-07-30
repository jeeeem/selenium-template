package com.example.utils;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.qameta.allure.Allure;

public class AllureUtils {
  private static final Logger log = LoggerFactory.getLogger(AllureUtils.class);

  public static void takeScreenshot(WebDriver driver) {
    takeScreenshot(driver, "Screenshot");
  }

  public static void takeScreenshot(WebDriver driver, String stepName) {
    Allure.step(stepName, () -> {
      try {
        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment("Screenshot", new ByteArrayInputStream((screenshot)));
        log.debug("Screenshot captured and attached successfully in step: {}", stepName);
      } catch (Exception e) {
        log.error("Failed to capture screenshot: {}", e.getMessage());
      }
    });
  }

  public static void takeScreenshot(WebDriver driver, String stepName, String screenshotName) {
    Allure.step(stepName, () -> {
      try {
        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment(screenshotName, new ByteArrayInputStream((screenshot)));
        log.debug("Screenshot captured and attached successfully in step: {}", stepName);
      } catch (Exception e) {
        log.error("Failed to capture screenshot: {}", e.getMessage());
      }
    });
  }

  public static void attachLog(String logFileName) {
    String logPath = "target/logs/" + logFileName +  ".log";
    try (InputStream file = new FileInputStream(logPath)){
      Allure.addAttachment(logFileName, "text/plain", file, "log");
    } catch (Exception e) {
      log.error("Failed to attach log file: {}", e.getMessage());
    }
  }
}
