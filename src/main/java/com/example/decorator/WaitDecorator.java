package com.example.decorator;

import java.time.Duration;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitDecorator extends WebElementDecoratorBase {
  private WebDriver driver;
  Logger log = Logger.getLogger(this.getClass().getName());
  private WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

  public WaitDecorator(WebElementDecorator decoratedElement, WebDriver driver) {
    super(decoratedElement);
    this.driver = driver;
  }

  @Override
  public void click(WebElement element) {
    log.info("Waiting for element to be visible: " + element);
    wait.until(ExpectedConditions.visibilityOf(element));
    super.click(element);
  }

  @Override
  public void sendKeys(WebElement element, String text) {
    log.info("Waiting for element to be visible: " + element);
    wait.until(ExpectedConditions.visibilityOf(element));
    super.sendKeys(element, text);
  }
}
