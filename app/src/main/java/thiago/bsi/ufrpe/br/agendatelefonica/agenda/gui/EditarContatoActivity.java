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

public class EditarContatoActivity extends AppCompatActivity {
    private EditText nome;
    private EditText numero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_contato);
        setTela();
    }

    private void setTela(){
        nome = findViewById(R.id.editarNomeContatoId);
        nome.setText(Sessao.instance.getContato().getNome());
        numero = findViewById(R.id.editarNumeroContatoId);
        numero.setText(Sessao.instance.getContato().getNumero());
        Button btEditar = findViewById(R.id.btEditarContatoId);
        btEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editarContato();
            }
        });
        Button btExcluir = findViewById(R.id.btExcluirContatoId);
        btExcluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                excluirContato();
            }
        });
    }

    private void editarContato(){
        Sessao.instance.getContato().setNome(nome.getText().toString().trim());
        Sessao.instance.getContato().setNumero(numero.getText().toString().trim());
        new AgendaNegocio().atualizarAgenda(Sessao.instance.getAgenda());
        onBackPressed();
    }

    private void excluirContato(){
        Sessao.instance.getAgenda().getContatos().remove(Sessao.instance.getContato());
        new AgendaNegocio().atualizarAgenda(Sessao.instance.getAgenda());
        onBackPressed();
    }

    @Override
    public void onBackPressed() {
        Sessao.instance.resetContato();
        startActivity(new Intent(EditarContatoActivity.this, ContatosActivity.class));
        finish();
    }
}
