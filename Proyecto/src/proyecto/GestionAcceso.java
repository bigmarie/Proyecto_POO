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
    private GestionArchivo archivo = new GestionArchivo();
    private Accesos arregloAccesos[] = new Accesos[400];
    
    // Consulta de ingresos por codigo
    public String consulta(QuickPass arreglo){
        Date fechaActual = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        
        String fecha = formato.format(fechaActual);
        
        getAllAccesos();
        
        if(arreglo == null){
            for(int i = 0; i < arregloAccesos.length; i++){
            if(arregloAccesos[i] == null){
                Accesos acceso = new Accesos("",0,0,Condicion.RECHAZADO,fecha);
                arregloAccesos[i] = acceso;
                System.out.println("Codigo no existe en la lista");
                Accesos arregloAcceso = arregloAccesos[i];
                setAcceso(arregloAcceso);
                return "RECHAZADO";
                }
            }
        }
        
        String filial = arreglo.getFilial();
        int placa = arreglo.getPlaca();
        int codigo = arreglo.getCodigo();
        Estado estado = arreglo.getEstado();  
        
        if(estado == Estado.INACTIVO){
          for(int i = 0; i < arregloAccesos.length; i++){
            if(arregloAccesos[i] == null){
                Accesos acceso = new Accesos(filial,codigo,placa,Condicion.RECHAZADO,fecha);
                arregloAccesos[i] = acceso;
                System.out.println("QuickPass inactivo");
                Accesos arregloAcceso = arregloAccesos[i];
                setAcceso(arregloAcceso);
                return "RECHAZADO";
                }
            }  
        }
        
        for(int i = 0; i < arregloAccesos.length; i++){
            if(arregloAccesos[i] == null){
                Accesos acceso = new Accesos(filial,codigo,placa,Condicion.ACEPTADO,fecha);
                arregloAccesos[i] = acceso;
                Accesos arregloAcceso = arregloAccesos[i];
                setAcceso(arregloAcceso);
                return "ACEPTADO";
                }
            }
        return null;
    }
    
    private void getAllAccesos(){
        Accesos datos[] = archivo.leerArchivoHistorial();
        for(int i = 0; i < datos.length; i++){
            arregloAccesos[i] = datos[i];
        }
    }
    
    private void setAcceso(Accesos acceso){
        archivo.escribirArchivoHistorial(acceso);
    }
    
    // Fin
}
