package ejemplodecolas;

import java.util.Scanner;

public class EjemploDeColas {
    class nodo{
        String nombre;
        int edad;
        nodo sig;
    }//nodo
    static Scanner leer = new Scanner(System.in);
    static nodo ultimo = null, raizCola = null, anterior = null;
    char otro = 's';
    String buscar;
    
    void crearCola(){
        do{
            nodo direccion = new nodo();
            System.out.print("Capturar un nombre: ");
            direccion.nombre = leer.next();
            System.out.print("Capturar una edad: ");
            direccion.edad = leer.nextInt();
            if(raizCola == null){
                raizCola = direccion;
            }//if
            else{
                ultimo.sig = direccion;
                
            }//else
            ultimo = direccion;
            direccion.sig = null;
            System.out.println("Capturar otro nodo s/n");
            otro=leer.next().charAt(0);
        }while(Character.toUpperCase(otro)=='S');
    }//crearCola
    
    void mostrarCola(nodo puntero){
        while(puntero != null){
            System.out.println(" "+puntero.nombre+" "+puntero.edad);
            puntero = puntero.sig;
        }//while
    }//mostrarNodo
    
    void buscarNodo(nodo puntero){
        System.out.println("Capturar dato a buscar");
        buscar = leer.next();
        while(puntero != null){
            if(puntero.nombre.equals(buscar)){
                System.out.println(" "+puntero.nombre+" "+puntero.edad);
            }
            puntero = puntero.sig;
        }
    }
    
    void eliminarNodo(nodo puntero){
        System.out.print("Capturar dato a borrar: ");
        buscar = leer.next();
        while(puntero != null){
            if(puntero.nombre.equals(buscar)){
                System.out.print("Se elimina a:");
                    if(puntero == raizCola)
                        raizCola = puntero.sig;
                    else
                        anterior.sig = puntero.sig;
                    puntero=null;
                    break;
            }//if
            anterior=puntero;
            puntero=puntero.sig;
        }
    }
    
    public static void main(String[] args) {
        EjemploDeColas objeto = new EjemploDeColas();
        int opcion = 0;
        for(opcion=0; opcion != 5;){
            System.out.println("1.- Almacenar en cola");
            System.out.println("2.- Mostrar cola");
            System.out.println("3.- Buscar dato");
            System.out.println("4.- Eliminar dato");
            System.out.println("5.- Salir");
            System.out.print("Capturar una opcion: ");
            opcion = leer.nextInt();
            switch(opcion){
                case 1:
                    objeto.crearCola();
                    break;
                case 2:
                    objeto.mostrarCola(raizCola);
                    break;
                case 3:
                    objeto.buscarNodo(raizCola);
                    break;
                case 4:
                    objeto.eliminarNodo(raizCola);
                    break;
            }
        }
    }

}