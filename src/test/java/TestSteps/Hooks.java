package TestSteps;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class Hooks {

    public static WebDriver driver;
    public static int printCount;

    @Before
    public static WebDriver getDriver() {
        WebDriverManager.chromedriver().setup();
        if (driver == null) {
            driver = new ChromeDriver();
            driver.get("https://site.getnet.com.br/");
            driver.manage().window().maximize();
        }
        return driver;
    }

    @AfterStep
    public static void getEvidencePrint(Scenario scenario) {
        File scrFile;
        File evidenceFolder = new File(
                "target/screenshots/" + scenario.getName() + "/" + printCount + ".png");
        try {
            scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, evidenceFolder);
            printCount = printCount + 1;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @After
    public static void killDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
