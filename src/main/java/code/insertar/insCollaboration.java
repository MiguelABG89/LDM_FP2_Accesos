package code.insertar;

import Singleton.EmfSingleton;
import entities.CollaborationEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import libs.Leer;

public class insCollaboration {
    public static void insertarCollaboration() {
        Long idProyecto = Leer.pedirLong("Introduzca el ID del proyecto");
        Long idUsuario = Leer.pedirLong("Introduzca el ID del usuario");
        Long idFamilia = Leer.pedirLong("Introduzca el ID de la familia");
        boolean userAdmin = Leer.pedirBoolean("El usuario es administrador (S/N)");
        byte esAdmin = 0;

        if (userAdmin) {
            esAdmin = 1;
        }

        EntityManagerFactory emf = EmfSingleton.getInstance().getEmf();
        EntityManager em = emf.createEntityManager();
        try {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();


            CollaborationEntity collaboration = new CollaborationEntity();
            collaboration.setIdProject(idProyecto);
            collaboration.setIdUser(idUsuario);
            collaboration.setIdFamily(idFamilia);
            collaboration.setIsManager(esAdmin);

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
