package code.insertar;

import Singleton.EmfSingleton;
import entities.TechnologyEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import libs.Leer;

public class insTechnology {
    public static void insertarTechnology() {
        String tag = Leer.pedirCadena("Introduzca la tag de la tecnologia");
        String name = Leer.pedirCadena("Introduzca el nombre de la tecnologia");

        EntityManagerFactory emf = EmfSingleton.getInstance().getEmf();
        EntityManager em = emf.createEntityManager();
        try {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();

            TechnologyEntity technology = new TechnologyEntity();
            technology.setTag(tag);
            technology.setTechName(name);

            em.persist(technology);
            transaction.commit();
        } catch (Exception e) {
            System.err.println(">>> Error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
