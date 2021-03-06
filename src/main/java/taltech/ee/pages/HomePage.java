package taltech.ee.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends Page {

    private final By mainTitle = By.tagName("h1");
    private final By formAuthenticationLink = By.linkText("Form Authentication");
    private final By dragAndDropLink = By.linkText("Drag and Drop");
    private final By multipleWindowsLink = By.linkText("Multiple Windows");
    private final By addRemoveElementsLink = By.linkText("Add/Remove Elements");
    private final By keyPressesLink = By.linkText("Key Presses");


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("https://the-internet.herokuapp.com/");
    }

    public boolean isAt() {

        return driver.findElement(mainTitle).getText().equals("Welcome to the-internet");

    }

    public FormAuthenticationPage goToAuthenticationPage() {
        driver.findElement(formAuthenticationLink).click();
        return new FormAuthenticationPage(driver);
    }

    public AddRemoveElementsPage goToAddRemoveElementsPage() {
        driver.findElement(addRemoveElementsLink).click();
        return new AddRemoveElementsPage(driver);
    }

    public KeyPressesPage goToKeyPressesPage() {
        driver.findElement(keyPressesLink).click();
        return new KeyPressesPage(driver);
    }

    public DragAndDropPage clickDragAndDropLink() {
        driver.findElement(dragAndDropLink).click();
        return new DragAndDropPage(driver);
    }

    public MultipleWindows clickMultipleWindowsLink() {
        driver.findElement(multipleWindowsLink).click();
        return new MultipleWindows(driver);
    }
}
