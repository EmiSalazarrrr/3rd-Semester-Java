package ejemplopila;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
public class EjemploPILA{
    
    class nodo{
        String nombre;
        int edad;
        nodo sig;
    }//nodo
    
    static Scanner leer = new Scanner(System.in);
    BufferedReader leer2 = new BufferedReader (new InputStreamReader(System.in));
    static nodo raizPila = null;
    char otro = 's';
    void crearPila() throws IOException{
        do{
            nodo direccion = new nodo();
            System.out.print("Capturar un nombre: ");
            direccion.nombre = leer2.readLine();
            System.out.print("Capturar una edad: ");
            direccion.edad = leer.nextInt();
            if(raizPila == null){
                direccion.sig = null;
            }
        else{
                direccion.sig=raizPila;
            }
            raizPila = direccion;
            System.out.println("Capturar otro nodo s/n ");
            otro =leer.next().charAt(0);
        }while(Character.toUpperCase(otro)=='S');
    }//crearPila
    void mostrarNodos(nodo puntero){
        while(puntero!=null){
            System.out.println("Nombre "+puntero.nombre);
            System.out.println("Edad "+puntero.edad);
            //System.out.println("Sig. "+puntero.sig);
            puntero = puntero.sig;
        }//while        
    }//mostraarNodos
    
    void buscarNodo (nodo puntero){
        String Buscar;
        System.out.println("Capturar nombre a buscar: ");
        Buscar = leer.next();
        while(puntero != null){
            if (puntero.nombre.equals(Buscar)) {
                System.out.println(" "+puntero.nombre);
                System.out.println(" "+puntero.edad);
                System.out.println("Se encontró en ");
                System.out.println(puntero);
                break;
            }
            puntero=puntero.sig;
        }//while
    }//buscar en pila
    
    void modificarNodo(nodo puntero){
        String Buscar;
        System.out.println("Captura nombre a modificar: ");
        Buscar = leer.next();
        while(puntero!=null){
            if(puntero.nombre.equals(Buscar)){
                System.out.println("Capturar nuevo nombre: ");
                puntero.nombre = leer.next();
                System.out.println("Capturar nueva edad: ");
                puntero.edad = leer.nextInt();
                break;
            }
            puntero = puntero.sig;
        }//while
    }
    
    void eliminarNodo(nodo puntero){
        String Buscar;
        System.out.println("Captura nombre a eliminar: ");
        Buscar = leer.next();
        nodo anterior = null;
        while(puntero!=null){
            if (puntero.nombre.equals(Buscar)) {
                anterior.sig = puntero.sig;
                System.out.println("Se eliminó exitosamente");
                break;
            }
            anterior = puntero;
            puntero = puntero.sig;
        }
    }
    
    public static void main(String[] args) throws IOException {
        EjemploPILA objeto = new EjemploPILA();
        objeto.crearPila();
        objeto.mostrarNodos(raizPila);
        objeto.buscarNodo(raizPila);
        objeto.modificarNodo(raizPila);
        objeto.mostrarNodos(raizPila);
        objeto.eliminarNodo(raizPila);
        objeto.mostrarNodos(raizPila);
    }
}
