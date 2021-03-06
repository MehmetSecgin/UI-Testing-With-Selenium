package gm.taltech.ee.selenium.common;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import taltech.ee.pages.HomePage;

public abstract class SeleniumTest {

    protected WebDriver driver;
    protected HomePage homePage;

    @BeforeClass
    public void set_up_driver() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
    }

    @BeforeMethod
    public void open_driver() {
        homePage.open();
    }

    @AfterClass
    public void close_driver() {
        if (driver != null) {
            driver.quit();
        }
    }

}
