package ifpr.pgua.eic.listatelefonica.controllers;

import ifpr.pgua.eic.listatelefonica.App;
import ifpr.pgua.eic.listatelefonica.classes.Escola;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;

public class TelaDeCadastroProfessor {

    @FXML
    private TextField tfCpf;

    @FXML
    private TextField tfNome;

    @FXML
    private TextField tfEmail;

    @FXML
    private TextField tfTelefone;

    @FXML
    private TextField tfSalario;

    private Escola escola;

    public TelaDeCadastroProfessor( Escola escola){
        this.escola = escola;
    }


    @FXML
    private void cadastrar(ActionEvent evento){
        String cpf = tfCpf.getText();
        String nome = tfNome.getText();
        String email = tfEmail.getText();
        String telefone = tfTelefone.getText();
        String salarioString = tfSalario.getText();
        double salario = Double.parseDouble(salarioString);
    
        if(escola.cadastrarProfessor(cpf, nome, telefone, email, salario)){
            Alert alert = new Alert(AlertType.INFORMATION,"Cadastro realizado");
            alert.showAndWait();
            limpar();
        }else{
            Alert alert = new Alert(AlertType.INFORMATION,"Cadastro não realizado");
            alert.showAndWait();  
        }
    }

    private void limpar(){
        tfCpf.clear();
        tfNome.clear();
        tfEmail.clear();
        tfTelefone.clear();
        tfSalario.clear();
    }
    
    
}
