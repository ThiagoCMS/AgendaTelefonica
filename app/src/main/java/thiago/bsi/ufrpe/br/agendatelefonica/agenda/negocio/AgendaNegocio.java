package thiago.bsi.ufrpe.br.agendatelefonica.agenda.negocio;

import android.content.Context;

import java.util.List;

import thiago.bsi.ufrpe.br.agendatelefonica.agenda.dominio.Agenda;
import thiago.bsi.ufrpe.br.agendatelefonica.agenda.dominio.Contato;
import thiago.bsi.ufrpe.br.agendatelefonica.database.AppDatabase;
import thiago.bsi.ufrpe.br.agendatelefonica.infra.Sessao;

public class AgendaNegocio {
    public void inserirAgenda(Agenda agenda){
        AppDatabase database = AppDatabase.getDatabase();
        database.agendaDao().insertAgenda(agenda);
    }

    public List<Agenda> recuperarAgendas(){
        AppDatabase database = AppDatabase.getDatabase();
        List<Agenda> agendaList = database.agendaDao().loadAllAgenda();
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
}
