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
import thiago.bsi.ufrpe.br.agendatelefonica.agenda.dominio.Contato;
import thiago.bsi.ufrpe.br.agendatelefonica.infra.MyApp;

public class ContatosAdapter extends ArrayAdapter<Contato> {
    private List<Contato> contatoList;
    public ContatosAdapter(@NonNull List<Contato> contatoList){
        super(MyApp.getContext(), R.layout.linha_contato, contatoList);
        this.contatoList = contatoList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) MyApp.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.linha_contato, parent, false);
        TextView nomeContato = view.findViewById(R.id.nomeContatoId);
        nomeContato.setText(contatoList.get(position).getNome());
        TextView numeroContato = view.findViewById(R.id.numeroContatoId);
        numeroContato.setText(contatoList.get(position).getNumero());
        return view;
    }
}
