/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto;
import java.io.*;

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
        GestionArchivo gestionArchivo = new GestionArchivo();
        
        for(int i = 0; i < 2; i++){
           gestionQuickPass.agregarQuickPass(); 
        }
        
        gestionQuickPass.eliminarQuickPass();
        
        for(int i = 0; i < 2; i++){
           gestionQuickPass.visualizar();
        }
        
//        Accesos data[] = gestionArchivo.leerArchivoHistorial();
//        
//        for(int i = 0; i < data.length; i++){
//            System.out.println(data[i].getCodigo() + ", " 
//                    + data[i].getFecha() + ", " 
//                    + data[i].getFilial() + ", " 
//                    + data[i].getPlaca() + ", " 
//                    + data[i].getCondicion());
//        }
//        
//        Accesos[] accesos = {
//            new Accesos("A03", 1010000002, 111111, Condicion.ACEPTADO, "21/11/2024 12:45"),
//            new Accesos("A04", 1010000003, 111112, Condicion.ACEPTADO, "21/11/2024 12:40")
//        };
//        
//        gestionArchivo.escribirArchivoHistorial(accesos);
//        
//        data = gestionArchivo.leerArchivoHistorial();
//        
//        for(int i = 0; i < data.length; i++){
//            System.out.println(data[i].getCodigo() + ", " 
//                    + data[i].getFecha() + ", " 
//                    + data[i].getFilial() + ", " 
//                    + data[i].getPlaca() + ", " 
//                    + data[i].getCondicion());
//        }
    }    
}
