/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;

import javax.swing.JOptionPane;

/**
 *
 * @author Nicole
 */
public class Reporte {
     public void totalQuickPass(QuickPass[] arreglo){
        int count = 0;
        String qp = "";
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] != null) {
                qp += "\n" + arreglo[i].toString();
            count++;
            }
        }
        String m;
        if (count == 0) {
            m = "TOTAL = 0\n No hay registros.";
        } else {
            m = "TOTAL = " + count + "\nDESGLOSE: " + qp;
        }
        JOptionPane.showMessageDialog(null, m);
    }
     
    public void totalAccesos(Accesos[] arreglo){
        int count = 0;
        String acc = "";
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] != null) {
                acc += "\n" + arreglo[i].toString();
            count++;
            }
        }
        String m;
        if (count == 0) {
            m = "TOTAL = 0\n No hay registros.";
        } else {
            m = "TOTAL = " + count + "\nDESGLOSE: " + acc;
        }
        JOptionPane.showMessageDialog(null, m);
    }
    
    public void totalFilial(Accesos[] arreglo){
        String filial = JOptionPane.showInputDialog(null, "Ingrese la filial:");
        if (filial == null || filial.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Operación cancelada o filial vacía.");
            return;
        }
        int count = 0;
        String qp = "";
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] != null && arreglo[i].getFilial().equalsIgnoreCase(filial)) {
                qp += "\n" + arreglo[i].toString();
                count++;
            }
        }
        String m;
        if (count == 0) {
            m = "TOTAL = 0\nNo hay registros para la filial ingresada.";
        } else {
            m = "TOTAL = " + count + "\nDESGLOSE: " + qp;
        }

        JOptionPane.showMessageDialog(null, m);
    }
     
     public void totalActivos(QuickPass[] arreglo){
        int count = 0;
        String qp = "";
        for (int i = 0; i < arreglo.length; i++) {
           if (arreglo[i] != null && arreglo[i].getEstado() == Estado.ACTIVO) {
               qp += "\n" + arreglo[i].toString();
               count++;
           }
        }
        String m;
        if (count == 0) {
            m = "TOTAL = 0\n No hay registros.";
        } else {
            m = "TOTAL = " + count + "\nDESGLOSE: " + qp;
        }
        JOptionPane.showMessageDialog(null, m);
     }
     
     public void totalInactivos(QuickPass[] arreglo){
        int count = 0;
        String qp = "";
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] != null && arreglo[i].getEstado() == Estado.INACTIVO) {
                qp += "\n" + arreglo[i].toString();
                count++;
            }
        }
        String m;
        if (count == 0) {
            m = "TOTAL = 0\n No hay registros.";
        } else {
            m = "TOTAL = " + count + "\nDESGLOSE: " + qp;
        }
        JOptionPane.showMessageDialog(null, m); 
     }
     //END
}
