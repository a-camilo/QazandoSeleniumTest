package pages;

import org.openqa.selenium.By;
import runner.RunCucumberTest;

import static support.Commands.*;

public class CadastroPage extends RunCucumberTest {
    //elementos
    private By nome = By.cssSelector("#user");
    private By email = By.cssSelector("#email");
    private By senha = By.cssSelector("#password");
    private By btnCadastrar = By.cssSelector("#btnRegister");
    private By modalCadastroSucesso = By.xpath("//div[@role='dialog']/h2");
    private By errorMessageName = By.xpath("//span[starts-with(text(),'O campo nome')]");
    private By errorMessageEmail = By.xpath("//span[starts-with(text(),'O campo e-mail')]");
    private By errorMessagePassword = By.xpath("//span[starts-with(text(),'O campo senha')]");

    public static CadastroPage action() {
        return new CadastroPage();
    }

    // ações / funções / metodos
    public CadastroPage fillName(String name) {
        writeField(nome, name);
        return this;
    }

    public CadastroPage fillEmail(String mail) {
        writeField(email, mail);
        return this;
    }

    public CadastroPage fillPassword(String password) {
        writeField(senha, password);
        return this;
    }

    public CadastroPage cadastrar() {
        clickElement(btnCadastrar);
        return this;
    }

    public CadastroPage preencherOFormulario(String name, String mail, String password) {

        fillName(name);
        fillEmail(mail);
        fillPassword(password);
        cadastrar();
        return this;
    }

    public CadastroPage mensagem(String msg) {

        if (msg.equals("Cadastro realizado!")) {
            checkMessage(msg, modalCadastroSucesso);
        }
        if (msg.equals("O campo nome deve ser prenchido")) {
            checkMessage(msg, errorMessageName);
        }
        if (msg.equals("O campo e-mail deve ser prenchido corretamente")) {
            checkMessage(msg, errorMessageEmail);
        }
        if (msg.equals("O campo senha deve ter pelo menos 6 dígitos")) {
            checkMessage(msg, errorMessagePassword);
        }
        return this;
    }
}