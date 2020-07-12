package org.techmeskills.aqa5.auf.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.techmeskills.aqa5.auf.baseEntity.BasePageFactory;
import org.techmeskills.aqa5.auf.core.BrowsersService;

public class DashboardPage extends BasePageFactory {

    @FindBy(id = "sidebar-projects-add")
    public WebElement addProjectButton;


    public DashboardPage(BrowsersService browsersService) {
        super(browsersService, false);
    }

    @Override
    protected void openPage() {

    }

    public boolean isPageOpened() {
        return browsersService.getDriver().getTitle().equalsIgnoreCase("All Projects - TestRail");
    }

    public AddProjectPage clickAddProjectButton() {
        addProjectButton.click();
        return new AddProjectPage(browsersService);
    }
}
