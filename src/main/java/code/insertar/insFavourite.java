package code.insertar;

import Singleton.EmfSingleton;
import entities.FavouriteEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import libs.Leer;

public class insFavourite {
    public static void insertarFavourite() {
        // Solicitar al usuario que ingrese los datos para el nuevo Favourite
        int idProyecto = Leer.pedirEntero("Introduzca el ID del proyecto");
        int idUsuario = Leer.pedirEntero("Introduzca el ID del usuario");

        // Configurar la conexión a la base de datos
        EntityManagerFactory emf = EmfSingleton.getInstance().getEmf();
        EntityManager em = emf.createEntityManager();
        try {
            // Iniciar una transacción para garantizar la integridad de los datos
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();

            // Crear un nuevo objeto Favourite y asignarle los datos proporcionados
            FavouriteEntity favourtie = new FavouriteEntity();
            favourtie.setIdProject(idProyecto);
            favourtie.setIdUser(idUsuario);

            // Persistir el nuevo Favourite en la base de datos
            em.persist(favourtie);
            transaction.commit();
        } catch (Exception e) {
            // Manejar cualquier error que pueda ocurrir durante la inserción
            System.err.println(">>> Error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Cerrar la conexión a la base de datos
            em.close();
        }
    }
}
