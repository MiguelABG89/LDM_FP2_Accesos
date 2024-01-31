package ExistDB.Data;

import ExistDB.Entities.Centros;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.File;

public class CargarDatosJsonCentros {
    public static void cargarObjetos(){
        File archivoCentros = new File("target/Centros.xml");
        Centros centros = new Centros();
        try {
            JAXBContext context = JAXBContext.newInstance(Centros.class);
        }catch (JAXBException e){
            e.printStackTrace();
        }
    }
}
