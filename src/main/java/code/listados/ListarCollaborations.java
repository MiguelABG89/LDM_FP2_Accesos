package code.listados;

import Singleton.EmfSingleton;
import entities.CollaborationEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.ArrayList;

public class ListarCollaborations {

    static EntityManager em = EmfSingleton.getInstance().getEmf().createEntityManager();

    public static void listarCollab() {

        System.out.println("\n-*-*-[ LISTADO DE COLABORACIONES ]-*-*-");

        // Consulta para obtener las colaboraciones.
        Query listadoCollabs = em.createQuery("from CollaborationEntity");
        ArrayList<CollaborationEntity> listaCollabs = (ArrayList<CollaborationEntity>) listadoCollabs.getResultList();

        for (CollaborationEntity c : listaCollabs) {

            // MOSTRAR LOS DATOS EN PANTALLA ----------
            System.out.println("\n- ID DE COLABORACIÓN: " + c.getId());
            System.out.println("- ID DE PROYECTO: " + c.getIdProject());
            System.out.println("- ID DE USUARIO: " + c.getIdUser());
            System.out.println("- ID DE FAMILIA: " + c.getIdFamily());
            System.out.println("- MANAGER: " + c.getManager());
            System.out.println("***********************************************************");

        }

        em.close();
    }
}
