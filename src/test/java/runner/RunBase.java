package runner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class RunBase {
    public static WebDriver driver;
    private enum Browser {CHROME, FIREFOX}

    public static WebDriver getDriver() {
        if (driver == null) {
            return getDriver(Browser.CHROME);
        } else {
            return driver;
        }
    }

    public static WebDriver getDriver(Browser browser) {
        if (driver != null) {
            driver.quit();
        }

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*", "ignore-certificate-errors");

        switch (browser) {
            case CHROME -> driver = new ChromeDriver(chromeOptions);
            case FIREFOX -> driver = new FirefoxDriver();
        }

        if (driver != null) {
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        }
        return driver;
    }
}
