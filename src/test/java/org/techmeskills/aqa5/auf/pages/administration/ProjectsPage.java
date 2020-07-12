package org.techmeskills.aqa5.auf.pages.administration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.techmeskills.aqa5.auf.baseEntity.BasePageFactory;
import org.techmeskills.aqa5.auf.core.BrowsersService;
import org.techmeskills.aqa5.auf.elements.UIElement;

public class ProjectsPage extends BasePageFactory {
    @FindBy(css = "#dialog-ident-deleteDialog input")
    public WebElement confirmationYesCheckbox;

    @FindBy(css = "#dialog-ident-deleteDialog .button-ok")
    public WebElement confirmationOkButton;

    @FindBy(className = "message-success")
    public WebElement messageSuccessText;

    public ProjectsPage(BrowsersService browsersService, boolean openPageByUrl) {
        super(browsersService, openPageByUrl);
    }

    @Override
    protected void openPage() {
        browsersService.getDriver().get(browsersService.getBaseUrl() + "index.php?/admin/projects/overview");
    }

    public boolean isPageOpened() {
        return browsersService.getDriver().getTitle().equalsIgnoreCase("Projects - TestRail");
    }

    public UIElement getProjectItemLink(String projectName) {
        return new UIElement(browsersService, By.linkText(projectName));
    }

    public UIElement getDeleteIcon(String projectName) {
        UIElement element = getProjectItemLink(projectName);
        UIElement parent = element.getParent().getParent();
        return parent.findElement(By.className("icon-small-delete"));
    }
}
