package gm.taltech.ee.selenium;

import gm.taltech.ee.selenium.common.SeleniumTest;
import org.testng.annotations.Test;
import taltech.ee.pages.DragAndDropPage;
import taltech.ee.pages.FormAuthenticationPage;
import taltech.ee.pages.MultipleWindows;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SeleniumYou extends SeleniumTest {

    @Test
    public void should_not_login_with_invalid_login() {
        FormAuthenticationPage formAuthenticationPage = homePage.goToAuthenticationPage();
        formAuthenticationPage.submitForm("user", "user");

        assertThat(formAuthenticationPage.isUsernameInvalidMessageDisplayed(), is(true));

    }

    @Test
    public void should_not_login_with_invalid_password() {
        FormAuthenticationPage formAuthenticationPage = homePage.goToAuthenticationPage();
        formAuthenticationPage.submitForm("tomsmith", "user");

        assertThat(formAuthenticationPage.isPasswordInvalidMessageDisplayed(), is(true));
    }

    @Test
    public void should_login_then_logout() {
        FormAuthenticationPage formAuthenticationPage = homePage.goToAuthenticationPage();
        formAuthenticationPage.submitForm("tomsmith", "SuperSecretPassword!");
        assertThat(formAuthenticationPage.isSuccessNotificationDisplayed(), is(true));

        formAuthenticationPage.clickLogout();
        assertThat(formAuthenticationPage.isSuccessfullyLoggedOutMessageDisplayed(), is(true));
    }

    @Test
    public void should_change_location_of_blocks_after_drag_and_drop_to_BA() {
        DragAndDropPage dragAndDropPage = homePage.clickDragAndDropLink();
        assertThat(dragAndDropPage.isTheFirstElementsHeaderText("A"), is(true));
        dragAndDropPage.dragAonTopOfB();
        assertThat(dragAndDropPage.isTheFirstElementsHeaderText("B"), is(true));
    }

    @Test
    public void should_not_change_location_of_blocks_after_drag_and_drop_to_not_B() {
        DragAndDropPage dragAndDropPage = homePage.clickDragAndDropLink();
        assertThat(dragAndDropPage.isTheFirstElementsHeaderText("A"), is(true));

        dragAndDropPage.dragAonTopOfHeading();
        assertThat(dragAndDropPage.isTheFirstElementsHeaderText("A"), is(true));


    }

    @Test
    public void should_see_text_new_window_after_clicking_the_link_click_here() {
        MultipleWindows multipleWindows = homePage.clickMultipleWindowsLink();
        multipleWindows.clickClickHereButton();
        assertThat(multipleWindows.isNewWindowTextAvailable(), is(true));
    }
}
