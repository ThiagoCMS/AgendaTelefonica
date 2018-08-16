package thiago.bsi.ufrpe.br.agendatelefonica.agenda.dominio;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Agenda {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String Nome;
    @Ignore
    private List<Contato> contatos;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
}
