package code.comprobacionesIDs;

import Singleton.EmfSingleton;
import entities.TechnologyEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.ArrayList;

public class compIDTechnology {

    static EntityManager em = EmfSingleton.getInstance().getEmf().createEntityManager();

    public static boolean compIdTech(int idTechUsuario) {

        // Declaración de variables -----------------
        boolean idEncontrado = false;

        // Consulta para obtener los Id de Technology.
        Query listadoTechnology = em.createQuery("from TechnologyEntity ");
        ArrayList<TechnologyEntity> listaTechnology = (ArrayList<TechnologyEntity>) listadoTechnology.getResultList();

        System.out.println("\n****[ FILTRADO DE TECNOLOGÍAS ]****\n");

        // Verificar si la lista de tecnologías está vacía.
        if (listaTechnology.isEmpty()) {
            System.err.println("\n>>> No se encontraron tecnologías en la BBDD.");
        } else {

            for (TechnologyEntity f : listaTechnology) {
                if (f.getId().equals(idTechUsuario)) {
                    System.out.println("\n>>> Se ha seleccionado la tecnología: " + f.getTechName());
                    idEncontrado = true;
                }
            }

            // Informar al usuario si no se encontró ninguna TECHNOLOGY con el ID proporcionado.
            if (!idEncontrado) {
                System.err.println("\n>>> No se encontraron tecnologías con el ID '" + idTechUsuario + "'.");
            }
        }
        return idEncontrado;
    }
}
