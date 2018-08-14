package thiago.bsi.ufrpe.br.agendatelefonica.agenda.gui;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import thiago.bsi.ufrpe.br.agendatelefonica.R;
import thiago.bsi.ufrpe.br.agendatelefonica.agenda.dominio.Agenda;

public class AgendasAdapter extends ArrayAdapter<Agenda> {
    private List<Agenda> agendaList;
    private Context context;

    public AgendasAdapter(@NonNull List<Agenda> agendaList, Context context){
        super(context, R.layout.linha_agenda, agendaList);
        this.agendaList = agendaList;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.linha_agenda, parent, false);
        TextView nomeAgenda = view.findViewById(R.id.nomeAgendaId);
        nomeAgenda.setText(agendaList.get(position).getNome());
        TextView numContatos = view.findViewById(R.id.numeroContatosId);
        numContatos.setText(String.valueOf(agendaList.get(position).getContatos().size()));
        return view;
    }
}
