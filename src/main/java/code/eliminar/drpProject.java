package code.eliminar;

import Singleton.EmfSingleton;
import entities.ProjectEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import libs.Leer;

public class drpProject {
    public static void eliminarProject() {
        // Solicitar al usuario el ID del Project que desea eliminar
        String code = Leer.pedirCadena("Introduzca el ID del proyecto que desea eliminar");

        // Configurar la conexión a la base de datos
        EntityManagerFactory emf = EmfSingleton.getInstance().getEmf();
        EntityManager em = emf.createEntityManager();
        try {
            // Iniciar una transacción para garantizar la integridad de los datos
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();

            // Buscar el Project por su código en la base de datos
            ProjectEntity project = em.find(ProjectEntity.class, code);

            if (project != null) {
                // Si el Project existe, eliminarla
                em.remove(project);
                System.out.println("Proyecto eliminado exitosamente.");
            } else {
                // Notificar al usuario si no se encuentra ningun Project con el ID proporcionado
                System.err.println("No se encontró ningun proyecto con el ID proporcionado.");
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
