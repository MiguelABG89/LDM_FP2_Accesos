package code.eliminar;

import Singleton.EmfSingleton;
import entities.TechnologyEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import libs.Leer;

public class drpTechnology {
    public static void eliminarTechnology() {
        String code = Leer.pedirCadena("Introduzca el ID de la tecnologia que desea eliminar");

        EntityManagerFactory emf = EmfSingleton.getInstance().getEmf();
        EntityManager em = emf.createEntityManager();
        try {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();

            // Buscar la tecnologia por el código
            TechnologyEntity technology = em.find(TechnologyEntity.class, code);

            if (technology != null) {
                // Si la tecnologia existe, se elimina
                em.remove(technology);
                System.out.println("Tecnologia eliminada exitosamente.");
            } else {
                System.err.println("No se encontró ninguna tecnologia con el ID proporcionado.");
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
