package ifpr.pgua.eic.listatelefonica.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import ifpr.pgua.eic.listatelefonica.classes.Escola;
import ifpr.pgua.eic.listatelefonica.classes.Professor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class ListaDeProfessores implements Initializable{
    
    @FXML
    private TextField tfNome;

    @FXML
    private ListView<Professor> ltvProfessores;

    @FXML
    private TextArea taDetalhes;

    private Escola escola;

    public ListaDeProfessores( Escola escola){
        this.escola = escola;
    }



    //método utilizado para inicializar os componentes visuais.
    //É executado depois do construtor e antes da tela ser mostrada.
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        ltvProfessores.getItems().clear();
        
        //inicialização do listview
        ltvProfessores.getItems().addAll(escola.getProfessores());
    }



    //Evento que ao clicar em um elemento do listview é executado.
    @FXML
    private void mostrarDetalhes(MouseEvent evento){
        Professor professor = ltvProfessores.getSelectionModel().getSelectedItem();

        if(professor != null){
            taDetalhes.clear();
            taDetalhes.appendText("Nome: "+professor.getNome()+"\n");
            taDetalhes.appendText("CPF: "+professor.getCpf()+"\n");
            taDetalhes.appendText("Email: "+professor.getEmail()+"\n");
            taDetalhes.appendText("Telefone: "+professor.getTelefone()+"\n");  
            taDetalhes.appendText("Salário: "+professor.getSalario()+"\n");
        }
    }

    @FXML
    private void buscar(ActionEvent evento){
        ltvProfessores.getItems().clear();
        ltvProfessores.getItems().addAll(escola.buscaProfessorPorNome(tfNome.getText()));
    }

}
