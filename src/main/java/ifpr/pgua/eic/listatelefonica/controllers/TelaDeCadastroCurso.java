package ifpr.pgua.eic.listatelefonica.controllers;

import ifpr.pgua.eic.listatelefonica.App;
import ifpr.pgua.eic.listatelefonica.classes.Curso;
import ifpr.pgua.eic.listatelefonica.classes.Escola;
import ifpr.pgua.eic.listatelefonica.classes.Professor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;

public class TelaDeCadastroCurso {
    
    @FXML
    private TextField tfCodigo;

    @FXML
    private TextField tfNome;

    @FXML
    private TextField tfDescricao;

    @FXML
    private TextField tfCargaHoraria;

    @FXML
    private TextField tfProfessor;

    private Escola escola;

    public TelaDeCadastroCurso( Escola escola){
        this.escola = escola;
    }


    @FXML
    private void cadastrar(ActionEvent evento){
        String codigoString = tfCodigo.getText();
        int codigo = Integer.parseInt(codigoString);
        String nome = tfNome.getText();
        Curso resultado = escola.buscarCurso(nome);
        String descricao = tfDescricao.getText();
        String cargaHorariaString = tfCargaHoraria.getText();
        int cargaHoraria = Integer.parseInt(cargaHorariaString);
        String cpfProfessor = tfProfessor.getText();
        Professor professor = escola.buscarProfessor(cpfProfessor);
        
        if(professor != null && resultado == null){
            if(escola.cadastrarCurso(codigo, nome, descricao, cargaHoraria, professor)){
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
        tfNome.clear();
        tfDescricao.clear();
        tfCargaHoraria.clear();
        tfProfessor.clear();
    }

}
