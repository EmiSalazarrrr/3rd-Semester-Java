//Joel Emiliano Salazar Figueroa 
package pffs;
import java.util.Scanner;
public class PFFS {
    //Método para el factorial
    int factorial(int X){
        if (X == 1)
            return 1;
        else 
            return X*factorial(X-1);
    }
    
    //Método para infertir un número
    void NumeroInvertido(String Num, int Aux) {
    System.out.print(Num.charAt(Aux));
    if (Aux > 0) {
        NumeroInvertido(Num, Aux - 1);
    }
}
    
    //Método Suma Numeros
    int SumaNumerosNaturales (int X){
        if (X == 1)
            return 1;
        else 
            return X + SumaNumerosNaturales (X - 1);
    }
    
    //Método Fibonacci
    void Fibonacci (int PrimerNumero,int SegundoNumero, int cantidad){
        if(cantidad > 0){ 
        int Fibonacci;
        Fibonacci = PrimerNumero + SegundoNumero;
        System.out.println(Fibonacci);
        Fibonacci(SegundoNumero,Fibonacci, cantidad -1);
        }
    }
    
    public static void main(String[] args) {
        int opc, Factorial,NumeroSumar,Aux, PrimerNumero,SegundoNumero,Cantidad;
        String Num;
        PFFS objeto = new PFFS();
        Scanner leer = new Scanner (System.in);
        do{
            System.out.println("Elige que hacer: ");
            System.out.println("1.- Calcular Factorial. ");
            System.out.println("2.- Invertir un número. ");
            System.out.println("3.- Sumar números naturales. ");
            System.out.println("4.- Calcular fibonacci. ");
            System.out.println("5.- Salir");
            opc = leer.nextInt();
            switch(opc){
                case 1:
                    System.out.println("Ingresa un número para calcular su factorial.");
                    Factorial = leer.nextInt();
                    System.out.println("El factorial de: "+Factorial + " es " + objeto.factorial(Factorial));
                    break;
                case 2:
                    System.out.println("Ingresa el número a invertir: ");
                    Num = leer.next();
                    Aux = Num.length() - 1; // Comenzar desde la última posición
                    System.out.print("El número invertido es: ");
                    objeto.NumeroInvertido(Num, Aux);
                    System.out.println();
                    break;
                case 3:
                    System.out.println("Ingresa el número a sumar");
                    NumeroSumar = leer.nextInt();
                    System.out.println("La suma es: "+objeto.SumaNumerosNaturales(NumeroSumar));
                    break;
                case 4:
                    System.out.println("Introduce la cantidad que se repetirá");
                    Cantidad = leer.nextInt();
                    PrimerNumero = 0;
                    SegundoNumero = 1;
                    System.out.println(PrimerNumero);
                    if(Cantidad > 1){
                        System.out.println(SegundoNumero);
                    }
                    objeto.Fibonacci(PrimerNumero,SegundoNumero,Cantidad - 2);
                    break;
            }
        }while (opc != 5);
    }
    
}
