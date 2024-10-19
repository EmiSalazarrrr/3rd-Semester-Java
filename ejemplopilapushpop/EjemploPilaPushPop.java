package ejemplopilapushpop;
import java.util.Scanner;
import java.util.Stack;
public class EjemploPilaPushPop {
    static Scanner leer = new Scanner (System.in);
    static int dato;
    Stack <Integer> pila1 = new Stack();
    void InsertarPila(){
        System.out.println("Capturar un entero para la pila: ");
        dato = leer.nextInt();
        pila1.push(dato);
    } 
    void VaciarMostrarPila(){
        while(pila1.isEmpty() != true){
            System.out.println(" "+pila1.pop());
        }
    }
    public static void main(String[] args) {
        int opc = 0; 
        EjemploPilaPushPop objeto = new EjemploPilaPushPop(); 
        for(int i = 0; i!=3;){
        System.out.println("1.- Llenar pila: ");
        System.out.println("2.- Vaciar pila: ");
        System.out.println("3.- Salir");
        System.out.println("Sleccionar una opción 1-3");
        opc = leer.nextInt();
        switch(opc){
            case 1:
                objeto.InsertarPila();
                break;
            case 2:
                objeto.VaciarMostrarPila();
                break;
        }
      } 
    }
    
}
