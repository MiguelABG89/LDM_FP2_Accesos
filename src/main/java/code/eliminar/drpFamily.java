package code.eliminar;

import Singleton.EmfSingleton;
import entities.FamilyEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import libs.Leer;

public class drpFamily {
    public static void eliminarFamily() {
        String code = Leer.pedirCadena("Introduzca el ID de la familia que desea eliminar");

        EntityManagerFactory emf = EmfSingleton.getInstance().getEmf();
        EntityManager em = emf.createEntityManager();
        try {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();

            // Buscar la familia por el código
            FamilyEntity family = em.find(FamilyEntity.class, code);

            if (family != null) {
                // Si la familia existe, se elimina
                em.remove(family);
                System.out.println("Familia eliminada exitosamente.");
            } else {
                System.err.println("No se encontró ninguna familia con el ID proporcionado.");
            }

            transaction.commit();
        } catch (Exception e) {
            System.err.println(">>> Error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}