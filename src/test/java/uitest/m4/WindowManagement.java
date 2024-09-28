package uitest.m4;

import helper.DemoHelper;
import helper.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.testng.Assert;
import org.testng.annotations.Test;

import static helper.Pages.HOME;
import static helper.Pages.SAVINGS;

public class WindowManagement {

    @Test
    public void tabDemo(){
        WebDriver driver= DriverFactory.newDriver();
        driver.get(HOME);
        String mainWindow=driver.getWindowHandle();
        DemoHelper.pause();

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get(SAVINGS);
        DemoHelper.pause();
        driver.switchTo().window(mainWindow);

        Assert.assertEquals(driver.getWindowHandles().size(), 2);
        driver.close();

        DemoHelper.pause();
        Assert.assertEquals(driver.getWindowHandles().size(), 1);
        driver.quit();


    }
}
