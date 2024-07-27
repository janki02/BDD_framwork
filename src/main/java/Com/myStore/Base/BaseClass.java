package Com.myStore.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

// BaseClass is used to load the config file and Initialize WebDriver

public class BaseClass {
    public static Properties pro;
    public static WebDriver driver;

    @BeforeTest
    public void loadConfig() {
        try {
            pro = new Properties(); // Initialize the static variable

            FileInputStream ip = new FileInputStream(
                    System.getProperty("user.dir") + "/BDDFramework/configuration/configuration.properties");
            pro.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void launchApplication() {
        // Browser setup
        WebDriverManager.chromedriver().setup();
        String browserName = pro.getProperty("Browser");

        if (browserName.contains("Chrome")) {
            driver = new ChromeDriver();
        } else if (browserName.contains("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browserName.contains("Edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Please pass the correct browser value: " + browserName);
        }

        // Maximize the screen
        driver.manage().window().maximize();
        // Delete all cookies
        driver.manage().deleteAllCookies();
        // Implicitly wait
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        // Page load timeout
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        // Launch the URL
        String url = pro.getProperty("url");
        System.out.println("URL from config: " + url);
        driver.get(url);
    }
}
