package com.example.listeners;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Field;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.example.utils.AllureUtils;

import io.qameta.allure.Allure;

public class ScreenshotOnFailureListener implements ITestListener {
  private static final Logger log = LoggerFactory.getLogger(ScreenshotOnFailureListener.class);

  @Override
  public void onTestFailure(ITestResult result) {
    Object currentClass = result.getInstance();
    try {
      Field driverField = getFieldIncludingSuperclasses(currentClass.getClass(), "driver");
      driverField.setAccessible(true);
      WebDriver driver = (WebDriver) driverField.get(currentClass);
      AllureUtils.takeScreenshot(driver, "Failure Screenshot");
    } catch (Exception e) {
      log.error("Failed to capture screenshot on failure", e);
    }

    // Log test failure with stack trace
    Throwable throwable = result.getThrowable();
    if (throwable != null) {
      log.error("Test '{}' failed with exception", result.getName(), throwable);
      StringWriter sw = new StringWriter();
      throwable.printStackTrace(new PrintWriter(sw));
      Allure.addAttachment("Stacktrace", sw.toString());
    }
  }

  private Field getFieldIncludingSuperclasses(Class<?> clazz, String fieldName) throws NoSuchFieldException {
    for (Class<?> c = clazz; c != null; c = c.getSuperclass()) {
      try {
        return c.getDeclaredField(fieldName);
      } catch (NoSuchFieldException ignored) {
      }
    }
    throw new NoSuchFieldException("Field '" + fieldName + "' not found in class hierarchy");
  }

}
