package org.techmeskills.aqa5.auf.steps;

import io.qameta.allure.Step;
import org.techmeskills.aqa5.auf.baseEntity.BaseStep;
import org.techmeskills.aqa5.auf.core.BrowsersService;
import org.techmeskills.aqa5.auf.models.UserLombok;
import org.techmeskills.aqa5.auf.pages.LoginPage;

public class LoginStepLombok extends BaseStep {

    public LoginStepLombok(BrowsersService browsersService) {
        super(browsersService);
    }

    @Step
    public void login(UserLombok userLombok) {
        LoginPage loginPage = new LoginPage(browsersService);

        loginPage.emailField.sendKeys(userLombok.getUsername());
        loginPage.passwordField.sendKeys(userLombok.getPassword());
        loginPage.loginButton.click();
    }
}
