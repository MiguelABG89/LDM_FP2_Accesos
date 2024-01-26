package code.eliminar;

import Singleton.EmfSingleton;
import entities.FamilyEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import libs.Leer;

public class drpFamily {
    public static void eliminarFamily() {
        // Solicitar al usuario el ID de la Family que desea eliminar
        String code = Leer.pedirCadena("Introduzca el ID de la familia que desea eliminar");

        // Configurar la conexión a la base de datos
        EntityManagerFactory emf = EmfSingleton.getInstance().getEmf();
        EntityManager em = emf.createEntityManager();
        try {
            // Iniciar una transacción para garantizar la integridad de los datos
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();

            // Buscar la Family por su código en la base de datos
            FamilyEntity family = em.find(FamilyEntity.class, code);

            if (family != null) {
                // Si la Family existe, eliminarla
                em.remove(family);
                System.out.println("Familia eliminada exitosamente.");
            } else {
                // Notificar al usuario si no se encuentra ninguna Family con el ID proporcionado
                System.err.println("No se encontró ninguna familia con el ID proporcionado.");
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
