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
public class GestionQuickPass {
    private QuickPass arregloQuickPass[];
    
    public void agregarQuickPass(){
    
        String filial = agregarFilial(); 
        int codigo = agregarCodigo();
        int placa = agregarPlaca();
        Estado estado = Estado.ACTIVO;
        
        
    }
    // Agregar Filial Quickpass
    public String agregarFilial(){
        boolean esValido = false;
        String filial = "";
        
        while(!esValido){
            filial = JOptionPane.showInputDialog(null, "Ingrese la filial: ");
            if(!esFilial(filial)){
                System.out.println("Filial tiene que ser un alfanumero de 3 letras (i.e.:A12)");
            }else{
                System.out.println("Filial validada");
                esValido = true;
            }
        }
        
        return filial;  
    }
    
    // Validacion Filial
    public boolean esFilial(String string){
        
        if(string.length() < 3){
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
    
    // 
    public int agregarCodigo(){
        boolean esValido = false;
        String inputCodigo;
        int codigo = 0;
        
        while(!esValido){
           inputCodigo = JOptionPane.showInputDialog(null, "Ingrese el codigo: ");
           if(!esCodigo(inputCodigo)){
               System.out.println("Codigo tiene que ser un numero de 10 digitos y empezar con 101 (i.e.:1011234567)");
           }else{
               codigo = Integer.parseInt(inputCodigo);
               System.out.println("codigo validado");
               esValido = true;
           }
        }
        
        
        return codigo;
    }
    
    // Validacion Codigo
    public boolean esCodigo(String codigo){
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
    
    public int agregarPlaca(){
        boolean esValido = false;
        String inputPlaca = "";
        int placa = 0;
        
        while(!esValido){
            inputPlaca = JOptionPane.showInputDialog(null, "Ingrese el codigo: ");
            if(!esCodigo(inputPlaca)){
                       System.out.println("Placa tiene que ser un numero de 6 digitos(i.e.:123123)");
                   }else{
                       placa = Integer.parseInt(inputPlaca);
                       System.out.println("Placa validada");
                       esValido = true;
                   }
                }
        return placa;
    }
    
    public boolean esPlaca(String placa){
        if(placa.length() < 6){
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
}
