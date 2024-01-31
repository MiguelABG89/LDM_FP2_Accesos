package code.insertar;

import Singleton.EmfSingleton;
import entities.ProjectEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import libs.Leer;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class insProject {
    public static void insertarProyecto() {
        List<String> opciones = Arrays.asList("Pendiente", "Completado", "En Curso");

        //todo leer el json


        // Solicitar al usuario que ingrese los datos para el nuevo Proyect
        // todo al leer el json, pasar los datos a las variables
        String title;
        String web;
        String projectDescription;
        String state;
        Date initDate;
        Date endDate;

        // Configurar la conexión a la base de datos
        EntityManagerFactory emf = EmfSingleton.getInstance().getEmf();
        EntityManager em = emf.createEntityManager();
        try {
            // Iniciar una transacción para garantizar la integridad de los datos
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();

            // Crear un nuevo objeto Proyect y asignarle los datos proporcionados
            ProjectEntity proyecto = new ProjectEntity();
            proyecto.setTitle(title);
            proyecto.setWeb(web);
            proyecto.setProjectDescription(projectDescription);
            proyecto.setState(state);
            proyecto.setInitDate(initDate);
            proyecto.setEndDate(endDate);

            // Persistir el nuevo Project en la base de datos
            em.persist(proyecto);
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
