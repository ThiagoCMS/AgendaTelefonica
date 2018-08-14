package thiago.bsi.ufrpe.br.agendatelefonica.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import thiago.bsi.ufrpe.br.agendatelefonica.agenda.dao.AgendaDao;
import thiago.bsi.ufrpe.br.agendatelefonica.agenda.dominio.Agenda;
import thiago.bsi.ufrpe.br.agendatelefonica.agenda.dominio.Contato;

@Database(entities = {Agenda.class, Contato.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase instance;
    private static boolean tempDatabase = true;

    public abstract AgendaDao agendaDao();

    public static AppDatabase getDatabase(Context context){
        if(instance == null) {
            if (tempDatabase) {
                instance = Room.inMemoryDatabaseBuilder(context.getApplicationContext(), AppDatabase.class).allowMainThreadQueries().build();
            }else{
                instance = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "Agendas").allowMainThreadQueries().build();
            }
        }
        return instance;
    }

    public static void destroyInstance(){
        instance = null;
    }
}
