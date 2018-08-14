package thiago.bsi.ufrpe.br.agendatelefonica.agenda.negocio;

import android.content.Context;

import java.util.List;

import thiago.bsi.ufrpe.br.agendatelefonica.agenda.dominio.Agenda;
import thiago.bsi.ufrpe.br.agendatelefonica.agenda.dominio.Contato;
import thiago.bsi.ufrpe.br.agendatelefonica.database.AppDatabase;
import thiago.bsi.ufrpe.br.agendatelefonica.infra.Sessao;

public class AgendaNegocio {
    public void inserirAgenda(Agenda agenda, Context context){
        AppDatabase database = AppDatabase.getDatabase(context);
        database.agendaDao().insertAgenda(agenda);
    }

    public List<Agenda> recuperarAgendas(Context context){
        AppDatabase database = AppDatabase.getDatabase(context);
        List<Agenda> agendaList = database.agendaDao().loadAllAgenda();
        for(Agenda agenda: agendaList){
            agenda.setContatos(database.agendaDao().loadContatos(agenda.getId()));
        }
        return agendaList;
    }

    public void inserirContato(Contato contato, Context context){
        AppDatabase database = AppDatabase.getDatabase(context);
        database.agendaDao().insertContato(contato);
    }

    public void atualizarContatosSessao(Context context){
        AppDatabase database = AppDatabase.getDatabase(context);
        Sessao.instance.getAgenda().setContatos(database.agendaDao().loadContatos(Sessao.instance.getAgenda().getId()));
    }

    public void deletarAgenda(Agenda agenda, Context context){
        AppDatabase database = AppDatabase.getDatabase(context);
        database.agendaDao().deleteAgenda(agenda);
    }

    public void atualizarAgenda(Agenda agenda, Context context){
        AppDatabase database = AppDatabase.getDatabase(context);
        database.agendaDao().updateAgenda(agenda);
    }

    public void atualizarContato(Contato contato, Context context){
        AppDatabase database = AppDatabase.getDatabase(context);
        database.agendaDao().updateContato(contato);
    }

    public void deletarContato(Contato contato, Context context){
        AppDatabase database = AppDatabase.getDatabase(context);
        database.agendaDao().deleteContato(contato);
    }
}
