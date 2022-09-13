package ifpr.pgua.eic.listatelefonica.controllers;

import ifpr.pgua.eic.listatelefonica.App;
import ifpr.pgua.eic.listatelefonica.utils.BorderPaneRegion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class JanelaPrincipal {
    
    @FXML
    private void cadastrarAluno(ActionEvent evento){
        App.changeScreenRegion("CADASTROALUNO", BorderPaneRegion.CENTER);
    }

    @FXML
    private void cadastrarProfessor(ActionEvent evento){
        App.changeScreenRegion("CADASTROPROFESSOR", BorderPaneRegion.CENTER);
    }

    @FXML
    private void cadastrarCurso(ActionEvent evento){
        App.changeScreenRegion("CADASTROCURSO", BorderPaneRegion.CENTER);
    }

    @FXML
    private void listarAlunos(ActionEvent evento){
        App.changeScreenRegion("LISTAALUNOS", BorderPaneRegion.CENTER);
    }

    @FXML
    private void listarProfessores(ActionEvent evento){
        App.changeScreenRegion("LISTAPROFESSORES", BorderPaneRegion.CENTER);
    }
    
    @FXML
    private void listarCursos(ActionEvent evento){
        App.changeScreenRegion("LISTACURSOS", BorderPaneRegion.CENTER);
    }

    @FXML
    private void matricularAluno(ActionEvent evento){
        App.changeScreenRegion("MATRICULARALUNO", BorderPaneRegion.CENTER);
    }

    @FXML
    private void listasGerais(ActionEvent evento){
        App.changeScreenRegion("LISTARTUDO", BorderPaneRegion.CENTER);
    }

}
