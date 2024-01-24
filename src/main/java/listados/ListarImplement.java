package listados;

import Singleton.EmfSingleton;
import entities.ImplementEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.ArrayList;

public class ListarImplement {

    static EntityManager em = EmfSingleton.getInstance().getEmf().createEntityManager();

    public static void listarImplement() {

        System.out.println("\n-*-*-[ LISTADO DE IMPLEMENTACIONES ]-*-*-");

        // Consulta para obtener las implementaciones.
        Query listadoImplements = em.createQuery("from ImplementEntity ");
        ArrayList<ImplementEntity> listaImplements = (ArrayList<ImplementEntity>) listadoImplements.getResultList();

        for (ImplementEntity i : listaImplements) {

            // MOSTRAR LOS DATOS EN PANTALLA ----------
            System.out.println("\n- ID DE IMPLEMENTACIÓN: " + i.getId());
            System.out.println("- ID PROYECTO: " + i.getIdProject());
            System.out.println("- ID TECNOLOGÍA: " + i.getIdTechnology());
            System.out.println("***********************************************************");

        }

        em.close();
    }

}
