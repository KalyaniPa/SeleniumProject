package uitest.m4;

import helper.DemoHelper;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static helper.Pages.HOME;

public class WebdriverConfiguration {

    @Test

    public void windowSize(){
        WebDriver driver =new ChromeDriver();
        WebDriver.Window win=driver.manage().window();
        win.setSize(new Dimension(800,600));
        driver.get(HOME);

        DemoHelper.pause();
        driver.quit();

    }

    @Test
    public void runHeadlessMode(){

    }
}
