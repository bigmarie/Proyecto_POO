/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;

/**
 *
 * @author Nicole
 */
public class QuickPass {
    
    
    //Atributos de la clase quickpass
    private String filial;
    private int codigo;
    private String  placa;
    public Estado estado;
    
   //Constructor
    public QuickPass(String filial, int codigo, String placa, Estado estado){
     this.filial = filial; 
     this.codigo = codigo;
     this.placa = placa; 
     this.estado = estado; 
    }
    
    public String getFilial(){
        return filial; 
    }
    
    public int getCodigo(){
        return codigo; 
    }
    
    public String getPlaca(){
        return placa; 
    }
    
    public Estado getEstado(){
        return estado; 
    }
    
    public void setFilial(String filial){
        this.filial = filial;
    }
    
    public void setCodigo(int codigo){
        this.codigo = codigo; 
        
    }
    
    public void setPlaca(String placa){
        this.placa = placa;
    }
    
    public void setEstado(Estado estado){
       this.estado = estado;
    }
}
