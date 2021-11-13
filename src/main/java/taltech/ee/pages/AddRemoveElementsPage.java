package taltech.ee.pages;

import org.openqa.selenium.*;

public class AddRemoveElementsPage extends Page {

    private final By mainTitle = By.tagName("h3");
    JavascriptExecutor js = (JavascriptExecutor) driver;

    public AddRemoveElementsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isAt() {
        return driver.findElement(mainTitle).getText().equals("Add/Remove Elements");
    }
    public void clickAddElementButton() {
        js.executeScript("addElement()");
    }

    public void clickDeleteButton() {
        try {

            js.executeScript("deleteElement()");
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }

    }

    public int numberOfExistingElements() {
        String string = driver.findElements(By.id("elements")).get(0).getText();

        if (!string.isEmpty() || !string.isBlank()) {
            int index = 0;
            int count = 0;
            while (true) {
                index = string.indexOf("Delete", index);
                if (index != -1) {
                    count++;
                    index += "Delete".length();
                } else {
                    break;
                }
            }
            return count;
        }
        return 0;
    }


}
