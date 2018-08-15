package thiago.bsi.ufrpe.br.agendatelefonica.agenda.gui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import thiago.bsi.ufrpe.br.agendatelefonica.R;
import thiago.bsi.ufrpe.br.agendatelefonica.agenda.dominio.Contato;
import thiago.bsi.ufrpe.br.agendatelefonica.agenda.negocio.AgendaNegocio;
import thiago.bsi.ufrpe.br.agendatelefonica.infra.Sessao;

public class CriarContatoActivity extends AppCompatActivity {
    private EditText nomeContato;
    private EditText numeroContato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_contato);
        setTela();
    }

    private void setTela(){
        nomeContato = findViewById(R.id.criarNomeContatoId);
        numeroContato = findViewById(R.id.criarNumeroContatoId);
        Button btCriarContato = findViewById(R.id.btCriarContatoId);
        btCriarContato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickCriar();
            }
        });

    }

    private void clickCriar(){
        Contato contato = new Contato();
        contato.setNome(nomeContato.getText().toString().trim());
        contato.setNumero(numeroContato.getText().toString().trim());
        contato.setAgendaId(Sessao.instance.getAgenda().getId());
        new AgendaNegocio().inserirContato(contato);
        onBackPressed();
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(CriarContatoActivity.this, ContatosActivity.class));
        finish();
    }
}
