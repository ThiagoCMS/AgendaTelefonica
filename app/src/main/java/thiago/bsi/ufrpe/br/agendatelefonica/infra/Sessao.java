package thiago.bsi.ufrpe.br.agendatelefonica.infra;

import java.util.HashMap;
import java.util.Map;

import thiago.bsi.ufrpe.br.agendatelefonica.agenda.dominio.Agenda;
import thiago.bsi.ufrpe.br.agendatelefonica.agenda.dominio.Contato;

public class Sessao {
    public static final Sessao instance = new Sessao();
    private Map<String, Object> values = new HashMap<>();

    private Sessao(){}

    private void setValue(String string, Object object){
        values.put(string, object);
    }

    public void setAgenda(Agenda agenda){
        setValue("sessao.agenda", agenda);
    }

    public Agenda getAgenda(){
        return (Agenda) values.get("sessao.agenda");
    }

    public void resetAgenda(){
        setAgenda(null);
    }

    public void setContato(Contato contato){
        setValue("sessao.contato", contato);
    }

    public Contato getContato(){
        return (Contato) values.get("sessao.contato");
    }

    public void resetContato(){
        setContato(null);
    }

    public void reset(){
        setAgenda(null);
        setContato(null);
    }
}
