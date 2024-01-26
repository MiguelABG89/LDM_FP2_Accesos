package code.eliminar;

import Singleton.EmfSingleton;
import entities.ImplementEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import libs.Leer;

public class drpImplement {
    public static void eliminarImplement() {
        // Solicitar al usuario el ID de la Implementation que desea eliminar
        String code = Leer.pedirCadena("Introduzca el ID del implement que desea eliminar");

        // Configurar la conexión a la base de datos
        EntityManagerFactory emf = EmfSingleton.getInstance().getEmf();
        EntityManager em = emf.createEntityManager();
        try {
            // Iniciar una transacción para garantizar la integridad de los datos
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();

            // Buscar la Implementation por su código en la base de datos
            ImplementEntity implement = em.find(ImplementEntity.class, code);

            if (implement != null) {
                // Si la Implementation existe, eliminarla
                em.remove(implement);
                System.out.println("Implement eliminado exitosamente.");
            } else {
                // Notificar al usuario si no se encuentra ninguna Implementation con el ID proporcionado
                System.err.println("No se encontró ningun implement con el ID proporcionado.");
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
