package TestPages;

import TestSteps.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    private static final int WAIT_TIMEMOUT = 35;
    private final WebDriverWait wait;
    protected WebDriver driver;

    public BasePage() {
        this.driver = Hooks.getDriver();
        this.wait = new WebDriverWait(driver, WAIT_TIMEMOUT);
    }

    public void waitForPageLoad() {
        ExpectedCondition<Boolean> pageLoadCondition = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
                    }
                };
        this.wait.until(pageLoadCondition);
    }

    public void waitForVisibleElement(By by) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void waitForNotVisibleElement(By by) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public void waitForClickableElement(By by) {
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    /********* TextField e TextArea ************/

    public void fieldInput(By by, String text) {
        waitForVisibleElement(by);
        waitForClickableElement(by);
        driver.findElement(by).click();
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(text);
        driver.findElement(by).sendKeys(Keys.TAB);
    }

    public String getText(By by) {
        waitForVisibleElement(by);
        waitForClickableElement(by);
        return driver.findElement(by).getText();
    }

    /********* Button ************/
    public void btnClick(By by) {
        waitForVisibleElement(by);
        waitForClickableElement(by);
        driver.findElement(by).click();
    }

    public String getValueElement(By by) {
        waitForVisibleElement(by);
        waitForClickableElement(by);
        return driver.findElement(by).getAttribute("value");
    }
}
