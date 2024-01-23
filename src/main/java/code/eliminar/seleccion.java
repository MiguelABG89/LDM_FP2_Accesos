package code.eliminar;

public class seleccion {
    public static void seleccionarDelete() {
        boolean salir = false;
        String opcion;
        while (!salir) {
            System.out.println("""
                    *******************************************
                    0. Salir
                    1. Borrar Collaboration
                    2. Borrar Entity
                    3. Borrar Family
                    4. Borrar Favourite
                    5. Borrar Implement
                    6. Borrar Project
                    7. Borrar Technology
                    8. Borrar Users
                    *******************************************""");
            opcion = libs.Leer.pedirCadena("Introduce una opción");

            switch (opcion) {
                case "0" -> salir = true;
                case "1" -> {}
                case "2" -> drpEntity.eliminarEntity();
                case "3" -> drpFamily.eliminarFamily();
                case "4" -> {}
                case "5" -> {}
                case "6" -> drpProject.eliminarProject();
                case "7" -> drpTechnology.eliminarTechnology();
                case "8" -> drpUser.eliminarUser();
                default -> System.err.println("La opción introducida no es valida");
            }
        }
    }
}
