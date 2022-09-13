package ifpr.pgua.eic.listatelefonica.controllers;

import ifpr.pgua.eic.listatelefonica.App;
import ifpr.pgua.eic.listatelefonica.classes.Escola;
import ifpr.pgua.eic.listatelefonica.utils.BorderPaneRegion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class OpcoesAluno {

    private Escola escola;

    public OpcoesAluno(Escola escola) {
        this.escola = escola;
    }
    
    @FXML
    private void cadastrarPessoa(ActionEvent evento){
        App.pushScreen("CADASTRO");
    }

    @FXML
    private void listarAlunos(ActionEvent evento){
        App.pushScreen("LISTA");
    }

    @FXML
    private void voltar(ActionEvent evento){
        App.popScreen();
    }

}
