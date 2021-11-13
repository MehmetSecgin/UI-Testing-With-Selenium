package gm.taltech.ee.selenium;

import gm.taltech.ee.selenium.common.SeleniumTest;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import taltech.ee.pages.KeyPressesPage;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class KeyPressesTest extends SeleniumTest {

    @Test
    public void goes_to_page() {
        KeyPressesPage keyPressesPage = homePage.goToKeyPressesPage();
        assertThat(keyPressesPage.isAt(), is(true));
    }

    @Test
    public void inputs_char_a(){
        KeyPressesPage keyPressesPage = homePage.goToKeyPressesPage();
        keyPressesPage.EnterKey("A");
        assertThat(keyPressesPage.IsInputCorrect("A"),is(true));
    }

    @Test
    public void inputs_special_key_shift(){
        KeyPressesPage keyPressesPage = homePage.goToKeyPressesPage();
        keyPressesPage.EnterSpecialKey(Keys.SHIFT);
        assertThat(keyPressesPage.IsInputCorrect("Shift"),is(true));
    }

    @Test
    public void inputs_special_key_backspace(){
        KeyPressesPage keyPressesPage = homePage.goToKeyPressesPage();
        keyPressesPage.EnterSpecialKey(Keys.BACK_SPACE);
        assertThat(keyPressesPage.IsInputCorrect("back_space"),is(true));
    }

}

