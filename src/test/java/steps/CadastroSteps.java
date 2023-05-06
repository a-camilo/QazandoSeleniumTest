package steps;

import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import pages.CadastroPage;

public class CadastroSteps {

    @Entao("visualizo a mensagenm de cadastro com {string}")
    public void visualizoAMensagenmDeCadastroCom(String msg) {
        CadastroPage.action().mensagem(msg);
    }

    @Quando("preencher o formulario {string} {string} {string}")
    public void preencherOFormulario(String nome, String email, String senha) {
        CadastroPage.action().preencherOFormulario(nome, email, senha);
    }
}
