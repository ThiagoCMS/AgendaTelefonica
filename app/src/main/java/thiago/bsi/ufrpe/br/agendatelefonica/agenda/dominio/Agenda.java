package thiago.bsi.ufrpe.br.agendatelefonica.agenda.dominio;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import thiago.bsi.ufrpe.br.agendatelefonica.infra.ContatoListConverter;

@Entity
public class Agenda {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int id;
    private String Nome;
    @TypeConverters(ContatoListConverter.class)
    private List<Contato> contatos;

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
        if (contatos == null){
            contatos = new ArrayList<>();
        }
        return contatos;
    }

    public void setContatos(List<Contato> contatos) {
        this.contatos = contatos;
    }

    public void addContato(Contato contato){
        if (contatos == null){
            contatos = new ArrayList<>();
        }
        contatos.add(contato);
    }
}
