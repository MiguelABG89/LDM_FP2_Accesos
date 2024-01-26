package code.eliminar;

import Singleton.EmfSingleton;
import entities.CollaborationEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import libs.Leer;

public class drpCollaboration {
    public static void eliminarCollaboration() {
        // Solicitar al usuario el ID de la Collaboration que desea eliminar
        String code = Leer.pedirCadena("Introduzca el ID de la colaboración que desea eliminar");

        // Configurar la conexión a la base de datos
        EntityManagerFactory emf = EmfSingleton.getInstance().getEmf();
        EntityManager em = emf.createEntityManager();
        try {
            // Iniciar una transacción para garantizar la integridad de los datos
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();

            // Buscar la Collaboration por su código en la base de datos
            CollaborationEntity collaboration = em.find(CollaborationEntity.class, code);

            if (collaboration != null) {
                // Si la Collaboration existe, eliminarla
                em.remove(collaboration);
                System.out.println("Colaboración eliminado exitosamente.");
            } else {
                // Notificar al usuario si no se encuentra ninguna Collaboration con el ID proporcionado
                System.err.println("No se encontró ninguna colaboración con el ID proporcionado.");
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
