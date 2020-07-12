package org.techmeskills.aqa5.auf.steps;

import io.qameta.allure.Step;
import org.techmeskills.aqa5.auf.baseEntity.BaseStep;
import org.techmeskills.aqa5.auf.core.BrowsersService;
import org.techmeskills.aqa5.auf.elements.UIElement;
import org.techmeskills.aqa5.auf.pages.administration.AdministrationPage;
import org.techmeskills.aqa5.auf.pages.administration.ProjectsPage;

public class AdministrationStep extends BaseStep {

    public AdministrationStep(BrowsersService browsersService) {
        super(browsersService);
    }

    @Step
    public void deleteProject(String projectName) {
        AdministrationPage administrationPage = new AdministrationPage(browsersService, true);
        UIElement projectLink = administrationPage.getProjectsLink();

        ProjectsPage projectsPage = administrationPage.clickProjectLink();
        projectsPage.getDeleteIcon(projectName).click();
        projectsPage.confirmationYesCheckbox.click();
        projectsPage.confirmationOkButton.click();

        browsersService.getWaiters().waitForInvisibility(projectLink);
    }
}
