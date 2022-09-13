package ifpr.pgua.eic.listatelefonica.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import ifpr.pgua.eic.listatelefonica.classes.Aluno;
import ifpr.pgua.eic.listatelefonica.classes.Escola;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class ListaDeAlunos implements Initializable{

    @FXML
    private TextField tfNome;

    @FXML
    private ListView<Aluno> ltvAlunos;

    @FXML
    private TextArea taDetalhes;

    private Escola escola;

    public ListaDeAlunos( Escola escola){
        this.escola = escola;
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        ltvAlunos.getItems().clear();
        
        //inicialização do listview
        ltvAlunos.getItems().addAll(escola.getAlunos());
    }


    //Evento que ao clicar em um elemento do listview é executado.
    @FXML
    private void mostrarDetalhes(MouseEvent evento){
        Aluno aluno = ltvAlunos.getSelectionModel().getSelectedItem();

        if(aluno != null){
            taDetalhes.clear();
            taDetalhes.appendText("Nome: "+aluno.getNome()+"\n");
            taDetalhes.appendText("CPF : "+aluno.getCpf()+"\n");
            taDetalhes.appendText("Email: "+aluno.getEmail()+"\n");
            taDetalhes.appendText("Telefone: "+aluno.getTelefone()+"\n");
            taDetalhes.appendText("Data da matrícula: "+aluno.getDataMatricula()+"\n");
        }
    }

    @FXML
    private void buscar(ActionEvent evento){
        ltvAlunos.getItems().clear();
        ltvAlunos.getItems().addAll(escola.buscaAlunoPorNome(tfNome.getText()));
    }
    
}