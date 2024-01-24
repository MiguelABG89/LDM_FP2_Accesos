package code.insertar;

import Singleton.EmfSingleton;
import entities.CollaborationEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import libs.Leer;

public class insCollaboration {
    public static void insertarCollaboration() {
        int idProyecto = Leer.pedirEntero("Introduzca el ID del proyecto");
        int idUsuario = Leer.pedirEntero("Introduzca el ID del usuario");
        int idFamilia = Leer.pedirEntero("Introduzca el ID de la familia");
        Boolean esAdmin = Leer.pedirBoolean("El usuario es administrador (S/N)");

        EntityManagerFactory emf = EmfSingleton.getInstance().getEmf();
        EntityManager em = emf.createEntityManager();
        try {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();


            CollaborationEntity collaboration = new CollaborationEntity();
            collaboration.setIdProject(idProyecto);
            collaboration.setIdUser(idUsuario);
            collaboration.setIdFamily(idFamilia);
            collaboration.setManager(esAdmin);

            em.persist(collaboration);
            transaction.commit();
        } catch (Exception e) {
            System.err.println(">>> Error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
