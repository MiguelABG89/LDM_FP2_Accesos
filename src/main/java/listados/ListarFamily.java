package listados;

import Singleton.EmfSingleton;
import entities.FamilyEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;

import java.util.ArrayList;

public class ListarFamily {
    static EntityManagerFactory emf = EmfSingleton.getInstance().getEmf();
    static EntityManager em = emf.createEntityManager();

    public static void listarFamily() {

        System.out.println("\n-*-*-[ LISTADO DE FAMILIAS ]-*-*-");

        // Consulta para obtener las familias.
        Query listadoFamilias = em.createQuery("from FamilyEntity ");
        ArrayList<FamilyEntity> listaFamilias = (ArrayList<FamilyEntity>) listadoFamilias.getResultList();

        for (FamilyEntity f : listaFamilias) {

            // MOSTRAR LOS DATOS EN PANTALLA ----------
            System.out.println("\n*******[ FAMILIA " + f.getFamilyName() + " ]*******");
            System.out.println("- ID FAMILIA: " + f.getId());
            System.out.println("- CÓDIGO: " + f.getFamilyCode());
            System.out.println("***********************************************************");

        }

        em.close();
    }

}
