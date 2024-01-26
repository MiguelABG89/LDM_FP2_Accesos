package code.eliminar;

import Singleton.EmfSingleton;
import entities.FavouriteEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import libs.Leer;

public class drpFavourite {
    public static void eliminarFavourite() {
        // Solicitar al usuario el ID del Favourite que desea eliminar
        String code = Leer.pedirCadena("Introduzca el ID del favorito que desea eliminar");

        // Configurar la conexión a la base de datos
        EntityManagerFactory emf = EmfSingleton.getInstance().getEmf();
        EntityManager em = emf.createEntityManager();
        try {
            // Iniciar una transacción para garantizar la integridad de los datos
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();

            // Buscar el Favourite por su código en la base de datos
            FavouriteEntity favourite = em.find(FavouriteEntity.class, code);

            if (favourite != null) {
                // Si el Favourite existe, eliminarla
                em.remove(favourite);
                System.out.println("Favorito eliminado exitosamente.");
            } else {
                // Notificar al usuario si no se encuentra ningun Favourite con el ID proporcionado
                System.err.println("No se encontró ningun favorito con el ID proporcionado.");
            }

            // Confirmar la transacción
            transaction.commit();
        } catch (Exception e) {
            // Manejar cualquier error que pueda ocurrir durante la eliminación
            System.err.println(">>> Error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Cerrar la conexión a la base de datos
            em.close();
        }
    }
}
