package code.comprobacionesIDs;

import Singleton.EmfSingleton;
import entities.ProjectEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.ArrayList;

public class compIDProject {
    static EntityManager em = EmfSingleton.getInstance().getEmf().createEntityManager();

    public static boolean comIdProject(int idProyecto) {

        // Declaración de variables -----------------
        boolean idEncontrado = false;

        // Consulta para obtener los Id de Project.
        Query listadoProject = em.createQuery("from ProjectEntity ");
        ArrayList<ProjectEntity> listaProjects = (ArrayList<ProjectEntity>) listadoProject.getResultList();

        System.out.println("\n****[ FILTRADO DE PROYECTOS ]****\n");

        // Verificar si la lista de proyectos está vacía.
        if (listaProjects.isEmpty()) {
            System.err.println("\n>>> No se encontraron proyectos en la BBDD.");
        } else {

            for (ProjectEntity p : listaProjects) {
                if (p.getId().equals(idProyecto)) {
                    System.out.println("\n>>> Se ha seleccionado el proyecto: " + p.getTitle());
                    idEncontrado = true;
                }
            }

            // Informar al usuario si no se encontró ningún PROJECT con el ID proporcionado.
            if (!idEncontrado) {
                System.err.println("\n>>> No se encontraron proyectos con el ID '" + idProyecto + "'.");
            }
        }

        return idEncontrado;

    }
}
