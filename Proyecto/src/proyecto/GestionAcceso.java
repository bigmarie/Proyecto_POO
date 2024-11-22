/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;
import java.io.*;
import java.util.*;
import java.text.SimpleDateFormat;

/**
 *
 * @author Nicole
 */
public class GestionAcceso {
    private Accesos arregloAccesos[] = new Accesos[400];
    
    public void ingresoQuickPass(QuickPass arreglo){
        Date fechaActual = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        
        String fecha = formato.format(fechaActual);   
    }
    // Fin
}
