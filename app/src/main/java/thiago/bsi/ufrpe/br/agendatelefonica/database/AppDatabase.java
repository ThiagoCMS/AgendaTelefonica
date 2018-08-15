package thiago.bsi.ufrpe.br.agendatelefonica.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import thiago.bsi.ufrpe.br.agendatelefonica.agenda.dao.AgendaDao;
import thiago.bsi.ufrpe.br.agendatelefonica.agenda.dominio.Agenda;
import thiago.bsi.ufrpe.br.agendatelefonica.agenda.dominio.Contato;
import thiago.bsi.ufrpe.br.agendatelefonica.infra.MyApp;

@Database(entities = {Agenda.class, Contato.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase instance;
    private static boolean tempDatabase = false;

    public abstract AgendaDao agendaDao();

    public static AppDatabase getDatabase(){
        if(instance == null) {
            if (tempDatabase) {
                instance = Room.inMemoryDatabaseBuilder(MyApp.getContext(), AppDatabase.class).allowMainThreadQueries().build();
            }else{
                instance = Room.databaseBuilder(MyApp.getContext(), AppDatabase.class, "Agendas").fallbackToDestructiveMigration().build();
            }
        }
        return instance;
    }
}
