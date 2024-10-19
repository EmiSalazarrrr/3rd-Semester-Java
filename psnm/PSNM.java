//Joel Emiliano Salazar Figueroa
package psnm;

import java.util.Scanner;

public class PSNM {
    
    static Scanner leer = new Scanner (System.in);
    
    //Método Salto +4 y -2
    void SaltoResta(int X, int Y){
        if (Y>X)
            return;
        System.out.println(Y);
        if (Y % 2 == 1)
            SaltoResta(X,Y+4);
        else 
            SaltoResta (X,Y-2);
    }
    
    void ImprimirSerie (int X){
        if (X==0)
            return;
        ImprimirSerie(X-1);
        System.out.println(X);
    }
    
    int SumaSerie(int X){
        int Aux;
        if (X == 1)
            return 1;
        else 
            Aux = X+SumaSerie(X-1);
        return Aux;
    }
    
    void Multiplicacion(int X, int Num1, int Num2){
        if (X<Num2){
            System.out.println(Num1);
            Multiplicacion(X+1,Num1,Num2);
        }
        if (X==0)
            System.out.println(" = "+Num1*Num2);
    }
    
    void Multiplicacion2(int X, int Num1, int Num2){
        if (X<Num1){
            System.out.println(Num2);
            Multiplicacion2(X+1,Num1,Num2);
        }
        if (X==0)
            System.out.println(" = "+Num1*Num2);
    }
    
    void Tabla (int Num, int Mult){
        if (Mult>10)
            return;
        System.out.println(Num + " x "+Mult+" = "+(Num*Mult));
        Tabla(Num,Mult+1);
    }
    public static void main(String[] args) {
        int opc,X,Aux,Num1,Num2;
        PSNM objeto = new PSNM();
        do{
            System.out.println("Elige la opción a realizar.");
            System.out.println("1.- Serie con salto.");
            System.out.println("2.- Imprimir serie consecutiva.");
            System.out.println("3.- Imprimir suma");
            System.out.println("4.- Calcular multiplicación.");
            System.out.println("5.- Tabla de multiplicación.");
            System.out.println("6.- Salir");
            opc = leer.nextInt();
            switch(opc){
                case 1:
                    System.out.println("Ingresa el límite.");
                    X = leer.nextInt();
                    objeto.SaltoResta(X,1);
                    break;
                case 2:
                    System.out.println("Ingresa el valor de la serie");
                    X = leer.nextInt();
                    objeto.ImprimirSerie(X);
                    break;
                case 3:
                    System.out.println("Ingresa el valor de N: ");
                    X = leer.nextInt();
                    Aux = objeto.SumaSerie(X);
                    System.out.println("La suma de la serie es: "+Aux);
                    break;
                case 4:
                    System.out.println("Captura el primer múltiplo: ");
                    Num1 = leer.nextInt();
                    System.out.println("Captura el segundo múltiplo: ");
                    Num2 = leer.nextInt();
                    objeto.Multiplicacion(0, Num1, Num2);
                    objeto.Multiplicacion2(0, Num1, Num2);
                    break;
                case 5:
                    System.out.println("Captura el número de la tabla de multiplicar");
                    X = leer.nextInt();
                    objeto.Tabla(X,1);
                    break;
            }
        }while(opc!=6);
    }
    
}
