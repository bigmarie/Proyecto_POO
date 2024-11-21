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
    private QuickPass arregloQuickPass[] = new QuickPass[150];
    private QuickPass quickPassEliminados[] = new QuickPass[150];
    
    // AGREGAR
    // Agregar quickpass nuevo al arreglo
    public void agregarQuickPass(){
    
        String filial = agregarFilial(); 
        int codigo = agregarCodigo();
        int placa = agregarPlaca();
        Estado estado = Estado.ACTIVO;
        
        agregarArregloQuickPass(filial, codigo, placa, estado);
    }
    
    public void agregarArregloQuickPass(String filial, int codigo, int placa, Estado estado){
        for(int i = 0; i < arregloQuickPass.length; i++){
            if(arregloQuickPass[i] == null){
                QuickPass nuevoQuickPass = new QuickPass(filial, codigo, placa, estado);
                arregloQuickPass[i] = nuevoQuickPass;
                System.out.println("QuickPass agregado correctamente");
                return;
            }
        }
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
    
    // Agregar Codigo quickpass
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
               if(!existeQuickPass(codigo)){
                   System.out.println("Codigo validado");
                   esValido = true;
               }else{
                   System.out.println("Codigo en uso");
               }
           }
        }
        
        
        return codigo;
    }
    
    // Agregar placa quickpass
    public int agregarPlaca(){
        boolean esValido = false;
        String inputPlaca = "";
        int placa = 0;
        
        while(!esValido){
            inputPlaca = JOptionPane.showInputDialog(null, "Ingrese la placa: ");
            if(!esPlaca(inputPlaca)){
                       System.out.println("Placa tiene que ser un numero de 6 digitos(i.e.:123123)");
                   }else{
                       placa = Integer.parseInt(inputPlaca);
                       System.out.println("Placa validada");
                       esValido = true;
                   }
                }
        return placa;
    }
    
    public void agregarArregloEliminado(QuickPass quickPassEliminado){
        for(int i = 0; i < arregloQuickPass.length;i++){
            if(arregloQuickPass[i]==null){
                arregloQuickPass[i] = quickPassEliminado;
                return;
            }
        }
    }
    // VALIDACIONES
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
    
    // Validacion Placa
    public boolean esPlaca(String placa){
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
    public boolean esFilial(String string){
        
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
    public boolean existeQuickPass(int codigo){
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
            opcion = JOptionPane.showInputDialog(null, "ELIMINAR \n 1. Por codigo \n 2. Por placa \n Ingrese el número de la opción a escoger: ");
            
            switch(opcion){
                case "1":
                    while(!esValido){
                        codigo = JOptionPane.showInputDialog(null, "Ingrese el codigo: ");
                        if(!esCodigo(codigo)){
                            System.out.println("Codigo tiene que ser un numero de 10 digitos y empezar con 101 (i.e.:1011234567)");
                        }else{
                            int codigoInt = Integer.parseInt(codigo);
                            eliminarQuickPassporCodigo(codigoInt);
                            esValido = true;
                            System.out.println("Codigo eliminado");
                        }
                    }
                    break;
                case "2":
                    while(!esValido){
                        filial = JOptionPane.showInputDialog(null, "Ingrese la filial: ");
                        if(!esFilial(filial)){
                            System.out.println("Filial tiene que ser un alfanumero de 3 letras (i.e.:A12)");
                        }else{
                            eliminarQuickPassporFilial(filial);
                            esValido = true;
                            System.out.println("Filial eliminado");
                        }
                    }
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        }
    }
    
    public void eliminarQuickPassporCodigo(int codigo){
        for(int i = 0; i < arregloQuickPass.length; i++){
            if(arregloQuickPass[i]!=null){
                if(arregloQuickPass[i].codigo == codigo){
                    agregarArregloEliminado(arregloQuickPass[i]);
                    arregloQuickPass[i] = null;
                }
            }
        }
    }
    
    public void eliminarQuickPassporFilial(String filial){
        for(int i = 0; i < arregloQuickPass.length; i++){
            if(arregloQuickPass[i]!=null){
                if(arregloQuickPass[i].getFilial().equals(filial)){
                    agregarArregloEliminado(arregloQuickPass[i]);
                    arregloQuickPass[i] = null;
                }
            }
        }
    }
    
    // VISUALIZAR
    public void visualizar(){
        boolean esValido = false;
        String opcion = "";
        String opcion2 = "";
        String codigo = "";
        
        String menu = "VISUALIZAR \n 1. Todos los QuickPass \n 2. Por codigo \n 3. Por filial \n Ingrese el número de la opción a escoger: ";
        
        while(!esValido){
            opcion = JOptionPane.showInputDialog(null, "VISUALIZAR \n 1. QuickPass Agregados \n 2. QuickPass Eliminados \n Ingrese el número de la opción a escoger: ");
            
            switch(opcion){
                case "1":
                    while(!esValido){
                        opcion2 = JOptionPane.showInputDialog(null, menu);
                        switch(opcion2){
                            case "1":
                                visualizarTodos(arregloQuickPass);
                                esValido = true;
                                break;
                            case "2":
                                while(!esValido){
                                    codigo = JOptionPane.showInputDialog(null, "Ingrese el codigo: ");
                                    if(!esCodigo(codigo)){
                                        System.out.println("Codigo tiene que ser un numero de 10 digitos y empezar con 101 (i.e.:1011234567)");
                                    }else{
                                        int codigoInt = Integer.parseInt(codigo);
                                        eliminarQuickPassporCodigo(codigoInt);
                                        esValido = true;
                                        System.out.println("Codigo eliminado");
                                    }
                                }
                                visualizarPorCodigo(arregloQuickPass);
                                esValido = true;
                                break;
                            case "3":
                                visualizarPorFilial(arregloQuickPass);
                                esValido = true;
                                break;
                            default:
                                System.out.println("Opcion no valida");
                                break;
                        }
                    }
                break;
                case "2":
                    while(!esValido){
                        opcion2 = JOptionPane.showInputDialog(null, menu);
                        switch(opcion2){
                            case "1":
                                visualizarTodos(quickPassEliminados);
                                esValido = true;
                                break;
                            case "2":
                                visualizarPorCodigo(quickPassEliminados);
                                esValido = true;
                                break;
                            case "3":
                                visualizarPorFilial(quickPassEliminados);
                                esValido = true;
                                break;
                            default:
                                System.out.println("Opcion no valida");
                                break;
                        }
                    }
                break;
                default:
                    System.out.println("Opcion no valida");
                break;
            }
        }
    }
    
    public void visualizarTodos(QuickPass arreglo[]){
        for(int i = 0; i < arreglo.length;i++){
            if(arreglo[i]!=null){
                String r = "Gestion QuickPass";
                r += "\n" + i + ". Codigo: " + arreglo[i].getCodigo() +
                        " Filial: " + arreglo[i].getFilial() +
                        " Placa: " + arreglo[i].getPlaca() + 
                        " Estado: " + arreglo[i].getEstado();
                System.out.println(r);
            }
         }
    }
    
    public void visualizarPorCodigo(QuickPass arreglo[]){
        
    }
    
    public void visualizarPorFilial(QuickPass arreglo[]){
        
    }
    // Fin
}
