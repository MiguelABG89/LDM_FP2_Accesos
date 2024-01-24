package code.insertar;

import Singleton.EmfSingleton;
import entities.EntityEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import libs.Leer;

public class insEntity {
    public static void insertarEntity() {
        String name = Leer.pedirCadena("Introduzca el nombre del centro");
        String code = Leer.pedirCadena("Introduzca el codigo del centro");
        String web = Leer.pedirCadena("Introduzca la URL de la web");
        String email = Leer.pedirCadena("Introduzca el email del centro");

        EntityManagerFactory emf = EmfSingleton.getInstance().getEmf();
        EntityManager em = emf.createEntityManager();
        try {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();

            EntityEntity entity = new EntityEntity();
            entity.setEntityName(name);
            entity.setEntityCode(code);
            entity.setWeb(web);
            entity.setEmail(email);

            em.persist(entity);
            transaction.commit();
        } catch (Exception e) {
            System.err.println(">>> Error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
