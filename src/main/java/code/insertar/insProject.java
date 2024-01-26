package code.insertar;

import Singleton.EmfSingleton;
import entities.ProjectEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import libs.Leer;

import java.sql.Date;
import java.time.LocalDate;

public class insProject {
    public static void insertarProyecto() {

        System.out.println("\n*****{ NUEVO PROYECTO }*****");

        String title = Leer.pedirCadena("\n> Inserte el nombre del proyecto");
        String web = Leer.pedirCadena("\n> Inserte la URL de la web");
        String projectDescription = Leer.pedirCadena("\n> Inserte la descripción del proyecto");
        String state = Leer.pedirCadena("\n> Inserte el estado del proyecto ('Pendiente', 'Completado', 'En Curso')");
//        String initDate = Leer.pedirCadena("\n > Inserte la fecha de inicio del proyecto");  //TODO implementar tambien fecha de inicio
//        String endDate = Leer.pedirCadena("\n > Inserte la fecha de finalización del proyecto");  //TODO implementar tambien fecha de finalizacion

        EntityManagerFactory emf = EmfSingleton.getInstance().getEmf();
        EntityManager em = emf.createEntityManager();
        try {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();

            ProjectEntity projecto = new ProjectEntity();
            projecto.setTitle(title);
            projecto.setWeb(web);
            projecto.setProjectDescription(projectDescription);
            projecto.setState(state);
            projecto.setInitDate(Date.valueOf(LocalDate.now()));
//            projecto.setInitDate(Date.valueOf(initDate));
//            projecto.setEndDate(Date.valueOf(endDate));

            em.persist(projecto);
            transaction.commit();
        } catch (Exception e) {
            System.err.println(">>> Error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
