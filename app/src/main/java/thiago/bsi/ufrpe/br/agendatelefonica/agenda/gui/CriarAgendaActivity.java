package thiago.bsi.ufrpe.br.agendatelefonica.agenda.gui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import thiago.bsi.ufrpe.br.agendatelefonica.R;
import thiago.bsi.ufrpe.br.agendatelefonica.agenda.dominio.Agenda;
import thiago.bsi.ufrpe.br.agendatelefonica.agenda.negocio.AgendaNegocio;

public class CriarAgendaActivity extends AppCompatActivity {
    private EditText nomeAgenda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_agenda);
        setTela();
    }

    private void setTela(){
        nomeAgenda = findViewById(R.id.nomeCriarAgendaId);
        Button btCriarAgenda = findViewById(R.id.btCriarAgendaId);
        btCriarAgenda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                criarAgenda();
            }
        });
    }

    private void criarAgenda(){
        Agenda agenda = new Agenda();
        agenda.setNome(nomeAgenda.getText().toString().trim());
        new AgendaNegocio().inserirAgenda(agenda, this);
        onBackPressed();
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(CriarAgendaActivity.this, AgendasActivity.class));
        this.finish();
    }
}
