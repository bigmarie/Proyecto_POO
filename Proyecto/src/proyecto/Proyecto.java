//C:\Users\chaco\AppData\Local\NetBeans\Cache\23\executor-snippets\run.xml:111
//C:\Users\chaco\AppData\Local\NetBeans\Cache\23\executor-snippets\run.xml:68


package proyecto;
import java.io.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Nicole
 */
public class Proyecto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        GestionQuickPass gestionQuickPass = new GestionQuickPass();
        GestionAcceso gestionAcceso = new GestionAcceso();
        
        boolean continuar = true;

        while (continuar) {
            String menuPrincipal = """
                    MENÚ PRINCIPAL
                    1. Gestión QuickPass
                    2. Gestión Accesos
                    3. Reportes
                    0. Salir
                    Ingrese el número de la opción deseada:
                    """;

            String opcion = JOptionPane.showInputDialog(menuPrincipal);

            if (opcion == null) { // Si el usuario presiona cancelar
                break;
            }

            switch (opcion) {
                case "1":
                    menuGestionQuickPass(gestionQuickPass);
                    break;
                case "2":
                    menuGestionAccesos(gestionAcceso, gestionQuickPass);
                    break;
                case "3":
                    menuReportes(gestionQuickPass);
                    break;
                case "0":
                    JOptionPane.showMessageDialog(null, "Saliendo del sistema...");
                    continuar = false;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida. Por favor, intente nuevamente.");
                    break;
            }
        }
    }

    private static void menuGestionQuickPass(GestionQuickPass gestionQuickPass) {
        boolean continuar = true;

        while (continuar) {
            String menuQuickPass = """
                    GESTIÓN QUICKPASS
                    1. Agregar QuickPass
                    2. Visualizar QuickPass
                    3. Eliminar QuickPass
                    4. Modificar QuickPass (No implementada)
                    0. Volver al menú principal
                    Ingrese el número de la opción deseada:
                    """;

            String opcion = JOptionPane.showInputDialog(menuQuickPass);

            if (opcion == null) { // Si el usuario presiona cancelar
                break;
            }

            switch (opcion) {
                case "1":
                    gestionQuickPass.agregarQuickPass();
                    break;
                case "2":
                    gestionQuickPass.visualizar();
                    break;
                case "3":
                    gestionQuickPass.eliminarQuickPass();
                    break;
                case "4":
                    String codigoDesactivar = JOptionPane.showInputDialog(null, "Ingrese el código del QuickPass a desactivar: ");
                    if (codigoDesactivar != null && !codigoDesactivar.isEmpty()) {
                        int codigo = Integer.parseInt(codigoDesactivar);
                        gestionQuickPass.desactivarQuickPass(codigo);
                    }
                    break;
                case "0":
                    continuar = false;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida. Por favor, intente nuevamente.");
                    break;
            }
        }
    }

    private static void menuGestionAccesos(GestionAcceso gestionAcceso, GestionQuickPass gestionQuickPass) {
        boolean continuar = true;

        while (continuar) {
            String menuAccesos = """
                    GESTIÓN ACCESOS
                    1. Agregar Acceso
                    2. Visualizar Accesos
                    3. Visualizar acceso por filial
                    4. Visualizar acceso por rango de fecha
                    5. Visualizar acceso por código
                    6. Visualizar acceso por placa
                    0. Volver al menú principal
                    Ingrese el número de la opción deseada:
                    """;

            String opcion = JOptionPane.showInputDialog(menuAccesos);

            if (opcion == null) { // Si el usuario presiona cancelar
                break;
            }

            switch (opcion) {
                case "1":
                    String sms = "";
                    QuickPass quickPass = gestionQuickPass.getArregloQuickPassperCodigo();
                    sms = gestionAcceso.consulta(quickPass);
                    System.out.println(sms);
                    break;
                case "2":
                    gestionAcceso.visualizarAccesos();
                    break;
                case "3":
                    gestionAcceso.visualizarPorFilial();
                    break;
                case "4":
                    gestionAcceso.visualizarPorFecha();
                    break;
                case "5":
                    gestionAcceso.visualizarPorCodigo();
                    break;
                case "6":
                    gestionAcceso.visualizarPorPlaca();
                    break;
                case "0":
                    continuar = false;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida. Por favor, intente nuevamente.");
                    break;
            }
        }
    }

    private static void menuReportes(GestionQuickPass gestionQuickPass) {
        boolean continuar = true;

        while (continuar) {
            String menuReportes = """
                    REPORTES
                    1. Total accesos registrados
                    2. Total de accesos por filial
                    3. Total de QuickPass registrados
                    4. Total de QuickPass Activos e Inactivos
                    5. Total de QuickPass eliminados
                    6. Volver al menú principal
                    Ingrese el número de la opción deseada:
                    """;

            String opcion = JOptionPane.showInputDialog(menuReportes);

            if (opcion == null) { // Si el usuario presiona cancelar
                break;
            }

            switch (opcion) {
                case "1":
                    JOptionPane.showMessageDialog(null, "Función Total accesos registrados aún no implementada.");
                    break;
                case "2":
                    JOptionPane.showMessageDialog(null, "Función Total de accesos por filial aún no implementada.");
                    break;
                case "3":
                    JOptionPane.showMessageDialog(null, "Función Total de QuickPass registrados aún no implementada.");
                    break;
                case "4":
                    JOptionPane.showMessageDialog(null, "Función Total de QuickPass Activos e Inactivos aún no implementada.");
                    break;
                case "5":
                    JOptionPane.showMessageDialog(null, "Función Total de QuickPass eliminados aún no implementada.");
                    break;
                case "6":
                    continuar = false;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida. Por favor, intente nuevamente.");
                    break;
            }
        }
    }
}
