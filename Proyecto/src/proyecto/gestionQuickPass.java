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
public class GestionQuickPass{
     private QuickPass[] arregloQuickPass = new QuickPass[150]; 
    private QuickPass[] quickPassEliminados = new QuickPass[150];
    
    // Método para agregar un QuickPass
    public void agregarQuickPass() {
        String filial = agregarFilial();
        int codigo = agregarCodigo();
        int placa = agregarPlaca();
        Estado estado = Estado.ACTIVO; 
        
        agregarArregloQuickPass(filial, codigo, placa, estado);
    }

    private void agregarArregloQuickPass(String filial, int codigo, int placa, Estado estado) {
        for (int i = 0; i < arregloQuickPass.length; i++) {
            if (arregloQuickPass[i] == null) {
                QuickPass nuevoQuickPass = new QuickPass(filial, codigo, placa, estado);
                arregloQuickPass[i] = nuevoQuickPass;
                JOptionPane.showMessageDialog(null, "QuickPass agregado correctamente");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "No hay espacio para agregar más QuickPass.");
    }

    //Filial QuickPass
    private String agregarFilial() {
        boolean esValido = false;
        String filial = "";
        
        while (!esValido) {
            filial = JOptionPane.showInputDialog(null, "Ingrese la filial: ");
            if (!esFilial(filial)) {
                JOptionPane.showMessageDialog(null, "Filial tiene que ser un alfanumero de 3 letras (i.e.:A12)");
            } else {
                esValido = true;
            }
        }
        return filial;  
    }

    //Código QuickPass
    private int agregarCodigo() {
        boolean esValido = false;
        String inputCodigo;
        int codigo = 0;
        
        while (!esValido) {
            inputCodigo = JOptionPane.showInputDialog(null, "Ingrese el codigo (10 dígitos y comienza con 101): ");
            if (!esCodigo(inputCodigo)) {
                JOptionPane.showMessageDialog(null, "Codigo tiene que ser un número de 10 dígitos y empezar con 101 (i.e.:1011234567)");
            } else {
                codigo = Integer.parseInt(inputCodigo);
                if (!existeQuickPass(codigo)) {
                    esValido = true;
                } else {
                    JOptionPane.showMessageDialog(null, "Código en uso.");
                }
            }
        }
        return codigo;
    }

    //Placa QuickPass
    private int agregarPlaca() {
        boolean esValido = false;
        String inputPlaca = "";
        int placa = 0;
        
        while (!esValido) {
            inputPlaca = JOptionPane.showInputDialog(null, "Ingrese la placa (6 dígitos): ");
            if (!esPlaca(inputPlaca)) {
                JOptionPane.showMessageDialog(null, "Placa tiene que ser un número de 6 dígitos (i.e.:123123)");
            } else {
                placa = Integer.parseInt(inputPlaca);
                esValido = true;
            }
        }
        return placa;
    }

    private void agregarArregloEliminado(QuickPass quickPassEliminado) {
        for (int i = 0; i < quickPassEliminados.length; i++) {
            if (quickPassEliminados[i] == null) {
                quickPassEliminados[i] = quickPassEliminado;
                return;
            }
        }
    }

    // Validaciones
    private boolean esCodigo(String codigo) {
        if (codigo.length() != 10) {
            return false;
        }
        if (!codigo.substring(0, 3).equals("101")) {
            return false;
        }
        for (int i = 0; i < codigo.length(); i++) {
            char c = codigo.charAt(i);
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    private boolean esPlaca(String placa) {
        if (placa.length() != 6) {
            return false;
        }
        for (int i = 0; i < placa.length(); i++) {
            char c = placa.charAt(i);
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    private boolean esFilial(String string) {
        if (string.length() != 3) {
            return false;
        }
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if (i == 0) {
                if (!Character.isLetter(c)) {
                    return false;
                }
            } else {
                if (!Character.isDigit(c)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean existeQuickPass(int codigo) {
        for (int i = 0; i < arregloQuickPass.length; i++) {
            if (arregloQuickPass[i] != null && arregloQuickPass[i].getCodigo() == codigo) {
                return true;
            }
        }
        return false;
    }

    // desactivar un QuickPass
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

    // Eliminar 
    public void eliminarQuickPass() {
        boolean esValido = false;
        String opcion = "";
        String codigo = "";
        String filial = "";

        while (!esValido) {
            opcion = JOptionPane.showInputDialog(null, "ELIMINAR \n 1. Por código \n 2. Por filial \n Ingrese el número de la opción a escoger: ");
            switch (opcion) {
                case "1":
                    while (!esValido) {
                        codigo = JOptionPane.showInputDialog(null, "Ingrese el código: ");
                        if (!esCodigo(codigo)) {
                            JOptionPane.showMessageDialog(null, "Código tiene que ser un número de 10 dígitos y empezar con 101 (i.e.:1011234567)");
                        } else {
                            int codigoInt = Integer.parseInt(codigo);
                            eliminarQuickPassporCodigo(codigoInt);
                            esValido = true;
                            JOptionPane.showMessageDialog(null, "Código eliminado");
                        }
                    }
                    break;
                case "2":
                    while (!esValido) {
                        filial = JOptionPane.showInputDialog(null, "Ingrese la filial: ");
                        if (!esFilial(filial)) {
                            JOptionPane.showMessageDialog(null, "Filial tiene que ser un alfanumero de 3 letras (i.e.:A12)");
                        } else {
                            eliminarQuickPassporFilial(filial);
                            esValido = true;
                            JOptionPane.showMessageDialog(null, "Filial eliminada");
                        }
                    }
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida");
                    break;
            }
        }
    }

    private void eliminarQuickPassporCodigo(int codigo) {
        for (int i = 0; i < arregloQuickPass.length; i++) {
            if (arregloQuickPass[i] != null && arregloQuickPass[i].getCodigo() == codigo) {
                agregarArregloEliminado(arregloQuickPass[i]);
                arregloQuickPass[i] = null;
            }
        }
    }

    private void eliminarQuickPassporFilial(String filial) {
        for (int i = 0; i < arregloQuickPass.length; i++) {
            if (arregloQuickPass[i] != null && arregloQuickPass[i].getFilial().equals(filial)) {
                agregarArregloEliminado(arregloQuickPass[i]);
                arregloQuickPass[i] = null;
            }
        }
    }

    // QuickPass
    public void visualizar() {
        boolean esValido = false;
        String opcion = "";
        String opcion2 = "";
        String codigo = "";
        String filial = "";

        String menu = "VISUALIZAR \n 1. Todos los QuickPass \n 2. Por código \n 3. Por filial \n Ingrese el número de la opción a escoger: ";

        while (!esValido) {
            opcion = JOptionPane.showInputDialog(null, "VISUALIZAR \n 1. QuickPass Agregados \n 2. QuickPass Eliminados \n Ingrese el número de la opción a escoger: ");
            switch (opcion) {
                case "1":
                    while (!esValido) {
                        opcion2 = JOptionPane.showInputDialog(null, menu);
                        switch (opcion2) {
                            case "1":
                                visualizarTodos(arregloQuickPass);
                                esValido = true;
                                break;
                            case "2":
                                while (!esValido) {
                                    codigo = JOptionPane.showInputDialog(null, "Ingrese el codigo: ");
                                    if (!esCodigo(codigo)) {
                                        JOptionPane.showMessageDialog(null, "Código tiene que ser un número de 10 dígitos y empezar con 101 (i.e.:1011234567)");
                                    } else {
                                        int codigoInt = Integer.parseInt(codigo);
                                        visualizarQuickPassporCodigo(codigoInt);
                                        esValido = true;
                                    }
                                }
                                break;
                            case "3":
                                while (!esValido) {
                                    filial = JOptionPane.showInputDialog(null, "Ingrese la filial: ");
                                    if (!esFilial(filial)) {
                                        JOptionPane.showMessageDialog(null, "Filial tiene que ser un alfanumero de 3 letras (i.e.:A12)");
                                    } else {
                                        visualizarQuickPassporFilial(filial);
                                        esValido = true;
                                    }
                                }
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Opción no válida.");
                                break;
                        }
                    }
                    break;
                case "2":
                    visualizarQuickPassporCodigoEliminados();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida.");
                    break;
            }
        }
    }

    
    private void visualizarQuickPassporCodigo(int codigo) {
        for (int i = 0; i < arregloQuickPass.length; i++) {
            if (arregloQuickPass[i] != null && arregloQuickPass[i].getCodigo() == codigo) {
                JOptionPane.showMessageDialog(null, "Codigo: " + arregloQuickPass[i].getCodigo() + "\nFilial: " + arregloQuickPass[i].getFilial() + "\nPlaca: " + arregloQuickPass[i].getPlaca() + "\nEstado: " + arregloQuickPass[i].getEstado());
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "QuickPass no encontrado.");
    }

    private void visualizarQuickPassporFilial(String filial) {
        for (int i = 0; i < arregloQuickPass.length; i++) {
            if (arregloQuickPass[i] != null && arregloQuickPass[i].getFilial().equals(filial)) {
                JOptionPane.showMessageDialog(null, "Codigo: " + arregloQuickPass[i].getCodigo() + "\nFilial: " + arregloQuickPass[i].getFilial() + "\nPlaca: " + arregloQuickPass[i].getPlaca() + "\nEstado: " + arregloQuickPass[i].getEstado());
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "QuickPass con filial " + filial + " no encontrado.");
    }

    private void visualizarTodos(QuickPass[] quickPass) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < quickPass.length; i++) {
            if (quickPass[i] != null) {
                sb.append("Codigo: ").append(quickPass[i].getCodigo()).append("\nFilial: ").append(quickPass[i].getFilial()).append("\nPlaca: ").append(quickPass[i].getPlaca()).append("\nEstado: ").append(quickPass[i].getEstado()).append("\n");
            }
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    private void visualizarQuickPassporCodigoEliminados() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < quickPassEliminados.length; i++) {
            if (quickPassEliminados[i] != null) {
                sb.append("Codigo: ").append(quickPassEliminados[i].getCodigo()).append("\nFilial: ").append(quickPassEliminados[i].getFilial()).append("\nPlaca: ").append(quickPassEliminados[i].getPlaca()).append("\nEstado: ").append(quickPassEliminados[i].getEstado()).append("\n");
            }
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }
}//Fin