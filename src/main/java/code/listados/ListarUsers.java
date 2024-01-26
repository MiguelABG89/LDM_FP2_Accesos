package code.listados;

import Singleton.EmfSingleton;
import entities.UsersEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.ArrayList;

public class ListarUsers {

    static EntityManager em = EmfSingleton.getInstance().getEmf().createEntityManager();

    public static void listarUsers() {

        System.out.println("\n-*-*-[ LISTADO DE USUARIOS ]-*-*-");

        // Consulta para obtener los usuarios.
        Query listadoUsers = em.createQuery("from UsersEntity");
        ArrayList<UsersEntity> listaUsers = (ArrayList<UsersEntity>) listadoUsers.getResultList();

        for (UsersEntity u : listaUsers) {

            // MOSTRAR LOS DATOS EN PANTALLA ----------
            System.out.println("\n- ID DEL USUARIO: " + u.getId());
            System.out.println("- ID CENTRO: " + u.getIdEntity());
            System.out.println("- LOGIN: " + u.getLogin());
            System.out.println("- NOMBRE: " +u.getUserName());
            System.out.println("- APELLIDO: " + u.getSurname());
            System.out.println("- EMAIL: " + u.getEmail());
            System.out.println("- LINKEDIN: " + u.getLinkedIn());
            System.out.println("***********************************************************");

        }

        em.close();
    }
}
