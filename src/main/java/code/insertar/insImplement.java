package code.insertar;

import Singleton.EmfSingleton;
import entities.EntityEntity;
import entities.ImplementEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import libs.Leer;

public class insImplement {
    public static void insertarImplement() {
        int idProyecto = Leer.pedirEntero("Introduzca el ID del proyecto");
        int idTecnologia = Leer.pedirEntero("Introduzca el ID de la tecnologia");

        EntityManagerFactory emf = EmfSingleton.getInstance().getEmf();
        EntityManager em = emf.createEntityManager();
        try {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();

            ImplementEntity implement = new ImplementEntity();
            implement.setIdProject(idProyecto);
            implement.setIdTechnology(idTecnologia);

            em.persist(implement);
            transaction.commit();
        } catch (Exception e) {
            System.err.println(">>> Error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
