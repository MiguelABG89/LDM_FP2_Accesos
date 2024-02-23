package ExistDB.Data.CargarDatosXml;

import ExistDB.Data.GenerarJsons.GenerarJsonFamilias;
import ExistDB.Entities.Familia;
import ExistDB.Entities.Familias;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import java.nio.file.Path;

public class CargarDatosJsonFamilias {
    public static void cargarObjetos(){
        Path archivoCentros = Path.of("target/Familias.xml");
        Familias familias = new Familias();
        try {
            JAXBContext context = JAXBContext.newInstance(Familias.class, Familia.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            familias = (Familias) unmarshaller.unmarshal(archivoCentros.toFile());
            System.out.println(familias.getFamilias());
        }catch (JAXBException e){
            e.printStackTrace();
        }
        GenerarJsonFamilias.generarJson(familias);
    }
}
