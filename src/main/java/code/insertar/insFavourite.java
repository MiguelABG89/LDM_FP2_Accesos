package code.insertar;

import Singleton.EmfSingleton;
import entities.FavouriteEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import libs.Leer;

public class insFavourite {
    public static void insertarFavourite() {

        // Declaración de variables -----------
        boolean idProyectoEncontrado = false;
        boolean idUserEncontrado = false;
        int idProyecto = 0;
        int idUsuario = 0;

        System.out.println("\n*****{ NUEVO FAVORITO }*****");

        // Pedir y comprobar el ID de Project
        while (!idProyectoEncontrado) {
            idProyecto = Leer.pedirEntero("> Introduzca el ID del proyecto");
            idProyectoEncontrado = code.comprobacionesIDs.compIDProject.comIdProject(idProyecto);
        }

        // Pedir y comprobar el ID de User
        while (!idUserEncontrado) {
            idUsuario = Leer.pedirEntero("> Introduzca el ID del usuario");
            idUserEncontrado = code.comprobacionesIDs.compIDUser.comIdUser(idUsuario);
        }

        EntityManagerFactory emf = EmfSingleton.getInstance().getEmf();
        EntityManager em = emf.createEntityManager();
        try {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();

            FavouriteEntity favourite = new FavouriteEntity();
            favourite.setIdProject(idProyecto);
            favourite.setIdUser(idUsuario);

            em.persist(favourite);
            transaction.commit();
        } catch (Exception e) {
            System.err.println("\n>>> Error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
