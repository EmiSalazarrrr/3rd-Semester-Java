
package fibonacci;

import java.util.Scanner;

public class Fibonacci {

    public static void main(String[] args) {
        Scanner leer = new Scanner (System.in);
        System.out.println("Introduce la cantidad que se repetirá");
        int cantidad = leer.nextInt();
        int PrimerNumero = 0;
        int SegundoNumero = 1;
        System.out.println(PrimerNumero);
        if(cantidad > 1){
            System.out.println(SegundoNumero);
        }
        fibonacci(PrimerNumero,SegundoNumero,cantidad - 2);
    }
    
    static void fibonacci (int PrimerNumero,int SegundoNumero, int cantidad){
        if(cantidad > 0){ 
        int Fibonacci = 0;
        Fibonacci = PrimerNumero + SegundoNumero;
        System.out.println(Fibonacci);
        fibonacci(SegundoNumero,Fibonacci, cantidad -1);
        }
    }
}   