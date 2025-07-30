package com.example;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.support.decorators.Decorated;
import org.openqa.selenium.support.decorators.DefaultDecorated;
import org.openqa.selenium.support.decorators.WebDriverDecorator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingDecorator extends WebDriverDecorator<WebDriver> {
  // Logger logger = LoggerFactory.getLogger(Thread.currentThread().getName());
  //
  // @Override
  // public void beforeCall(Decorated<?> target, Method method, Object[] args) {
  //   // logger.debug("before {}.{}({})", target, method, args);
  // }
  //
  // @Override
  // public Decorated<WebElement> createDecorated(WebElement original) {
  //   return new DefaultDecorated<>(original, this) {
  //     @Override
  //     public void beforeCall(Method method, Object[] args) {
  //       String methodName = method.getName();
  //       logger.debug("call {}", methodName);
  //     }
  //   };
  // }
  //
  // @Override
  // public void afterCall(Decorated<?> target, Method method, Object[] args, Object res) {
  //   // logger.debug("after {}.{}({})", target, method, args);
  // }
  //
}
