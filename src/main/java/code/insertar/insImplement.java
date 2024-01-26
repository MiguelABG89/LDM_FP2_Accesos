package code.insertar;

import Singleton.EmfSingleton;
import entities.EntityEntity;
import entities.ImplementEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import libs.Leer;

public class insImplement {
    public static void insertarImplement() {
        // Solicitar al usuario que ingrese los datos para el nuevo Implement
        int idProyecto = Leer.pedirEntero("Introduzca el ID del proyecto");
        int idTecnologia = Leer.pedirEntero("Introduzca el ID de la tecnologia");

        // Configurar la conexión a la base de datos
        EntityManagerFactory emf = EmfSingleton.getInstance().getEmf();
        EntityManager em = emf.createEntityManager();
        try {
            // Iniciar una transacción para garantizar la integridad de los datos
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();

            // Crear un nuevo objeto Implement y asignarle los datos proporcionados
            ImplementEntity implement = new ImplementEntity();
            implement.setIdProject(idProyecto);
            implement.setIdTechnology(idTecnologia);

            // Persistir el nuevo Implement en la base de datos
            em.persist(implement);
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
