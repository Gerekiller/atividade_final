package ifpr.pgua.eic.listatelefonica.classes;

import java.util.ArrayList;

public class Curso {

    private int codigo;
    private String nome;
    private String descricao;
    private int cargaHoraria;
    private Professor professor;
    private ArrayList<Aluno> alunos;

    public Curso(int codigo, String nome, String descricao, int cargaHoraria, Professor professor){
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.cargaHoraria = cargaHoraria;
        this.professor = professor;
        alunos = new ArrayList<>();
    }

    public boolean matriculaAluno(Aluno aluno){
        for(int i=0; i<alunos.size();i++){
            if(alunos.get(i).equals(aluno)){
                return false;
            }
        }
        this.alunos.add(aluno);
        return true;
    }

    public boolean desmatriculaAluno(Aluno aluno){
        for(int i=0; i<alunos.size();i++){
            if(alunos.get(i).equals(aluno)){
                this.alunos.remove(aluno);
                return true;
            }
        }
        return false;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(ArrayList<Aluno> alunos) {
        this.alunos = alunos;
    }

    public String toString(){
        String str = ""+this.getNome();
        return str;
    }
}
