package ifpr.pgua.eic.listatelefonica;

import ifpr.pgua.eic.listatelefonica.classes.Escola;
import ifpr.pgua.eic.listatelefonica.controllers.JanelaPrincipal;
import ifpr.pgua.eic.listatelefonica.controllers.ListaDeAlunos;
import ifpr.pgua.eic.listatelefonica.controllers.ListaDeCursos;
import ifpr.pgua.eic.listatelefonica.controllers.ListaDeProfessores;
import ifpr.pgua.eic.listatelefonica.controllers.MatricularAluno;
import ifpr.pgua.eic.listatelefonica.controllers.TelaDeCadastroAluno;
import ifpr.pgua.eic.listatelefonica.controllers.TelaDeCadastroCurso;
import ifpr.pgua.eic.listatelefonica.controllers.TelaDeCadastroProfessor;
import ifpr.pgua.eic.listatelefonica.utils.BaseAppNavigator;
import ifpr.pgua.eic.listatelefonica.utils.ScreenRegistryFXML;



/**
 * JavaFX App
 */
public class App extends BaseAppNavigator {

    
    private Escola escola;

    @Override
    public void init() throws Exception {
        super.init();

        escola = new Escola("A", "123");
        escola.carregarDados();
        
    }

    @Override
    public void stop() throws Exception {
        escola.salvarDados();
        super.stop();
    }


    @Override
    public String getHome() {
        // TODO Auto-generated method stub
        return "PRINCIPAL";
    }


    @Override
    public String getAppTitle() {
        // TODO Auto-generated method stub
        return "Lista Telefônica";
    }
    
    @Override
    public void registrarTelas() {
        registraTela("PRINCIPAL",new ScreenRegistryFXML(App.class, "principal.fxml", o->new JanelaPrincipal()));
        registraTela("CADASTROALUNO",new ScreenRegistryFXML(App.class, "cadastroAluno.fxml", o->new TelaDeCadastroAluno(escola)));
        registraTela("LISTAALUNOS",new ScreenRegistryFXML(App.class, "listaAlunos.fxml", o->new ListaDeAlunos(escola)));
        registraTela("CADASTROPROFESSOR",new ScreenRegistryFXML(App.class, "cadastroProfessor.fxml", o->new TelaDeCadastroProfessor(escola)));
        registraTela("CADASTROCURSO",new ScreenRegistryFXML(App.class, "cadastroCurso.fxml", o->new TelaDeCadastroCurso(escola)));
        registraTela("LISTAPROFESSORES",new ScreenRegistryFXML(App.class, "listaProfessores.fxml", o->new ListaDeProfessores(escola)));
        registraTela("LISTACURSOS",new ScreenRegistryFXML(App.class, "listarCursos.fxml", o->new ListaDeCursos(escola)));
        registraTela("MATRICULARALUNO",new ScreenRegistryFXML(App.class, "matricularAluno.fxml", o->new MatricularAluno(escola)));
    }

}