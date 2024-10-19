//Joel Emiliano Salazar Figueroa
package problemasiterativos;

import java.util.Scanner;

public class ProblemasIterativos {
    static Scanner leer = new Scanner (System.in);
    
    void Serie(int n, int p){
        if(n<=p){
            System.out.println(" "+n);
            Serie(n+1,p);
        } 
    }
    static int Resultado = 1;
    double potencia (int r, int n, int p, int contar){
        if(contar<=p){
            Resultado=r; //estado base 
            potencia(r*n,n,p,contar+1);
        }
        return Resultado;
    }
    
    void PalabraInversa(String Palabra,int Aux){
        System.out.println(Palabra.charAt(Aux)+ " ");
        if(Aux>0)
        PalabraInversa(Palabra, Aux-1);
    }
    
    public static void main(String[] args) {
        int opc,n,p;
        double r;
        String Palabra;
        int Aux;
        ProblemasIterativos objeto = new ProblemasIterativos();
        do{
            System.out.println("Elige la opción que deseas: ");
            System.out.println("1.- Imprimir serie de números. ");
            System.out.println("2.- Calcular potencia de un número. ");
            System.out.println("3.- Imprimir una palabra de forma inversa. ");
            System.out.println("4.- Salir.");
            opc = leer.nextInt();
            switch(opc){
                case 1:    
                    System.out.println("Elige el número de inicio: ");
                    n = leer.nextInt();
                    System.out.println("Elige el número final: ");
                    p = leer.nextInt();
                    objeto.Serie(n, p);
                    break;
                case 2:
                    System.out.println("Capturar un numero entero: ");
                    n = leer.nextInt();
                    System.out.println("Capturar la potencia: ");
                    p = leer.nextInt();
                    r = objeto.potencia(1,n,p,0);
                    System.out.println("La potencia es: " +r);
                    break;
                case 3:
                    System.out.println("Ingresa la palabra: ");
                    Palabra = leer.next();
                    Aux = Palabra.length()-1;
                    objeto.PalabraInversa(Palabra, Aux);
                    break;
            }
        }while(opc!=4);
    }
    
}