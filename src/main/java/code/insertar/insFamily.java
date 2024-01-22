package code.insertar;

import Singleton.EmfSingleton;
import entities.FamilyEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import libs.Leer;

public class insFamily {
    public static void insertarFamily() {
        String name = Leer.pedirCadena("Inserte el nombre");
        String code = Leer.pedirCadena("Inserte el codigo");

        EntityManagerFactory emf = EmfSingleton.getInstance().getEmf();
        EntityManager em = emf.createEntityManager();
        try {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();

            FamilyEntity family = new FamilyEntity();
            family.setFamilyName(name);
            family.setFamilyCode(code);

            em.persist(family);
            transaction.commit();
        } catch (Exception e) {
            System.err.println(">>> Error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
