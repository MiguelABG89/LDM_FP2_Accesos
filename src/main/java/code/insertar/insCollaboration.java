package code.insertar;

import Singleton.EmfSingleton;
import entities.CollaborationEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import libs.Leer;

public class insCollaboration {
    public static void insertarCollaboration() {
        // Solicitar al usuario que ingrese los datos para la nueva Collaboration
        int idProyecto = Leer.pedirEntero("Introduzca el ID del proyecto");
        int idUsuario = Leer.pedirEntero("Introduzca el ID del usuario");
        int idFamilia = Leer.pedirEntero("Introduzca el ID de la familia");
        Boolean esAdmin = Leer.pedirBoolean("El usuario es administrador (S/N)");

        // Configurar la conexión a la base de datos
        EntityManagerFactory emf = EmfSingleton.getInstance().getEmf();
        EntityManager em = emf.createEntityManager();
        try {
            // Iniciar una transacción para garantizar la integridad de los datos
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();

            // Crear un nuevo objeto Collaboration y asignarle los datos proporcionados
            CollaborationEntity collaboration = new CollaborationEntity();
            collaboration.setIdProject(idProyecto);
            collaboration.setIdUser(idUsuario);
            collaboration.setIdFamily(idFamilia);
            collaboration.setManager(esAdmin);

            // Persistir la nueva Collaboration en la base de datos
            em.persist(collaboration);
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
