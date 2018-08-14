package thiago.bsi.ufrpe.br.agendatelefonica.agenda.gui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import thiago.bsi.ufrpe.br.agendatelefonica.R;
import thiago.bsi.ufrpe.br.agendatelefonica.agenda.negocio.AgendaNegocio;
import thiago.bsi.ufrpe.br.agendatelefonica.infra.Sessao;

public class EditarAgendaActivity extends AppCompatActivity {
    private EditText nome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_agenda);
        setTela();
    }

    private void setTela(){
        nome = findViewById(R.id.nomeEditarAgendaId);
        nome.setText(Sessao.instance.getAgenda().getNome());
        Button btEditar = findViewById(R.id.btEditarAgendaId);
        btEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickEditar();
            }
        });
        Button btExcluir = findViewById(R.id.btApagarAgendaId);
        btExcluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickExcluir();
            }
        });
    }

    private void clickEditar(){
        Sessao.instance.getAgenda().setNome(nome.getText().toString().trim());
        new AgendaNegocio().atualizarAgenda(Sessao.instance.getAgenda(), this);
        onBackPressed();
    }

    private void clickExcluir(){
        new AgendaNegocio().deletarAgenda(Sessao.instance.getAgenda(), this);
        Sessao.instance.resetAgenda();
        startActivity(new Intent(EditarAgendaActivity.this, AgendasActivity.class));
        finish();
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(EditarAgendaActivity.this, ContatosActivity.class));
        finish();
    }
}
