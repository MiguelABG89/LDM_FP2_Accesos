package listados;

import Singleton.EmfSingleton;
import entities.FavouriteEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.ArrayList;

public class ListarFavourite {

    static EntityManager em = EmfSingleton.getInstance().getEmf().createEntityManager();

    public static void listarFavourite() {

        System.out.println("\n-*-*-[ FAVORITOS ]-*-*-");

        // Consulta para obtener los favoritos.
        Query listadoFavoritos = em.createQuery("from FavouriteEntity ");
        ArrayList<FavouriteEntity> listaFavoritos = (ArrayList<FavouriteEntity>) listadoFavoritos.getResultList();

        for (FavouriteEntity f : listaFavoritos) {

            // MOSTRAR LOS DATOS EN PANTALLA ----------
            System.out.println("\n- ID DE FAVORITO: " + f.getId());
            System.out.println("- ID DE PROYECTO: " + f.getIdProject());
            System.out.println("- ID DE USUARIO: " + f.getIdUser());
            System.out.println("***********************************************************");

        }

        em.close();
    }

}
