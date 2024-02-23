package ExistDB.Data.GenerarJsons;

import ExistDB.Entities.Familias;
import ExistDB.Entities.Proyectos;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class GenerarJsonFamilias {
    public static void generarJson(Familias familias){
        Path p = Path.of("target/Familias.json");
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.setPrettyPrinting().create();
        String jsonListaFamilias= gson.toJson(familias);
        try {
            Files.writeString(p, jsonListaFamilias);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
