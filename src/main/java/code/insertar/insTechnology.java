package code.insertar;

import Singleton.EmfSingleton;
import entities.TechnologyEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import libs.Leer;

public class insTechnology {
    public static void insertarTechnology() {
        // Solicitar al usuario que ingrese los datos para la nueva Technology
        String tag = Leer.pedirCadena("Introduzca la tag de la tecnologia");
        String name = Leer.pedirCadena("Introduzca el nombre de la tecnologia");

        // Configurar la conexión a la base de datos
        EntityManagerFactory emf = EmfSingleton.getInstance().getEmf();
        EntityManager em = emf.createEntityManager();
        try {
            // Iniciar una transacción para garantizar la integridad de los datos
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();

            // Crear un nuevo objeto Technology y asignarle los datos proporcionados
            TechnologyEntity technology = new TechnologyEntity();
            technology.setTag(tag);
            technology.setTechName(name);

            // Persistir la nueva Technology en la base de datos
            em.persist(technology);
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
