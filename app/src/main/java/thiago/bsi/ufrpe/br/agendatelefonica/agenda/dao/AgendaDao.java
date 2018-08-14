package thiago.bsi.ufrpe.br.agendatelefonica.agenda.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import thiago.bsi.ufrpe.br.agendatelefonica.agenda.dominio.Agenda;
import thiago.bsi.ufrpe.br.agendatelefonica.agenda.dominio.Contato;

@Dao
public interface AgendaDao {
    @Insert
    public void insertAgenda(Agenda agenda);

    @Update
    public void updateAgenda(Agenda agenda);

    @Delete
    public void deleteAgenda(Agenda agenda);

    @Query("select * from agenda")
    public List<Agenda> loadAllAgenda();

    @Insert
    public void insertContato(Contato contato);

    @Update
    public void updateContato(Contato contato);

    @Delete
    public void deleteContato(Contato contato);

    @Query("select * from contato where userid = :id")
    public List<Contato> loadContatos(int id);
}
