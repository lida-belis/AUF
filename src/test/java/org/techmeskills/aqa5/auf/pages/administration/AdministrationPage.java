package org.techmeskills.aqa5.auf.pages.administration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.techmeskills.aqa5.auf.baseEntity.BasePageFactory;
import org.techmeskills.aqa5.auf.core.BrowsersService;

public class AdministrationPage extends BasePageFactory {
    @FindBy(xpath = "//h1[. = 'Administration']")
    public WebElement pageIdentifier;

    @FindBy(xpath = "//div[@class = 'info-box-title']/a[. = 'Projects']")
    public WebElement projectsLink;

    public AdministrationPage(BrowsersService browsersService, boolean openPageByUrl) {
        super(browsersService, openPageByUrl);
    }

    @Override
    protected void openPage() {
        browsersService.getDriver().get(browsersService.getBaseUrl() + "index.php?/admin/overview");
    }

    public boolean isPageOpened() {
        return pageIdentifier.isDisplayed();
    }
}
