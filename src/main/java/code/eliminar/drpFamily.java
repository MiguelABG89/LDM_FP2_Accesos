package code.eliminar;

import Singleton.EmfSingleton;
import entities.EntityEntity;
import entities.FamilyEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import libs.Leer;

public class drpFamily {
    public static void eliminarEntity() {
        String code = Leer.pedirCadena("Introduzca el ID de la familia que desea eliminar");

        EntityManagerFactory emf = EmfSingleton.getInstance().getEmf();
        EntityManager em = emf.createEntityManager();
        try {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();

            // Buscar la entidad por el código
            FamilyEntity family = em.find(FamilyEntity.class, code);

            if (family != null) {
                // Si la entidad existe, se elimina
                em.remove(family);
                System.out.println("Familia eliminada exitosamente.");
            } else {
                System.out.println("No se encontró ninguna familia con el ID proporcionado.");
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
