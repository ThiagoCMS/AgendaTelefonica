package thiago.bsi.ufrpe.br.agendatelefonica.agenda.dominio;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Agenda {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int id;
    private String Nome;
    @Ignore
    private List<Contato> contatos = new ArrayList<>();

    @NonNull
    public int getId() {
        return id;
    }

    public void setId(@NonNull int id) {
        this.id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public List<Contato> getContatos() {
        return contatos;
    }

    public void setContatos(List<Contato> contatos) {
        this.contatos = contatos;
    }

    public void addContato(Contato contato){
        contatos.add(contato);
    }
}
