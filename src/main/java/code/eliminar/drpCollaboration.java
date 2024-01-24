package code.eliminar;

import Singleton.EmfSingleton;
import entities.CollaborationEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import libs.Leer;

public class drpCollaboration {
    public static void eliminarCollaboration() {
        String code = Leer.pedirCadena("Introduzca el ID de la colaboración que desea eliminar");

        EntityManagerFactory emf = EmfSingleton.getInstance().getEmf();
        EntityManager em = emf.createEntityManager();
        try {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();

            // Buscar la colaboración por el código
            CollaborationEntity collaboration = em.find(CollaborationEntity.class, code);

            if (collaboration != null) {
                // Si la colaboración existe, eliminarla
                em.remove(collaboration);
                System.out.println("Colaboración eliminado exitosamente.");
            } else {
                System.err.println("No se encontró ninguna colaboración con el ID proporcionado.");
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
