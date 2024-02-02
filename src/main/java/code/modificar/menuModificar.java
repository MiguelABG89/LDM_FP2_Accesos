package code.modificar;

import code.listados.*;

public class menuModificar {
    public static void seleccionarModificar() {
        boolean salir = false;
        String opcion;

        while (!salir) {
            System.out.println("""
            \n***************[ LISTADOS ]***************
            \t\t0. Salir
            \t\t1. Modificar Collaborations
            \t\t2. Modificar Entities
            \t\t3. Modificar Families
            \t\t4. Modificar Favourites
            \t\t5. Modificar Implements
            \t\t6. Modificar Projects
            \t\t7. Modificar Technologies
            \t\t8. Modificar Users
            ******************************************""");

            opcion = libs.Leer.pedirCadena("Introduce una opción:");

            switch (opcion) {
                case "0" -> salir = true;
                case "1" -> {}
                case "2" -> {}
                case "3" -> {}
                case "4" -> {}
                case "5" -> {}
                case "6" -> {}
                case "7" -> {}
                case "8" -> {}
                default -> System.err.println(">>> ERROR: La opción introducida no es valida");
            }
        }
    }
}
