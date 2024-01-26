package code.insertar;

import Singleton.EmfSingleton;
import entities.UsersEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import libs.Leer;

public class insUser {
    public static void insertarUser() {
        // Solicitar al usuario que ingrese los datos para el nuevo User
        String login = Leer.pedirCadena("Introduzca su Login");
        String userName = Leer.pedirCadena("Introduzca su nombre");
        String surname = Leer.pedirCadena("Introduzca su apellido");
        String email = Leer.pedirCadena("Introduzca su email");
        String linkedIn = Leer.pedirCadena("Introduzca su linkedIn");

        // Configurar la conexión a la base de datos
        EntityManagerFactory emf = EmfSingleton.getInstance().getEmf();
        EntityManager em = emf.createEntityManager();
        try {
            // Iniciar una transacción para garantizar la integridad de los datos
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();

            // Crear un nuevo objeto Proyect y asignarle los datos proporcionados
            UsersEntity user = new UsersEntity();
            user.setLogin(login);
            user.setUserName(userName);
            user.setSurname(surname);
            user.setEmail(email);
            user.setLinkedIn(linkedIn);

            // Persistir el nuevo Project en la base de datos
            em.persist(user);
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
