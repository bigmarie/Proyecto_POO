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
        boolean salir = false;
        
        while (!salir) {
            // Menú Principal
            String menu = "MENU PRINCIPAL\n"
                    + "1. Gestión QuickPass\n"
                    + "2. Gestión Accesos\n"
                    + "3. Reportes\n"
                    + "0. Salir\n"
                    + "Ingrese una opción: ";
            
            String opcion = JOptionPane.showInputDialog(null, menu);

            switch (opcion) {
                case "1":
                    menuQuickPass(gestionQuickPass);
                    break;
                case "2":
                    
                    JOptionPane.showMessageDialog(null, "Funcionalidad no implementada aún.");
                    break;
                case "3":
                    
                    JOptionPane.showMessageDialog(null, "Funcionalidad no implementada aún.");
                    break;
                case "0":
                    salir = true;
                    JOptionPane.showMessageDialog(null, "Gracias por usar el sistema.");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida. Intente nuevamente.");
            }
        }
    }

    public static void menuQuickPass(GestionQuickPass gestionQuickPass) {
        boolean salirQuickPass = false;

        while (!salirQuickPass) {
            
            String menuQuickPass = "GESTIÓN QUICKPASS\n"
                    + "1. Agregar QuickPass\n"
                    + "2. Visualizar QuickPass\n"
                    + "3. Eliminar QuickPass\n"
                    + "4. Desactivar QuickPass\n"
                    + "5. Volver al Menú Principal\n"
                    + "Ingrese una opción: ";

            String opcionQuickPass = JOptionPane.showInputDialog(null, menuQuickPass);

            switch (opcionQuickPass) {
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
                case "5":
                    salirQuickPass = true;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida. Intente nuevamente.");
            }
        }
    }
}
