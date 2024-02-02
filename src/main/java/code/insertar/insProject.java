package code.insertar;
import Singleton.EmfSingleton;
import com.google.gson.Gson;
import dtos.NewUserProject;
import entities.ProjectEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;


public class insProject {

    // Método para leer un archivo JSON y convertirlo en un objeto NewUserProject
    public static NewUserProject leerJSON() {

        // Ruta del archivo JSON
        Path p = Path.of("src/main/resources/proyectoEjemplo.json");

        // Objeto para almacenar los datos del proyecto
        NewUserProject project = new NewUserProject();

        if (Files.exists(p)) {
            // Verificar si el archivo es legible
            if (libs.CheckFiles.ficheroLegible(p)) {
                NewUserProject userJSON;

                // Texto del archivo JSON
                String txtJson;

                try {
                    // Leer el contenido del archivo JSON
                    txtJson = Files.readString(p);

                    // Crear un objeto Gson para convertir el JSON a un objeto Java
                    Gson gson = new Gson();
                    // Convertir el JSON a un objeto NewUserProject
                    userJSON = gson.fromJson(txtJson, NewUserProject.class);

                    // Asignar los datos del objeto convertido al objeto project
                    project.setTitle(userJSON.getTitle());
                    project.setLogo(userJSON.getLogo());
                    project.setWeb(userJSON.getWeb());
                    project.setDescription(userJSON.getDescription());
                    project.setState(userJSON.getState());
                    project.setInitDate(userJSON.getInitDate());
                    project.setEndDate(userJSON.getEndDate());

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

        // Devolver el objeto NewUserProject con los datos del JSON
        return project;
    }

    // Método para insertar un proyecto en la base de datos
    public static void insertarProyecto() {
        System.out.println("\n*****{ NUEVO PROYECTO }*****");

        // Leer el JSON y obtener un objeto NewUserProject
        NewUserProject project = leerJSON();

        // Obtener los datos del objeto NewUserProject
        String title = project.getTitle();
        String web = project.getWeb();
        String projectDescription = project.getDescription();
        String state = project.getState();
        java.util.Date initDate = project.getInitDate();
        java.util.Date endDate = project.getEndDate();

        // Obtener una instancia del EntityManagerFactory a través del Singleton
        EntityManagerFactory emf = EmfSingleton.getInstance().getEmf();
        // Crear un EntityManager a partir del EntityManagerFactory
        EntityManager em = emf.createEntityManager();

        try {
            // Iniciar una transacción con la base de datos
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();

            // Crear una entidad de proyecto
            ProjectEntity projecto = new ProjectEntity();

            // Asignar los datos al objeto de entidad del proyecto
            projecto.setTitle(title);
            projecto.setWeb(web);
            projecto.setProjectDescription(projectDescription);
            projecto.setState(state);
            projecto.setInitDate(Date.valueOf(LocalDate.now()));
            projecto.setInitDate(Date.valueOf(initDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate()));
            projecto.setEndDate(Date.valueOf(endDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate()));

            // Persistir la entidad del proyecto en la base de datos
            em.persist(projecto);
            // Confirmar la transacción
            transaction.commit();

        } catch (Exception e) {
            // Manejar cualquier excepción que pueda ocurrir durante la transacción
            System.err.println(">>> Error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Cerrar el EntityManager para liberar recursos
            em.close();
        }
    }
}
