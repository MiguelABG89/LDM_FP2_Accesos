package code.eliminar;

import Singleton.EmfSingleton;
import entities.ProjectEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import libs.Leer;

public class drpProject {
    public static void eliminarProject() {
        String code = Leer.pedirCadena("Introduzca el ID del proyecto que desea eliminar");

        EntityManagerFactory emf = EmfSingleton.getInstance().getEmf();
        EntityManager em = emf.createEntityManager();
        try {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();

            // Buscar el proyecto por el código
            ProjectEntity project = em.find(ProjectEntity.class, code);

            if (project != null) {
                // Si el proyecto existe, se elimina
                em.remove(project);
                System.out.println("Proyecto eliminado exitosamente.");
            } else {
                System.err.println("No se encontró ningun proyecto con el ID proporcionado.");
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
