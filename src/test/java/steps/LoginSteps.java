package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.After;
import pages.HomePage;
import pages.LoginPage;

public class LoginSteps {

    @E("acessar a tela de login")
    public void acessarATelaDeLogin() {
        HomePage.action().acessarTelaLogin();
    }


    @Quando("inserir minhas credenciais {string}, {string}")
    public void inserirMinhasCredenciais(String email, String senha) {
        LoginPage.action().inserirMinhasCredenciais(email, senha);
    }

    @Entao("devo visualizar a mensagem na tela {string}")
    public void devoVisualizarAMensagemNaTela(String msg) {
        LoginPage.action().mensagem(msg);
    }

    @Entao("devo acessar a tela Dashboard")
    public void devoAcessarATelaDashboard() {
    }

    @After
    public static void takeScreenshot(Scenario scenario) {

        System.out.println("==================");
        System.out.println("Teste executado: " + scenario.getName());
        System.out.println("Status: " + scenario.getStatus());
        System.out.println("Tag: " + scenario.getSourceTagNames());
        System.out.println("==================");
    }

}
