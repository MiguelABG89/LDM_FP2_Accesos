package code.eliminar;

import Singleton.EmfSingleton;
import entities.EntityEntity;
import entities.FavouriteEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import libs.Leer;

public class drpFavourite {
    public static void eliminarFavourite() {
        String code = Leer.pedirCadena("Introduzca el ID del favorito que desea eliminar");

        EntityManagerFactory emf = EmfSingleton.getInstance().getEmf();
        EntityManager em = emf.createEntityManager();
        try {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();

            // Buscar el favorito por el código
            FavouriteEntity favourite = em.find(FavouriteEntity.class, code);

            if (favourite != null) {
                // Si el favorito existe, eliminarla
                em.remove(favourite);
                System.out.println("Favorito eliminado exitosamente.");
            } else {
                System.err.println("No se encontró ningun favorito con el ID proporcionado.");
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
