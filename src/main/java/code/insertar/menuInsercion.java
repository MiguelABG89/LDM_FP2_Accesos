package code.insertar;

public class menuInsercion {
    public static void seleccionarInserccion() {
        boolean salir = false;
        String opcion;
        while (!salir) {
            System.out.println("""
            \n***************[ INSERTAR ]***************
            \t\t0. Salir
            \t\t1. Insertar Collaboration
            \t\t2. Insertar Entity
            \t\t3. Insertar Family
            \t\t4. Insertar Favourite
            \t\t5. Insertar Implement
            \t\t6. Insertar Project
            \t\t7. Insertar Technology
            \t\t8. Insertar Users
            ******************************************""");

            opcion = libs.Leer.pedirCadena("Introduce una opción");

            switch (opcion) {
                case "0" -> salir = true;
                case "1" -> insCollaboration.insertarCollaboration();
                case "2" -> insEntity.insertarEntity();
                case "3" -> insFamily.insertarFamily();
                case "4" -> insFavourite.insertarFavourite();
                case "5" -> insImplement.insertarImplement();
                case "6" -> insProject.insertarProyecto();
                case "7" -> insTechnology.insertarTechnology();
                case "8" -> insUser.insertarUser();
                default -> System.err.println(">>> ERROR: La opción introducida no es valida");
            }
        }
    }
}
