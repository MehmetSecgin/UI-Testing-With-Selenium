package taltech.ee.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.util.Locale;

public class KeyPressesPage extends Page {

    private final By mainTitle = By.tagName("h3");
    private final By input = By.id("target");
    private final By resultString = By.id("result");

    public KeyPressesPage(WebDriver driver) {
        super(driver);
    }

    public boolean isAt() {
        return driver.findElement(mainTitle).getText().equals("Key Presses");
    }

    public void EnterKey(String ch){
        driver.findElement(input).sendKeys(ch);
    }

    public void EnterSpecialKey(Keys key){
        driver.findElement(input).sendKeys(key);
    }

    public boolean IsInputCorrect(String input){
        return driver.findElement(resultString).getText().substring(13).equals(input.toUpperCase(Locale.ROOT));
    }

}
