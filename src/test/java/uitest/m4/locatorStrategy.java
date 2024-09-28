package uitest.m4;

import helper.DemoHelper;
import helper.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class locatorStrategy {
    @Test
    public void simpleLocators(){
        WebDriver driver= new ChromeDriver();
        driver.manage().window().fullscreen();
        //driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
/*
        //ID
        WebElement idElement= driver.findElement(By.id("name"));
                    idElement.sendKeys("Kaveri Iyer");
        String EnteredName = idElement.getAttribute("value");
        Assert.assertEquals(EnteredName,"Kaveri Iyer");
        System.out.println("Given Name: "+EnteredName);


        //Name locator
        WebElement nameEle =driver.findElement(By.name("email"));
                    nameEle.sendKeys("test@email.com");
        String givenEmail = nameEle.getAttribute("value");
        Assert.assertEquals(givenEmail, "test@email.com");
        System.out.println("Given Email: "+givenEmail);
*/
        //Link
        driver.get("https://www.tutorialspoint.com/selenium/practice/links.php");
        WebElement link=driver.findElement(By.linkText("Home"));
        link.click();
        System.out.println("The link navigates to: "+link.getAttribute("href"));

        //Partial Link
        WebElement partLink= driver.findElement(By.partialLinkText("PWPU"));
        System.out.println("Link Name: "+partLink.getText());

        driver.quit();

    }

    @Test
    public void cssLocator(){
        WebDriver driver= DriverFactory.newDriver();
        driver.navigate().to("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");

        //cssID
        driver.findElement(By.cssSelector("input#subjects")).sendKeys("EDC, Statistics");

        //cssClass
        driver.findElement(By.cssSelector("textarea.form-control")).sendKeys("A1-Apartment, Mumbai, MH-01");

        //css Tag and Attributte
        String field=driver.findElement(By.cssSelector("input[type='file']")).getAttribute("name");
        System.out.println("Field Name "+ field);

        //Combine ID and class with attribute

        // Class and attributte
        WebElement menuChoice=driver.findElement(By.cssSelector("button.accordion-button[data-bs-target='#collapseOne']"));
        menuChoice.click();
        String tabName=menuChoice.getText();
        System.out.println("Highlight: "+tabName);

        //ID and attributte
        String addr=driver.findElement(By.cssSelector("textarea#picture[placeholder='Currend Address']")).getText();
        System.out.println("Fetch address using id locator: "+addr);

        driver.close();

    }

    @Test
    public void cssStringLocators(){
        WebDriver driver= DriverFactory.newDriver();

        //driver.navigate().to();
    }
}
