package support;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import runner.RunCucumberTest;

import java.time.Duration;

public class Commands extends RunCucumberTest {

    public static void waitElementBeClickable(By element, int tempo) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(tempo));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitElementBeVisible(By element, int tempo) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(tempo));
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public static void clickElement(By element) {
        try {
            waitElementBeClickable(element, 30);
            getDriver().findElement(element).click();
        } catch (Exception error) {
            throw new RuntimeException("Aconteceu um erro ao tentar clicar no elemento: " + element);
        }
    }

    public static void writeField(By element, String value) {
        try {
            waitElementBeVisible(element, 30);
            getDriver().findElement(element).sendKeys(value);
        } catch (Exception error) {
            throw new RuntimeException("Aconteceu um erro ao tentar escrever o elemento: " + element);
        }
    }

    public static void checkMessage(String expectedMessage, By element) {
        try {
            waitElementBeVisible(element, 30);
            String actualMessage = getDriver().findElement(element).getText();
            Assert.assertEquals(actualMessage, expectedMessage);

        } catch (Exception error) {
            throw new RuntimeException("Aconteceu um erro ao validar a mensagem: " + element);
        }
    }

    public static void selectOptions(By element, String value){
        try{
            waitElementBeVisible(element, 30);
            Select select_city = new Select(getDriver().findElement(element));
            select_city.selectByVisibleText(value);
        } catch (Exception error) {
            throw new RuntimeException("Aconteceu um erro ao selecionar: " + element);
        }
    }
}
