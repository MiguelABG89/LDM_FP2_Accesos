package ExistDB.Data.CargarDatosXml;

import ExistDB.Data.GenerarJsons.GenerarJsonCentros;
import ExistDB.Entities.Centro;
import ExistDB.Entities.Centros;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

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
        GenerarJsonCentros.generarJson(centros);
    }
}
