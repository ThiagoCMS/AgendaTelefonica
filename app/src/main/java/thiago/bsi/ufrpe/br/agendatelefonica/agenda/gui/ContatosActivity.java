package thiago.bsi.ufrpe.br.agendatelefonica.agenda.gui;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import thiago.bsi.ufrpe.br.agendatelefonica.R;
import thiago.bsi.ufrpe.br.agendatelefonica.agenda.negocio.AgendaNegocio;
import thiago.bsi.ufrpe.br.agendatelefonica.infra.Sessao;

public class ContatosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contatos);
        setTela();
    }

    private void setTela(){
        Sessao.instance.getAgenda().setContatos(new AgendaNegocio().recuperarContatosAgenda(Sessao.instance.getAgenda()));
        ListView listView = findViewById(R.id.contatoListViewId);
        listView.setAdapter(new ContatosAdapter(Sessao.instance.getAgenda().getContatos(), this));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                editarContato(position);
            }
        });
        FloatingActionButton fabCriarContato = findViewById(R.id.fabContatoId);
        fabCriarContato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                criarContato();
            }
        });
        FloatingActionButton fabEditarAgenda = findViewById(R.id.fabEditarAgendaId);
        fabEditarAgenda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editarAgenda();
            }
        });
    }

    private void criarContato(){
        startActivity(new Intent(ContatosActivity.this, CriarContatoActivity.class));
        finish();
    }

    private void editarAgenda(){
        startActivity(new Intent(ContatosActivity.this, EditarAgendaActivity.class));
        finish();
    }

    private void editarContato(int position){
        Sessao.instance.setContato(Sessao.instance.getAgenda().getContatos().get(position));
        startActivity(new Intent(ContatosActivity.this, EditarContatoActivity.class));
        finish();
    }

    @Override
    public void onBackPressed() {
        Sessao.instance.resetAgenda();
        startActivity(new Intent(ContatosActivity.this, AgendasActivity.class));
        finish();
    }
}
