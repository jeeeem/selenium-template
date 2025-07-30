package com.example.decorator;

import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoggingDecorator extends WebElementDecoratorBase {
  Logger log = Logger.getLogger(this.getClass().getName());

  public LoggingDecorator(WebElementDecorator decoratedElement) {
    super(decoratedElement);
  }

  @Override
  public void click(WebElement element) {
    log.info("Clicking element to: " + element);
    super.click(element);
  }

  @Override
  public void sendKeys(WebElement element, String text) {
    log.info("Sending keys '"+text+ "' to: " + element);
    super.sendKeys(element, text);
  }
}
