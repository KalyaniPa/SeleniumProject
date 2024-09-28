package uitest.m4;

import helper.DriverFactory;
import org.openqa.selenium.*;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import static helper.Pages.HOME;
import static helper.Pages.LOANS;

public class ScreenShotTest {
    @Test
    public void fullPageScreen() throws IOException {
        WebDriver driver = DriverFactory.newDriver();
        driver.get(LOANS);

         TakesScreenshot ts =(TakesScreenshot) driver;

        File screenshot=ts.getScreenshotAs(OutputType.FILE);
        Path destination = Paths.get("fullPageScreen.png");
        Files.move(screenshot.toPath(),destination, StandardCopyOption.REPLACE_EXISTING);

        driver.close();

    }
    @Test
    public void elementScreen() throws IOException {
        WebDriver driver = DriverFactory.newDriver();
        driver.get(HOME);

        WebElement form=driver.findElement(By.tagName("form"));
        File formScreen=form.getScreenshotAs(OutputType.FILE);

        Path destination = Paths.get("elementScreen.png");
        Files.move(formScreen.toPath(),destination, StandardCopyOption.REPLACE_EXISTING);
        driver.close();


    }
}
