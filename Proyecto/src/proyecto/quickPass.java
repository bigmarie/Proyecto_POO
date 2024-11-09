/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;

/**
 *
 * @author Nicole
 */
public class quickPass {
    
    
    //Atributos de la clase quickpass
    private int filial;
    private int codigo;
    private int placa;
    public Estado estado;
    
   //Constructor
    public quickPass(int filial, int codigo, int placa, Estado estado){
     this.filial = filial; 
     this.codigo = codigo;
     this.placa = placa; 
     this.estado = estado; 
    }
    // Prueba
    
    public int getFilial(){
        return filial; 
    }
    
    public int getCodigo(){
        return codigo; 
    }
    
    public int getPlaca(){
        return placa; 
    }
    
    public Estado getEstado(){
        return estado; 
    }
    
    public void setFilial(int filial){
        this.filial = filial;
    }
    
    public void setCodigo(int codigo){
        this.codigo = codigo; 
        
    }
    
    public void setPlaca(int placa){
        this.placa = placa;
    }
    
    public void setEstado(Estado estado){
       this.estado = estado;
    }
}
