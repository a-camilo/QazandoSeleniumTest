package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import pages.HomePage;

public class HomeSteps {

    @Dado("que estou na home do Qazando Shop")
    public void queEstouNaHomeDoQazandoShop() {
        HomePage.action().url();
    }
    @E("acessar a tela de cadastro")
    public void acessarATelaDeCadastro() {
        HomePage.action().acessarTelaDeCadastro();
    }

    @E("acessar a tela de CheckOut")
    public void acessarATelaDeCheckOut() {
        HomePage.action().acessarTelaChekoutView();
    }
}
