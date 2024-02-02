package ExistDB.Data;

import ExistDB.Entities.Centro;
import ExistDB.Entities.Centros;
import ExistDB.Entities.Familia;
import ExistDB.Entities.Familias;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
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
    }
}
