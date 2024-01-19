package listados;

import Singleton.EmfSingleton;
import entities.CollaborationEntity;
import entities.TechnologyEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.ArrayList;

public class ListarTechnology {

    static EntityManager em = EmfSingleton.getInstance().getEmf().createEntityManager();

    public static void listarTechnology() {

        System.out.println("\n-*-*-[ LISTADO DE TECNOLOGÍAS ]-*-*-");

        // Consulta para obtener las tecnologías.
        Query listadoTecnologias = em.createQuery("from TechnologyEntity ");
        ArrayList<TechnologyEntity> listaTecnologias = (ArrayList<TechnologyEntity>) listadoTecnologias.getResultList();

        for (TechnologyEntity t : listaTecnologias) {

            // MOSTRAR LOS DATOS EN PANTALLA ----------
            System.out.println("- TECNOLOGÍA: " + t.getTechName());
            System.out.println("- TAG: " + t.getTag()); // todo preguntar qué es
            System.out.println("***********************************************************");

        }

        em.close();
    }
}
