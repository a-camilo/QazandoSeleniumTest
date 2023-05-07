package steps;

import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import pages.CheckOutViewPage;

public class CheckOutViewSteps {

    @Quando("preencher as informações")
    public void preencherAsInformações() throws InterruptedException {
        CheckOutViewPage.action().preencherAsInformações(
                "Petter",
                "Parker",
                "Clarin",
                "p.parker@gmail.com",
                "usa",
                "Afghanistan",
                "15987",
                "Tonny Stark street 1564",
                "spider man it´s my favorite hero!"
        );
    }

    @Entao("devo receber uma mensagem")
    public void devoReceberUmaMensagem() {
        CheckOutViewPage.action().mensagem();
    }
}
