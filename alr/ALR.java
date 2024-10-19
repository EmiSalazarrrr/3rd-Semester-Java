//Joel Emiliano Salazar Figueroa 
package alr;
import java.util.ArrayList;
import java.util.Scanner;
public class ALR {
    static ArrayList<Integer> Num = new ArrayList<>();
    static Scanner leer = new Scanner (System.in);
    static int Aux, Ayu;
    
    void Registrar(){
        int N;
        System.out.println("Captura un número");
        N = leer.nextInt();
        Num.add(N);
    }
    
    void Mostrar(int X){
        if (X<Num.size()){
            System.out.println(Num.get(X));
            Mostrar(X+1);
        }
    }
    
    void Consultar(int X){
        if(Aux == Num.get(X))
            System.out.println("El número está en la casilla: "+(X+1));
        else 
            Consultar(X+1);
    }
    
    void Modificar(int X,int Ayu){
        if (X<Num.size()){
            if(Num.get(X).equals(Aux)){
                System.out.println("Captura el nuevo número");
                Ayu = leer.nextInt();
                Num.set(X, Ayu);
            }
        }
        else
            Modificar(X+1,Aux);
    }
    
    public static void main(String[] args) {
        int opc;
        ALR objeto = new ALR();
        do{
            System.out.println("Elige una opción a realizar. ");
            System.out.println("1.- Registrar. ");
            System.out.println("2.- Mostrar. ");
            System.out.println("3.- Consultar. ");
            System.out.println("4.- Modificar. ");
            System.out.println("5.- Salir. ");
            opc = leer.nextInt();
            switch(opc){
                case 1:
                    objeto.Registrar();
                    break;
                case 2:
                    objeto.Mostrar(0);
                    break;
                case 3:
                    System.out.println("Captura el número a buscar: ");
                    Aux = leer.nextInt();
                    objeto.Consultar(0);
                    break;
                case 4:
                    System.out.println("Captura el número a buscar: ");
                    Aux = leer.nextInt();
                    objeto.Modificar(0, Aux);
                    break;
            }
        }while(opc!=5);
        
    }
    
}