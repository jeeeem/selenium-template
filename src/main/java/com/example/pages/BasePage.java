package com.example.pages;

import org.openqa.selenium.WebDriver;

import com.example.decorator.LoggingDecorator;
import com.example.decorator.WaitDecorator;
import com.example.decorator.WebElementActions;
import com.example.decorator.WebElementDecorator;

public abstract class BasePage {
  protected WebDriver driver;
  protected WebElementDecorator webElementAction;

  public BasePage(WebDriver driver) {
    this.driver = driver;
    this.webElementAction = new WaitDecorator(new LoggingDecorator(new WebElementActions()), driver);
  }

  public static void delay(int milliseconds) {
    // Testing Purposes
    try {
      Thread.sleep(milliseconds);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

}
