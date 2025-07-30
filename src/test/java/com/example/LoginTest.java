package com.example;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;

import com.example.pages.LoginPage;
import com.example.utils.AllureUtils;

import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class LoginTest extends BaseTest {

  @Test(dependsOnMethods = "verifyPage")
  @Description("Login with dependency")
  @Severity(SeverityLevel.NORMAL)
  public void loginWithDependency() throws InterruptedException {

    LoginPage page = new LoginPage(driver);

    Allure.step("Logging in credentials", () -> {
      page.login();
      AllureUtils.takeScreenshot(driver, "Filling credentials");
    });
  }

  @Test()
  @Description("Login Independent")
  @Severity(SeverityLevel.NORMAL)
  public void loginIndependent() throws InterruptedException {

    LoginPage page = new LoginPage(driver);

    Allure.step("Logging in credentials", () -> {
      page.login();
      AllureUtils.takeScreenshot(driver, "Filling credentials");
    });
  }
}
