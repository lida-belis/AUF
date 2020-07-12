package org.techmeskills.aqa5.auf.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.techmeskills.aqa5.auf.baseEntity.BasePageFactory;
import org.techmeskills.aqa5.auf.core.BrowsersService;

public class LoginPage extends BasePageFactory {
    private String URL = "https://aqa5master.testrail.io/";

    @FindBy(id = "button_primary")
    public WebElement pageIdentifier;

    @FindBy(id = "name")
    public WebElement emailField;

    @FindBy(id = "password")
    public WebElement passwordField;

    @FindBy(id = "button_primary")
    public WebElement loginButton;

    public LoginPage(BrowsersService browsersService) {
        super(browsersService, false);
    }

    @Override
    protected void openPage() {

    }

    @Override
    public boolean isPageOpened() {
        return pageIdentifier.isDisplayed();
    }

    public DashboardPage clickLoginButton() {
        loginButton.click();
        return new DashboardPage(browsersService);
    }
}
