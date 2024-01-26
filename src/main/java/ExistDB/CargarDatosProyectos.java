package ExistDB;

import org.exist.http.jaxb.Result;
import org.exist.source.Source;
import org.w3c.dom.Node;
import org.xmldb.api.base.*;
import org.xmldb.api.modules.XMLResource;
import org.xmldb.api.modules.XPathQueryService;

import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class CargarDatosProyectos {
    static Collection col = null;
    static Node nodo = null;
    static XMLResource nodoDom = null;

    public static void CargarDatos(){
        String Consulta = "declare variable $xml as document-node() external := doc(\"proyectosFP.xml\");\n" +
                "\n" +
                "<Proyectos>{\n" +
                "    for $row in $xml//Row\n" +
                "    return\n" +
                "        <Proyecto>\n" +
                "            <CENTROCOORDINADOR>{data($row/CENTROCOORDINADOR)}</CENTROCOORDINADOR>\n" +
                "            <TÍTULODELPROYECTO>{data($row/TÍTULODELPROYECTO)}</TÍTULODELPROYECTO>\n" +
                "            <AUTORIZACIÓN>{data($row/AUTORIZACIÓN)}</AUTORIZACIÓN>\n" +
                "            <CONTINUIDAD>{data($row/CONTINUIDAD)}</CONTINUIDAD>\n" +
                "            <COORDINACIÓN>{data($row/COORDINACIÓN)}</COORDINACIÓN>\n" +
                "            <CONTACTO>{data($row/CONTACTO)}</CONTACTO>\n" +
                "            <CENTROSANEXIONADOS>{data($row/CENTROSANEXIONADOS)}</CENTROSANEXIONADOS>\n" +
                "        </Proyecto>\n" +
                "}</Proyectos>\n";
        if (col!=null) {
            try {
                XPathQueryService facturasCod1;
                facturasCod1 = (XPathQueryService) col.getService("XPathQueryService", "3.0");
                col.setProperty("indent", "yes");
                facturasCod1.setProperty("indent", "yes");
                ResourceSet result = facturasCod1.query(Consulta);
                ResourceIterator i;
                i = result.getIterator();
                if (!i.hasMoreResources()) {
                    System.out.println(" LA CONSULTA NO DEVUELVE NADA O ESTÁ MAL ESCRITA");
                }
                while (i.hasMoreResources()) {
                    Resource r = i.nextResource();
                    nodoDom = (XMLResource) r;
                    nodo = nodoDom.getContentAsDOM();
                    //creamos la variables XMLResource que nos permite extraer luego un objeto Node
                }
                File archivo = new File("target/Familias.xml");
                Source source = new DOMSource(nodo); //se crea la fuente xml a partir del resultado de la consulta (Node)
                Result resultado = new StreamResult(archivo);  //se crea el resultado en el archivo
                Transformer transformer = TransformerFactory.newInstance().newTransformer();
                transformer.setOutputProperty(OutputKeys.METHOD, "xml");
                transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
                transformer.setOutputProperty(OutputKeys.INDENT, "yes");
                transformer.setOutputProperty("{http:xml.apache.org/xslt}indent-amount", "4");
                transformer.transform(source, resultado);
                System.out.println(nodo);
                Resource rCol = col.createResource(archivo.getName(), "XMLResource");
                rCol.setContent(archivo);
                col.storeResource(rCol);
                //crear un archivo que lo contiene
                col.close();
            }catch (XMLDBException e){
                System.out.println(" ERROR AL CONSULTAR DOCUMENTO.");
                e.printStackTrace();
            }catch (TransformerConfigurationException e) {
                throw new RuntimeException(e);
            } catch (TransformerException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
