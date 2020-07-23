package org.techmeskills.aqa5.auf.uiTests;

import org.openqa.selenium.*;
import org.techmeskills.aqa5.auf.baseEntity.BaseTest;
import org.techmeskills.aqa5.auf.models.User;
import org.techmeskills.aqa5.auf.models.UserLombok;
import org.techmeskills.aqa5.auf.pages.administration.ProjectsPage;
import org.techmeskills.aqa5.auf.steps.AdministrationStep;
import org.techmeskills.aqa5.auf.steps.LoginStep;
import org.techmeskills.aqa5.auf.steps.LoginStepLombok;
import org.techmeskills.aqa5.auf.steps.ProjectStep;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SmokeTest_Lombok extends BaseTest {
    @Test
    public void login() {
        UserLombok user = new UserLombok();
        user.setUsername("atrostyanko+master@gmail.com");
        user.setPassword("QqtRK9elseEfAk6ilYcJ");
        LoginStepLombok loginStepLombok = new LoginStepLombok(browsersService);
        loginStepLombok.login(user);
    }

    @Test(dependsOnMethods = "login")
    public void createProject() {
        ProjectStep projectStep = new ProjectStep(browsersService);
        projectStep.createNewProject("PR01", "Use a single repository for all cases (recommended)");

        Assert.assertTrue(browsersService.getDriver().getTitle().equalsIgnoreCase("PR01 - TestRail")
                || browsersService.getDriver().getTitle().equalsIgnoreCase("Projects - TestRail"));
    }

    @Test(dependsOnMethods = "createProject")
    public void deleteProject() {
        AdministrationStep administrationStep = new AdministrationStep(browsersService);
        administrationStep.deleteProject("PR01");

        ProjectsPage projectsPage = new ProjectsPage(browsersService, false);
        Assert.assertThrows(TimeoutException.class, () -> projectsPage.getProjectItemLink("PR01"));
    }
}