package pages;

import org.example.Cadastro;
import org.openqa.selenium.By;
import runner.RunCucumberTest;

import static support.Commands.*;

public class LoginPage extends RunCucumberTest {
    private final By user = By.id("user");
    private final By password = By.id("password");
    private final By btnLogin = By.id("btnLogin");
    private final By successModal = By.id("swal2-title");
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

        setEmail(cadastro.getEmail());
        setSenha(cadastro.getPassword());
        Login();
        return this;
    }

    public LoginPage mensagem(String msg) {
        switch (msg) {
            case "Login realizado" -> checkMessage(msg, successModal);
            case "Senha inválida." -> checkMessage(msg, invalidPassword);
            case "E-mail inválido." -> checkMessage(msg, invalidEmail);
        }
        return this;
    }


}
