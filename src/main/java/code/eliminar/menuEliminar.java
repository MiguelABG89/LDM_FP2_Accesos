package code.eliminar;

public class menuEliminar {
    public static void seleccionarDelete() {
        boolean salir = false;
        String opcion;
        while (!salir) {
            System.out.println("""
            \n***************[ ELIMINAR ]***************
            \t\t0. Salir
            \t\t1. Borrar Collaboration
            \t\t2. Borrar Entity
            \t\t3. Borrar Family
            \t\t4. Borrar Favourite
            \t\t5. Borrar Implement
            \t\t6. Borrar Project
            \t\t7. Borrar Technology
            \t\t8. Borrar Users
            ******************************************""");

            opcion = libs.Leer.pedirCadena("Introduce una opción");

            switch (opcion) {
                case "0" -> salir = true;
                case "1" -> drpCollaboration.eliminarCollaboration();
                case "2" -> drpEntity.eliminarEntity();
                case "3" -> drpFamily.eliminarFamily();
                case "4" -> drpFavourite.eliminarFavourite();
                case "5" -> drpImplement.eliminarImplement();
                case "6" -> drpProject.eliminarProject();
                case "7" -> drpTechnology.eliminarTechnology();
                case "8" -> drpUser.eliminarUser();
                default -> System.err.println(">>> ERROR: La opción introducida no es valida");
            }
        }
    }
}
