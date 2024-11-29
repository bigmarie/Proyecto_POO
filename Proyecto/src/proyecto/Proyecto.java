/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
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
        boolean esValido = false;
        GestionQuickPass gestionQuickPass = new  GestionQuickPass();
        GestionAcceso gestionAcceso = new GestionAcceso();
        
        while(!esValido){
            String m = "MENU \n"
                + "1. Usuario \n"
                + "2. Administrador \n"
                + "0. Salir \n"
                + "Ingrese la opcion que desea: ";
            String r = JOptionPane.showInputDialog(null, m);
            
            switch(r){
                case "1":
                    String sms = "";
                    QuickPass quickPass = gestionQuickPass.getArregloQuickPassperCodigo();
                    sms = gestionAcceso.consulta(quickPass);
                    System.out.println(sms);
                    break;
                case "2":
                    boolean esSalir = false;
                    
                    while(!esSalir){
                        m = "MENU \n"
                            + "1. Gestion QuickPass \n"
                            + "2. Gestion Acceso \n"
                            + "3. Reportes \n"
                            + "0. Salir \n"
                            + "Ingrese la opcion que desea: ";
                        String admin = JOptionPane.showInputDialog(null, m);
                        switch(admin){
                            case "1":
                                gestionQuickPass.agregarQuickPass();
                            case "2":
                                break;
                            case "3":
                                break;
                            case "0":
                                esSalir = true;
                                break;
                            default:
                                break;
                        }
                    }
                    break;
                case "0":
                    esValido = true;
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        }
        
        // End
    }    
}
