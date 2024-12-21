/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;
import java.io.*;
import java.util.*;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import java.text.ParseException;
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
                JOptionPane.showMessageDialog(null,"Codigo no existe en la lista");
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
                JOptionPane.showMessageDialog(null,"QuickPass inactivo");
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
    
    void getAllAccesos(){
        Accesos datos[] = archivo.leerArchivoHistorial();
        for(int i = 0; i < datos.length; i++){
            arregloAccesos[i] = datos[i];
        }
    }
    
    private void setAcceso(Accesos acceso){
        archivo.escribirArchivoHistorial(acceso);
    }
    
    // VALIDACIONES
    // Validacion Codigo
    private boolean esCodigo(String codigo){
        if(codigo.length() < 10){
            return false;
        }
        
        if(!codigo.substring(0,3).equals("101")){
            return false;
        }
        
        // validar codigo es numerico
        for(int i = 0; i < codigo.length();i++){
            char c = codigo.charAt(i);
            if(!Character.isDigit(c)){
                    return false;
                }  
        }
        return true;
    }
    
    // Validacion Placa
    private boolean esPlaca(String placa){
        if(placa.length() != 6){
            return false;
        }
        
        // validar codigo es numerico
        for(int i = 0; i < placa.length();i++){
            char c = placa.charAt(i);
            if(!Character.isDigit(c)){
                    return false;
                }  
        }
        return true;
    }
    
    // Validacion Filial
    private boolean esFilial(String string){
        
        if(string.length() != 3){
            return false;
        }
        
        for(int i = 0; i < string.length();i++){
            char c = string.charAt(i);
            if( i == 0){
                if(!Character.isLetter(c)){
                    return false;
                }
            }else{
                if(!Character.isDigit(c)){
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean esFecha(String string){
        if (string == null || string.trim().isEmpty()) {
        return false;
        }
        
        if(string.length() != 10){
            return false;
        }
        
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        formato.setLenient(false); // Para validar fechas estrictamente
        try {
            formato.parse(string);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
    
    public void visualizarAccesos(){
        getAllAccesos();
        String r = "";
        for(int i = 0; i < arregloAccesos.length;i++){
            if(arregloAccesos[i]!=null){
                int puesto = i + 1;
                r += "\n" + puesto + ". Codigo: " + arregloAccesos[i].getCodigo()
                + " Filial: " + arregloAccesos[i].getFilial()
                + " Placa: " + arregloAccesos[i].getPlaca()
                + " Condicion: " + arregloAccesos[i].getCondicion()
                + " Fecha: " + arregloAccesos[i].getFecha();
            }
        }
        JOptionPane.showMessageDialog(null,r);
    }
    
    public void visualizarPorCodigo(){
        getAllAccesos();
        boolean esValido = false;
        
        while(!esValido){
            String input = JOptionPane.showInputDialog(null, "Ingrese el codigo: ");
            if (input == null) {
                JOptionPane.showMessageDialog(null, "Operación cancelada.");
                return; // Salir del método si se da cancelar
            }
            if(!esCodigo(input)){
                JOptionPane.showMessageDialog(null,"Codigo tiene que ser un numero de 10 digitos y empezar con 101 (i.e.:1011234567)");
            }else{
                int codigo = Integer.parseInt(input);
                String r = "";
                boolean encontrado = false;
                for(int i = 0; i < arregloAccesos.length;i++){
                    if(arregloAccesos[i]!=null){
                        if(arregloAccesos[i].getCodigo()==codigo){
                            encontrado = true;
                            r += "\n" + i + ". Codigo: " + arregloAccesos[i].getCodigo() +
                                    " Filial: " + arregloAccesos[i].getFilial() +
                                    " Placa: " + arregloAccesos[i].getPlaca() + 
                                    " Condicion: " + arregloAccesos[i].getCondicion() +
                                    " Fecha: " + arregloAccesos[i].getFecha();
                            
                        }
                    }
                }
                if (!encontrado) {
                    r = "No existe un registro de acceso con el codigo ingresada.";
                }
                JOptionPane.showMessageDialog(null,r);
                esValido = true;
            }
        }
    }
    
    public void visualizarPorPlaca(){
        getAllAccesos();
        boolean esValido = false;
        
        while(!esValido){
            String input = JOptionPane.showInputDialog(null, "Ingrese la placa: ");
            if (input == null) {
                JOptionPane.showMessageDialog(null, "Operación cancelada.");
                return; // Salir del método si se da cancelar
            }
            if(!esPlaca(input)){
                JOptionPane.showMessageDialog(null,"Placa tiene que ser un numero de 6 digitos(i.e.:123123)");
            }else{
                int placa = Integer.parseInt(input);
                String r = "";
                boolean encontrado = false;
                for(int i = 0; i < arregloAccesos.length;i++){
                    if(arregloAccesos[i]!=null){
                        if(arregloAccesos[i].getPlaca()==placa){
                            encontrado = true;
                            r += "\n" + i + ". Codigo: " + arregloAccesos[i].getCodigo() +
                                    " Filial: " + arregloAccesos[i].getFilial() +
                                    " Placa: " + arregloAccesos[i].getPlaca() + 
                                    " Condicion: " + arregloAccesos[i].getCondicion() +
                                    " Fecha: " + arregloAccesos[i].getFecha();
                            
                        }
                    }
                }
                if (!encontrado) {
                    r = "No existe un registro de acceso con la placa ingresada.";
                }
                JOptionPane.showMessageDialog(null,r);
                esValido = true;
            }
        }
    }
    
    public void visualizarPorFilial(){
        getAllAccesos();
        boolean esValido = false;
        
        while(!esValido){
            String filial = JOptionPane.showInputDialog(null, "Ingrese la filial: ");
            if (filial == null) {
                JOptionPane.showMessageDialog(null, "Operación cancelada.");
                return; // Salir del método si se da cancelar
            }
            if(!esFilial(filial)){
                JOptionPane.showMessageDialog(null,"Filial tiene que ser un alfanumero de 3 letras (i.e.:A12)");
            }else{
                String r = "";
                boolean encontrado = false;
                for(int i = 0; i < arregloAccesos.length;i++){
                    if(arregloAccesos[i]!=null){
                        if(arregloAccesos[i].getFilial().equals(filial)){
                            encontrado = true;
                            r += "\n" + i + ". Codigo: " + arregloAccesos[i].getCodigo() +
                                    " Filial: " + arregloAccesos[i].getFilial() +
                                    " Placa: " + arregloAccesos[i].getPlaca() + 
                                    " Condicion: " + arregloAccesos[i].getCondicion() +
                                    " Fecha: " + arregloAccesos[i].getFecha();
                            
                        }
                    }
                }
                if (!encontrado) {
                    r = "No existe un registro de acceso con la filial ingresada.";
                }
                JOptionPane.showMessageDialog(null,r);
                esValido = true;
            }
        }   
    }
    
    public void visualizarPorFecha(){
        getAllAccesos();
        boolean esValido = false;
        
        while(!esValido){
            String fecha = JOptionPane.showInputDialog(null, "Ingrese el dia (formato DD/MM/YYYY): ");
            if (fecha == null || fecha.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Operación cancelada o fecha vacía.");
                return;
            }
            if(!esFecha(fecha)){
                JOptionPane.showMessageDialog(null,"Fecha tiene que ser en formato valido (DD/MM/YYYY)(i.e.:29/11/2024)");
            }else{
            String r = "";
                boolean encontrado = false;

                for (int i = 0; i < arregloAccesos.length; i++) {
                    if (arregloAccesos[i] != null) {
                        String fechaArreglo = arregloAccesos[i].getFecha().substring(0, 10);
                        if (fechaArreglo.equals(fecha)) {
                            encontrado = true;
                            r += "\n" + i + ". Codigo: " + arregloAccesos[i].getCodigo() +
                                 " Filial: " + arregloAccesos[i].getFilial() +
                                 " Placa: " + arregloAccesos[i].getPlaca() +
                                 " Condicion: " + arregloAccesos[i].getCondicion() +
                                 " Fecha: " + arregloAccesos[i].getFecha();
                        }
                    }
                }

                if (!encontrado) {
                    r = "No existen registros con la fecha ingresada.";
                }

                JOptionPane.showMessageDialog(null, r);
                esValido = true;
            }
        }   
    }
    
    public void visualizarTodosPorFilial(){
        getAllAccesos();
        String r = "";
        for(int i = 0; i < arregloAccesos.length;i++){
            if(arregloAccesos[i]!=null){
                int puesto = i + 1;
                r += "\n" + puesto +". " + " Filial: " + arregloAccesos[i].getFilial()
                + "    Condicion: " + arregloAccesos[i].getCondicion();
            }
        }
        JOptionPane.showMessageDialog(null,r);
    }
    
    public Accesos[] getAccesos(){
        getAllAccesos();
        return arregloAccesos;
    }
    // Fin
}

