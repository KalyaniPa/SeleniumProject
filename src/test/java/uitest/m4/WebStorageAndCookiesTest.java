package uitest.m4;

import helper.DemoHelper;
import helper.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.html5.SessionStorage;
import org.openqa.selenium.html5.WebStorage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

import static helper.Pages.HOME;
import static helper.Pages.SAVINGS;

public class WebStorageAndCookiesTest {

    @Test
    public void storageTest(){
        WebDriver driver = DriverFactory.newDriver();
        driver.get(HOME);
        WebElement fn = driver.findElement(By.id("firstName"));
        WebElement ln = driver.findElement(By.id("lastName"));
        WebElement save = driver.findElement(By.id("save"));

        fn.sendKeys("Joy");
        ln.sendKeys("Todds");
        save.click();

        WebStorage webStorage = (WebStorage) driver;
        SessionStorage session = webStorage.getSessionStorage();
        session.keySet().forEach(key-> System.out.println(key + "="+ session.getItem(key)));

        driver.get(SAVINGS);
        driver.navigate().back();

        WebElement fn_1 = driver.findElement(By.id("firstName"));
        WebElement ln_1 = driver.findElement(By.id("lastName"));
        Assert.assertEquals(fn_1.getAttribute("value"),"Joy");
        Assert.assertEquals(ln_1.getAttribute("value"),"Todds");

        session.clear();
        driver.navigate().refresh(); // Need to refresh page for session data to update

        DemoHelper.pause();
        //Stale Element error is displayed on using fn_1 and ln_1, need to fetch elements anew on webpage.
        WebElement fn_2 = driver.findElement(By.id("firstName"));
        WebElement ln_2 = driver.findElement(By.id("lastName"));
        Assert.assertEquals(fn_2.getAttribute("value"),"");
        Assert.assertEquals(ln_2.getAttribute("value"),"");

        driver.close();

    }

    @Test
    public void cookieTest(){

        WebDriver driver=DriverFactory.newDriver();
        WebDriver.Options options= driver.manage();

        Set<Cookie> cookies= options.getCookies();
        Cookie thing= options.getCookieNamed("thing");
        options.deleteAllCookies();


    }
}
