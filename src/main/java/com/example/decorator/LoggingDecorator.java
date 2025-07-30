package com.example.decorator;

import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingDecorator extends WebElementDecoratorBase {
  private static final Logger log = LoggerFactory.getLogger(LoggingDecorator.class);

  public LoggingDecorator(WebElementDecorator decoratedElement) {
    super(decoratedElement);
  }

  @Override
  public void click(WebElement element) {
    log.info("Clicking element to: {}",  element);
    super.click(element);
  }

  @Override
  public void sendKeys(WebElement element, String text) {
    log.info("Sending keys '{}' to: {}", element, text);
    super.sendKeys(element, text);
  }
}
