package com.example.decorator;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WaitDecorator extends WebElementDecoratorBase {
  private WebDriver driver;
  private static final Logger log = LoggerFactory.getLogger(WaitDecorator.class);
  private WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

  public WaitDecorator(WebElementDecorator decoratedElement, WebDriver driver) {
    super(decoratedElement);
    this.driver = driver;
  }

  @Override
  public void click(WebElement element) {
    log.debug("Waiting for element to be visible: {}", element);
    wait.until(ExpectedConditions.visibilityOf(element));
    super.click(element);
  }

  @Override
  public void sendKeys(WebElement element, String text) {
    log.debug("Waiting for element to be visible: {}", element);
    wait.until(ExpectedConditions.visibilityOf(element));
    super.sendKeys(element, text);
  }
}
