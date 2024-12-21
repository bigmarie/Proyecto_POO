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
        Reporte reporte = new Reporte();
        
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

            if (opcion == null) { 
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
                    menuReportes(gestionQuickPass, gestionAcceso, reporte);
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
                    4. Modificar QuickPass
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
                    boolean est = true;
                    while (est){
                    String estados = """
                                    Estados
                                   1. Activar
                                   2. Desactivar
                                   0. Salir""";
                    String opcs = JOptionPane.showInputDialog(estados);    
                    if (opcs == null) { 
                break;
            }
                    switch (opcs){
                        case "1":
                    String codigoActivar = JOptionPane.showInputDialog(null, "Ingrese el código del QuickPass a activar: ");
                     if (codigoActivar != null && !codigoActivar.isEmpty()) {
                         int codigo = Integer.parseInt(codigoActivar);
                     gestionQuickPass.activarQuickPass(codigo);
                    }
                     break;
                        case "2":
                    String codigoDesactivar = JOptionPane.showInputDialog(null, "Ingrese el código del QuickPass a desactivar: ");
                    if (codigoDesactivar != null && !codigoDesactivar.isEmpty()) {
                        int codigo = Integer.parseInt(codigoDesactivar);
                        gestionQuickPass.desactivarQuickPass(codigo);
                    }
                    break;
                    case "0":
                    est = false;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida. Por favor, intente nuevamente.");
                    break;
                    }}

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
                    if (quickPass == null) {
                        JOptionPane.showMessageDialog(null, "Operación cancelada.");
                    } else {
                        // Solo si no se cancela, procedemos con la consulta
                        sms = gestionAcceso.consulta(quickPass);
                        JOptionPane.showMessageDialog(null, sms);
                    }
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

    private static void menuReportes(GestionQuickPass gestionQuickPass, GestionAcceso gestionAcceso, Reporte reporte) {
        boolean continuar = true;

        while (continuar) {
            String menuReportes = """
                    REPORTES
                    1. Total accesos registrados
                    2. Total de accesos por filial
                    3. Total de QuickPass registrados
                    4. Total de QuickPass Activos e Inactivos
                    5. Total de QuickPass eliminados
                    0. Volver al menú principal
                    Ingrese el número de la opción deseada:
                    """;

            String opcion = JOptionPane.showInputDialog(menuReportes);

            if (opcion == null) { // Si el usuario presiona cancelar
                break;
            }

            switch (opcion) {
                case "1":
                    reporte.totalAccesos(gestionAcceso.getAccesos());
                    break;
                case "2":
                    reporte.totalFilial(gestionAcceso.getAccesos());
                    break;
                case "3":
                    reporte.totalQuickPass(gestionQuickPass.getArregloQuickPass("QuickPass"));
                    break;
                case "4":
                    String m = """
                               REPORTES ACTIVO E INACTIVO
                               1. Total Activos
                               2. Total Inactivos no eliminados
                               3. Total Inactivos eliminados
                               """;
                    String opc = JOptionPane.showInputDialog(m);
                    if (opc == null) { // Si el usuario presiona cancelar
                        break;
                    }
                    switch(opc){
                        case "1":
                            reporte.totalActivos(gestionQuickPass.getArregloQuickPass("QuickPass"));
                            break;
                        case "2":
                            reporte.totalInactivos(gestionQuickPass.getArregloQuickPass("QuickPass"));
                            break;
                        case "3":
                            reporte.totalInactivos(gestionQuickPass.getArregloQuickPass("Eliminados"));
                            break;
                        default:
                            break;
                    }
                    break;
                case "5":
                    reporte.totalQuickPass(gestionQuickPass.getArregloQuickPass("Eliminados"));
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
}
