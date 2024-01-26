package code.eliminar;

import Singleton.EmfSingleton;
import entities.EntityEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import libs.Leer;

public class drpEntity {
    public static void eliminarEntity() {
        // Solicitar al usuario el ID de la Entity que desea eliminar
        String code = Leer.pedirCadena("Introduzca el ID del centro que desea eliminar");

        // Configurar la conexión a la base de datos
        EntityManagerFactory emf = EmfSingleton.getInstance().getEmf();
        EntityManager em = emf.createEntityManager();
        try {
            // Iniciar una transacción para garantizar la integridad de los datos
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();

            // Buscar la Entity por su código en la base de datos
            EntityEntity entity = em.find(EntityEntity.class, code);

            if (entity != null) {
                // Si la Entity existe, eliminarla
                em.remove(entity);
                System.out.println("Centro eliminado exitosamente.");
            } else {
                // Notificar al usuario si no se encuentra ninguna Entity con el ID proporcionado
                System.err.println("No se encontró ningun centro con el ID proporcionado.");
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
