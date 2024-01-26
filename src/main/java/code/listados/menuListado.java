package code.listados;

public class menuListado {
    public static void seleccionarListado() {
        boolean salir = false;
        String opcion;

        while (!salir) {
            System.out.println("""
            \n***************[ LISTADOS ]***************
            \t\t0. Salir
            \t\t1. Listar Collaborations
            \t\t2. Listar Entities
            \t\t3. Listar Families
            \t\t4. Listar Favourites
            \t\t5. Listar Implements
            \t\t6. Listar Projects
            \t\t7. Listar Technologies
            \t\t8. Listar Users
            ******************************************""");

            opcion = libs.Leer.pedirCadena("Introduce una opción:");

            switch (opcion) {
                case "0" -> salir = true;
                case "1" -> ListarCollaborations.listarCollab();
                case "2" -> ListarEntity.listarEntity();
                case "3" -> ListarFamily.listarFamily();
                case "4" -> ListarFavourite.listarFavourite();
                case "5" -> ListarImplement.listarImplement();
                case "6" -> ListarProjects.listarProyectos();
                case "7" -> ListarTechnology.listarTechnology();
                case "8" -> ListarUsers.listarUsers();
                default -> System.err.println(">>> ERROR: La opción introducida no es valida");
            }
        }
    }
}
