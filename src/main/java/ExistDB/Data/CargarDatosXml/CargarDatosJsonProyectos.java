package ExistDB.Data.CargarDatosXml;

import ExistDB.Data.GenerarJsons.GenerarJsonProyectos;
import ExistDB.Entities.Centro;
import ExistDB.Entities.Centros;
import ExistDB.Entities.Proyecto;
import ExistDB.Entities.Proyectos;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
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
        GenerarJsonProyectos.generarJson(proyectos);
    }
}
