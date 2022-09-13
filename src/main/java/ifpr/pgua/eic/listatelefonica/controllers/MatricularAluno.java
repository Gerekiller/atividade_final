package ifpr.pgua.eic.listatelefonica.controllers;

import ifpr.pgua.eic.listatelefonica.App;
import ifpr.pgua.eic.listatelefonica.classes.Aluno;
import ifpr.pgua.eic.listatelefonica.classes.Curso;
import ifpr.pgua.eic.listatelefonica.classes.Escola;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;

public class MatricularAluno {

    @FXML
    private TextField tfCpf;

    @FXML
    private TextField tfCodigo;

    Escola escola;

    public MatricularAluno(Escola escola) {
        this.escola = escola;
    }
    
    @FXML
    private void matricular(ActionEvent evento){
        String cpf = tfCpf.getText();
        Aluno alunoBuscar = escola.buscarAluno(cpf);
        String nome = tfCodigo.getText();
        Curso cursoBuscar = escola.buscarCurso(nome);
        
        if(cursoBuscar != null && alunoBuscar != null){
            if(escola.matricularAluno(alunoBuscar, cursoBuscar)){
                Alert alert = new Alert(AlertType.INFORMATION,"Cadastro realizado");
                alert.showAndWait();
                limpar();
            }else{
                Alert alert = new Alert(AlertType.INFORMATION,"Cadastro não realizado");
                alert.showAndWait();  
            }
        }else{
            Alert alert = new Alert(AlertType.INFORMATION,"Cadastro não realizado");
            alert.showAndWait();  
        }
    }

    private void limpar(){
        tfCodigo.clear();
        tfCpf.clear();
    }

    @FXML
    private void desmatricular(ActionEvent evento){
        String cpf = tfCpf.getText();
        Aluno alunoBuscar = escola.buscarAluno(cpf);
        String nome = tfCodigo.getText();
        Curso cursoBuscar = escola.buscarCurso(nome);
        
        if(cursoBuscar != null && alunoBuscar != null){
            if(escola.desmatricularAluno(alunoBuscar, cursoBuscar)){
                Alert alert = new Alert(AlertType.INFORMATION,"Matrícula retirada");
                alert.showAndWait();
                limpar();
            }else{
                Alert alert = new Alert(AlertType.INFORMATION,"Exclusão não confirmada");
                alert.showAndWait();  
            }
        }else{
            Alert alert = new Alert(AlertType.INFORMATION,"Exclusão não confirmada");
            alert.showAndWait();  
        }
    }

}
