package code.eliminar;

import Singleton.EmfSingleton;
import entities.UsersEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import libs.Leer;

public class drpUser {
    public static void eliminarUser() {
        String code = Leer.pedirCadena("Introduzca el ID del usuario que desea eliminar");

        EntityManagerFactory emf = EmfSingleton.getInstance().getEmf();
        EntityManager em = emf.createEntityManager();
        try {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();

            // Buscar la entidad por el código
            UsersEntity usuario = em.find(UsersEntity.class, code);

            if (usuario != null) {
                // Si la entidad existe, se elimina
                em.remove(usuario);
                System.out.println("usuario eliminado exitosamente.");
            } else {
                System.err.println("No se encontró ningun usuario con el ID proporcionado.");
            }

            transaction.commit();
        } catch (Exception e) {
            System.err.println(">>> Error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
