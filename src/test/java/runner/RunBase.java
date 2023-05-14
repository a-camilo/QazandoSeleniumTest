package runner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class RunBase {
    public static WebDriver driver;
    private enum Browser {CHROME, FIREFOX,CHROME_CI,EDGE}

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
        switch (browser) {
            case CHROME:
                chromeOptions.addArguments("--remote-allow-origins=*", "ignore-certificate-errors");
                driver = new ChromeDriver(chromeOptions);
                break;
            case CHROME_CI:
                chromeOptions.addArguments("--headless");
                driver = new ChromeDriver(chromeOptions);
                break;
            case FIREFOX:
                driver = new FirefoxDriver();
                break;
            case EDGE:
                throw new IllegalArgumentException("Edge ainda nao suportado");
            default:
                throw new IllegalArgumentException("Navegador não encontrado! Passe um navegador existente: chrome, forefox ou edge.");
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        return driver;
    }
}