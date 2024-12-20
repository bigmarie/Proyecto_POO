/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;
import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Nicole
 */
public class GestionArchivo {
    
    public void crearArchivo(String nombre) {
        try {
          File archivo = new File(nombre);
          if (archivo.createNewFile()) {
            JOptionPane.showMessageDialog(null,"Archivo creado: " + archivo.getName());
          } else {
            JOptionPane.showMessageDialog(null,"Archivo ya existe.");
            JOptionPane.showMessageDialog(null,"Directorio de trabajo actual: " + System.getProperty("user.dir"));
          }
        } catch (IOException e) {
          JOptionPane.showMessageDialog(null,"Ha ocurrido un error.");
          e.printStackTrace();
            }
    }
    
    public Accesos[] leerArchivoHistorial(){
        String nombre = "Historial.txt";
        Accesos datos[] = null;
        
        try {
          int totalDatos = leerCantidad(nombre);
          
          datos = new Accesos[totalDatos];
          
          File archivo = new File(nombre);
          Scanner lector = new Scanner(archivo);
          String linea;
          int i = 0;
          
          while(lector.hasNextLine()) {
            linea = lector.nextLine();
            
            String[] partes = linea.split(",");
            
            int codigo = Integer.parseInt(partes[0].split(":")[1].trim());
            int placa = Integer.parseInt(partes[1].split(":")[1].trim());
            String filial = partes[2].split(":")[1].trim();
            Condicion condicion = Condicion.valueOf(partes[3].split(":")[1].trim().toUpperCase());
            String fecha = linea.substring(linea.indexOf("Fecha: ") + 7).trim();
            
            Accesos acceso = new Accesos(filial, codigo, placa, condicion, fecha);
            
            datos[i] = acceso;
            i++;
          }
          lector.close();
        } catch (FileNotFoundException e) {
          JOptionPane.showMessageDialog(null,"Ha ocurrido un error.");
          e.printStackTrace();
        }
        
        return datos;
    }
    
    public int leerCantidad(String nombre){
        int contador = 0;
        
        try{
           File archivo = new File(nombre);
           Scanner lector = new Scanner(archivo);
           String linea;
           
           while(lector.hasNextLine()){
            linea = lector.nextLine();
            contador ++;
           }
           lector.close();
        } catch(IOException e){
            JOptionPane.showMessageDialog(null,"Error al contar elementos");
            e.printStackTrace();
        }
        return contador;
    }
    
    public void escribirArchivoHistorial(Accesos acceso){
        String nombre = "Historial.txt";
        
        try {
         FileWriter archivo = new FileWriter(nombre,true);
             String linea = "\n" + "Codigo: " + acceso.getCodigo() +
                     ", Placa: " + acceso.getPlaca() +
                     ", Filial: " + acceso.getFilial() +
                     ", Condicion: " + acceso.getCondicion() +
                     ", Fecha: " + acceso.getFecha();
             archivo.write(linea);
         
         archivo.close();
         JOptionPane.showMessageDialog(null,"Se ha escrito correctamente");
       } catch (IOException e) {
         JOptionPane.showMessageDialog(null,"Ha ocurrido un error.");
         e.printStackTrace();
       }
    }
    // Fin
}
