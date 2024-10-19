
package arraylist;

import java.util.ArrayList;
import java.util.Scanner;

public class Arraylist {
    static ArrayList lista = new ArrayList();
    static Scanner leer = new Scanner(System.in);
    
    static void Registrar(){
        String nombre;
        System.out.println("Caputrar un nombre");
        nombre = leer.next();
        lista.add(nombre);
    }//Registrar
    
    static void Mostrar(){
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(" "+lista.get(i));
        }//for
    }//Mostrar
    
    static void Eliminar(){
        String buscar;
        System.out.println("Capturar el nombre a eliminar");
        buscar = leer.next();
        for (int i = 0; i < lista.size(); i++) {
            if (buscar.equals(lista.get(i))) {
                lista.remove(i);
                System.out.println("Dato eliminado");
            }//If
        }//For
    }//Eliminar
    
    static void Modificar(){
        String buscar, nuevo;
        System.out.println("Capturar el nombre a eliminar");
        buscar = leer.next();
        for (int i = 0; i < lista.size(); i++) {
            if (buscar.equals(lista.get(i))) {
                System.out.println("Capturar dato nuevo");
                nuevo = leer.next();
                lista.set(i,nuevo); 
            }//If
        }//For
    }//Modificar
    
    public static void main(String[] args) {
        Arraylist Objeto = new Arraylist();
        int opc = 0;
        do{
            System.out.println("1.- Almacenar. \n"
                    + "2.- Mostrar. \n"
                    + "3.- Eliminar. \n"
                    + "4.- Modificar. \n"
                    + "5.- Salir");
            System.out.println("Selecciona una opción.");
            opc = leer.nextInt();
            switch(opc){
                case 1:
                    Objeto.Registrar();
                    break;
                case 2:
                    Objeto.Mostrar();
                    break;
                case 3:
                    Objeto.Eliminar();
                    break;
                case 4:
                    Objeto.Modificar();
                    break;
            }
        }while (opc != 5);
    }//Main
    
}//Clase
