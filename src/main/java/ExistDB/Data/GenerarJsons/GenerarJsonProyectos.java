package ExistDB.Data.GenerarJsons;

import ExistDB.Entities.Proyectos;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class GenerarJsonProyectos {
    public static void generarJson(Proyectos proyectos){
        Path p = Path.of("target/Proyectos.json");
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.setPrettyPrinting().create();
        String jsonListaProyectos = gson.toJson(proyectos);
        try {
            Files.writeString(p, jsonListaProyectos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
