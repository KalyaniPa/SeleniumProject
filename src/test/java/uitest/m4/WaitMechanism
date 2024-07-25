package uitest.m4;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

import static helper.Pages.LOANS;

public class WaitMechanism {
//Flaky UI test generally fail as element on webpage is not available or interactable. 'ElementNotFoundException' and ElementNotClickable ane commonly encountered exceptions error due to it.
//Implicit wait is a global wait at driver level. Generally it does not affect for methods like isDisplayed or isEnabled as element is already part of DOM and the test fails.
//An explict wait is for individual actions.

    @Test
    public void webdriverWait(){

        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(LOANS);
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));

        driver.findElement(By.id("borrow")).sendKeys("500");
         //WebElement element= driver.findElement(By.id("result"));
        //Assert.assertTrue(element.isDisplayed());//Fails with implicit wait as boolean return method is not affected by wait
        //element.click();//the implicit wait will force selenium to wait till the element is available and interactable to click.

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(6));
        WebElement result=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("result")));

        Assert.assertTrue(result.isDisplayed());

        driver.close();

    }

    @Test

    public void fluentWait(){
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(LOANS);

       /* FluentWait<WebDriver> wait= new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(6))
                .pollingEvery(Duration.ofSeconds(1)); */
        Wait<WebDriver> wait =new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(6))
                        .pollingEvery(Duration.ofMillis(200))
                .ignoring(NoSuchElementException.class);

        driver.findElement(By.id("borrow")).sendKeys("500");
        WebElement result= driver.findElement(By.id("result"));
        wait.until(ExpectedConditions.elementToBeClickable(result));
        result.click();

        driver.close();


    }

}
