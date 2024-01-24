package code.eliminar;

import Singleton.EmfSingleton;
import entities.ImplementEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import libs.Leer;

public class drpImplement {
    public static void eliminarImplement() {
        String code = Leer.pedirCadena("Introduzca el ID del implement que desea eliminar");

        EntityManagerFactory emf = EmfSingleton.getInstance().getEmf();
        EntityManager em = emf.createEntityManager();
        try {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();

            // Buscar el implement por el código
            ImplementEntity implement = em.find(ImplementEntity.class, code);

            if (implement != null) {
                // Si el implement existe, eliminarla
                em.remove(implement);
                System.out.println("Implement eliminado exitosamente.");
            } else {
                System.err.println("No se encontró ningun implement con el ID proporcionado.");
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
