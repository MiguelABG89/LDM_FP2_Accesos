package code.eliminar;

import Singleton.EmfSingleton;
import entities.UsersEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import libs.Leer;

public class drpUser {
    public static void eliminarUser() {
        // Solicitar al usuario el ID del User que desea eliminar
        String code = Leer.pedirCadena("Introduzca el ID del usuario que desea eliminar");

        // Configurar la conexión a la base de datos
        EntityManagerFactory emf = EmfSingleton.getInstance().getEmf();
        EntityManager em = emf.createEntityManager();
        try {
            // Iniciar una transacción para garantizar la integridad de los datos
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();

            // Buscar el User por su código en la base de datos
            UsersEntity usuario = em.find(UsersEntity.class, code);

            if (usuario != null) {
                // Si el User existe, eliminarla
                em.remove(usuario);
                System.out.println("usuario eliminado exitosamente.");
            } else {
                // Notificar al usuario si no se encuentra ningun User con el ID proporcionado
                System.err.println("No se encontró ningun usuario con el ID proporcionado.");
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
