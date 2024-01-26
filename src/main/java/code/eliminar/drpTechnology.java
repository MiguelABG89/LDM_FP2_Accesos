package code.eliminar;

import Singleton.EmfSingleton;
import entities.TechnologyEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import libs.Leer;

public class drpTechnology {
    public static void eliminarTechnology() {
        // Solicitar al usuario el ID de la Technology que desea eliminar
        String code = Leer.pedirCadena("Introduzca el ID de la tecnologia que desea eliminar");

        // Configurar la conexión a la base de datos
        EntityManagerFactory emf = EmfSingleton.getInstance().getEmf();
        EntityManager em = emf.createEntityManager();
        try {
            // Iniciar una transacción para garantizar la integridad de los datos
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();

            // Buscar la Technology por su código en la base de datos
            TechnologyEntity technology = em.find(TechnologyEntity.class, code);

            if (technology != null) {
                // Si la Technology existe, eliminarla
                em.remove(technology);
                System.out.println("Tecnologia eliminada exitosamente.");
            } else {
                // Notificar al usuario si no se encuentra ninguna Technology con el ID proporcionado
                System.err.println("No se encontró ninguna tecnologia con el ID proporcionado.");
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
