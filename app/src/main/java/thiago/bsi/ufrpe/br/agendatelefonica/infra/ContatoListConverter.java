package thiago.bsi.ufrpe.br.agendatelefonica.infra;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import thiago.bsi.ufrpe.br.agendatelefonica.agenda.dominio.Contato;

public class ContatoListConverter {
    @TypeConverter
    public String fromList(List<Contato> list){
        return new Gson().toJson(list);
    }
    @TypeConverter
    public List<Contato> fromString(String string){
        Type listType = new TypeToken<ArrayList<Contato>>() {}.getType();
        return new Gson().fromJson(string, listType);
    }
}
