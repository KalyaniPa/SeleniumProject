package helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class DriverFactory {

    public static WebDriver newDriver(){

        ChromeOptions options = new ChromeOptions();

        /* Code to run headless
        options.addArguments("--headless=new");
        WebDriver driver =new ChromeDriver(options);
*/
        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return driver;
    }
}
