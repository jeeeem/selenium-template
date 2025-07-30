package com.example;

import org.testng.annotations.Test;

import com.example.pages.LoginPage;

public class LoginTest extends BaseTest {

  @Test
  public void testGetTitle() throws InterruptedException {
    LoginPage page = new LoginPage(driver);
    page.login();
  }
}
