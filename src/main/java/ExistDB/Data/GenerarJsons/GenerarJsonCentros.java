package ExistDB.Data.GenerarJsons;

import ExistDB.Entities.Centro;
import ExistDB.Entities.Centros;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

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
    public static String pasarJson(){
        Centros centros = new Centros();
        Centro c1 = new Centro();
        c1.setNombre("c1");
        Centro c2 = new Centro();
        c1.setNombre("c2");
        List<Centro> ListCentro = new ArrayList<>();
        ListCentro.add(c1);
        ListCentro.add(c2);

        Gson gson = new Gson();
        String jsonListaCentros = gson.toJson(ListCentro);

        return jsonListaCentros;
    }
}
