package org.techmeskills.aqa5.auf.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.techmeskills.aqa5.auf.baseEntity.BasePage;
import org.techmeskills.aqa5.auf.core.BrowsersService;
import org.techmeskills.aqa5.auf.elements.UIElement;

public class ProjectOverviewPage extends BasePage {

    @FindBy(className = "header-menu-item-selected")
    public WebElement headMenuItemSelected;

    public ProjectOverviewPage(BrowsersService browsersService) {
        super(browsersService, false);
    }

    @Override
    protected void openPage() {

    }

    public boolean isPageOpened() {
        return new UIElement(browsersService, headMenuItemSelected).getText().equalsIgnoreCase("Overview");
    }
}
