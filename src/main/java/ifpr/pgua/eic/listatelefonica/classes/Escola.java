package ifpr.pgua.eic.listatelefonica.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.google.gson.Gson;

import javafx.scene.control.ListView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Escola {

    private String nome;
    private String telefone;
    private ArrayList<Professor> professores;
    private ArrayList<Aluno> alunos;
    private ArrayList<Curso> cursos;
    
    public Escola(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
        professores = new ArrayList<>();
        alunos = new ArrayList<>();
        cursos = new ArrayList<>();
    }

    public boolean cadastrarAluno(String cpf, String nome, String email, String telefone, LocalDate dataMatricula){
        Aluno novoAluno = new Aluno(cpf, nome, email, telefone, dataMatricula);
        if(buscarAluno(novoAluno.getCpf()) == null){
            this.alunos.add(novoAluno);
            return true;
        }
        return false;
    }

    public boolean cadastrarProfessor(String cpf, String nome, String email, String telefone, double salario){
        Professor novoProfessor = new Professor(cpf, nome, email, telefone, salario);
        if(buscarProfessor(novoProfessor.getCpf()) == null){
            this.professores.add(novoProfessor);
            return true;
        }
        return false;
    }

    public Aluno buscarAluno(String cpf){
        for(int i=0; i<alunos.size();i++){
            if(alunos.get(i).getCpf().equals(cpf)){
                return alunos.get(i);
            }
        }
        return null;
    }

    public Professor buscarProfessor(String cpf){
        for(int i=0; i<professores.size();i++){
            if(professores.get(i).getCpf().equals(cpf)){
                return professores.get(i);
            }
        }
        return null;
    }

    public Curso buscarCurso(String nome){
        for(int i=0; i<cursos.size();i++){
            if(cursos.get(i).getNome().equals(nome)){
                return cursos.get(i);
            }
        }
        return null;
    }

    public boolean cadastrarCurso(int codigo, String nome, String descricao, int cargaHoraria, Professor professor){
        Curso novoCurso = new Curso(codigo, nome, descricao, cargaHoraria, professor);
        if(buscarCurso(novoCurso.getNome()) == null){
            this.cursos.add(novoCurso);
            return true;
        }
        return false;
    }

    
    public boolean matricularAluno(Aluno aluno, Curso curso){
        boolean resultado;
        return resultado = curso.matriculaAluno(aluno);
    }

    public boolean desmatricularAluno(Aluno aluno, Curso curso){
        boolean resultado;
        return resultado = curso.desmatriculaAluno(aluno);
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public ArrayList<Professor> getProfessores() {
        return professores;
    }

    public void setProfessores(ArrayList<Professor> professores) {
        this.professores = professores;
    }

    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(ArrayList<Aluno> alunos) {
        this.alunos = alunos;
    }

    public ArrayList<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(ArrayList<Curso> cursos) {
        this.cursos = cursos;
    }
    
    public void salvarDados() {
        try (FileWriter fout = new FileWriter("professores.txt");
                BufferedWriter bout = new BufferedWriter(fout)) {

            for (Professor professor : professores) {
                bout.write(professor.getCpf() + ";" + professor.getNome() + ";" + professor.getEmail() + ";"+ professor.getTelefone()+";"+professor.getSalario());
                bout.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar professores");
        }

        try (FileWriter fout = new FileWriter("alunos.txt");
                BufferedWriter bout = new BufferedWriter(fout)) {

            for (Aluno aluno : alunos) {
                bout.write(aluno.getCpf() + ";" + aluno.getNome() + ";" + aluno.getEmail() + ";"+ aluno.getTelefone()+";"+aluno.getDataMatricula());
                bout.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar professores");
        }

        try (FileWriter fout = new FileWriter("cursos.txt");
            BufferedWriter bout = new BufferedWriter(fout)) {
            String cpf;
            for (Curso curso: cursos) {
                bout.write(curso.getCodigo() + ";" + curso.getNome()+";"+curso.getDescricao()+";"+curso.getCargaHoraria()+";"+(cpf = curso.getProfessor().getCpf())+";");
                for(Aluno aluno: curso.getAlunos()){
                    bout.write(aluno.getCpf()+","); 
                }
                bout.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar curso");
        }

    }

    public void carregarDados(){
        try (FileReader fin = new FileReader("professores.txt");
                BufferedReader bin = new BufferedReader(fin)) {
            
            String linha = bin.readLine();
            while(linha != null){
                String[] tokens = linha.split(";");
                String cpf = tokens[0];
                String nome = tokens[1];
                String email = tokens[2];
                String telefone = tokens[3];
                double salario = Double.valueOf(tokens[4]);
                Professor professor = new Professor(cpf, nome, email, telefone, salario);

                if(buscarProfessor(cpf)== null){
                    this.professores.add(professor);
                }
                linha = bin.readLine();
            }

        } catch (IOException e) {
            System.out.println("Erro ao carregar itens");
        }
        
        try (FileReader fin = new FileReader("alunos.txt");
                BufferedReader bin = new BufferedReader(fin)) {
            
            String linha = bin.readLine();
            while(linha != null){
                String[] tokens = linha.split(";");
                String cpf = tokens[0];
                String nome = tokens[1];
                String email = tokens[2];
                String telefone = tokens[3];
                LocalDate dataMatricula = LocalDate.parse(tokens[4]);
                
                Aluno aluno = new Aluno(cpf, nome, email, telefone, dataMatricula);

                if(buscarAluno(cpf)== null){
                    this.alunos.add(aluno);
                }
                linha = bin.readLine();
            }

        } catch (IOException e) {
            System.out.println("Erro ao carregar itens");
        }

        try (FileReader fin = new FileReader("cursos.txt");
            BufferedReader bin = new BufferedReader(fin)) {

            String linha = bin.readLine();
            while(linha!=null){
                String[] tokens = new String[5];
                tokens = linha.split(";");
                int codigo = Integer.valueOf(tokens[0]);
                String nome = tokens[1];
                String descricao = tokens[2];
                int cargaHoraria = Integer.valueOf(tokens[3]);
                String cpf = tokens[4];
                Professor professor = buscarProfessor(cpf);

                Curso registraCurso = new Curso(codigo, nome, descricao, cargaHoraria, professor);
                
                if(tokens.length > 5){
                    String[] cpfAluno = tokens[5].split(",");
                    for(String registraAluno:cpfAluno){
                        Aluno aluno = buscarAluno(registraAluno);
                        registraCurso.matriculaAluno(aluno);
                    }   
                }

                if(buscarCurso(nome) == null){
                    this.cursos.add(registraCurso);
                }

                linha = bin.readLine();
            }
            
        } catch (IOException e) {

            System.out.println(e.getMessage());
        }
        
    }
   
    public List<Aluno> buscaAlunoPorNome(String inicio){
        return alunos.stream().filter((aluno)->aluno.getNome().startsWith(inicio)).collect(Collectors.toList());
    }

    public List<Professor> buscaProfessorPorNome(String inicio){
        return professores.stream().filter((professor)->professor.getNome().startsWith(inicio)).collect(Collectors.toList());
    }

    public List<Curso> buscaCursoPorNome(String inicio){
        return cursos.stream().filter((curso)->curso.getNome().startsWith(inicio)).collect(Collectors.toList());
    }
    
}
