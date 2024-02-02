package ExistDB.Data.GenerarJsons;

import ExistDB.Entities.Centros;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class GenerarJsonCentros {
    public static void generarJson(Centros centros){
        Path p = Path.of("target/Centros.json");
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.setPrettyPrinting().create();
        String jsonListaCentros = gson.toJson(centros);
        try {
            Files.writeString(p, jsonListaCentros);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
