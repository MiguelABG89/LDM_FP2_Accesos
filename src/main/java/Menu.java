import code.eliminar.menuEliminar;
import code.insertar.menuInsercion;

public class Menu {
    public static void main(String[] args) {
        boolean salir = false;
        String opcion;
        while (!salir) {
            System.out.println("""
                    *******************************************
                    0. Salir
                    1. Insertar proyecto
                    2. Eliminar proyecto
                    3. Modificar proyecto
                    4. Mostrar proyectos
                    *******************************************""");
            opcion = libs.Leer.pedirCadena("Introduce una opción");

            switch (opcion) {
                case "0" -> salir = true;
                case "1" -> menuInsercion.seleccionarInserccion();
                case "2" -> menuEliminar.seleccionarDelete();
                case "3" -> {}
                case "4" -> {}
                default -> System.err.println("La opción introducida no es valida");
            }
        }
    }
}
