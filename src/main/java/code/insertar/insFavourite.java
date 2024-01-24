package code.insertar;

import Singleton.EmfSingleton;
import entities.FavouriteEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import libs.Leer;

public class insFavourite {
    public static void insertarFavourite() {
        Long idProyecto = Leer.pedirLong("Introduzca el ID del proyecto");
        Long idUsuario = Leer.pedirLong("Introduzca el ID del usuario");

        EntityManagerFactory emf = EmfSingleton.getInstance().getEmf();
        EntityManager em = emf.createEntityManager();
        try {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();

            FavouriteEntity favourtie = new FavouriteEntity();
            favourtie.setIdProject(idProyecto);
            favourtie.setIdUser(idUsuario);

            em.persist(favourtie);
            transaction.commit();
        } catch (Exception e) {
            System.err.println(">>> Error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
