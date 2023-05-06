package support;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import runner.RunCucumberTest;

import java.util.Random;

public class Utils extends RunCucumberTest {

    public static String getRandomEmail() {
        String email_init = "qazando_";
        String email_final = "@qazando.com.br";

        Random random = new Random();
        int min = 1;
        int max = 9999;
        int result = random.nextInt(max - min) + min;

        return email_init + result + email_final;
    }

    public static String getRandomName() {
        String name_init = "Rolando";
        String name_final = "Lero";

        Random random = new Random();
        int min = 1;
        int max = 9999;
        int result = random.nextInt(max - min) + min;

        return name_init + result + name_final;
    }

    public static void scrollView(By by){
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        WebElement element = getDriver().findElement(by);
        js.executeScript("arguments[0].scrollIntoView(true)", element);
    }
}
