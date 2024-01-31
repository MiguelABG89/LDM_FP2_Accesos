package code.listados;

import Singleton.EmfSingleton;
import entities.ProjectEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.ArrayList;

public class ListarProjects {

    public static void listarProyectos() {
        // Configurar la conexión a la base de datos
        EntityManager em = EmfSingleton.getInstance().getEmf().createEntityManager();

        try {
            System.out.println("\n-*-*-[ LISTADO DE PROYECTOS ]-*-*-");

            // Consulta para obtener los proyectos.
            Query listadoProyectos = em.createQuery("from ProjectEntity");
            ArrayList<ProjectEntity> listaProyectos = (ArrayList<ProjectEntity>) listadoProyectos.getResultList();

            for (ProjectEntity p : listaProyectos) {

                // MOSTRAR LOS DATOS EN PANTALLA ----------
                System.out.println("\n*******[ PROYECTO " + p.getTitle() + " ]*******");
                System.out.println("- ID DE PROYECTO: " + p.getId());
                System.out.println("- LOGO: " + p.getLogo());
                System.out.println("- WEB: " + p.getWeb());
                System.out.println("- DESCRIPCIÓN DEL PROYECTO: " + p.getProjectDescription());
                System.out.println("- ESTADO: " + p.getState());
                System.out.println("- FECHA DE INICIO: " + p.getInitDate());
                System.out.println("- FECHA DE FINALIZACIÓN: " + p.getEndDate());
                System.out.println("***********************************************************");

            }
        } catch (Exception e) {
            // Manejar cualquier error que pueda ocurrir durante la operación
            System.err.println(">>> Error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Cerrar el EntityManager en el bloque "finally" para asegurar que se cierre incluso en caso de excepciones
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }
}
