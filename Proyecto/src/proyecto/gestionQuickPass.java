/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;

import java.util.HashSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Nicole
 */
public class GestionQuickPass{
    private QuickPass arregloQuickPass[] = new QuickPass[150];
    private QuickPass quickPassEliminados[] = new QuickPass[150];
    
    // AGREGAR
    // Agregar quickpass nuevo al arreglo
    public void agregarQuickPass(){
    
        String filial = agregarFilial(); 
        if (filial == null) { // Si la operación fue cancelada
            return; // Salir de la operación
        }
        int codigo = agregarCodigo();
        if (codigo == -1) { // Si la operación fue cancelada
            return; // Salir de la operación
        }
        int placa = agregarPlaca();
        if (placa == -1) { // Si la operación fue cancelada
            return; // Salir de la operación
        }
        Estado estado = Estado.ACTIVO;
        agregarArregloQuickPass(filial, codigo, placa, estado);
    }
    
    public void agregarArregloQuickPass(String filial, int codigo, int placa, Estado estado){
        for(int i = 0; i < arregloQuickPass.length; i++){
            if(arregloQuickPass[i] == null){
                QuickPass nuevoQuickPass = new QuickPass(filial, codigo, placa, estado);
                arregloQuickPass[i] = nuevoQuickPass;
                JOptionPane.showMessageDialog(null,"QuickPass agregado correctamente");
                return;
            }
        }
    }

    // Agregar Filial Quickpass
    private String agregarFilial(){
        boolean esValido = false;
        String filial = "";
        
        while(!esValido){
            filial = JOptionPane.showInputDialog(null, "Ingrese la filial: ");
            
            if (filial == null) { // Verificar si el usuario canceló
                JOptionPane.showMessageDialog(null, "Operación cancelada.");
                return null; // Cancelar operación y retornar null
            }
            if(!esFilial(filial)){
                JOptionPane.showMessageDialog(null,"Filial tiene que ser un alfanumero de 3 letras (i.e.:A12)");
            }else{
                JOptionPane.showMessageDialog(null,"Filial validada");
                esValido = true;
            }
        }
        
        return filial;  
    }
    
    // Agregar Codigo quickpass
    private int agregarCodigo(){
        boolean esValido = false;
        String inputCodigo;
        int codigo = 0;
        
        while(!esValido){
           inputCodigo = JOptionPane.showInputDialog(null, "Ingrese el codigo: ");
           if (inputCodigo == null || inputCodigo.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Operación cancelada.");
                return -1; // Devuelve -1 para indicar que no se ingresó un código válido
            }
           if(!esCodigo(inputCodigo)){
               JOptionPane.showMessageDialog(null,"Codigo tiene que ser un numero de 10 digitos y empezar con 101 (i.e.:1011234567)");
           }else{
               codigo = Integer.parseInt(inputCodigo);
               if(!existeQuickPass(codigo)){
                   JOptionPane.showMessageDialog(null,"Codigo validado");
                   esValido = true;
               }else{
                   JOptionPane.showMessageDialog(null,"Codigo en uso");
               }
           }
        }
        
        
        return codigo;
    }
    
    // Agregar placa quickpass
    private int agregarPlaca(){
        boolean esValido = false;
        String inputPlaca = "";
        int placa = 0;
        
        while(!esValido){
            inputPlaca = JOptionPane.showInputDialog(null, "Ingrese la placa: ");
            if (inputPlaca == null) { // Verificar si el usuario canceló
                JOptionPane.showMessageDialog(null, "Operación cancelada.");
                return -1; // Cancelar operación y retornar -1
            }
            if(!esPlaca(inputPlaca)){
                       JOptionPane.showMessageDialog(null,"Placa tiene que ser un numero de 6 digitos(i.e.:123123)");
                   }else{
                       placa = Integer.parseInt(inputPlaca);
                       JOptionPane.showMessageDialog(null,"Placa validada");
                       esValido = true;
                   }
                }
        return placa;
    }
    
    private void agregarArregloEliminado(QuickPass quickPassEliminado){
        for(int i = 0; i < quickPassEliminados.length;i++){
            if(quickPassEliminados[i]==null){
                quickPassEliminado.setEstado(Estado.INACTIVO);
                quickPassEliminados[i] = quickPassEliminado;
                return;
            }
        }
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
    
    // Validar si existe quickpass
    private boolean existeQuickPass(int codigo){
        for(int i = 0; i < arregloQuickPass.length; i++){
            if(arregloQuickPass[i] != null){
                if(arregloQuickPass[i].codigo == codigo){
                return true;
                }
            }
        }
        return false;
    }
        
    // ELIMINAR
    public void eliminarQuickPass(){
        boolean esValido = false;
        String opcion = "";
        String codigo = "";
        String filial = "";
        
        while(!esValido){
            opcion = JOptionPane.showInputDialog(null, "ELIMINAR \n 1. Por codigo \n 2. Por filial \n Ingrese el número de la opción a escoger: ");
            
            if (opcion == null) {
                JOptionPane.showMessageDialog(null, "Operación cancelada.");
                return; // Salir si se cancela
            }
            
            switch(opcion){
                case "1":
                    while(!esValido){
                        codigo = JOptionPane.showInputDialog(null, "Ingrese el codigo: ");
                        if (codigo == null) {
                            JOptionPane.showMessageDialog(null, "Operación cancelada.");
                            return; // Salir si se cancela
                        }
                        if(!esCodigo(codigo)){
                            JOptionPane.showMessageDialog(null,"Codigo tiene que ser un numero de 10 digitos y empezar con 101 (i.e.:1011234567)");
                        }else{
                            int codigoInt = Integer.parseInt(codigo);
                            eliminarQuickPassporCodigo(codigoInt);
                            esValido = true;
                        }
                    }
                    break;
                case "2":
                    while(!esValido){
                        filial = JOptionPane.showInputDialog(null, "Ingrese la filial: ");
                        if (filial == null) {
                            JOptionPane.showMessageDialog(null, "Operación cancelada.");
                            return; // Salir si se cancela
                        }
                        if(!esFilial(filial)){
                            JOptionPane.showMessageDialog(null,"Filial tiene que ser un alfanumero de 3 letras (i.e.:A12)");
                        }else{
                            eliminarQuickPassporFilial(filial);
                            esValido = true;
                            JOptionPane.showMessageDialog(null,"Filial eliminado");
                        }
                    }
                    break;
                default:
                    JOptionPane.showMessageDialog(null,"Opcion no valida");
                    break;
            }
        }
    }
    
    private void eliminarQuickPassporCodigo(int codigo){
        boolean encontrado = false;
        for(int i = 0; i < arregloQuickPass.length; i++){
            if(arregloQuickPass[i]!=null){
                if(arregloQuickPass[i].codigo == codigo){
                    agregarArregloEliminado(arregloQuickPass[i]);
                    arregloQuickPass[i] = null;
                    encontrado = true;
                    break;
                }
            }
        }
        if(encontrado){
            JOptionPane.showMessageDialog(null, "Código eliminado");
        } else {
            // Si no se encontró el código, mostramos un mensaje de error
            JOptionPane.showMessageDialog(null, "Código no encontrado");
        }
    }
    
    private void eliminarQuickPassporFilial(String filial){
        boolean encontrado = false;
        for(int i = 0; i < arregloQuickPass.length; i++){
            if(arregloQuickPass[i]!=null){
                if(arregloQuickPass[i].getFilial().equals(filial)){
                    agregarArregloEliminado(arregloQuickPass[i]);
                    arregloQuickPass[i] = null;
                    encontrado = true;
                }
            }
        }
        if (!encontrado) {
            JOptionPane.showMessageDialog(null, "No se encontró QuickPass con esa filial.");
        }
    }
    
    // VISUALIZAR
    public void visualizar(){
        boolean esValido = false;
        String opcion = "";
        String opcion2 = "";
        String codigo = "";
        String filial = "";
        
        String menu = "VISUALIZAR \n 1. Todos los QuickPass \n 2. Por codigo \n 3. Por filial \n Ingrese el número de la opción a escoger: ";
        
        while(!esValido){
            opcion = JOptionPane.showInputDialog(null, "VISUALIZAR \n 1. QuickPass Agregados \n 2. QuickPass Eliminados \n Ingrese el número de la opción a escoger: ");
            
            if (opcion == null) { // Verificar si el usuario canceló
                JOptionPane.showMessageDialog(null, "Operación cancelada.");
                return; // Salir de la operación
            }
            switch(opcion){
                case "1":
                    while(!esValido){
                        opcion2 = JOptionPane.showInputDialog(null, menu);
                        if (opcion2 == null) { // Verificar si el usuario canceló
                            JOptionPane.showMessageDialog(null, "Operación cancelada.");
                            return; // Salir de la operación
                        }
                        switch(opcion2){
                            case "1":
                                visualizarTodos(arregloQuickPass);
                                esValido = true;
                                break;
                            case "2":
                                while(!esValido){
                                    codigo = JOptionPane.showInputDialog(null, "Ingrese el codigo: ");
                                    if (codigo == null) { // Verificar si el usuario canceló
                                        JOptionPane.showMessageDialog(null, "Operación cancelada.");
                                        return; // Salir de la operación
                                    }
                                    if(!esCodigo(codigo)){
                                        JOptionPane.showMessageDialog(null,"Codigo tiene que ser un numero de 10 digitos y empezar con 101 (i.e.:1011234567)");
                                    }else{
                                        int codigoInt = Integer.parseInt(codigo);
                                        visualizarPorCodigo(codigoInt, arregloQuickPass);
                                        esValido = true;
                                    }
                                }
                                break;
                            case "3":
                                while(!esValido){
                                    filial = JOptionPane.showInputDialog(null, "Ingrese la filial: ");
                                    if (filial == null) { // Verificar si el usuario canceló
                                        JOptionPane.showMessageDialog(null, "Operación cancelada.");
                                        return; // Salir de la operación
                                    }
                                    if(!esFilial(filial)){
                                        JOptionPane.showMessageDialog(null,"Filial tiene que ser un alfanumero de 3 letras (i.e.:A12)");
                                    }else{
                                        visualizarPorFilial(filial, arregloQuickPass);
                                        esValido = true;
                                    }
                                }
                                break;
                            default:
                                JOptionPane.showMessageDialog(null,"Opcion no valida");
                                break;
                        }
                    }
                break;
                case "2":
                   while(!esValido){
                        opcion2 = JOptionPane.showInputDialog(null, menu);
                        if (opcion2 == null) { // Verificar si el usuario canceló
                            JOptionPane.showMessageDialog(null, "Operación cancelada.");
                            return; // Salir de la operación
                        }
                        switch(opcion2){
                            case "1":
                                visualizarTodos(quickPassEliminados);
                                esValido = true;
                                break;
                            case "2":
                                while(!esValido){
                                    codigo = JOptionPane.showInputDialog(null, "Ingrese el codigo: ");
                                    if (codigo == null) { // Verificar si el usuario canceló
                                        JOptionPane.showMessageDialog(null, "Operación cancelada.");
                                        return; // Salir de la operación
                                    }
                                    if(!esCodigo(codigo)){
                                        JOptionPane.showMessageDialog(null,"Codigo tiene que ser un numero de 10 digitos y empezar con 101 (i.e.:1011234567)");
                                    }else{
                                        int codigoInt = Integer.parseInt(codigo);
                                        visualizarPorCodigo(codigoInt, quickPassEliminados);
                                        esValido = true;
                                    }
                                }
                                break;
                            case "3":
                                while(!esValido){
                                    filial = JOptionPane.showInputDialog(null, "Ingrese la filial: ");
                                    if (filial == null) { // Verificar si el usuario canceló
                                        JOptionPane.showMessageDialog(null, "Operación cancelada.");
                                        return; // Salir de la operación
                                    }
                                    if(!esFilial(filial)){
                                        JOptionPane.showMessageDialog(null,"Filial tiene que ser un alfanumero de 3 letras (i.e.:A12)");
                                    }else{
                                        visualizarPorFilial(filial, quickPassEliminados);
                                        esValido = true;
                                    }
                                }
                                break;
                            default:
                                JOptionPane.showMessageDialog(null,"Opcion no valida");
                                break;
                        }
                    }
                break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion no valida");
                break;
            }
        }
    }
    
    private void visualizarTodos(QuickPass arreglo[]){
        for(int i = 0; i < arreglo.length;i++){
            if(arreglo[i]!=null){
                String r = "";
                r += "\n" + i + ". Codigo: " + arreglo[i].getCodigo() +
                        " Filial: " + arreglo[i].getFilial() +
                        " Placa: " + arreglo[i].getPlaca() + 
                        " Estado: " + arreglo[i].getEstado();
                JOptionPane.showMessageDialog(null,r);
            }
        }
    }
    
    private void visualizarPorCodigo(int codigo, QuickPass arreglo[]){
        for(int i = 0; i < arreglo.length;i++){
            if(arreglo[i]!=null){
                if(arreglo[i].getCodigo()==codigo){
                    String r = "";
                    r += "\n" + i + ". Codigo: " + arreglo[i].getCodigo() +
                            " Filial: " + arreglo[i].getFilial() +
                            " Placa: " + arreglo[i].getPlaca() + 
                            " Estado: " + arreglo[i].getEstado();
                    JOptionPane.showMessageDialog(null,r);
                }
            }
        }
    }
    
    private void visualizarPorFilial(String filial, QuickPass arreglo[]){
        for(int i = 0; i < arreglo.length;i++){
            if(arreglo[i]!=null){
                if(arreglo[i].getFilial().equals(filial)){
                    String r = "";
                    r += "\n" + i + ". Codigo: " + arreglo[i].getCodigo() +
                            " Filial: " + arreglo[i].getFilial() +
                            " Placa: " + arreglo[i].getPlaca() + 
                            " Estado: " + arreglo[i].getEstado();
                    JOptionPane.showMessageDialog(null,r);
                }
            }
        }
    }

    // en progreso
    public QuickPass getArregloQuickPassperCodigo(){
        String inputCodigo = "";
        boolean esValido = false;
        int codigo = 0;
        
        while(!esValido){
            inputCodigo = JOptionPane.showInputDialog(null, "Ingrese el codigo: ");
            
            if (inputCodigo == null) {
                return null; // Retorna null si se cancela la operación
            }
            if(!esCodigo(inputCodigo)){
                JOptionPane.showMessageDialog(null,"Codigo tiene que ser un numero de 10 digitos y empezar con 101 (i.e.:1011234567)");
            }else{
               codigo = Integer.parseInt(inputCodigo);
               
               for(int i = 0; i < arregloQuickPass.length; i++){
                   if(arregloQuickPass[i]!=null){
                       if(arregloQuickPass[i].codigo == codigo){
                           esValido = true;
                           return arregloQuickPass[i];
                       }
                   }
               }
               esValido = true;
               return null;
               
           }
        }
        return null;
    }

    public QuickPass[] getArregloQuickPass(String arreglo){
        switch(arreglo){
            case "QuickPass":
                return arregloQuickPass;
            case "Eliminados":
                return quickPassEliminados;
            default:
                break;
        }
        return null;
    }
    
    // MODIFICAR
        public void desactivarQuickPass(int codigo) {
        for (int i = 0; i < arregloQuickPass.length; i++) {
            if (arregloQuickPass[i] != null && arregloQuickPass[i].getCodigo() == codigo) {
                arregloQuickPass[i].setEstado(Estado.INACTIVO);  // Cambiar estado a INACTIVO
                JOptionPane.showMessageDialog(null, "QuickPass desactivado.");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "QuickPass con ese código no encontrado.");
    }
        public void activarQuickPass(int codigo) {
        for (int i = 0; i < arregloQuickPass.length; i++) {
            if (arregloQuickPass[i] != null && arregloQuickPass[i].getCodigo() == codigo) {
                arregloQuickPass[i].setEstado(Estado.ACTIVO);  
                JOptionPane.showMessageDialog(null, "QuickPass activado.");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "QuickPass con ese código no encontrado.");
    }
// Fin
}
