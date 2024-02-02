package ExistDB.Data;

import ExistDB.Entities.Centro;
import ExistDB.Entities.Centros;
import ExistDB.Entities.Proyecto;
import ExistDB.Entities.Proyectos;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.nio.file.Path;

public class CargarDatosJsonProyectos {
    public static void cargarObjetos(){
        Path archivoCentros = Path.of("target/Proyectos.xml");
        Proyectos proyectos = new Proyectos();
        try {
            JAXBContext context = JAXBContext.newInstance(Proyectos.class, Proyecto.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            proyectos = (Proyectos) unmarshaller.unmarshal(archivoCentros.toFile());
            System.out.println(proyectos.getProyectos());
        }catch (JAXBException e){
            e.printStackTrace();
        }
    }
}
