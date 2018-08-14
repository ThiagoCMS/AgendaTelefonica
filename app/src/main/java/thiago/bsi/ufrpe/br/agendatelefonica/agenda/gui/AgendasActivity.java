package thiago.bsi.ufrpe.br.agendatelefonica.agenda.gui;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import thiago.bsi.ufrpe.br.agendatelefonica.R;
import thiago.bsi.ufrpe.br.agendatelefonica.agenda.dominio.Agenda;
import thiago.bsi.ufrpe.br.agendatelefonica.agenda.negocio.AgendaNegocio;
import thiago.bsi.ufrpe.br.agendatelefonica.infra.Sessao;

public class AgendasActivity extends AppCompatActivity {
    private List<Agenda> agendaList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agendas);
        setTela();
    }

    private void setTela(){
        agendaList = new AgendaNegocio().recuperarAgendas(this);
        ListView listView = findViewById(R.id.agendaListViewId);
        listView.setAdapter(new AgendasAdapter(agendaList, this));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                clickAgenda(position);
            }
        });
        FloatingActionButton fab = findViewById(R.id.fabAgendaId);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                criarAgenda();
            }
        });
    }

    private void criarAgenda(){
        startActivity(new Intent(AgendasActivity.this, CriarAgendaActivity.class));
        this.finish();
    }

    private void clickAgenda(int position){
        Sessao.instance.setAgenda(agendaList.get(position));
        startActivity(new Intent(AgendasActivity.this, ContatosActivity.class));
        finish();
    }
}
