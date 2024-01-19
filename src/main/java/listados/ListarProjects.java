package listados;

import Singleton.EmfSingleton;
import entities.ProjectEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.ArrayList;

public class ListarProjects {

    static EntityManager em = EmfSingleton.getInstance().getEmf().createEntityManager();

    public static void listarProyectos() {

        System.out.println("\n-*-*-[ LISTADO DE PROYECTOS ]-*-*-");

        // Consulta para obtener los proyectos.
        Query listadoProyectos = em.createQuery("from ProjectEntity");
        ArrayList<ProjectEntity> listaProyectos = (ArrayList<ProjectEntity>) listadoProyectos.getResultList();

        for (ProjectEntity p : listaProyectos) {

            // MOSTRAR LOS DATOS EN PANTALLA ----------
            System.out.println("\n*******[ PROYECTO " + p.getTitle() + " ]*******");
            System.out.println("- LOGO: " + p.getLogo());
            System.out.println("- WEB: " + p.getWeb());
            System.out.println("- DESCRIPCIÓN DEL PROYECTO: " + p.getProjectDescription() + " €");
            System.out.println("- ESTADO: " + p.getState());
            System.out.println("- FECHA DE INICIO: " + p.getInitDate());
            System.out.println("- FECHA DE FINALIZACIÓN: " + p.getEndDate());
            System.out.println("***********************************************************");

        }

        em.close();

    }
}
