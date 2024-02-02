package ExistDB.Data;

import ExistDB.Entities.Centro;
import ExistDB.Entities.Centros;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.nio.file.Path;

public class CargarDatosJsonCentros {
    public static void cargarObjetos(){
        Path archivoCentros = Path.of("target/Centros.xml");
        Centros centros = new Centros();
        try {
            JAXBContext context = JAXBContext.newInstance(Centros.class, Centro.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            centros = (Centros) unmarshaller.unmarshal(archivoCentros.toFile());
            System.out.println(centros.getCentros());
        }catch (JAXBException e){
            e.printStackTrace();
        }
    }
}
