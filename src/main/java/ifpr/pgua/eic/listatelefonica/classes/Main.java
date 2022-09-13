package ifpr.pgua.eic.listatelefonica.classes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.sql.Date;

public class Main {
    public static Scanner scan = new Scanner(System.in);
    public static Escola verificador = new Escola("ESCOLA 1", "1234");
    public static Aluno aluno;
    public static Professor professor;

    public static void main(String[] args){
        int op = 1;

        while(op != 0){
            System.out.println(menu());
            op = scan.nextInt();
            scan.nextLine();
            if(op == 1){
                cadastroDeAluno();
            }else if(op == 2){
                cadastroDeProfessor();
            }else if(op == 3){
                buscaAluno();
            }else if(op == 4){
                buscaProfessor();
            }else if(op == 5){
                listarAlunos();
            }else if(op == 6){
                cadastrarCurso();
            }else if(op == 7){
                listarCursos();
            }else if(op == 8){
                listarCursos();
            }else if(op == 9){
                listarCursos();
            }
        }
    }

    public static String menu(){
        String str = "";
        str += "1 - Cadastrar aluno\n";
        str += "2 - Cadastrar professor\n";
        str += "3 - Buscar aluno\n";
        str += "4 - Buscar professor\n";
        str += "5 - Listar alunos\n";
        str += "6 - Cadastrar curso\n";
        str += "7 - Listar cursos\n";
        str += "8 - Matricular aluno no curso\n";
        str += "9 - Desmatricular aluno no curso\n";
        return str;
    }

    public static void cadastroDeAluno(){
        System.out.print("Nome do aluno: ");
        String nome = scan.nextLine();
        System.out.print("Cpf: ");
        String cpf = scan.nextLine();
        System.out.print("Email: ");
        String email = scan.nextLine();
        System.out.print("Telefone: ");
        String telefone = scan.nextLine();
        System.out.print("Data matricula: ");
        //String data = scan.nextLine();
        LocalDate dia = LocalDate.now();
        System.out.println(dia);
        boolean resultado = verificador.cadastrarAluno(cpf, nome, email, telefone, dia);
        if(resultado){
            System.out.println("Cadastrado");
        }else{
            System.out.println("Erro.");
        }
    }

    public static void cadastroDeProfessor(){
        System.out.print("Nome do professor: ");
        String nome = scan.nextLine();
        System.out.print("Cpf: ");
        String cpf = scan.nextLine();
        System.out.print("Email: ");
        String email = scan.nextLine();
        System.out.print("Telefone: ");
        String telefone = scan.nextLine();
        System.out.print("Salário: ");
        double salario = scan.nextInt();
        boolean resultado = verificador.cadastrarProfessor(cpf, nome, email, telefone, salario);
        if(resultado){
            System.out.println("Cadastrado");
        }else{
            System.out.println("Erro.");
        }
    }

    public static void buscaAluno(){
        System.out.print("Digite o numero do CPF: ");
        String cpf = scan.nextLine();
        Aluno alunoBusca = verificador.buscarAluno(cpf);
        if(alunoBusca != null){
            System.out.println(alunoBusca);
        }else{
            System.out.println("CPF inválido.");
        }
    }

    public static void buscaProfessor(){
        System.out.print("Digite o numero do CPF: ");
        String cpf = scan.nextLine();
        Professor professorBusca = verificador.buscarProfessor(cpf);
        if(professorBusca != null){
            System.out.println(professorBusca);
        }else{
            System.out.println("CPF inválido.");
        }
    }

    private static void listarAlunos() {
        System.out.println("");
        ArrayList<Aluno> listaAlunos = verificador.getAlunos();
        for (int i = 0; i < listaAlunos.size(); i++) {
            System.out.println(listaAlunos.get(i).getNome());
        }
        System.out.println("");
    }

    private static void cadastrarCurso() {
        System.out.print("Código do curso: ");
        int codigo = scan.nextInt();
        scan.nextLine();
        System.out.print("Nome do curso: ");
        String nome = scan.nextLine();
        System.out.print("Descrição: ");
        String descricao = scan.nextLine();
        System.out.print("Carga horária: ");
        int cargaHoraria = scan.nextInt();
        scan.nextLine();
        System.out.print("CPF professor: ");
        String cpf = scan.nextLine();
        Professor professor = verificador.buscarProfessor(cpf);
        if(professor != null){
            verificador.cadastrarCurso(codigo, nome, descricao, cargaHoraria, professor);
        }else{
            System.out.println("Erro ao cadastrar.");
        }
    }
    
    private static void listarCursos() {
        System.out.println("");
        ArrayList<Curso> listaCursos = verificador.getCursos();
        for (int i = 0; i < listaCursos.size(); i++) {
            System.out.println(listaCursos.get(i).getNome());
        }
        System.out.println("");
    }
}
