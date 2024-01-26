package code.insertar;

import Singleton.EmfSingleton;
import entities.EntityEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import libs.Leer;

public class insEntity {
    public static void insertarEntity() {
        // Solicitar al usuario que ingrese los datos para la nueva Entity
        String name = Leer.pedirCadena("Introduzca el nombre del centro");
        String code = Leer.pedirCadena("Introduzca el codigo del centro");
        String web = Leer.pedirCadena("Introduzca la URL de la web");
        String email = Leer.pedirCadena("Introduzca el email del centro");

        // Configurar la conexión a la base de datos
        EntityManagerFactory emf = EmfSingleton.getInstance().getEmf();
        EntityManager em = emf.createEntityManager();
        try {
            // Iniciar una transacción para garantizar la integridad de los datos
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();

            // Crear un nuevo objeto Entity y asignarle los datos proporcionados
            EntityEntity entity = new EntityEntity();
            entity.setEntityName(name);
            entity.setEntityCode(code);
            entity.setWeb(web);
            entity.setEmail(email);

            // Persistir la nueva Entity en la base de datos
            em.persist(entity);
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
