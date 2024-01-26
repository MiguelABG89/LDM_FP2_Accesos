package code.insertar;

import Singleton.EmfSingleton;
import entities.FamilyEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import libs.Leer;

public class insFamily {
    public static void insertarFamily() {
        // Solicitar al usuario que ingrese los datos para la nueva Family
        String name = Leer.pedirCadena("Inserte el nombre");
        String code = Leer.pedirCadena("Inserte el codigo");

        // Configurar la conexión a la base de datos
        EntityManagerFactory emf = EmfSingleton.getInstance().getEmf();
        EntityManager em = emf.createEntityManager();
        try {
            // Iniciar una transacción para garantizar la integridad de los datos
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();

            // Crear un nuevo objeto Family y asignarle los datos proporcionados
            FamilyEntity family = new FamilyEntity();
            family.setFamilyName(name);
            family.setFamilyCode(code);

            // Persistir la nueva Family en la base de datos
            em.persist(family);
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
