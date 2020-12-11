/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaarraylist;

/**
 *
 * @author txaber
 */
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Collections;
public class PracticaArrayList {

    /**
     * @param args the command line arguments
     */
    private static ArrayList<Double> lista;
    
    public static void main(String[] args) {
        
        try {
            lista = new ArrayList();
            int fin;
            
            fin = JOptionPane.showConfirmDialog(null,"quieres meter numeros en la lista?");
            while(fin == 0) {
                lista.add(Double.parseDouble(JOptionPane.showInputDialog("meter un numero en la lista")));
                fin = JOptionPane.showConfirmDialog(null,"seguir introduciendo numeros?");
            }
            
            int opcion;
            do {
                opcion = menu();
                
                switch(opcion) {
                    case 1: f1(); break;
                    case 2: f2(); break;
                    case 3: f3(); break;
                    case 4: f4(); break;
                    case 5: f5(); break;
                    case 6: f6(); break;
                    case 7: f7(); break;
                    case 8: f8(); break;
                    case 9: f9(); break;
                    case 10: break;
                }
            }while(opcion != 10);
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null,"problemas: "+ e.getClass());
        }
    }
    
    public static int menu() throws Exception {
        int op = 0;
        boolean error;
        do {
            try {
                op = Integer.parseInt(JOptionPane.showInputDialog("lista\n"
                        + "1: Visualizar el valor maximo y el minimo\n"
                        + "2: Solicitar un numero y buscarlo\n"
                        + "3: Solicitar un numero, buscarlo y borrarlo\n"
                        + "4: Convertir el arrayList en un array\n"
                        + "5: mostrar el numero de elementos que contiene\n"
                        + "6: Insertar un nuevo elemento por el final\n"
                        + "7: Insertar un nuevo elemento en la posicion que te indique\n"
                        + "8: Borrar un elemento de una posicion concreta\n"
                        + "9: Calcular la suma y la media aritmetica de los valores contenidos\n"
                        + "10: terminar"));
                
                if (op < 0 || op > 10)
                    throw new NumberFormatException();
                    
                error = false;
            }
            catch(NumberFormatException e) {
                JOptionPane.showMessageDialog(null,"introduce un numero del 1 al 10");
                error = true;
            }
        }while(error);
        
        return op;
    }
    
    public static Double solicitarNumero(String m) throws Exception {
        Double ret;
        try 
        {
            ret = Double.parseDouble(JOptionPane.showInputDialog("introduce numero a "+m));
        }
        catch (NumberFormatException e) 
        {
            JOptionPane.showMessageDialog(null,"el numero a "+m+" no estaba bien escrito");
            ret = null;
        }
        return ret;
    }
    
    public static void f1() throws Exception {
        Double max =(double) Collections.max(lista);
        Double min =(double) Collections.min(lista);
        
        
        /*
        *lista.sort((e1,e2)-> e1.compareTo(e2));
        *JOptionPane.showMessageDialog(null,"mayor= "+lista.get(0));
        *JOptionPane.showMessageDialog(null,"menor= "+lista.get(lista.size()-1));
        */
        
        JOptionPane.showMessageDialog(null,"el numero mayor es "+max+" el menor es "+min);
    }
    
    public static void f2() throws Exception {
        Double numero = solicitarNumero("buscar");
        
        if (lista.contains(numero))
            JOptionPane.showMessageDialog(null,"el numero "+numero+" esta en la lista");
        else
            JOptionPane.showMessageDialog(null,"el numero "+numero+" no esta en la lista");
    }
    
    public static void f3() throws Exception {
        Double numero = solicitarNumero("retirar");
        
        if(!lista.remove(numero)) {
            JOptionPane.showMessageDialog(null, "no se encontro el numero");
        }
        else {JOptionPane.showMessageDialog(null, "numero "+numero+" borrado");}
    }
    
    public static void f4() throws Exception {
        
        Double[] arrayLista = lista.toArray(new Double[lista.size()]);
        
    }
    
    public static void f5() throws Exception {
        
        int cant = lista.size();
        JOptionPane.showMessageDialog(null,"la lista tiene "+cant+" numeros");
    }
    
    public static void f6() throws Exception {
        try 
        {
            lista.add(Double.parseDouble(JOptionPane.showInputDialog("introduce otro numero")));
        }
        catch(NumberFormatException e)
        {
            JOptionPane.showMessageDialog(null,"problemas");
        }
        
    }
    
    public static void f7() throws Exception {
        try 
        {
            Double add = solicitarNumero("añadir");
            int pos = Integer.parseInt(JOptionPane.showInputDialog("en cual posicion?"));
            
            lista.add(pos,add);
        }
        catch(IndexOutOfBoundsException | NumberFormatException e) 
        {
            JOptionPane.showMessageDialog(null,"la posicion introducida no vale o no es correcta");
        }
    }
    
    public static void f8() throws Exception {
        try 
        {
            int pos = Integer.parseInt(JOptionPane.showInputDialog("cual posicion quitar?"));
            
            lista.remove(pos);
        }
        catch(IndexOutOfBoundsException | NumberFormatException e) 
        {
            JOptionPane.showMessageDialog(null,"la posicion introducida no vale o no es correcta");
        }
    }
    
    public static void f9() throws Exception {
        double suma = 0;
        double media;
        
        for(Double numero : lista) {
            suma += numero;
        }
        
        //suma = lista.stream().map((numero) -> numero).reduce(suma, (accumulator, _item) -> accumulator + _item);
        
        media = suma / lista.size();
        JOptionPane.showMessageDialog(null,"suma total = "+suma+"\nmedia de los valores = "+media);
    }
    
}
