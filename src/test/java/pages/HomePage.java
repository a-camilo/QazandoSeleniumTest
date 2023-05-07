package pages;

import org.openqa.selenium.By;
import support.Commands;

public class HomePage extends Commands {
    private final String URL = "http://automationpratice.com.br/";
    private final By wait = By.xpath("//*[text()='Vaideo & Audio']");
    private final By register = By.xpath("//*[text()=' Cadastro']");
    private final By login = By.xpath("//*[@class='right_list_fix']/li[1]");
    private final By checkOut = By.xpath("//li[@class='has-dropdown has-megaitem']");

    public static HomePage action() {
        return new HomePage();
    }

    public HomePage url() {
        getDriver().get(URL);
        waitElementBeVisible(wait,30);
        return this;
    }

    public HomePage acessarTelaDeCadastro() {
        clickElement(register);
        return this;
    }

    public HomePage acessarTelaChekoutView() {
        clickElement(checkOut);
        return this;
    }

    public HomePage acessarTelaLogin() {
        clickElement(login);
        return this;
    }
}
