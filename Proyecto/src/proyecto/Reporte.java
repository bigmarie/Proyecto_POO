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
        String m = "TOTAL = " +count+ 
                "\n DESGLOSE: " + qp;
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
        String m = "TOTAL ACTIVOS = " + count +
                  "\n DESGLOSE: " + qp;
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
        String m = "TOTAL INACTIVOS = " + count +
                   "\n DESGLOSE: " + qp;
        JOptionPane.showMessageDialog(null, m); 
     }
     //END
}
