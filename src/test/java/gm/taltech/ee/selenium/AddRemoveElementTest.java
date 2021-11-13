package gm.taltech.ee.selenium;

import gm.taltech.ee.selenium.common.SeleniumTest;
import org.testng.annotations.Test;
import taltech.ee.pages.AddRemoveElementsPage;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddRemoveElementTest extends SeleniumTest {

    @Test
    public void goes_to_page() {
        AddRemoveElementsPage addRemoveElementsPage = homePage.goToAddRemoveElementsPage();
        assertThat(addRemoveElementsPage.isAt(), is(true));
    }

    @Test
    public void adds_a_new_element() {
        AddRemoveElementsPage addRemoveElementsPage = homePage.goToAddRemoveElementsPage();

        addRemoveElementsPage.clickAddElementButton();
        assertThat(addRemoveElementsPage.numberOfExistingElements(), is(1));

        addRemoveElementsPage.clickAddElementButton();
        assertThat(addRemoveElementsPage.numberOfExistingElements(), is(2));
    }

    @Test
    public void adds_2_and_deletes_1_element() {
        AddRemoveElementsPage addRemoveElementsPage = homePage.goToAddRemoveElementsPage();
        addRemoveElementsPage.clickAddElementButton();
        addRemoveElementsPage.clickAddElementButton();
        assertThat(addRemoveElementsPage.numberOfExistingElements(), is(2));
        addRemoveElementsPage.clickDeleteButton();
        assertThat(addRemoveElementsPage.numberOfExistingElements(), is(1));
    }

    @Test
    public void adds_1_and_tries_to_delete_2_elements_prints_stack_trace() {
        AddRemoveElementsPage addRemoveElementsPage = homePage.goToAddRemoveElementsPage();
        addRemoveElementsPage.clickDeleteButton();
        assertThat(addRemoveElementsPage.numberOfExistingElements(), is(0));
    }

}
