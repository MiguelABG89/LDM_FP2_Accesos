package code.insertar;

import Singleton.EmfSingleton;
import com.google.gson.Gson;
import dtos.NewUser;
import dtos.NewUserProject;
import entities.ProjectEntity;
import entities.UsersEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import libs.Leer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;

public class insUser {

    // Método para leer un archivo JSON y convertirlo en un objeto NewUser
    public static NewUser leerJSON() {

        // Ruta del archivo JSON
        Path p = Path.of("src/main/resources/jsonUsers.json");

        // Objeto para almacenar los datos del usuario
        NewUser user = new NewUser();

        if (Files.exists(p)) {
            // Verificar si el archivo es legible
            if (libs.CheckFiles.ficheroLegible(p)) {
                NewUser userJSON;

                // Texto del archivo JSON
                String txtJson;

                try {
                    // Leer el contenido del archivo JSON
                    txtJson = Files.readString(p);

                    // Crear un objeto Gson para convertir el JSON a un objeto Java
                    Gson gson = new Gson();
                    // Convertir el JSON a un objeto NewUserProject
                    userJSON = gson.fromJson(txtJson, NewUser.class);

                    // Asignar los datos del objeto convertido al objeto user
                    user.setLogin(userJSON.getLogin());
                    user.setUserName(userJSON.getUserName());
                    user.setSurname(userJSON.getSurname());
                    user.setEmail(userJSON.getEmail());
                    user.setLinkedIn(userJSON.getLinkedIn());
                    user.setIdEntity(userJSON.getIdEntity());

                    System.out.println("\n>>> JSON CARGADO CORRECTAMENTE");

                } catch (IOException e) {
                    System.out.println("\n>>> ERROR: el archivo JSON no es legible");
                }
            } else {
                System.out.println("\n>>> ERROR: el archivo no es legible");
            }
        } else {
            System.out.println("\n>>> ERROR: la ruta indicada no existe");
        }

        // Devolver el objeto NewUser con los datos del JSON
        return user;
    }

    // Método para insertar un usuario en la base de datos
    public static void insertarUser() {
        System.out.println("\n*****{ NUEVO USUARIO }*****");

        // Leer el JSON y obtener un objeto NewUser
        NewUser user = leerJSON();

        // Obtener los datos del objeto NewUser
        String login = user.getLogin();
        String userName = user.getUserName();
        String surname = user.getSurname();
        String email = user.getEmail();
        String linkedId = user.getLinkedIn();
        int idEntity = user.getIdEntity();

        // Obtener una instancia del EntityManagerFactory a través del Singleton
        EntityManagerFactory emf = EmfSingleton.getInstance().getEmf();
        // Crear un EntityManager a partir del EntityManagerFactory
        EntityManager em = emf.createEntityManager();

        try {
            // Iniciar una transacción con la base de datos
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();

            // Crear una entidad de usuario
            UsersEntity users = new UsersEntity();

            // Asignar los datos al objeto de entidad del usuario
            users.setLogin(login);
            users.setUserName(userName);
            users.setSurname(surname);
            users.setEmail(email);
            users.setLinkedIn(linkedId);
            users.setIdEntity(idEntity);

            // Persistir la entidad del usuario en la base de datos
            em.persist(users);
            // Confirmar la transacción
            transaction.commit();

        } catch (Exception e) {
            // Manejar cualquier excepción que pueda ocurrir durante la transacción
            System.err.println("\n>>> Error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Cerrar el EntityManager para liberar recursos
            em.close();
        }
    }
}
