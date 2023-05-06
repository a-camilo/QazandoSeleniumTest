package pages;

import org.example.Cadastro;
import org.openqa.selenium.By;
import runner.RunCucumberTest;

import static support.Commands.*;

public class LoginPage extends RunCucumberTest {
    private final By user = By.id("user");
    private final By password = By.id("password");
    private final By btnLogin = By.cssSelector("#btnLogin");
    private final By successModal = By.cssSelector("#swal2-html-container");
    private final By invalidPassword = By.xpath("//span[contains(text(),'Senha inválida.')]");
    private final By invalidEmail = By.xpath("//span[contains(text(),'E-mail inválido.')]");

    public static LoginPage action() {
        return new LoginPage();
    }

    // ações / funções / metodos
    public LoginPage setEmail(String email) {
        writeField(user, email);
        return this;
    }

    public LoginPage setSenha(String senha) {
        writeField(password, senha);
        return this;
    }

    public LoginPage Login() {
        clickElement(btnLogin);
        return this;
    }

    public LoginPage inserirMinhasCredenciais(String email, String senha) {
        Cadastro cadastro = new Cadastro(null, email, senha);

        if (email == null) {
            getDriver().findElement(user).clear();
        } else {
            setEmail(cadastro.getEmail());
        }
        if (senha == null) {
            getDriver().findElement(password).clear();
        } else {
            setSenha(cadastro.getPassword());
        }
        Login();
        return this;
    }

    public LoginPage mensagem(String msg) {
        switch (msg) {
            case "Olá, antonio@gmail.com" -> checkMessage(msg, successModal);
            case "Senha inválida." -> checkMessage(msg, invalidPassword);
            case "E-mail inválido." -> checkMessage(msg, invalidEmail);
        }
        return this;
    }


}
