package code.insertar;

public class seleccion {
    public static void seleccionarInserccion() {
        boolean salir = false;
        String opcion;
        while (!salir) {
            System.out.println("""
                    *******************************************
                    0. Salir
                    1. Insertar Collaboration
                    2. Insertar Entity
                    3. Insertar Family
                    4. Insertar Favourite
                    5. Insertar Implement
                    6. Insertar Project
                    7. Insertar Technology
                    8. Insertar Users
                    *******************************************""");
            opcion = libs.Leer.pedirCadena("Introduce una opción");

            switch (opcion) {
                case "0" -> salir = true;
                case "1" -> {}
                case "2" -> insEntity.insertarEntity();
                case "3" -> insFamily.insertarFamily();
                case "4" -> {}
                case "5" -> {}
                case "6" -> insProject.insertarProyecto();
                case "7" -> insTechnology.insertarTechnology();
                case "8" -> insUser.insertarUser();
                default -> System.err.println("La opción introducida no es valida");
            }
        }
    }
}
