package ExistDB;

import com.aspose.cells.Workbook;
import org.w3c.dom.Node;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.Resource;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XMLResource;

import java.io.File;

public class InsertarXML {
    static Collection col = null;
    static Node nodo = null;
    static XMLResource nodoDom = null;
    //Metodo para pasar de CSV a XML utilizando la dependencia AsposeJavaAPI
    public static void CSVtoXML(){
        try {
            //creamos el workbook de cada csv y luego lo guardamos donde queremos que se situe
            Workbook workbook = new Workbook("src/main/resources/CentrosCFGMyS.csv");
            Workbook workbook2 = new Workbook("src/main/resources/proyectos.csv");
            workbook.save("src/main/resources/CentrosCFGMyS.xml");
            workbook2.save("src/main/resources/proyectos.xml");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    //Metodo para insertar los datos Xml a la colecion de ExistDb
    public static void Insertar(){

        File XmlFamilia = new File("src/main/resources/familias.xml");
        File XmlProyectosFP = new File("src/main/resources/proyectosFP.xml");
        File XmlCentros = new File("src/main/resources/CentrosCFGMyS.xml");
        File XmlProyectos = new File("src/main/resources/proyectos.xml");

        col = ConexionCollection.conectar();

        if (col!=null) {
            //Manera de insertar el xml
            System.out.println("Exito de conexion");
            if (!XmlFamilia.canRead()){
                System.out.println("Error al intentar leer el documento Familias");
            }else {
                try {
                    Resource resource = col.createResource(XmlFamilia.getName(),"XMLResource");
                    resource.setContent(XmlFamilia);
                    col.storeResource(resource);
                }catch (XMLDBException e){
                    throw new RuntimeException(e);
                }

            }
            if (!XmlProyectosFP.canRead()){
                System.out.println("Error al intentar leer el documento ProyectosFP");
            }else {
                try {
                    Resource resource = col.createResource(XmlProyectosFP.getName(),"XMLResource");
                    resource.setContent(XmlProyectosFP);
                    col.storeResource(resource);
                }catch (XMLDBException e){
                    throw new RuntimeException(e);
                }
            }
            if (!XmlCentros.canRead()){
                System.out.println("Error al intentar leer el documento Centros");
            }else {
                try {
                    Resource resource = col.createResource(XmlCentros.getName(),"XMLResource");
                    resource.setContent(XmlCentros);
                    col.storeResource(resource);
                }catch (XMLDBException e){
                    throw new RuntimeException(e);
                }

            }
            if (!XmlProyectos.canRead()){
                System.out.println("Error al intentar leer el documento Proyectos");
            }else {
                try {
                    Resource resource = col.createResource(XmlProyectos.getName(),"XMLResource");
                    resource.setContent(XmlProyectos);
                    col.storeResource(resource);
                }catch (XMLDBException e){
                    throw new RuntimeException(e);
                }

            }
        }
    }

}
