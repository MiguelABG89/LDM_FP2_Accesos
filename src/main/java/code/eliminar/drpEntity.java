package code.eliminar;

import Singleton.EmfSingleton;
import entities.EntityEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import libs.Leer;

public class drpEntity {
    public static void eliminarEntity() {
        String code = Leer.pedirCadena("Introduzca el ID del centro que desea eliminar");

        EntityManagerFactory emf = EmfSingleton.getInstance().getEmf();
        EntityManager em = emf.createEntityManager();
        try {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();

            // Buscar la entidad por el código
            EntityEntity entity = em.find(EntityEntity.class, code);

            if (entity != null) {
                // Si la entidad existe, eliminarla
                em.remove(entity);
                System.out.println("Centro eliminado exitosamente.");
            } else {
                System.out.println("No se encontró ningun centro con el ID proporcionado.");
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
