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

        // Declaración de variables -------------
        boolean idTechEncontrado = false;
        boolean idProjectEncontrado = false;
        int idTecnologia = 0;
        int idProyecto = 0;

        System.out.println("\n*****{ NUEVA IMPLEMENTACIÓN }*****");

        // Pedir Id de PROJECT.
        while (!idProjectEncontrado) {
            idProyecto = Leer.pedirEntero("> Introduzca el ID del proyecto");
            idProjectEncontrado = code.comprobacionesIDs.compIDProject.comIdProject(idProyecto);
        }

        // Pedir y comprobar el id de TECHNOLOGY.
        while (!idTechEncontrado) {
            idTecnologia = Leer.pedirEntero("> Introduzca el ID de la tecnologia");
            idTechEncontrado = code.comprobacionesIDs.compIDTechnology.compIdTech(idTecnologia);
        }

        EntityManagerFactory emf = EmfSingleton.getInstance().getEmf();
        EntityManager em = emf.createEntityManager();

        // CREAR LA IMPLEMENTACIÓN EN LA BBDD
        try {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();

            ImplementEntity implement = new ImplementEntity();
            implement.setIdProject(idProyecto);
            implement.setIdTechnology(idTecnologia);

            em.persist(implement);
            transaction.commit();
        } catch (Exception e) {
            System.err.println("\n>>> Error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

}
