package uitest.m4;

import helper.DemoHelper;
import helper.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import javax.swing.*;

import java.time.Duration;

import static helper.Pages.*;


public class TestDrive {

    @Test
    public void test() {
        WebDriver driver= DriverFactory.newDriver();

        driver.get(HOME);

        Actions act= new Actions(driver);

        WebElement name= driver.findElement(By.id("firstName"));
        WebElement checkbox= driver.findElement(By.id("heard-about"));
        DemoHelper.pause();

        act.doubleClick(checkbox).perform();
        driver.findElement(By.id("textarea")).isEnabled();
        name.sendKeys(Keys.SHIFT, "KalTest");

        DemoHelper.pause();
        act.contextClick(checkbox).perform();
        DemoHelper.pause();
        driver.quit();

    }

    @Test
    public void browserCommands(){
        WebDriver driver =DriverFactory.newDriver();
        driver.get(HOME);

        String title= driver.getTitle();
        System.out.println("Tile: "+title);

        String pagesource = driver.getPageSource();
        System.out.println("Page Source: "+pagesource);

        String actualUrl= driver.getCurrentUrl();
        System.out.println("Actual URL: "+actualUrl);

        //Navigation Command
        String test="https://www.toolsqa.com/";
        driver.navigate().to(test);

        driver.close();

    }

    @Test
    public static void complexActions() {
        WebDriver driver=DriverFactory.newDriver();

        /*driver.get("https://www.lambdatest.com/intl/en-in");
        WebElement ele=driver.findElement(By.linkText("Contact Us"));
        act.scrollToElement(ele).perform();
        DemoHelper.pause();
        ele.click(); */

       //Drag and drop
        driver.get("https://artoftesting.com/samplesiteforselenium");

        Actions act= new Actions(driver);
        //WebElement tab = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.linkText("Accept")));

        WebElement source= driver.findElement(By.id("myImage"));
        WebElement target= driver.findElement(By.id("targetDiv"));
        //DemoHelper.pause();

        act.scrollToElement(source).perform();

        act.dragAndDrop(source,target).perform();

        String highlight= target.getCssValue("background-color"), fieldText= target.getText();
        System.out.println("Highlight: "+highlight);

        if (fieldText.equals("Dropped!")){
            System.out.println("Pass");
        }
        else {
            System.out.println("Drop Failed.");
        }

        driver.close();

    }

    @Test
    public static void webElementCommands(){
        WebDriver driver = DriverFactory.newDriver();

        driver.get("https://demoqa.com/text-box");

        //WebElement textbox=driver
    }

}
