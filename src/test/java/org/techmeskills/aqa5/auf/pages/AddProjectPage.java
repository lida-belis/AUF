package org.techmeskills.aqa5.auf.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.techmeskills.aqa5.auf.baseEntity.BasePageFactory;
import org.techmeskills.aqa5.auf.core.BrowsersService;

public class AddProjectPage extends BasePageFactory {

    @FindBy(id = "accept")
    public WebElement pageIdentifier;

    @FindBy(id = "accept")
    public WebElement addProjectButton;

    @FindBy(id = "name")
    public WebElement nameField;

    @FindBy(id = "suite_mode_single")
    public WebElement suiteModeSingleOption;

    @FindBy(id = "suite_mode_single_baseline")
    public WebElement suiteModeSingleBaselineOption;

    @FindBy(id = "suite_mode_multi")
    public WebElement suiteModeMultiSelectorOption;

    public AddProjectPage(BrowsersService browsersService) {
        super(browsersService, false);
    }

    @Override
    protected void openPage() {

    }

    public boolean isPageOpened() {
        return pageIdentifier.isDisplayed();
    }
}
