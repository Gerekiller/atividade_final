package ifpr.pgua.eic.listatelefonica.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import ifpr.pgua.eic.listatelefonica.classes.Curso;
import ifpr.pgua.eic.listatelefonica.classes.Escola;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class ListaDeCursos implements Initializable{
    
    @FXML
    private TextField tfNome;

    @FXML
    private ListView<Curso> ltvCursos;

    @FXML
    private TextArea taDetalhes;

    private Escola escola;

    public ListaDeCursos( Escola escola){
        this.escola = escola;
    }



    //método utilizado para inicializar os componentes visuais.
    //É executado depois do construtor e antes da tela ser mostrada.
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        ltvCursos.getItems().clear();
        
        //inicialização do listview
        ltvCursos.getItems().addAll(escola.getCursos());
    }


    //Evento que ao clicar em um elemento do listview é executado.
    @FXML
    private void mostrarDetalhes(MouseEvent evento){
        Curso cursos = ltvCursos.getSelectionModel().getSelectedItem();

        if(cursos != null){
            taDetalhes.clear();
            taDetalhes.appendText("Código: "+cursos.getCodigo()+"\n");
            taDetalhes.appendText("Nome: "+cursos.getNome()+"\n");
            taDetalhes.appendText("Descrição: "+cursos.getDescricao()+"\n");
            taDetalhes.appendText("Carga Horaria: "+cursos.getCargaHoraria()+"\n");
            taDetalhes.appendText("Professor: "+cursos.getProfessor().getNome()+"\n");
            taDetalhes.appendText("Alunos: "+cursos.getAlunos());
        }
    }

    @FXML
    private void buscar(ActionEvent evento){
        ltvCursos.getItems().clear();
        ltvCursos.getItems().addAll(escola.buscaCursoPorNome(tfNome.getText()));
    }

}
