package code.insertar;

import Singleton.EmfSingleton;
import entities.UsersEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import libs.Leer;

public class insUser {
    public static void insertarUser() {
        String login = Leer.pedirCadena("");// TODO no se que poner aqui
        String userName = Leer.pedirCadena("Introduzca su nombre");
        String surname = Leer.pedirCadena("Introduzca su apellido");
        String email = Leer.pedirCadena("Introduzca su email");
        String linkedIn = Leer.pedirCadena("Introduzca su linkedIn");

        EntityManagerFactory emf = EmfSingleton.getInstance().getEmf();
        EntityManager em = emf.createEntityManager();
        try {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();

            UsersEntity user = new UsersEntity();
            user.setLogin(login);
            user.setUserName(userName);
            user.setSurname(surname);
            user.setEmail(email);
            user.setLinkedIn(linkedIn);

            em.persist(user);
            transaction.commit();
        } catch (Exception e) {
            System.err.println(">>> Error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
