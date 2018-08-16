package thiago.bsi.ufrpe.br.agendatelefonica.agenda.negocio;

import java.util.List;

import thiago.bsi.ufrpe.br.agendatelefonica.agenda.dominio.Agenda;
import thiago.bsi.ufrpe.br.agendatelefonica.agenda.dominio.Contato;
import thiago.bsi.ufrpe.br.agendatelefonica.database.AppDatabase;

public class AgendaNegocio {
    public void inserirAgenda(Agenda agenda){
        AppDatabase database = AppDatabase.getDatabase();
        database.agendaDao().insertAgenda(agenda);
    }

    public List<Agenda> recuperarAgendas(){
        AppDatabase database = AppDatabase.getDatabase();
        List<Agenda> agendaList = database.agendaDao().loadAllAgenda();
        for(Agenda agenda: agendaList){
            agenda.setContatos(recuperarContatosAgenda(agenda));
        }
        return agendaList;
    }

    public void deletarAgenda(Agenda agenda){
        AppDatabase database = AppDatabase.getDatabase();
        database.agendaDao().deleteAgenda(agenda);
    }

    public void atualizarAgenda(Agenda agenda){
        AppDatabase database = AppDatabase.getDatabase();
        database.agendaDao().updateAgenda(agenda);
    }

    public void inserirContato(Contato contato){
        AppDatabase database = AppDatabase.getDatabase();
        database.agendaDao().insertContato(contato);
    }

    public void deletarContato(Contato contato){
        AppDatabase database = AppDatabase.getDatabase();
        database.agendaDao().deleteContato(contato);
    }

    public void atualizarContato(Contato contato){
        AppDatabase database = AppDatabase.getDatabase();
        database.agendaDao().updateContato(contato);
    }

    public List<Contato> recuperarContatosAgenda(Agenda agenda){
        AppDatabase database = AppDatabase.getDatabase();
        return database.agendaDao().loadAgendaContatos(agenda.getId());
    }
}
